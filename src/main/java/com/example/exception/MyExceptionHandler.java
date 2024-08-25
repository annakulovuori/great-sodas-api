package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorInfo> handleConflict(ResourceNotFoundException ex) {
        ErrorInfo e = new ErrorInfo("Could not find with id " + ex.getSodaId());
        return new ResponseEntity<ErrorInfo>(e, HttpStatus.NOT_FOUND);
    }
}
