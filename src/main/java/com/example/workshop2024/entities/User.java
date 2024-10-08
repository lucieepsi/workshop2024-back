package com.example.workshop2024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private int idUser;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="firstname")
    private String firstname;

    @Column(name="password")
    private String password;

    @Column(name="total_points")
    private String totalPoints;
}
