package com.example.workshop2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workshop2024.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
