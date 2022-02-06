package com.gorshkov.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class RequestHandler {
    private final BufferedReader reader;
    private final BufferedWriter writer;
    private final ContentReader contentReader;

    public RequestHandler(BufferedReader reader, BufferedWriter writer,
                          ContentReader contentReader) {
        this.reader = reader;
        this.writer = writer;
        this.contentReader = contentReader;
    }

    public void handle() throws IOException, NoSuchHttpStatusException {

        RequestParser requestParser = new RequestParser();
        Request request = requestParser.parseRequest(reader);
//        while (true) {
        String uri = request.getUri();

        String content = contentReader.readContent(uri);

        Map<String, String[]> headers = new HashMap<>();

        ResponseWriter responseWriter = new ResponseWriter();
        Response response = new Response(content, HttpStatus.OK, headers);
        responseWriter.writeResponse(writer, response);
//        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (RequestHandler) obj;
        return Objects.equals(this.reader, that.reader) &&
                Objects.equals(this.writer, that.writer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reader, writer, contentReader);
    }

    @Override
    public String toString() {
        return "RequestHandler{" +
                "reader=" + reader +
                ", writer=" + writer +
                ", contentReader=" + contentReader +
                '}';
    }
}
