package com.example.fitnesshelp.bean;

public class BeanBuyWorkoutPlan {
    private double prize;
    public String name;
    public String username;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String Username) {
        this.username = Username;
    }
}
