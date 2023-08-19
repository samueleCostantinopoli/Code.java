package com.example.fitnesshelp.entities;

public class Tdee {

    private int kcal;
    private int userId;
    private float pro;
    private float fat;
    private float carb;
    private String target;
    private String quantity;

    public Tdee(int kcal, int userId, float pro, float fat, float carb, String target, String quantity){
        this.kcal = kcal;
        this.userId = userId;
        this.pro = pro;
        this.fat = fat;
        this.carb = carb;
        this.target = target;
        this.quantity = quantity;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getPro() {
        return pro;
    }

    public void setPro(float pro) {
        this.pro = pro;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public float getCarb() {
        return carb;
    }

    public void setCarb(float carb) {
        this.carb = carb;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
