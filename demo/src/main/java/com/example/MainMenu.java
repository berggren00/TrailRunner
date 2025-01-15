package com.example;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while(!exit) {
            System.out.println("Choose an alternative:");
            System.out.println("1. Show Runtime");
            System.out.println("2. Show Average Speed");
            System.out.println("3. Show FitnessScore");
            System.out.println("4. Show total run distance");
            System.out.println("5. Show total runs");
            System.out.println("6. Show run ID's");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                showRunTime();
                break;
                case 2:
                showAverageSpeed();
                break;
                case 3:
                showFitnessScore();
                break;
                case 4:
                showRunDistance();
                break;
                case 5:
                showTotalRuns();
                break;
                case 6:
                showRunDetails();
                break;
                case 7:
                showExistingRunID(scanner);
                break;
            }
        }
    }

    private static void showRunTime() {
        RunTime runTime = new RunTime();
        System.out.println("Time elapsed " + runTime.getFormattedRunTime());
    }

    private static void showAverageSpeed() {
        AddDistance distance = new AddDistance();
        distance.addDistance(25.0);
        RunTime runTime = new RunTime(1, 29, 48);
        AverageSpeed averageSpeed = new AverageSpeed(distance, runTime);
        System.out.println("Your average speed for running 25km in 1:29:48 is: " + averageSpeed.calculateAverageSpeed() + "km/h");
    }

    private static void showFitnessScore() {
        AddDistance distance = new AddDistance();
        distance.addDistance(25.0); 
        RunTime runtime = new RunTime(1, 29, 48);
        AverageSpeed averageSpeed = new AverageSpeed(distance, runtime);
        double currentScore = 50.0; 
        int daysSinceLastRun = 5; 
        double fitnessScore = FitnessScore.calculateFitnessScore(currentScore, distance, averageSpeed, runtime, daysSinceLastRun);
        System.out.println("FitnessScore: " + fitnessScore);
    }

    private static void showRunDistance() {
        AddDistance distance = new AddDistance();
        distance.addDistance(25.0);
        System.out.println("Total distance of your run: " + distance.getTotalDistance() + "km");
    }

    private static void showTotalRuns() {
        TotalDistanceInKM totalDistance = new TotalDistanceInKM();
        totalDistance.addRun(10.0);
        totalDistance.addRun(15.0);
        totalDistance.addRun(25.0);
        System.out.println("Total number of runs: " + totalDistance.getTotalRuns());
        System.out.println("Total distance of runs: " + totalDistance.getTotalDistance() + "km");
    }

    private static void showRunDetails() {
        AddDistance distance = new AddDistance();
        distance.addDistance(25.0); // Add a certain distance
        RunTime runtime = new RunTime(1, 29, 48);
        AverageSpeed averageSpeed = new AverageSpeed(distance, runtime);
        double currentScore = 50.0; // Example current score
        int daysSinceLastRun = 5; // Example days since last run
        double fitnessScore = FitnessScore.calculateFitnessScore(currentScore, distance, averageSpeed, runtime, daysSinceLastRun);
        String todaysDate = "2023-10-10"; // Example today's date

        String runId = GenerateID.generateNewID(); // Generate a new run ID
        StringBuilder detailsBuilder = new StringBuilder();

        detailsBuilder.append("Run ID: ").append(runId).append("\n");
        detailsBuilder.append("Date: ").append(todaysDate).append("\n");
        detailsBuilder.append("Distance: ").append(distance.getTotalDistance()).append(" km\n");
        detailsBuilder.append("Time: ").append(runtime.getHours()).append("h ").append(runtime.getMinutes()).append("m ").append(runtime.getSeconds()).append("s\n");

        RunDetails.addRunDetails(runId, detailsBuilder.toString());
        RunDetails.printRunDetails(runId);
    }

    private static void showExistingRunID(Scanner scanner) {
        System.out.println("Enter the run ID:");
        String runId = scanner.next();
        RunDetails.printRunDetails(runId);
    }
    
}
