package com.example.fitnesshelp.graphics_controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CalculateTdee3 extends GraphicsControllerHomePage {

    @FXML
    private Button saveButton;

    @FXML
    private Label stateNameLabel;

    @FXML
    private Hyperlink tdeeCalculatorHyperlink1;

    @FXML
    private TextField caloriesTextField;

    @FXML
    private Label higherCarbLabel;

    @FXML
    private Label higherFatsLabel;

    @FXML
    private Label higherProLabel;

    @FXML
    private Label lowerCarbLabel;

    @FXML
    private Label lowerFatsLabel;

    @FXML
    private Label lowerProLabel;

    @FXML
    private Label moderateCarbLabel;

    @FXML
    private Label moderateFatsLabel;

    @FXML
    private Label moderateProLabel;

    @FXML
    void clickedOnButtonSave(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/calculateTdee0";
        switchStage(event);
    }


}
