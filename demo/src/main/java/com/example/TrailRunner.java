package com.example;

public class TrailRunner {


    public class DistanceTracker(){
        private double totalDistance;

        public DistanceTracker(){
            this.totalDistance = 0;
        }

        public void addDistance(double km){
            if (km < 0) {
                throw new IllegalArgumentException("Distance can not be negative");
            }
            this.totalDistance += km;
        }

        public double getTotalDistance() {
            return this.totalDistance;
        }
    }



}
