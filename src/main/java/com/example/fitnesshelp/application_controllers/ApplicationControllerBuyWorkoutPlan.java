package com.example.fitnesshelp.application_controllers;

import com.example.fitnesshelp.bean.BeanBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.entities.State;
import com.example.fitnesshelp.entities.User;

import static com.example.fitnesshelp.entities.State.NOT_LOGGED_IN;


public class ApplicationControllerBuyWorkoutPlan {
    int prize;
    String state;

    public ApplicationControllerBuyWorkoutPlan(BeanState stateUser) {
        this.state = stateUser.toString();
    }

    public void ApplicationControllerBuyWorkout(BeanBuyWorkoutPlan beanBuyWorkoutPlan){
        this.prize = beanBuyWorkoutPlan.getPrize();

    }

    public boolean isLogged(){
        BeanState state = new BeanState(User.getState());

    }
}
