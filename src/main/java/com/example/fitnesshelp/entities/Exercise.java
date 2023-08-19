package com.example.fitnesshelp.entities;

public class Exercise {

    private String exercise;
    private Muscle muscle;
    private int sets;
    private int reps;
    private float rest;
    private String workoutPlan;

    public Exercise(String exercise, Muscle muscle, int sets, int reps, float rest, String workoutPlan) {
        this.exercise = exercise;
        this.muscle = muscle;
        this.sets = sets;
        this.reps = reps;
        this.rest = rest;
        this.workoutPlan = workoutPlan;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public Muscle getMuscle() {
        return muscle;
    }

    public void setMuscle(Muscle muscle) {
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

    public String getWorkoutPlan() {
        return workoutPlan;
    }

    public void setWorkoutPlan(String workoutPlan) {
        this.workoutPlan = workoutPlan;
    }
}
