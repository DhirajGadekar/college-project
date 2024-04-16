package com.security.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.jwt.entity.User;
import com.security.jwt.exception.EmailAlreadyExistsException;
import com.security.jwt.exception.NullVlauesException;
import com.security.jwt.exception.LoginCredentialWrongException;
import com.security.jwt.model.AuthenticationResponse;
import com.security.jwt.repository.UserRepository;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    public AuthenticationResponse register(User request) throws NullVlauesException, EmailAlreadyExistsException {

        if (request.getEmail() == null)
            throw new NullVlauesException("Email is null");

        if (request.getPassword() == null)
            throw new NullVlauesException("Password is null");

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        if (userService.emailExists(request.getEmail())) {

            throw new EmailAlreadyExistsException("Email already Used");
        }
        user = userRepository.save(user);

        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(User request) throws LoginCredentialWrongException {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(
                        () -> new LoginCredentialWrongException("Invalid Email or password. Please Enter valid Credentials..!"));

        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(request.getEmail());

        if (!passwordEncoder.matches(request.getPassword(), userDetails.getPassword())) {

            throw new LoginCredentialWrongException("Invalid Email or password. Please Enter valid Credentials..!");
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(token);
    }
}
