package com.example.workshop2024.services;


import com.example.workshop2024.dtos.AverageResponse;
import com.example.workshop2024.dtos.LoginDTO;

public interface SessionService {
    
   AverageResponse getWeeklyAverage(LoginDTO loginDTO);
}
