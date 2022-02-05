package com.gorshkov.server;

import java.io.*;

public class ContentReader {
    private String webAppPath;

    public ContentReader(String webAppPath) {
        this.webAppPath = webAppPath;
    }

    public String readContent(String uri) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(webAppPath + uri));
        String line;
        StringBuilder result = new StringBuilder();
        while (!(line = reader.readLine()).isEmpty()) {
            result.append(line);
        }
        return result.toString();
    }
}
