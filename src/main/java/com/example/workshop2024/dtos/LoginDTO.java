package com.example.workshop2024.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
}
