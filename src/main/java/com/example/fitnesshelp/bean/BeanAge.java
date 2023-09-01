package com.example.fitnesshelp.bean;

import com.example.fitnesshelp.exception.*;

public class BeanAge {

    private int age;

    public BeanAge(int age) {
        this.age = age;
    }

    public String verifyAge(int age) {
        try {
            BeanQuestionnaire.verifyAge(age);
        } catch (AgeException e) {
            return e.getMessage();
        }
        return null;
    }

    public int getAge() {
        return age;
    }
}
