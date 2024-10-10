package com.example.workshop2024.dtos;


public class AverageResponse {
    private Double averageCalories;
    private Double averagePoints;
    private Double averageDistance;
    private Double averageRate;
    private Double averageDistanceKm;

    public AverageResponse(Double averageCalories, Double averagePoints, Double averageDistance, Double averageRate, Double averageDistanceKm) {
        this.averageCalories = averageCalories;
        this.averagePoints = averagePoints;
        this.averageDistance = averageDistance;
        this.averageRate = averageRate;
        this.averageDistanceKm = averageDistanceKm;
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

    public Double getAverageRate() {
        return averageRate;
    }

    public Double getAverageDistanceKm() {
        return averageDistanceKm;
    }
}
