package com.example.fitnesshelp.controller_grafici;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class CalculateTdee2 extends HomePage{

    @FXML
    private ChoiceBox<?> acticityChoiceBox;

    @FXML
    private Label activityTextView;

    @FXML
    private TextArea ageTextArea;

    @FXML
    private Label ageTextView;

    @FXML
    private Button calculateButton;

    @FXML
    private Label emptyAllertLabel;

    @FXML
    private RadioButton femaleRadioButton;

    @FXML
    private Label genderTextView;

    @FXML
    private TextArea heightTextArea;

    @FXML
    private Label heightTextView;

    @FXML
    private RadioButton maleRadioButton;

    @FXML
    private Button nextButton;

    @FXML
    private Hyperlink tdeeCalculatorHyperlink1;

    @FXML
    private TextArea weightTextArea;

    @FXML
    private Label weightTextView;

    @FXML
    private RadioButton bulkingRadioButton;

    @FXML
    private RadioButton maintenanceRadioButton;

    @FXML
    private RadioButton cuttingRadioButton;

    @FXML
    void clickedOnButtonNext(ActionEvent event) {

    }

    @FXML
    void clickedOnCalculateButton(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/calculateTdee3";
        switchStage(event);
    }

    @FXML
    void clickedOnFemaleRadioButton(ActionEvent event) {

    }

    @FXML
    void clickedOnMaleRadioButton(ActionEvent event) {

    }

    @FXML
    void clickedOnRadioButtonBulking(ActionEvent event) {

    }

    @FXML
    void clickedOnRadioButtonCutting(ActionEvent event) {

    }

    @FXML
    void clickedOnRadioButtonMaintenance(ActionEvent event) {

    }

}
