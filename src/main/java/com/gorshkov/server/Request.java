package com.gorshkov.server;

import java.util.Map;

public class Request {
    private String uri;
    private HttpMethod httpMethod;
    private Map<String, String[]> headers;
}
