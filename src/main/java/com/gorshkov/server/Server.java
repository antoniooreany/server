package com.gorshkov.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private String webAppPath;

    public void setWebAppPath(String webAppPath) {
        this.webAppPath = webAppPath;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (Socket socket = new ServerSocket(port).accept();
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));) {
            ContentReader contentReader = new ContentReader(webAppPath);
            RequestHandler handler = new RequestHandler(reader, writer, contentReader);
            handler.handle();
        }
    }
}
