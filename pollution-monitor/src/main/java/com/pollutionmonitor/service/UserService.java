package com.pollutionmonitor.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pollutionmonitor.entity.User;
import com.pollutionmonitor.repository.UserRepository;

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