package com.example.workshop2024.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshop2024.dtos.LoginDTO;
import com.example.workshop2024.entities.Landing;
import com.example.workshop2024.services.LandingService;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/landings")
public class LandingController {

    @Autowired
    private LandingService landingService;

    @PostMapping("/quests")
     public ResponseEntity<Object> getQuests(@RequestBody LoginDTO loginDTO) {
        List<Landing> landings = landingService.getLandingsByUserId(loginDTO);
        if (landings.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(landings);
        }
    }
}