package com.pollutionmonitor.exception;

public class LoginCredentialWrongException extends Exception {
    
    public LoginCredentialWrongException() {}

    public LoginCredentialWrongException(String msg) {

        super(msg);
    }
}
