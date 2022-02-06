package com.gorshkov.server;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ResponseWriter {
    public void writeResponse(Writer writer, Response response) throws IOException {
        String content = response.getContent();

        writer.write("HTTP/1.1 ");
        writer.write(response.getHttpStatus().getCode());
        writer.write(" ");
        writer.write(response.getHttpStatus().getMessage());
        //TODO implement writing of headers
        writer.write("\n\r");
        writer.write("\n\r");
        writer.write(content);
    }

    public void writeResponse(Writer writer, HttpStatus httpStatus) throws IOException {
        writer.write("HTTP/1.1 ");
        writer.write(httpStatus.getCode());
        writer.write(" ");
        writer.write(httpStatus.getMessage());
    }
}
