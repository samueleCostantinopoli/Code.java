package com.example.fitnesshelp.bean;

public class BeanAge {

    private int age;

    public BeanAge(int age) {
        this.age = age;
    }

    public boolean isValid() {
        return age >= 1 && age <= 99;
    }

    public int getAge() {
        return age;
    }
}
