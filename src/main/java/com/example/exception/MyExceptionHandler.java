package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorInfo> handleConflict(ResourceNotFoundException ex) {
        ErrorInfo e = new ErrorInfo(ex.getMessage());
        return new ResponseEntity<ErrorInfo>(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorInfo> handleConflict(MethodArgumentTypeMismatchException ex) {
        ErrorInfo e = new ErrorInfo("Argument type doesn't match");
        return new ResponseEntity<ErrorInfo>(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> handleConflict(Exception ex) {
        ErrorInfo e = new ErrorInfo("Something went wrong");
        return new ResponseEntity<ErrorInfo>(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
