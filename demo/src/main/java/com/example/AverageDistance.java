package com.example;

import java.util.ArrayList;
import java.util.List;

public class AverageDistance {
    private List<Double> runs;

    public AverageDistance() {
        this.runs = new ArrayList<>();
    }

    public void addRun(double distance) {
        runs.add(distance);
    }

    public double calculateAverageDistance() {
        if (runs.isEmpty()) {
            return 0.0;
        }

        double totalDistance = 0.0;
        for (double distance : runs) {
            totalDistance += distance;
        }
        
        return totalDistance / runs.size();
    }
}
