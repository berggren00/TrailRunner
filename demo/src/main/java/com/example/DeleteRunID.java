package com.example;

import java.util.HashMap;
import java.util.Map;

public class DeleteRunID {
    private Map<String, Double> runs = new HashMap<>();

    public String addRun(double distance) {
        String runId = GenerateID.generateNewID();
        runs.put(runId, distance);
        return runId;
    }

    public void deleteRun(String runId) {
        if (runs.remove(runId) == null) {
            throw new IllegalArgumentException("Run not found");
        }
    }
}