package com.gorshkov.server;

import com.gorshkov.server.controller.Server;

import java.io.IOException;

public class Starter {
    public static void main(String[] args) throws IOException {
        Server server = new Server(3000, "src/main/resources");
        server.start();
    }
}
