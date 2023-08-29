package com.example.fitnesshelp.bean;

import com.example.fitnesshelp.exception.AgeException;
import com.example.fitnesshelp.exception.UpperCaseException;

public class BeanAge {

    private int age;

    public BeanAge(int age) {
        this.age = age;
    }

    public String verifyAge(int age) throws AgeException {
        if(age > 1 && age < 100){
            return null;
        } else {
            throw new AgeException("the age must be between 1 and 99\n");
        }
    }

    public int getAge() {
        return age;
    }
}
