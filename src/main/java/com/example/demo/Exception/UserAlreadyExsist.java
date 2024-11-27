package com.example.demo.Exception;

public class UserAlreadyExsist extends RuntimeException {
    public UserAlreadyExsist(String message) {
        super(message);
    }
}
