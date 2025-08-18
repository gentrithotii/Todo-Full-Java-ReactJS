package com.gentrit.todo.controller;

import com.gentrit.todo.dto.UserRegisterDTO;
import com.gentrit.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "signup")
    public ResponseEntity<UserRegisterDTO> registerUser(@RequestBody UserRegisterDTO requestUser) {

       UserRegisterDTO savedUser =  userService.registerUser(requestUser).orElseThrow(() -> new RuntimeException("User could not regsiter"));

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

}
