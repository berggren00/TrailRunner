package com.example;

public class AverageSpeed {
    private AddDistance distance;
    private RunTime runtime;

    public AverageSpeed(AddDistance distance, RunTime runtime) {
        this.distance = distance;
        this.runtime = runtime;
    }

    public double calculateAverageSpeed() {
        double totalHours = runtime.getHours() + (runtime.getMinutes() / 60.0) + (runtime.getSeconds() / 3600.0);

        double totalDistance = distance.getTotalDistance();

        if(totalHours == 0) {
            throw new IllegalArgumentException("Tiden kan inte vara noll!!");
        }

        return Math.round(totalDistance / totalHours);
    }
    
}
