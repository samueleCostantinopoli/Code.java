package com.example.fitnesshelp.entities;

import java.util.Date;

public class Purchase {

    private int idPurchase;
    private double price;
    private Date date;
    private int userId;
    private String workoutPlan;

    public Purchase(int idPurchase, double price, Date date, int userId, String workoutPlan) {
        this.idPurchase = idPurchase;
        this.price = price;
        this.date = date;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getWorkoutPlan() {
        return workoutPlan;
    }

    public void setWorkoutPlan(String workoutPlan) {
        this.workoutPlan = workoutPlan;
    }
}
