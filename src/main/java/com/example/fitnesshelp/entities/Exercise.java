package com.example.fitnesshelp.entities;

public class Exercise {

    private String exerciseName;
    private Muscle muscle;
    private int sets;
    private int reps;
    private float rest;
    private WorkoutPlan workoutPlan;

    public Exercise(String exerciseName, Muscle muscle, int sets, int reps, float rest, WorkoutPlan workoutPlan) {
        this.exerciseName = exerciseName;
        this.muscle = muscle;
        this.sets = sets;
        this.reps = reps;
        this.rest = rest;
        this.workoutPlan = workoutPlan;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
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

    public WorkoutPlan getWorkoutPlan() {
        return workoutPlan;
    }

    public void setWorkoutPlan(WorkoutPlan workoutPlan) {
        this.workoutPlan = workoutPlan;
    }
}
