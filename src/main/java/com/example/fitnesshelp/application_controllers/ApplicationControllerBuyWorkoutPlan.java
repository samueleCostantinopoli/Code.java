package com.example.fitnesshelp.application_controllers;

import com.example.fitnesshelp.bean.BeanBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.entities.State;
import com.example.fitnesshelp.entities.User;

import static com.example.fitnesshelp.entities.State.NOT_LOGGED_IN;


public class ApplicationControllerBuyWorkoutPlan {
    int prize;
    String state;

    public ApplicationControllerBuyWorkoutPlan(BeanState stateUser, BeanBuyWorkoutPlan beanBuyWorkoutPlan) {
        this.state = stateUser.toString();
        this.prize = beanBuyWorkoutPlan.getPrize();
    }

}
