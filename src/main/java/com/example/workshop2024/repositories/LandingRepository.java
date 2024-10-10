package com.example.workshop2024.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.workshop2024.entities.Landing;
import com.example.workshop2024.entities.User;

public interface LandingRepository extends JpaRepository<Landing, Integer>{
    List<Landing> findByUser_IdUser(int userId);
    List<Landing> findByUser(User user);
}
