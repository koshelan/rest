package com.example.demo.exception;

public class UnauthorizedUser extends RuntimeException {

    public UnauthorizedUser(String s) {
        super(s);
    }
}
