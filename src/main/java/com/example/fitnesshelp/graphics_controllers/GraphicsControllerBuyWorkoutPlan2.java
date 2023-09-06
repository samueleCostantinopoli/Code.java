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
import java.util.Date;
import java.util.List;
import java.util.Random;

public class GraphicsControllerBuyWorkoutPlan2 extends GraphicsControllerHomePage{
    public Label IDPurchase;
    public Label PrizePurchase;
    public Label DatePurchase;
    public Label UsernameCreatorPurchase;
    public Label WorkoutNamePurchase;


    public GraphicsControllerBuyWorkoutPlan2() {
    }

    public Purchase newPurchase;
    public void savePurchase(Purchase newPurchase) {
        this.newPurchase = newPurchase;
    }

    @FXML
    public void initialize(){
        IDPurchase.setText("ID: " + newPurchase.getIdPurchase());
        PrizePurchase.setText("Prize:" + newPurchase.getWorkoutPlan().getPrize());
        DatePurchase.setText("Date:" + newPurchase.getDate());
        UsernameCreatorPurchase.setText("Username of creator:" + newPurchase.getWorkoutPlan().getUsername());
        WorkoutNamePurchase.setText("Workout name:" + newPurchase.getWorkoutPlan().getName());
    }

    public void clickedOnBuyWorkoutPlanHyperlink1(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/buyWorkoutPlan";
        switchStage(event);
    }
}
