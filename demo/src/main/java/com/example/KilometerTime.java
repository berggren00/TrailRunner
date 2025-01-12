package com.example;


public class KilometerTime{

    public static double calculateKilometerTime(RunTime runTime, AddDistance distance) {

        int hours = runTime.getHours();
        int minutes = runTime.getMinutes();
        int seconds = runTime.getSeconds();

        double totalMinutes = hours * 60 + minutes + seconds / 60.0;

        double totalDistance = distance.getTotalDistance();

        if (totalMinutes < 0 || totalDistance <= 0) {
            return -1;
        }
        return totalMinutes/totalDistance;
    }

}
