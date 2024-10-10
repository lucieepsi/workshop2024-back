package com.example.workshop2024.services.impls;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.workshop2024.dtos.AverageResponse;
import com.example.workshop2024.dtos.LoginDTO;
import com.example.workshop2024.entities.User;
import com.example.workshop2024.projections.AverageProjection;
import com.example.workshop2024.projections.SessionProjection;
import com.example.workshop2024.repositories.SessionRepository;
import com.example.workshop2024.services.SessionService;
import com.example.workshop2024.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;
    private final UserService userService;

    public AverageResponse getWeeklyAverage(LoginDTO loginDTO) {

        String userEmail = loginDTO.getEmail();
    
        User user = userService.findByEmail(userEmail);
 
        if (user == null) {
            throw new RuntimeException("Utilisateur non trouvé");
        }
    
        int idUser = user.getIdUser();
    
        LocalDate startDate = LocalDate.now().with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
        LocalDate endDate = LocalDate.now().with(TemporalAdjusters.next(java.time.DayOfWeek.SUNDAY));

        AverageProjection result = sessionRepository.findAverage(idUser, startDate, endDate);
    
        Double averageCalories = (result.getAverageCalories() != null) ? result.getAverageCalories() : 0.0;
        Double averagePoints = (result.getAveragePoints() != null) ? result.getAveragePoints() : 0.0;
        Double averageDistance = (result.getAverageDistance() != null) ? result.getAverageDistance() : 0.0;
        Double averageRate = (result.getAverageRate() != null) ? result.getAverageDistance() : 0.0;
        Double averageDistanceKm = (averageDistance * 2.65) / 1000;
  
        return new AverageResponse(averageCalories, averagePoints, averageDistance, averageRate, averageDistanceKm);
    }

    @Override
    public Optional<SessionProjection> findLastSession(LoginDTO loginDTO) {
        String userEmail = loginDTO.getEmail();
        
        User user = userService.findByEmail(userEmail);

        int idUser = user.getIdUser();
 
        return sessionRepository.findFirstByUser_IdUserOrderBySessionDateDesc(idUser);
    }

}
