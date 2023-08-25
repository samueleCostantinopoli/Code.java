package com.example.fitnesshelp.bean;

import com.example.fitnesshelp.exception.DoubleCommaException;
import com.example.fitnesshelp.exception.DoubleSnailException;
import com.example.fitnesshelp.exception.EmailTerminatorException;

public class BeanEmail {

    private String email;

    public BeanEmail(String email) {
        this.email=email.toLowerCase();
    }
    public String getEmail() {
        return email;
    }

    public String emailCehck(){
        try {
            BeanVerify.syntaxCheck(email);
        }catch(DoubleSnailException | DoubleCommaException | EmailTerminatorException e){
            return e.getMessage();
        }
        return null;
    }
}
