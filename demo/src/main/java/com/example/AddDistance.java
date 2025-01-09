package com.example;

    public class AddDistance {
        private double totalDistance;

        public AddDistance(){
            this.totalDistance = 0;
        }

        public void addDistance(double km){
            if (km < 0) {
                throw new IllegalArugmentException("Distance can not be negative");
            }
            this.totalDistance += km;
        }

        public double getTotalDistance(){
            return totalDistance
        }

    }