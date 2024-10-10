package com.example.workshop2024.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshop2024.entities.User;
import com.example.workshop2024.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/topPoints")
    public ResponseEntity<Object> getTop3UsersByPoints() {
        List<User> topUsers = userService.getTop3UsersByPoints();
        return ResponseEntity.ok(topUsers);
    }
}
