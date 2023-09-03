package com.example.fitnesshelp.graphics_controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class GraphicsControllerBuyPreviewWorkoutPlan extends GraphicsControllerHomePage {


    @FXML
    public void clickedOnButtonInfoWorkoutPlan(ActionEvent event) throws IOException {
        stageToSwitch= "/com/example/fitnesshelp/buyInfoWorkoutPlan";
        switchStage(event);
    }


    @FXML
    void clickedOnButtonPageOneBuyWorkoutPlan(ActionEvent event) throws IOException {
        stageToSwitch= "/com/example/fitnesshelp/buyWorkoutPlan";
        switchStage(event);
    }


    @FXML
    void clickedOnButtonPriceWorkoutPlan(ActionEvent event) {

    }
}
