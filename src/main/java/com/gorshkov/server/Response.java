package com.gorshkov.server;

import java.io.Reader;
import java.util.Map;

public class Response {
    private Reader content;
    private HttpCode httpCode;
    private Map<String, String[]> headers;
}
