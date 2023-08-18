package com.example.fitnesshelp.controller_grafici;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class GraphicsControllerCalculateTdee3 extends HomePage{

    @FXML
    private RadioButton higherCarbRadioButton;

    @FXML
    private RadioButton lowerCarbRadioButton;

    @FXML
    private RadioButton moderateCarbRadioButton;

    @FXML
    private Label errorCarbLabel;

    @FXML
    private Button saveDBButton;

    @FXML
    private Button saveFSButton;

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
    void clickedOnHigherCarbRadioButton(ActionEvent event) {

    }

    @FXML
    void clickedOnLowerCarbRadioButton(ActionEvent event) {

    }

    @FXML
    void clickedOnModerateCarbRadioButton(ActionEvent event) {

    }

    @FXML
    void clickedOnButtonSaveDB(ActionEvent event) throws IOException{
        stageToSwitch = "/com/example/fitnesshelp/calculateTdee0";
        switchStage(event);
    }

    @FXML
    void clickedOnButtonSaveFS(ActionEvent event) throws IOException{
        stageToSwitch = "/com/example/fitnesshelp/calculateTdee0";
        switchStage(event);
    }



}
