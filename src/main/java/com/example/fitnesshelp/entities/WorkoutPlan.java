package com.example.fitnesshelp.entities;

public class WorkoutPlan {

    private String name;
    private String day;
    private String exercise;
    private String muscle;
    private int sets;
    private int reps;
    private float rest;
    private int userId;

    public WorkoutPlan(String name, String day, String exercise, String muscle, int sets, int reps, float rest, int userId) {
        this.name = name;
        this.day = day;
        this.exercise = exercise;
        this.muscle = muscle;
        this.sets = sets;
        this.reps = reps;
        this.rest = rest;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public String getMuscle() {
        return muscle;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public float getRest() {
        return rest;
    }

    public void setRest(float rest) {
        this.rest = rest;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
