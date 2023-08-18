package com.example.fitnesshelp.bean;

public class AgeBean {

    private int age;

    public AgeBean(int age) {
        this.age = age;
    }

    public boolean isValid() {
        return age >= 1 && age <= 99;
    }

    public int getAge() {
        return age;
    }
}
