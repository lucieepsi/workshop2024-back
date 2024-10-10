package com.example.workshop2024.services;

import java.util.Optional;

import com.example.workshop2024.dtos.AverageResponse;
import com.example.workshop2024.dtos.LoginDTO;
import com.example.workshop2024.projections.SessionProjection;

public interface SessionService {
    
   AverageResponse getWeeklyAverage(LoginDTO loginDTO);
   Optional<SessionProjection> findLastSession(LoginDTO loginDTO);

}
