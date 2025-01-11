package com.example;

public class FitnessScore {
    
    public double calculateFitnessScore(double currentScore, AddDistance addDistance, AverageSpeed averageSpeedCalc, RunTime runTime, int daysSinceLastRun){
        if (addDistance == null || averageSpeedCalc == null || runTime == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        double distance = addDistance.getTotalDistance();
        double averageSpeed = averageSpeedCalc.calculateAverageSpeed();
        double kilometreTime = KilometerTime.calculateKilometerTime(runTime, addDistance);

        if (kilometreTime <= 0) {
            throw new IllegalArgumentException("Invalid kilometer time");
        
    }
    double fitnessScore = currentScore + (distance + averageSpeed / kilometreTime) - daysSinceLastRun / 2.0;
    return fitnessScore;

    }
}

