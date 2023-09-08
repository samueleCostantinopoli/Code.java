package com.example.fitnesshelp.bean;

public class BeanBuyWorkoutPlan {
    private double prize;
    private final String name;
    private String username;

    public BeanBuyWorkoutPlan(String name, double prize, String username) {
        this.name = name;
        this.prize = prize;
        this.username = username;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
