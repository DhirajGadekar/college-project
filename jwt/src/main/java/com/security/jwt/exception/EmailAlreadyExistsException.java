package com.security.jwt.exception;

public class EmailAlreadyExistsException extends Exception {
    
    public EmailAlreadyExistsException() {}

    public EmailAlreadyExistsException(String message) {

        super(message);
    }
}
