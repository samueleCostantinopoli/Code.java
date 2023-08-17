package com.example.fitnesshelp.graphics_controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import java.io.IOException;

public class CalculateTdee1 extends HomePage{

    @FXML
    private Button myTdeeButton;

    @FXML
    private Button startButton;

    @FXML
    private Hyperlink tdeeCalculatorHyperlink1;

    @FXML
    void clickedOnButtonStart(ActionEvent event) throws  IOException{
        stageToSwitch= "/com/example/fitnesshelp/calculateTdee2";
        switchStage(event);
    }

    @FXML
    void clickedOnButtonMyTdee(ActionEvent event) throws  IOException {
        stageToSwitch = "/com/example/fitnesshelp/calculateTdee0";
        switchStage(event);
    }
}
