package com.example.workshop2024.projections;

import java.time.*;

public interface SessionProjection {
    LocalDate getSessionDate();
    Double getCalories();
    Double getDistance();
    Double getRate();
    LocalTime getStartTime();
}
