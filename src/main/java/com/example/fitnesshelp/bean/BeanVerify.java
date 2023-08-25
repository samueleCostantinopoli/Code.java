package com.example.fitnesshelp.bean;


import com.example.fitnesshelp.exception.DoubleSnailException;
import com.example.fitnesshelp.exception.DoubleCommaException;
import com.example.fitnesshelp.exception.EmailTerminatorException;

public class BeanVerify {
    // this bean provides methods to check the syntax
    private BeanVerify(){}
    public static void syntaxCheck(String email) throws DoubleSnailException, DoubleCommaException, EmailTerminatorException {
        int count1 = 0;
        int count2 = 0;
        count1 = email.indexOf('@');
        count2 = email.indexOf('@', count1 + 1);
        if (count2 != -1) {
            // launch exception
            throw new DoubleSnailException("the email must contain only one @");
        }
        if (email.indexOf(',') != -1) {
            throw new DoubleCommaException("email cannot contain a ','");
        }
        if(!(email.endsWith(".com") || email.endsWith(".it") || email.endsWith(".live"))){
            throw new EmailTerminatorException("the email must end with .com or .it or .live");
        }
    }
}
