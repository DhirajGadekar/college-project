package com.pollutionmonitor.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pollutionmonitor.entity.User;
import com.pollutionmonitor.exception.EmailAlreadyExistsException;
import com.pollutionmonitor.exception.LoginCredentialWrongException;
import com.pollutionmonitor.exception.NullVlauesException;
import com.pollutionmonitor.model.AuthenticationResponse;
import com.pollutionmonitor.service.AuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
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
