package com.gorshkov.server;

import java.io.Reader;
import java.util.Map;

public class Response {
    private String content;
    private HttpStatus httpStatus;
    private Map<String, String[]> headers;

    public Response(String content, HttpStatus httpStatus, Map<String, String[]> headers) {
        this.httpStatus = httpStatus;
        this.headers = headers;
        this.content = content;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Map<String, String[]> getHeaders() {
        return headers;
    }

    public String getContent() {
        return content;
    }
}
