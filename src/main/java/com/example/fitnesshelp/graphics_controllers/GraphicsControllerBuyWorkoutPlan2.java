package com.example.fitnesshelp.graphics_controllers;


import com.example.fitnesshelp.application_controllers.ApplicationControllerBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.entities.Purchase;
import com.example.fitnesshelp.entities.WorkoutPlan;
import com.example.fitnesshelp.utils.UtilityAccess;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;


public class GraphicsControllerBuyWorkoutPlan2 extends GraphicsControllerHomePage{
    public Label IDPurchase;
    public Label PrizePurchase;
    public Label DatePurchase;
    public Label UsernameCreatorPurchase;
    public Label WorkoutNamePurchase;

    ApplicationControllerBuyWorkoutPlan applicationControllerBuyWorkoutPlan = new ApplicationControllerBuyWorkoutPlan(new BeanState(UtilityAccess.getState()));

    Random random = new Random();

    public GraphicsControllerBuyWorkoutPlan2() {
    }

    public Purchase newPurchase;
    public void savePurchase(WorkoutPlan thisWorkout) throws SQLException, IOException {
        newPurchase = new Purchase(GenerateId(), thisWorkout.getPrize(), TakeDate(), UtilityAccess.getUsername(), thisWorkout);
        IDPurchase.setText("ID: " + newPurchase.getIdPurchase());
        PrizePurchase.setText("Prize: " + newPurchase.getWorkoutPlan().getPrize());
        DatePurchase.setText("Date: " + newPurchase.getDate());
        UsernameCreatorPurchase.setText("Username of creator: " + newPurchase.getWorkoutPlan().getUsername());
        WorkoutNamePurchase.setText("Workout name: " + thisWorkout.getName());

        applicationControllerBuyWorkoutPlan.createPurchase(newPurchase);
    }

    private Date TakeDate() {
        return new Date();
    }

    private int GenerateId() {
        // Generate int random ID
        return random.nextInt(Integer.MAX_VALUE);
    }

    public void clickedOnBuyWorkoutPlanHyperlink1(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/buyWorkoutPlan";
        switchStage(event);
    }
}
