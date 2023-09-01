package com.example.fitnesshelp.bean;

import com.example.fitnesshelp.exception.HeightException;

public class BeanHeight {

    private float height;

    public BeanHeight(float height) {
        this.height = height;
    }

    public String verifyHeight(float height) {
        try {
            BeanQuestionnaire.verifyHeight(height);
        } catch (HeightException e) {
            return e.getMessage();
        }
        return null;
    }

    public float getHeight() {
        return height;
    }
}
