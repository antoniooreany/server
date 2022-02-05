package com.gorshkov.server;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public record RequestHandler(BufferedReader reader, BufferedWriter writer) {

    public void handle(String webAppPath) throws IOException, NoSuchHttpStatusException {
        RequestParser requestParser = new RequestParser();
        Request request = requestParser.parseRequest(reader);

        String uri = request.getUri();

        ContentReader contentReader = new ContentReader(webAppPath);
        String content = contentReader.readContent(uri);

        Map<String, String[]> headers = new HashMap<>();
        ResponseWriter responseWriter = new ResponseWriter();
        Response response = new Response(content, HttpStatus.OK, headers);
        responseWriter.writeResponse(writer, response);
    }
}
