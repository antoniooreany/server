package com.gorshkov.server.model;

import com.gorshkov.server.exception.NoSuchHttpMethodException;

public enum HttpMethod {
    GET("GET"),
    POST("POST");

    private String value;

    HttpMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static HttpMethod getHttpMethod(String httpMethod) {
        if ("GET".equals(httpMethod)) {
            return GET;
        } else if ("POST".equals(httpMethod)) {
            return POST;
        }
        throw new NoSuchHttpMethodException("There is no method '" + httpMethod + "' like this.");
    }
}
