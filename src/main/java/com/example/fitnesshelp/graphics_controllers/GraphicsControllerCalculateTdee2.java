package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerCalculateTdee;
import com.example.fitnesshelp.bean.*;
import com.example.fitnesshelp.entities.Activity;
import com.example.fitnesshelp.entities.Gender;
import com.example.fitnesshelp.exception.AgeException;
import com.example.fitnesshelp.exception.HeightException;
import com.example.fitnesshelp.exception.WeightException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class GraphicsControllerCalculateTdee2 extends GraphicsControllerHomePage{

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

    private ToggleGroup genderToggleGroup;
    private ToggleGroup targetToggleGroup;

    private BeanGender beanGender;
    private BeanHeight beanHeight;
    private BeanAge beanAge;
    private BeanWeight beanWeight;
    private BeanActivity beanActivity;
    private BeanTarget beanTarget;

    @FXML
    void clickedOnButtonNext(ActionEvent event) throws IOException {
        // check if all fields are empty
        if (activityChoiceBox.getSelectionModel().isEmpty()
                || ageTextArea.getText().isEmpty()
                || !genderToggleGroup.getSelectedToggle().isSelected()
                || heightTextArea.getText().isEmpty()
                || weightTextArea.getText().isEmpty()
                || !targetToggleGroup.getSelectedToggle().isSelected()) {
            // Display an error message if any field is empty or not selected
            emptyAllertLabel.setText("Please fill in all fields");
            emptyAllertLabel.setOpacity(1);
        } else {
            // Clear the error message if all fields are filled/selected
            emptyAllertLabel.setOpacity(0);
            if (!isNumeric(ageTextArea.getText()) || !isNumeric(heightTextArea.getText()) || !isNumeric(weightTextArea.getText())){
                emptyAllertLabel.setText("Invalid input. Age, height, and weight must be numeric values");
                emptyAllertLabel.setOpacity(1);
            } else {
                // if fields are not empty and values insert are numeric, user can try to calculate tdee
                calculateButton.setOpacity(1);
                nextButton.setDisable(true);
                calculateButton.setOpacity(1);
                calculateButton.setDisable(false);
            }
        }
    }

    private boolean isNumeric(String str) {
        // this method verify if the age, weight and height are numeric
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @FXML
    public void initialize() {
        calculateButton.setDisable(true);
        //choice box selection
        activityChoiceBox.getItems().addAll(
                "Sedentary (office job)",
                "Light Exercise (1-2 days/week)",
                "Moderate Exercise (3-5 days/week)",
                "Heavy Exercise (6-7 days/week)",
                "Athlete (2x day)"
        );

        // radio button initialization
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
    void clickedOnCalculateButton(ActionEvent event) throws IOException, AgeException, HeightException, WeightException {
        RadioButton genderSelected = (RadioButton) genderToggleGroup.getSelectedToggle();
        RadioButton targetSelected = (RadioButton) targetToggleGroup.getSelectedToggle();
        Activity activity = switch (activityChoiceBox.getValue()){
            case "Sedentary (office job)" -> Activity.SEDENTARY;
            case "Light Exercise (1-2 days/week)" -> Activity.LIGHT_EXERCISE;
            case "Moderate Exercise (3-5 days/week)" -> Activity.MODERATE_EXERCISE;
            case "Heavy Exercise (6-7 days/week)" -> Activity.HEAVY_EXERCISE;
            case "Athlete (2x day)" -> Activity.ATHLETE;
        };
        Gender gender = switch (genderSelected.getText()){
            case "male" -> Gender.MALE;
            case "female" -> Gender.FEMALE;
        };
        beanGender = new BeanGender(gender);
        beanAge = new BeanAge(Integer.parseInt(ageTextArea.getText()));
        beanHeight = new BeanHeight(Float.parseFloat(heightTextArea.getText()));
        beanWeight = new BeanWeight(Float.parseFloat(weightTextArea.getText()));
        beanActivity = new BeanActivity(activity);
        beanTarget = new BeanTarget(targetSelected.getText());
        String ageRange = beanAge.verifyAge(Integer.parseInt(ageTextArea.getText()));
        String heightRange = beanHeight.verifyHeight(Float.parseFloat(heightTextArea.getText()));
        String weightRange = beanWeight.verifyWeight(Float.parseFloat(weightTextArea.getText()));
        // strings values null if checks are ok
        if (ageRange == null && heightRange == null && weightRange == null){
            // in this I can call the application controller, which will call the tdee calculator to get the tdee
            ApplicationControllerCalculateTdee applicationControllerCalculateTdee = new ApplicationControllerCalculateTdee(beanAge, beanHeight, beanWeight, beanGender, beanActivity, beanTarget);
            // now I can switch to the final page
            stageToSwitch = "/com/example/fitnesshelp/calculateTdee3";
            switchStage(event);
        } else if (ageRange != null){
            // age is out of the range
            emptyAllertLabel.setText(ageRange);
            emptyAllertLabel.setOpacity(1);
        } else if (heightRange != null) {
            // height is out of the range
            emptyAllertLabel.setText(heightRange);
            emptyAllertLabel.setOpacity(1);
        } else {
            // weight is out of the range
            emptyAllertLabel.setText(weightRange);
            emptyAllertLabel.setOpacity(1);
        }
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
