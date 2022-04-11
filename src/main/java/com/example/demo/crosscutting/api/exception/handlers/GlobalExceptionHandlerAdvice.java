package com.example.demo.crosscutting.api.exception.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    @ExceptionHandler(BaseApplicationException.class)
    public ResponseEntity<Object> onException(BaseApplicationException ex) {
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }

}
