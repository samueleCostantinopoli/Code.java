package com.example.fitnesshelp.bean;

import com.example.fitnesshelp.exception.AgeException;
import com.example.fitnesshelp.exception.HeightException;
import com.example.fitnesshelp.exception.WeightException;

public class BeanQuestionnaire {

    private BeanQuestionnaire(){}

    public static void verifyAge(int age) throws AgeException {
        if(!(age > 0 && age < 121)){
            // lunch exception
            throw new AgeException("The age must be between 1 and 120\n");
        }
    }

    public static void verifyWeight(float weight) throws WeightException {
        if(!(weight > 1 && weight < 201)){
            // lunch exception
            throw new WeightException("The weight must be between 1 and 200 kg\n");
        }
    }

    public static void verifyHeight(float height) throws HeightException {
        if(!(height > 20 && height < 241)){
            // lunch exception
            throw new HeightException("The height must be between 20 and 240 cm\n");
        }
    }
}
