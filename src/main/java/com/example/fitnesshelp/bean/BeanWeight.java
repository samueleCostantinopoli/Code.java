package com.example.fitnesshelp.bean;

import com.example.fitnesshelp.exception.WeightException;

public class BeanWeight {

    private float weight;

    public BeanWeight(float weight) {
        this.weight = weight;
    }

    public String verifyWeight(float weight) {
        try {
            BeanQuestionnaire.verifyWeight(weight);
        } catch (WeightException e) {
            return e.getMessage();
        }
        return null;
    }

    public float getWeight() {
        return weight;
    }
}
