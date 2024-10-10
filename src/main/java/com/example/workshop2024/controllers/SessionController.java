package com.example.workshop2024.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshop2024.dtos.ArduinoPacket;
import com.example.workshop2024.dtos.AverageResponse;
import com.example.workshop2024.dtos.LoginDTO;
import com.example.workshop2024.entities.Session;
import com.example.workshop2024.services.SessionService;

@CrossOrigin
@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

   @PostMapping("/average")
    public ResponseEntity<Object> getCurrentWeekAverage(@RequestBody LoginDTO loginDTO) {
        AverageResponse averages = sessionService.getWeeklyAverage(loginDTO);
        return ResponseEntity.ok(averages);
    }

    @PostMapping("/sendData")
    public ResponseEntity<Object> updateCurrentSession(@RequestBody ArduinoPacket arduinoPacket){
        Session s = sessionService.updateSession(arduinoPacket);
        return ResponseEntity.ok(s);
    }

}