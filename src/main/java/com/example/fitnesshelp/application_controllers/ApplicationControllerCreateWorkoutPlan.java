package com.example.fitnesshelp.application_controllers;

import com.example.fitnesshelp.bean.BeanCustomWorkoutData;
import com.example.fitnesshelp.dao.DaoImplFilSystemWorkoutPlan;
import com.example.fitnesshelp.dao.DaoImplFileSystemExercise;
import com.example.fitnesshelp.entities.Exercise;
import com.example.fitnesshelp.utils.UtilityAccess;

import java.io.IOException;
import java.sql.SQLException;

public class ApplicationControllerCreateWorkoutPlan {
    public void receiveCustomWorkoutData(BeanCustomWorkoutData dataBean) throws SQLException, IOException {
        DaoImplFileSystemExercise daoImplFileSystemExercise = new DaoImplFileSystemExercise();

        for (int i = 0; i < 7; i++) {
            if (i < dataBean.getExerciseListSize()) {
                Exercise exercise = dataBean.getExercise(i);

                if (exercise != null) {
                    String exerciseData = exercise.getExercise();

                    if (exerciseData != null && !exerciseData.isEmpty()) {
                        daoImplFileSystemExercise.saveData(exercise);
                    }
                }
            }
        }

        DaoImplFilSystemWorkoutPlan daoImplFilSystemWorkoutPlan = new DaoImplFilSystemWorkoutPlan();
        daoImplFilSystemWorkoutPlan.saveData(dataBean.getExercise(0).getWorkoutPlan());

        /*daoImplFileSystemExercise.saveData(dataBean.getExercise(0));
        for (int i = 1; i <= 6; i++) {
            String exerciseData = dataBean.getExercise(i).getExercise();

            if (exerciseData != null && !exerciseData.isEmpty()) {
                daoImplFileSystemExercise.saveData(dataBean.getExercise(i));
            }
        }
        DaoImplFilSystemWorkoutPlan daoImplFilSystemWorkoutPlan = new DaoImplFilSystemWorkoutPlan();
        daoImplFilSystemWorkoutPlan.saveData(dataBean.getExercise(0).getWorkoutPlan());

         */

    }
}

