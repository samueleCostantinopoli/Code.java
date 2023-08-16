package com.example.fitnesshelp.entities;

public class Tdee {

    private int kcal;
    private int userId;
    private float pro;
    private float fat;
    private float carb;

    public Tdee(int kcal, int userId, float pro, float fat, float carb){
        this.kcal = kcal;
        this.userId = userId;
        this.pro = pro;
        this.fat = fat;
        this.carb = carb;
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

}
