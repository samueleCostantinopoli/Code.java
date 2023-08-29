package com.example.fitnesshelp.bean;

import com.example.fitnesshelp.exception.HeightException;
import com.example.fitnesshelp.exception.WeightException;

public class BeanWeight {

    private float weight;

    public BeanWeight(float weight) {
        this.weight = weight;
    }

    public String verifyWeight(float weight) throws WeightException {
        if (weight > 20 && weight < 200){
            return null;
        } else {
            throw new WeightException("the weigth must be between 20 kg and 200 kg\n");
        }
    }

    public float getWeight() {
        return weight;
    }
}
