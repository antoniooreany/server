package com.gorshkov.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class RequestParser {

    public Request parseRequest(BufferedReader reader) throws IOException {
        Request request = new Request();
        injectUriAndHttpMethod(reader, request);
        injectHeaders(reader, request);
        return request;
    }

    private void injectUriAndHttpMethod(BufferedReader reader, Request request) throws IOException {
        String line = reader.readLine();
        String[] parts = line.split("\s");
        String uri = parts[1];
        request.setUri(uri);
        HttpMethod httpMethod = HttpMethod.getHttpMethod(parts[0]);
        request.setHttpMethod(httpMethod);
    }

    private void injectHeaders(BufferedReader reader, Request request) throws IOException {
        String line;
        HashMap<String, String[]> headers = new HashMap<>();
        while (!(line = reader.readLine()).isEmpty()) {
            String[] header = line.split(": ");
            String[] headerValues = header[1].split(", ");
            headers.put(header[0], headerValues);
        }
        request.setHeaders(headers);
    }
}