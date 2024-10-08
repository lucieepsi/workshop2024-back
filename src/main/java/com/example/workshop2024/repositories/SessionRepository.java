package com.example.workshop2024.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.workshop2024.entities.Session;
import com.example.workshop2024.projections.AverageProjection;

public interface SessionRepository extends JpaRepository<Session, Integer> {
    @Query("SELECT AVG(s.calories) AS averageCalories, AVG(s.points) AS averagePoints , AVG(s.distance) AS averageDistance " +
            "FROM Session s " +
            "WHERE s.sessionDate >= :startDate AND s.sessionDate <= :endDate")
    AverageProjection findAverage(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
