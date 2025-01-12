package com.example;

import java.util.ArrayList;
import java.util.List;


public class TotalDistanceInKM {
    private List<Double> runs;
    private AddDistance totalDistanceTracker;

    public TotalDistanceInKM() {
        this.runs = new ArrayList<>();
        this.totalDistanceTracker = new AddDistance();
    }

    public void addRun(double km) {
        runs.add(km);
        this.totalDistanceTracker.addDistance(km);
    }

    public double getTotalDistance() {
        return totalDistanceTracker.getTotalDistance();
    }

    public int getTotalRuns() {
        return runs.size();
    }
}
