package com.example.workshop2024.services.impls;

import org.springframework.stereotype.Service;

import com.example.workshop2024.entities.User;
import com.example.workshop2024.repositories.UserRepository;
import com.example.workshop2024.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean authenticateUser(String email, String password) {
        User user = findByEmail(email);
        if (user != null) {
            return user.getPassword().equals(password);
        }
        return false;
    }
}