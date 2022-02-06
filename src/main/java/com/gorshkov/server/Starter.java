package com.gorshkov.server;

import java.io.IOException;

public class Starter {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.setPort(3000);
        server.setWebAppPath("src/main/resources");
            server.start();
    }
}
