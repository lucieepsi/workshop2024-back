package com.example.workshop2024.entities;

import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_session")
    private int idSession;

    @Column(name="duration")
    private Timestamp duration;

    @Column(name="distance")
    private String distance;

    @Column(name="rate")
    private int rate;
    
    @Column(name="calories")
    private int calories;

    @Column(name="points")
    private int points;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;
    
}
