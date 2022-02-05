package com.gorshkov.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private ContentReader contentReader;
    private String webAppPath;

    public Server(int port, ContentReader contentReader) {
        this.port = port;
        this.contentReader = contentReader;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setWebAppPath(String webAppPath) {
        this.webAppPath = webAppPath;
    }

    public ContentReader getContentReader() {
        return contentReader;
    }

    public void start() throws IOException {
        try (Socket socket = new ServerSocket(port).accept();
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            RequestHandler handler = new RequestHandler(reader, writer, contentReader);
            handler.handle();
        }
    }
}
