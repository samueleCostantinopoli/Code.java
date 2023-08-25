package com.example.fitnesshelp.bean;

import com.example.fitnesshelp.exception.*;

public class BeanPassword {

    private String password;

    public BeanPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String passwordCheck(String password) {
        try {
            BeanComplexity.checkComplexity(password);
        } catch (UpperCaseException | LowerCaseException | DigitException | SpecialException | LenghtException e) {
            return e.getMessage();
        }
        return null;
    }
}
