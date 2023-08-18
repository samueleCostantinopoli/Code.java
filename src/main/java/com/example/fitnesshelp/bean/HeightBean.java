package com.example.fitnesshelp.bean;

public class HeightBean {

    private float height;

    public HeightBean(float height) {
        this.height = height;
    }

    public boolean isValid() {
        return height >= 100 && height <= 220;
    }

    public float getHeight() {
        return height;
    }
}
