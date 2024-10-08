package com.example.workshop2024.services.impls;

import java.sql.Time;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.workshop2024.dtos.AverageResponse;
import com.example.workshop2024.dtos.LoginDTO;
import com.example.workshop2024.entities.User;
import com.example.workshop2024.projections.AverageProjection;
import com.example.workshop2024.repositories.SessionRepository;
import com.example.workshop2024.services.SessionService;
import com.example.workshop2024.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;

    public AverageResponse getWeeklyAverage(LoginDTO loginDTO) {
        
        LocalDate startDate = LocalDate.now().with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
        LocalDate endDate = LocalDate.now().with(TemporalAdjusters.next(java.time.DayOfWeek.SUNDAY));

        AverageProjection result = sessionRepository.findAverage(startDate, endDate);

        Double averageCalories = (result.getAverageCalories() != null) ? result.getAverageCalories() : 0.0;
        Double averagePoints = (result.getAveragePoints() != null) ? result.getAveragePoints() : 0.0;
        Double averageDistance = (result.getAverageDistance() != null) ? result.getAverageDistance() : 0.0;
    
        System.out.println(result.getAverageCalories());

        return new AverageResponse(averageCalories, averagePoints, averageDistance);
    }
}
