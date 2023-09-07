package com.example.fitnesshelp.bean;

public class BeanBuyWorkoutPlan {
    public double prize;
    public String name;
    public String Username;


    public BeanBuyWorkoutPlan (String name, double prize, String Username){
        this.name = name;
        this.prize = prize;
        this.Username = Username;
    }

    public double getPrize(){
        return prize;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return Username;
    }
}
