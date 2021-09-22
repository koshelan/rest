package com.example.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class DemoExceptionHandler {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handleICE(InvalidCredentials e) {
        return ResponseEntity.status(401).body(e.getLocalizedMessage());
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> handleICE(UnauthorizedUser e) {
        return ResponseEntity.status(401).body(e.getLocalizedMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleCVE(ConstraintViolationException e) {
        return ResponseEntity.status(400).body(e.getLocalizedMessage());
    }

}
