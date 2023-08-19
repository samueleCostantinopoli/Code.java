package com.example.fitnesshelp.entities;

public class WorkoutPlan {

    private String name;
    private String day;
    private int userId;

    public WorkoutPlan(String name, String day, int userId) {
        this.name = name;
        this.day = day;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
