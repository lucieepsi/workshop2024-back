package com.example.workshop2024.entities;

import java.security.Timestamp;
import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_session")
    private int idSession;

    @Column(name="distance")
    private Double distance;

    @Column(name="rate")
    private int rate;
    
    @Column(name="calories")
    private int calories;

    @Column(name="points")
    private int points;

    @Column(name="session_date")
    private LocalDate sessionDate;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;
    
}
