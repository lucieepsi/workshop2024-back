package com.example.workshop2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import com.example.workshop2024.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    @Query("SELECT u FROM User u ORDER BY u.totalPoints DESC")
    List<User> findTop3UsersByPoints();
}
