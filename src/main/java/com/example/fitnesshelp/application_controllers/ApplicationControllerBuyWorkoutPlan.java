package com.example.fitnesshelp.application_controllers;

import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.dao.DaoImplFilSystemWorkoutPlan;
import com.example.fitnesshelp.entities.WorkoutPlan;
import com.example.fitnesshelp.utils.UtilityAccess;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class ApplicationControllerBuyWorkoutPlan {
    int prize;
    String state;

    public ApplicationControllerBuyWorkoutPlan(BeanState stateUser) {
        this.state = stateUser.toString();
    }

    public List<WorkoutPlan> checkWorkoutPlan() throws SQLException, IOException {
        DaoImplFilSystemWorkoutPlan daoImplFilSystemWorkoutPlan = new DaoImplFilSystemWorkoutPlan();
        return daoImplFilSystemWorkoutPlan.showData(UtilityAccess.getUsername());
    }



}
