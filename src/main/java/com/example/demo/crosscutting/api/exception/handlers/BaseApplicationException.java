package com.example.demo.crosscutting.api.exception.handlers;

import java.util.List;

public class BaseApplicationException extends RuntimeException {

    public BaseApplicationException() {
        super();
    }

    public BaseApplicationException(String message) {
        super(message);
    }

    public BaseApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseApplicationException(List<String> ve) {
        super(String.join(",", ve));
    }
}
