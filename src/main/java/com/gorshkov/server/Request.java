package com.gorshkov.server;

import java.util.Map;

public class Request {
    private String uri;
    private HttpMethod httpMethod;
    private Map<String, String[]> headers;

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    public void setHeaders(Map<String, String[]> headers) {
        this.headers = headers;
    }

    public String getUri() {
        return uri;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public Map<String, String[]> getHeaders() {
        return headers;
    }
}
