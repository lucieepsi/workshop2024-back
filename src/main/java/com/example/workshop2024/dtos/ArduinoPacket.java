package com.example.workshop2024.dtos;

import com.example.workshop2024.entities.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArduinoPacket {

    @JsonProperty("nbTours")
    private int nbtours;

    @JsonProperty("email")
    private String email;

}
