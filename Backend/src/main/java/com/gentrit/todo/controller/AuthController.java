package com.gentrit.todo.controller;

import com.gentrit.todo.dto.UserDTO;
import com.gentrit.todo.dto.UserDetailsDTO;
import com.gentrit.todo.dto.UserRegisterDTO;

import com.gentrit.todo.service.UserService;
import com.gentrit.todo.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtils;
    private final UserService userService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserService userService, JwtUtil jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userService = userService;
    }

    @PostMapping("/signin")
    public String authenticateUser(@RequestBody UserDTO user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return jwtUtils.generateToken(userDetails.getUsername());
    }

    @PostMapping("/signup")
    public ResponseEntity<UserRegisterDTO> registerUser(@RequestBody UserRegisterDTO user) {
        UserRegisterDTO newUser = new UserRegisterDTO(
                user.getUsername(), user.getPassword(),
                new UserDetailsDTO(user.getUserDetailsDTO()
                        .getFirstName(),
                        user.getUserDetailsDTO()
                                .getLastName(),
                        user.getUserDetailsDTO()
                                .getEmail(), user.getUserDetailsDTO()
                        .getSex()));

        userService.registerUser(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
}