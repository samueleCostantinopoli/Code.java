package com.example.fitnesshelp.application_controllers;

import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.dao.DaoImplFilSystemWorkoutPlan;
import com.example.fitnesshelp.dao.DaoImplFileSystemExercise;
import com.example.fitnesshelp.entities.Exercise;
import com.example.fitnesshelp.entities.WorkoutPlan;
import com.example.fitnesshelp.utils.UtilityAccess;

import java.io.IOException;
import java.util.List;


public class ApplicationControllerBuyWorkoutPlan {
    int prize;
    String state;

    public ApplicationControllerBuyWorkoutPlan(BeanState stateUser) {
        this.state = stateUser.toString();
    }

    public List<WorkoutPlan> checkWorkoutPlan() throws IOException {
        DaoImplFilSystemWorkoutPlan daoImplFilSystemWorkoutPlan = new DaoImplFilSystemWorkoutPlan();
        return daoImplFilSystemWorkoutPlan.showData(UtilityAccess.getUsername());
    }

    public List<Exercise> checkExercise() throws IOException {
        DaoImplFileSystemExercise daoImplFileSystemExercise = new DaoImplFileSystemExercise();
        return daoImplFileSystemExercise.showData(UtilityAccess.getUsername());
    }
}
