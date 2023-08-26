package com.example.fitnesshelp.bean;

import com.example.fitnesshelp.exception.LenghtException;

public class BeanUsername {

    private String username;

    public BeanUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String checkUsernameLength(String username) {
        try{
            BeanVerify.lenghtCheck(username);
        }catch (LenghtException e){
            return e.getMessage();
        }
        return null;
    }
}
