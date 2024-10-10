package com.example.workshop2024.repositories;

import java.time.LocalDate;
import java.util.List;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.workshop2024.entities.Session;
import com.example.workshop2024.entities.User;
import com.example.workshop2024.projections.AverageProjection;
import com.example.workshop2024.projections.SessionProjection;

public interface SessionRepository extends JpaRepository<Session, Integer> {
        @Query("SELECT AVG(s.calories) AS averageCalories, AVG(s.points) AS averagePoints , AVG(s.distance) AS averageDistance , AVG(s.rate) AS averageRate "
                        +
                        "FROM Session s " +
                        "WHERE s.sessionDate >= :startDate AND s.sessionDate <= :endDate " +
                        "AND s.user.id = :idUser")
        AverageProjection findAverage(@Param("idUser") int idUser, @Param("startDate") LocalDate startDate,
                        @Param("endDate") LocalDate endDate);

        @Query("SELECT s.sessionDate AS date, AVG(s.calories) AS averageCalories, AVG(s.distance) AS averageDistance " +
                        "FROM Session s " +
                        "WHERE s.sessionDate >= :startDate AND s.sessionDate <= :endDate " +
                        "AND s.user.id = :idUser " +
                        "GROUP BY s.sessionDate")
        List<AverageProjection> findDailyAverage(
                        @Param("idUser") int idUser,
                        @Param("startDate") LocalDate startDate,
                        @Param("endDate") LocalDate endDate);

        Optional<SessionProjection> findFirstByUser_IdUserOrderBySessionDateDesc(int idUser);

        Session findByUserOrderBySessionDateDesc(User user);

}
