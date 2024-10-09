package com.example.workshop2024.dtos;


public class AverageResponse {
    private Double averageCalories;
    private Double averagePoints;
    private Double averageDistance;

    public AverageResponse(Double averageCalories, Double averagePoints, Double averageDistance) {
        this.averageCalories = averageCalories;
        this.averagePoints = averagePoints;
        this.averageDistance = averageDistance;
    }

    public Double getAverageCalories() {
        return averageCalories;
    }

    public Double getAveragePoints() {
        return averagePoints;
    }

    public Double getAverageDistance() {
        return averageDistance;
    }
}
