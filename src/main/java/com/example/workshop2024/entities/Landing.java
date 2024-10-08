package com.example.workshop2024.entities;

import jakarta.persistence.Column;
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
@Table(name="landing")
public class Landing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_landing")
    private int idLanding;

    @Column(name="description")
    private String description;

    @Column(name="points_required")
    private int pointsRequired;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name="id_reward")
    private Reward reward;
}
