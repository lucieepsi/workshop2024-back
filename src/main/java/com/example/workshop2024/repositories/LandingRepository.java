package com.example.workshop2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workshop2024.entities.Landing;

public interface LandingRepository extends JpaRepository<Landing, Integer>{
    
}
