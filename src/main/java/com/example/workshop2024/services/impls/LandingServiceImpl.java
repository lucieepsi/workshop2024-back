package com.example.workshop2024.services.impls;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.workshop2024.dtos.LoginDTO;
import com.example.workshop2024.entities.Landing;
import com.example.workshop2024.entities.User;
import com.example.workshop2024.repositories.LandingRepository;
import com.example.workshop2024.services.LandingService;
import com.example.workshop2024.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LandingServiceImpl implements LandingService {

    private final LandingRepository landingRepository;
    private final UserService userService;

    @Override
    public List<Landing> getLandingsByUserId(LoginDTO loginDTO) {;

        User user = userService.findByEmail(loginDTO.getEmail());
        int idUser = user.getIdUser();
        return landingRepository.findByUser_IdUser(idUser);
    }
}
