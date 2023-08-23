package com.example.fitnesshelp.entities;

public class Tdee {

    private int kcal;
    private String username;
    private float pro;
    private float fat;
    private float carb;
    private String target;
    private String quantity;

    public Tdee(int kcal, String username, float pro, float fat, float carb, String target, String quantity){
        this.kcal = kcal;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
