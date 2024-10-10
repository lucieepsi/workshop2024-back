package com.example.workshop2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workshop2024.entities.Reward;
import com.example.workshop2024.entities.Session;

public interface RewardRepository extends JpaRepository<Reward, Integer>{

}
