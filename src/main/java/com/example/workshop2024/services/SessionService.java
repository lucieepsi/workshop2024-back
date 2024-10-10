package com.example.workshop2024.services;


import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;

import com.example.workshop2024.dtos.ArduinoPacket;
import com.example.workshop2024.dtos.AverageResponse;
import com.example.workshop2024.dtos.LoginDTO;
import com.example.workshop2024.entities.Session;

public interface SessionService {
    
   AverageResponse getWeeklyAverage(LoginDTO loginDTO);

   Session updateSession(ArduinoPacket arduinoPacket);
}
