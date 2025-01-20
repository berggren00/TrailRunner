package com.example;

import java.util.Scanner;
import java.util.Set;

public class MainMenu {
    private static DeleteRunID deleteRunID = new DeleteRunID();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        String testRunId = deleteRunID.addRun(10.0);
        System.out.println("Generated test run ID: " + testRunId);

        placeHolderRunDetails(testRunId);

        while(!exit) {
            System.out.println("Choose an alternative:");
            System.out.println("1. Show Runtime");
            System.out.println("2. Show Average Speed");
            System.out.println("3. Show FitnessScore");
            System.out.println("4. Show total run distance");
            System.out.println("5. Show total runs");
            System.out.println("6. Show run details");
            System.out.println("7. Show run ID's");
            System.out.println("8. Delete run by ID");
            System.out.println("9. Exit");

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
                    showRunDetails(scanner);
                    break;
                case 7:
                    showRunIDs();
                    break;
                case 8:
                    deleteRun(scanner);
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void placeHolderRunDetails(String runId) {
        String placeholderDetails = "Date: 2023-10-01\n" +
                                    "Distance: 10.0 km\n" +
                                    "Time: 1h 29m 33s\n" +
                                    "Average Speed: 10.0 km/h\n" +
                                    "Kilometer Time: 8.9 min/km\n" +
                                    "Fitness Score: 82.3\n";
        RunDetails.addRunDetails(runId, placeholderDetails);
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

    private static void deleteRun(Scanner scanner) {
        System.out.println("Enter the run ID to delete:");
        String runId = scanner.next();
        try {
            deleteRunID.deleteRun(runId);
            System.out.println("Run deleted successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showRunDetails(Scanner scanner) {
        System.out.println("Enter the run ID to print details:");
        String runId = scanner.next();
        RunDetails.printRunDetails(runId);
    }

    private static void showRunIDs() {
        Set<String> runIDs = deleteRunID.getRunIDs();
        System.out.println("Run IDs:");
        for (String id : runIDs) {
            System.out.println(id);
        }
    }

    
    
}
