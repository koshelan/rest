package com.example.demo.exception;

public class InvalidCredentials extends RuntimeException {

    public InvalidCredentials(String s) {
        super(s);
    }
}
