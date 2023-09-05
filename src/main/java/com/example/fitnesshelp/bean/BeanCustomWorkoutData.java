package com.example.fitnesshelp.bean;

import com.example.fitnesshelp.entities.Exercise;

import java.util.ArrayList;
import java.util.List;

public class BeanCustomWorkoutData {


    /*public void setExercise(Exercise exercise, int number) {
        this.exerciseList.set(number, exercise);
    }

     */

    private List<Exercise> exerciseList = new ArrayList<>();

    public void setExercise(Exercise exercise) {
        exerciseList.add(exercise);
    }

    public Exercise getExercise(int i) {
        return exerciseList.get(i);
    }

    public int getExerciseListSize() {
        return exerciseList.size();
    }
}