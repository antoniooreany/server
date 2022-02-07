package com.gorshkov.server.controller;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private String webAppPath;

    public Server(int port, String webAppPath) {
        this.port = port;
        this.webAppPath = webAppPath;
    }

    public void start() throws IOException {
        System.out.println("Server started");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));) {
                    ContentReader contentReader = new ContentReader(webAppPath);
                    RequestHandler handler = new RequestHandler(reader, writer, contentReader);
                    handler.handle();
                }
            }
        }
    }
}
