package com.example;

public class RunTime {
    private int hours;
    private int minutes;
    private int seconds;

    public RunTime(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public RunTime() {
        this(1, 29 , 48);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public String getFormattedRunTime() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
