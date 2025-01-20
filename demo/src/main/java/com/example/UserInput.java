package com.example;

public class UserInput {
    private int heightCm;
    private int ageYears;
    private double weightKg;

    public UserInput(int heightCm, int ageYears, double weightKg) {
        validateInputs(heightCm, ageYears, weightKg);
        this.heightCm = heightCm;
        this.ageYears = ageYears;
        this.weightKg = weightKg;
    }

    private void validateInputs(int heightCm, int ageYears, double weightKg) {
        if (heightCm <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
        if (ageYears <= 0) {
            throw new IllegalArgumentException("Age must be positive");
        }
        if (weightKg <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
    }

    public int getHeightCm() {
        return heightCm;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public double getWeightKg() {
        return weightKg;
    }
}
