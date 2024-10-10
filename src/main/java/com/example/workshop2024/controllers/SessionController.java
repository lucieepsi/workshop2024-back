package com.example.workshop2024.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshop2024.dtos.AverageResponse;
import com.example.workshop2024.dtos.LoginDTO;
import com.example.workshop2024.projections.SessionProjection;
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

    @PostMapping("/last")
    public ResponseEntity<Object> getLastSession(@RequestBody LoginDTO loginDTO) {
        Optional<SessionProjection> lastSession = sessionService.findLastSession(loginDTO);
        if (lastSession.isPresent()) {
            return ResponseEntity.ok(lastSession.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}