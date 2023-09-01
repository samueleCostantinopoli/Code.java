package com.example.fitnesshelp.graphics_controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class GraphicsControllerBuyWorkoutPlan1 extends GraphicsControllerHomePage {
    @FXML
    public void clickedOnPurchaseBuyWorkoutPlanButton(ActionEvent event) throws IOException {
        stageToSwitch= "/com/example/fitnesshelp/buyWorkoutPlan2";
        switchStage(event);
    }

    public void clickedOnBuyWorkoutPlanHyperlink1(ActionEvent event) throws IOException{
        stageToSwitch= "/com/example/fitnesshelp/buyWorkoutPlan";
        switchStage(event);
    }
}
