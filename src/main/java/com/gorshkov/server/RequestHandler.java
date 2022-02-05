package com.gorshkov.server;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler {
    private BufferedReader reader;
    private BufferedWriter writer;
    private ContentReader contentReader;

    public RequestHandler(BufferedReader reader, BufferedWriter writer, ContentReader contentReader) {
        this.reader = reader;
        this.writer = writer;
        this.contentReader = contentReader;
    }

    public void handle() throws IOException, NoSuchHttpCodeException {
        RequestParser requestParser = new RequestParser();
        Request request = requestParser.parseRequest(reader);

        String uri = request.getUri();

        ContentReader contentReader = new ContentReader("src/main/resources/");
        String content = contentReader.readContent(uri);


        Map<String, String[]> headers = new HashMap<>();
        ResponseWriter responseWriter = new ResponseWriter();
        Response response = new Response(content, HttpStatus.OK, headers);
        responseWriter.writeResponse(writer, response);
    }
}
