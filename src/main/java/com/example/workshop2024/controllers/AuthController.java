package com.example.workshop2024.controllers;

import java.util.Collections;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshop2024.dtos.LoginDTO;
import com.example.workshop2024.entities.User;
import com.example.workshop2024.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginDTO loginDTO) {
        boolean authenticated = userService.authenticateUser(loginDTO.getEmail(), loginDTO.getPassword());

        if (authenticated) {
            return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("message","Successful"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("message","Invalid"));
        }
    }

}
