package com.gorshkov.server;

public enum HttpStatus {
    OK(200, "OK"),
    NOT_FOUND(404, "NOT_FOUND"),
    INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR"),
    BAD_REQUEST(401, "BAD_REQUEST");

    private int code;
    private String message;

    HttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static HttpStatus getHttpStatus(String message) throws NoSuchHttpStatusException {
        if ("OK".equals(message)) {
            return OK;
        } else if ("NOT_FOUND".equals(message)) {
            return NOT_FOUND;
        } else if ("INTERNAL_SERVER_ERROR".equals(message)) {
            return INTERNAL_SERVER_ERROR;
        } else if ("BAD_REQUEST".equals(message)) {
            return BAD_REQUEST;
        }
        throw new NoSuchHttpStatusException("The code " + message + " does not exist.");
    }
}
