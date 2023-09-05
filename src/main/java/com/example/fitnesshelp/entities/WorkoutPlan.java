package com.example.fitnesshelp.entities;

public class WorkoutPlan {

    private String name;
    private String day;
    private String username;
    private double prize;

    public WorkoutPlan(String name, String day, String username, double prize) {
        this.name = name;
        this.day = day;
        this.username = username;
        this.prize = prize;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public double getPrize() {
        return prize;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }
}
