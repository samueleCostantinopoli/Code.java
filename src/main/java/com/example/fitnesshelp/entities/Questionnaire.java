package com.example.fitnesshelp.entities;

public class Questionnaire {

    private Gender gender;
    private int age;
    private float weight;
    private float height;
    private Activity activity;

    public Questionnaire(Gender gender, int age, float weight, float height, Activity activity) {
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.activity = activity;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}

enum Gender {
    MALE,
    FEMALE
}

enum Activity {
    SEDENTARY,
    LIGHT_EXERCISE,
    MODERATE_EXERCISE,
    HEAVY_EXERCISE,
    ATHLETE
}
