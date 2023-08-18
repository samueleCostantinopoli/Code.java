package com.example.fitnesshelp.bean;

public class BeanWeight {

    private float weight;

    public BeanWeight(float weight) {
        this.weight = weight;
    }

    public boolean isValid() {
        return weight >= 30 && weight <= 190;
    }

    public float getWeight() {
        return weight;
    }
}
