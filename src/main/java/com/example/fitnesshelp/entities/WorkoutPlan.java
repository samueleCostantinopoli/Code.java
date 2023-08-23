package com.example.fitnesshelp.entities;

public class WorkoutPlan {

    private String name;
    private String day;
    private String username;

    public WorkoutPlan(String name, String day, String username) {
        this.name = name;
        this.day = day;
        this.username = username;
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

    public void setDay(String day) {
        this.day = day;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
