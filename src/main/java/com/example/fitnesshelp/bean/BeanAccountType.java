package com.example.fitnesshelp.bean;

import com.example.fitnesshelp.entities.TypeOfUser;

public class BeanAccountType {

    private String typeOfUser;

    public BeanAccountType(String typeOfUser){
        this.typeOfUser = typeOfUser;
    }

    public String getTypeOfUser(){return typeOfUser;}
}
