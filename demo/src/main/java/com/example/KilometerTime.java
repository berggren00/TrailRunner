package com.example;


public class KilometerTime{

    RunTime runtime = new RunTime(0, 0, 0);
    AddDistance addDistance = new AddDistance();

    public static double calculateKilometerTime(Runtime runTime, AddDistance addDistance) {
        if (runTime == null || addDistance == null) {
            return -1;
        }
        int hours = runTime.getHours();
        int minutes = runTime.getMinutes();
        int seconds = runTime.getSeconds();

        double totalMinutes = hours * 60 + minutes + seconds / 60.0;

        double totalDistance = addDistance.getTotalDistance();

        if (totalMinutes < 0 || totalDistance <= 0) {
            return -1;
        }
        return totalMinutes/totalDistance;
    }

}
