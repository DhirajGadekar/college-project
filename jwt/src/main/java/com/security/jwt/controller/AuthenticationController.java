package com.security.jwt.controller;

import org.springframework.web.bind.annotation.RestController;

import com.security.jwt.entity.User;
import com.security.jwt.exception.EmailAlreadyExistsException;
import com.security.jwt.exception.NullVlauesException;
import com.security.jwt.exception.LoginCredentialWrongException;
import com.security.jwt.model.AuthenticationResponse;
import com.security.jwt.service.AuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody User request) throws NullVlauesException, EmailAlreadyExistsException {

        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> loginUser(@RequestBody User user) throws LoginCredentialWrongException {

        return ResponseEntity.ok(authenticationService.authenticate(user));
    }

}
