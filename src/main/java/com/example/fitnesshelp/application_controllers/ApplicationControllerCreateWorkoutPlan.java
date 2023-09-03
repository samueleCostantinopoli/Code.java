package com.example.fitnesshelp.application_controllers;

import com.example.fitnesshelp.bean.BeanCustomWorkoutData;
import com.example.fitnesshelp.dao.DaoImplFilSystemWorkoutPlan;

import java.io.IOException;
import java.sql.SQLException;

public class ApplicationControllerCreateWorkoutPlan {
    public void receiveCustomWorkoutData(BeanCustomWorkoutData dataBean) throws SQLException, IOException {
        DaoImplFilSystemWorkoutPlan daoImplFilSystemWorkoutPlan = new DaoImplFilSystemWorkoutPlan();
        daoImplFilSystemWorkoutPlan.saveData(dataBean.getExercise1().getWorkoutPlan());

        // Ecco come accedere ai dati nel bean:

        // ... E così via per gli altri campi
    }
}
