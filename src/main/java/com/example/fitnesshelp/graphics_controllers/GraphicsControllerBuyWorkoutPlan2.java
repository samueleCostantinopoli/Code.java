package com.example.fitnesshelp.graphics_controllers;


import com.example.fitnesshelp.application_controllers.ApplicationControllerBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.entities.Purchase;
import com.example.fitnesshelp.entities.WorkoutPlan;
import com.example.fitnesshelp.utils.UtilityAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class GraphicsControllerBuyWorkoutPlan2 extends GraphicsControllerHomePage{
    public Label IDPurchase;
    public Label PrizePurchase;
    public Label DatePurchase;
    public Label UsernameCreatorPurchase;
    public Label WorkoutNamePurchase;

    ApplicationControllerBuyWorkoutPlan applicationControllerBuyWorkoutPlan = new ApplicationControllerBuyWorkoutPlan(new BeanState(UtilityAccess.getState()));
    List<WorkoutPlan> workoutPlanList = applicationControllerBuyWorkoutPlan.checkWorkoutPlan();
    int CurrentWorkout = -1;
    public GraphicsControllerBuyWorkoutPlan2() throws IOException {
    }

    public Purchase newPurchase;
    public void savePurchase(int thisWorkout) throws SQLException, IOException {
        CurrentWorkout = thisWorkout;
        WorkoutPlan workoutPlanToPurchase = workoutPlanList.get(thisWorkout);
        newPurchase = new Purchase(GenerateId(), workoutPlanToPurchase.getPrize(), TakeDate(), UtilityAccess.getUsername(), workoutPlanToPurchase);
        IDPurchase.setText("ID: " + newPurchase.getIdPurchase());
        PrizePurchase.setText("Prize: " + newPurchase.getWorkoutPlan().getPrize());
        DatePurchase.setText("Date: " + newPurchase.getDate());
        UsernameCreatorPurchase.setText("Username of creator: " + newPurchase.getWorkoutPlan().getUsername());
        WorkoutNamePurchase.setText("Workout name: " + newPurchase.getWorkoutPlan().getName());

        ApplicationControllerBuyWorkoutPlan applicationControllerBuyWorkoutPlan1 = new ApplicationControllerBuyWorkoutPlan(new BeanState(UtilityAccess.getState()));
        applicationControllerBuyWorkoutPlan1.createPurchase(newPurchase);
    }

    private Date TakeDate() {
        return new Date();
    }

    private int GenerateId() {
        Random random = new Random();
        // Generate int random ID
        int id = random.nextInt(Integer.MAX_VALUE);
        return id;
    }


    public void clickedOnBuyWorkoutPlanHyperlink1(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/buyWorkoutPlan";
        switchStage(event);
    }
}
