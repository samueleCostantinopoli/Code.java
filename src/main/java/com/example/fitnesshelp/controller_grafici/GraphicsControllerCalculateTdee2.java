package com.example.fitnesshelp.controller_grafici;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class GraphicsControllerCalculateTdee2 extends HomePage{

    @FXML
    private ChoiceBox<String> activityChoiceBox;

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

    private ToggleGroup genderToggleGroup;
    private ToggleGroup targetToggleGroup;

    @FXML
    public void initialize() {
        //choice box selection
        activityChoiceBox.getItems().addAll(
                "Sedentary (office job)",
                "Light Exercise (1-2 days/week)",
                "Moderate Exercise (3-5 days/week)",
                "Heavy Exercise (6-7 days/week)",
                "Athlete (2x day)"
        );

        // radio button initializzazion
        genderToggleGroup = new ToggleGroup();
        targetToggleGroup = new ToggleGroup();

        // add radio button to group
        maleRadioButton.setToggleGroup(genderToggleGroup);
        femaleRadioButton.setToggleGroup(genderToggleGroup);

        maintenanceRadioButton.setToggleGroup(targetToggleGroup);
        cuttingRadioButton.setToggleGroup(targetToggleGroup);
        bulkingRadioButton.setToggleGroup(targetToggleGroup);
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
