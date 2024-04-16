package com.security.jwt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.jwt.entity.User;
import com.security.jwt.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean emailExists(String email) {

        Optional<User> byEmail = userRepository.findByEmail(email);
        if(byEmail.isPresent()) {

            return true;
        }
        return false;
    }
}