package com.gorshkov.server;

import java.io.*;

public record ContentReader(String webAppPath) {

    public String readContent(String uri) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(webAppPath + uri));
        String line = "";
        StringBuilder result = new StringBuilder();
        while (reader.readLine() != null /*|| !(line = reader.readLine()).isEmpty()*/) {
            result.append(line);
        }
        return result.toString();
    }
}
