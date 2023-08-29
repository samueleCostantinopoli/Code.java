package com.example.fitnesshelp.bean;

import com.example.fitnesshelp.exception.AgeException;
import com.example.fitnesshelp.exception.HeightException;

public class BeanHeight {

    private float height;

    public BeanHeight(float height) {
        this.height = height;
    }

    public String verifyHeight(float height) throws HeightException {
        if (height > 100 && height < 220){
            return null;
        } else {
            throw new HeightException("the height must be between 100 cm and 220 cm\n");
        }
    }

    public float getHeight() {
        return height;
    }
}
