package com.example.workshop2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workshop2024.entities.Reward;

public interface RewardRepository extends JpaRepository<Reward, Integer>{
    
}
