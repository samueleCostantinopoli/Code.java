package com.example.fitnesshelp.entities;

import java.util.Date;

public class Purchase {

    private int idPurchase;
    private double price;
    private Date date;
    private String username;
    private String workoutPlan;

    public Purchase(int idPurchase, double price, Date date, String username, String workoutPlan) {
        this.idPurchase = idPurchase;
        this.price = price;
        this.date = date;
        this.username = username;
        this.workoutPlan = workoutPlan;
    }

    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWorkoutPlan() {
        return workoutPlan;
    }

    public void setWorkoutPlan(String workoutPlan) {
        this.workoutPlan = workoutPlan;
    }
}
