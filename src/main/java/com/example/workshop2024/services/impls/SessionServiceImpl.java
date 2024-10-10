package com.example.workshop2024.services.impls;

import java.security.Timestamp;
import java.sql.Time;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;


import org.springframework.stereotype.Service;

import com.example.workshop2024.dtos.ArduinoPacket;
import com.example.workshop2024.dtos.AverageResponse;
import com.example.workshop2024.dtos.LoginDTO;
import com.example.workshop2024.entities.Landing;
import com.example.workshop2024.entities.Session;
import com.example.workshop2024.entities.User;
import com.example.workshop2024.projections.AverageProjection;
import com.example.workshop2024.repositories.LandingRepository;
import com.example.workshop2024.repositories.RewardRepository;
import com.example.workshop2024.repositories.SessionRepository;
import com.example.workshop2024.services.SessionService;
import com.example.workshop2024.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;
    private final UserService userService;
    private final LandingRepository landingRepository;
    private final RewardRepository rewardRepository;

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
  
        return new AverageResponse(averageCalories, averagePoints, averageDistance);
    }

    public Session updateSession(ArduinoPacket arduinoPacket){
        String userEmail = arduinoPacket.getEmail();
        User user = userService.findByEmail(userEmail);

        if (user == null) {
            throw new RuntimeException("Utilisateur non trouvé");
        }

        Session lastSession = sessionRepository.findByUserOrderBySessionDateDesc(user);

        if(lastSession == null){
            lastSession = new Session();
        }
        


        lastSession.setPoints(arduinoPacket.getNbtours() + lastSession.getPoints());
        lastSession.setDistance(lastSession.getPoints()*2.65/1000);
        lastSession.setCalories((int)(lastSession.getDistance()*15));
        lastSession.setUser(user);
        lastSession.setRate((lastSession.getRate()+(int)((arduinoPacket.getNbtours()*2.6c5/3)*3.6))/2);
        lastSession.setSessionDate(LocalDate.now());
        
        if(arduinoPacket.getNbtours() == 0){
            lastSession.setRate(0);
        }
        
        sessionRepository.save(lastSession);
        

        return lastSession;        
    }
}
