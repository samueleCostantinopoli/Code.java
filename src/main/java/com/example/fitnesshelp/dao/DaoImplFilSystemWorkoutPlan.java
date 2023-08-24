package com.example.fitnesshelp.dao;

import com.example.fitnesshelp.entities.Questionnaire;
import com.example.fitnesshelp.entities.Tdee;
import com.example.fitnesshelp.entities.WorkoutPlan;

import java.util.List;

public class DaoImplFilSystemWorkoutPlan implements DaoEntity<WorkoutPlan>{
    @Override
    public void saveData(WorkoutPlan workoutPlan){}

    @Override
    public List<WorkoutPlan> showData(){
        return null;
    }
}
