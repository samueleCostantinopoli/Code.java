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
import java.util.Random;


public class GraphicsControllerBuyWorkoutPlanPurchase extends GraphicsControllerHomePage{
    @FXML
    public Label idPurchase;
    @FXML
    public Label prizePurchase;
    @FXML
    public Label datePurchase;
    @FXML
    public Label usernameCreatorPurchase;
    @FXML
    public Label workoutNamePurchase;

    ApplicationControllerBuyWorkoutPlan applicationControllerBuyWorkoutPlan = new ApplicationControllerBuyWorkoutPlan(new BeanState(UtilityAccess.getState()));

    Random random = new Random();

    private Purchase newPurchase;


    public Purchase getWorkoutPlan() {
        return newPurchase;
    }

    public void savePurchase(WorkoutPlan thisWorkout) throws SQLException, IOException {
        this.newPurchase = new Purchase(generateId(), thisWorkout.getPrize(), takeDate(), UtilityAccess.getUsername(), thisWorkout);
        idPurchase.setText("ID: " + this.newPurchase.getIdPurchase());
        prizePurchase.setText("Prize: " + this.newPurchase.getWorkoutPlan().getPrize());
        datePurchase.setText("Date: " + this.newPurchase.getDate());
        usernameCreatorPurchase.setText("Username of creator: " + this.newPurchase.getWorkoutPlan().getUsername());
        workoutNamePurchase.setText("Workout name: " + thisWorkout.getName());

        applicationControllerBuyWorkoutPlan.createPurchase(this.newPurchase);
    }

    private Date takeDate() {
        return new Date();
    }

    private int generateId() {
        // Generate int random ID
        return random.nextInt(Integer.MAX_VALUE);
    }

    public void clickedOnBuyWorkoutPlanHyperlink1(ActionEvent event) throws IOException {
        setStageToSwitch("/com/example/fitnesshelp/buyWorkoutPlan");
        switchStage(event);
    }
}
