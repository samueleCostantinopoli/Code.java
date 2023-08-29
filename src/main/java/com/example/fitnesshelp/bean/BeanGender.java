package com.example.fitnesshelp.bean;

import com.example.fitnesshelp.entities.Gender;
import com.example.fitnesshelp.entities.State;

public class BeanGender {
    Gender gender;
    public BeanGender(Gender gender){
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }
}
