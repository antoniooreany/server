package com.gorshkov.server;

import java.io.*;
import java.util.Objects;

public final class ContentReader {
    private final String webAppPath;

    public ContentReader(String webAppPath) {
        this.webAppPath = webAppPath;
    }

    public String readContent(String uri) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(webAppPath + uri));
        StringBuilder result = new StringBuilder();
        while (reader.ready()/* != null ||!(line = reader.readLine()).isEmpty()*/) {
            result.append(reader.readLine());
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ContentReader) obj;
        return Objects.equals(this.webAppPath, that.webAppPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(webAppPath);
    }

    @Override
    public String toString() {
        return "ContentReader[" +
                "webAppPath=" + webAppPath + ']';
    }

}
