package com.gorshkov.server;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Starter {
    public static void main(String[] args) throws IOException {
        Server server = new Server(3000, new ContentReader("src/main/resources/"));
        server.start();
    }
}
