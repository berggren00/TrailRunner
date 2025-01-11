package com.example;

import java.util.HashMap;

public class RunDetails {
    private static final HashMap<String, String> runDetails = new HashMap<>();
    
    
    public static void addRundetails(String id, String details) {
        runDetails.put(id, details);
    }

    public static String getRunDetails(String id) {
        return runDetails.getOrDefault(id, "No details found for ID: " +id);
    }

    public static void printRunDetails(String id) {
        String details = getRunDetails(id);
        System.out.println("Run ID: " + id);
        System.out.println("Details: " + details);
    }

    public static void interigateRunDetails(String id, AddDistance distance, RunTime runTime, AverageSpeed averageSpeedCalc, KilometerTime kilometerTime, FitnessScore fitnessScore, TodaysDate todaysDate) {
        StringBuilder detailsBuilder = new StringBuilder();

        detailsBuilder.append("Distance: ").append(distance.getTotalDistance()).append(" km\n");
        detailsBuilder.append("Time: ").append(runTime.getHours()).append("h ").append(runTime.getMinutes()).append("m ").append(runTime.getSeconds()).append("s\n");
        try {
            detailsBuilder.append("Average Speed: ").append(averageSpeedCalc.calculateAverageSpeed()).append("km/h\n");
        } catch (IllegalArgumentException e) {
            detailsBuilder.append("Average Speed: Error calculating\n");
        }

        try {
            detailsBuilder.append("Kilometer time: ").append(KilometerTime.calculateKilometerTime(runTime, distance)).append("m/kmn");
        } catch (IllegalArgumentException e) {
            detailsBuilder.append("Kilometer Time: Error calculating\n");
        }

        try {
            detailsBuilder.append("Fitness Score: ").append(FitnessScore.calculateFitnessScore(0, distance, averageSpeedCalc, runTime, 0)).append("\n");
        } catch (IllegalArgumentException e) {
            detailsBuilder.append("Fitness Score: Error calculating");
        }

        addRundetails(id, detailsBuilder.toString());
    }
    public static void clearRunDetails(){
        runDetails.clear();
    }
}
