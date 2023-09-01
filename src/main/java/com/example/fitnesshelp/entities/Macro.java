package com.example.fitnesshelp.entities;

public class Macro {
    private float pro;
    private float fat;
    private float carb;

    public Macro(float pro, float fat, float carb) {
        this.pro = pro;
        this.fat = fat;
        this.carb = carb;
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
