package com.example.fitnesshelp.application_controllers;

import com.example.fitnesshelp.bean.BeanCustomWorkoutData;
import com.example.fitnesshelp.dao.DaoImplFileSystemWorkoutPlan;
import com.example.fitnesshelp.dao.DaoImplFileSystemExercise;
import com.example.fitnesshelp.entities.Exercise;
import java.io.IOException;
import java.sql.SQLException;

public class ApplicationControllerCreateWorkoutPlan {
    public void receiveCustomWorkoutData(BeanCustomWorkoutData dataBean) throws SQLException, IOException {
        DaoImplFileSystemExercise daoImplFileSystemExercise = new DaoImplFileSystemExercise();

        for (int i = 0; i < 7; i++) {
            if (i < dataBean.getExerciseListSize()) {
                Exercise exercise = dataBean.getExercise(i);
                if (exercise != null) {
                    String exerciseData = exercise.getExerciseName();

                    if (exerciseData != null && !exerciseData.isEmpty()) {
                        daoImplFileSystemExercise.saveData(exercise);
                    }
                }
            }
        }

        DaoImplFileSystemWorkoutPlan daoImplFileSystemWorkoutPlan = new DaoImplFileSystemWorkoutPlan();
        daoImplFileSystemWorkoutPlan.saveData(dataBean.getExercise(0).getWorkoutPlan());
    }
}

