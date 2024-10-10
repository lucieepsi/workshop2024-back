package com.example.workshop2024.services;

import java.util.List;

import com.example.workshop2024.dtos.LoginDTO;
import com.example.workshop2024.entities.Landing;

public interface LandingService {
     public List<Landing> getLandingsByUserId(LoginDTO loginDTO);
}
 