package com.example.workshop2024.services;

import com.example.workshop2024.entities.User;

import java.util.List;

public interface UserService {

    User findByEmail(String email);

    boolean authenticateUser(String email, String password);

    List<User> getTop3UsersByPoints();
}
