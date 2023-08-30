package com.example.fitnesshelp.application_controllers;

import com.example.fitnesshelp.bean.BeanBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.dao.DaoImplFilSystemWorkoutPlan;
import com.example.fitnesshelp.dao.DaoImplRegistration;
import com.example.fitnesshelp.entities.State;
import com.example.fitnesshelp.exception.EmailAlreadyExistException;
import com.example.fitnesshelp.exception.UsernameAlreadyExistException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static com.example.fitnesshelp.entities.State.NOT_LOGGED_IN;


public class ApplicationControllerBuyWorkoutPlan {
    int prize;
    String state;

    public ApplicationControllerBuyWorkoutPlan(BeanState stateUser, BeanBuyWorkoutPlan beanBuyWorkoutPlan) {
        this.state = stateUser.toString();
        this.prize = beanBuyWorkoutPlan.getPrize();
    }

    public void checkWorkoutPlan() throws SQLException, IOException {
        DaoImplFilSystemWorkoutPlan daoImplFilSystemWorkoutPlan = new DaoImplFilSystemWorkoutPlan();
        daoImplFilSystemWorkoutPlan.checkWorkout();

    }



}
