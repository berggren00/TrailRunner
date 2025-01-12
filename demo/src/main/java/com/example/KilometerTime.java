package com.example;


public class KilometerTime{

    public static double calculateKilometerTime(RunTime runTime, AddDistance distance) {
        if (runTime == null || distance == null) {
            throw new IllegalArgumentException("Input can not be null");
        }

        int hours = runTime.getHours();
        int minutes = runTime.getMinutes();
        int seconds = runTime.getSeconds();

        double totalMinutes = hours * 60 + minutes + seconds / 60.0;

        double totalDistance = distance.getTotalDistance();

        if (totalMinutes < 0 || totalDistance <= 0) {
            throw new IllegalArgumentException("Input can not be negative");
        }
        return totalMinutes/totalDistance;
    }

}
