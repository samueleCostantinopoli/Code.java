package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerCalculateTdee;
import com.example.fitnesshelp.bean.*;
import com.example.fitnesshelp.entities.Activity;
import com.example.fitnesshelp.entities.Gender;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class GraphicsControllerCalculateTdee2 extends GraphicsControllerHomePage{

    @FXML
    private ChoiceBox<String> activityChoiceBox;

    @FXML
    private TextField ageTextField;

    @FXML
    private Button calculateButton;

    @FXML
    private Label emptyAllertLabel;

    @FXML
    private RadioButton femaleRadioButton;

    @FXML
    private TextField heightTextField;

    @FXML
    private RadioButton maleRadioButton;

    @FXML
    private Button nextButton;

    @FXML
    private TextField weightTextField;

    @FXML
    private RadioButton bulkingRadioButton;

    @FXML
    private RadioButton maintenanceRadioButton;

    @FXML
    private RadioButton cuttingRadioButton;

    private ToggleGroup genderToggleGroup;
    private ToggleGroup targetToggleGroup;

    @FXML
    void clickedOnButtonNext(ActionEvent event) {
        // check if all fields are empty
        if (activityChoiceBox.getSelectionModel().isEmpty()
                || ageTextField.getText().isEmpty()
                || !genderToggleGroup.getSelectedToggle().isSelected()
                || heightTextField.getText().isEmpty()
                || weightTextField.getText().isEmpty()
                || !targetToggleGroup.getSelectedToggle().isSelected()) {
            // Display an error message if any field is empty or not selected
            emptyAllertLabel.setText("Please fill in all fields");
            emptyAllertLabel.setOpacity(1);
        } else {
            // Clear the error message if all fields are filled/selected
            emptyAllertLabel.setOpacity(0);
            if (!isNotNumeric(ageTextField.getText()) || !isNotNumeric(heightTextField.getText()) || !isNotNumeric(weightTextField.getText())){
                emptyAllertLabel.setText("Invalid input. Age, height, and weight must be numeric values");
                emptyAllertLabel.setOpacity(1);
            } else {
                // if fields are not empty and values insert are numeric, user can try to calculate tdee
                // disable the filed that user has confirmed
                calculateButton.setOpacity(1);
                nextButton.setDisable(true);
                calculateButton.setOpacity(1);
                calculateButton.setDisable(false);
                ageTextField.setDisable(true);
                activityChoiceBox.setDisable(true);
                heightTextField.setDisable(true);
                weightTextField.setDisable(true);
                maleRadioButton.setDisable(true);
                femaleRadioButton.setDisable(true);
                maintenanceRadioButton.setDisable(true);
                cuttingRadioButton.setDisable(true);
                bulkingRadioButton.setDisable(true);
            }
        }
    }

    private boolean isNotNumeric(String str) {
        // this method verify if the age, weight and height are numeric
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void disableButton(){
        calculateButton.setDisable(true);
    }

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
    void clickedOnCalculateButton(ActionEvent event) {
        // take values of radio buttons and choice boxes
        RadioButton genderSelected = (RadioButton) genderToggleGroup.getSelectedToggle();
        RadioButton targetSelected = (RadioButton) targetToggleGroup.getSelectedToggle();
        Activity activity = switch (activityChoiceBox.getValue()){
            case "Sedentary (office job)" -> Activity.SEDENTARY;
            case "Light Exercise (1-2 days/week)" -> Activity.LIGHT_EXERCISE;
            case "Moderate Exercise (3-5 days/week)" -> Activity.MODERATE_EXERCISE;
            case "Heavy Exercise (6-7 days/week)" -> Activity.HEAVY_EXERCISE;
            case "Athlete (2x day)" -> Activity.ATHLETE;
            default -> null;
        };
        Gender gender = switch (genderSelected.getText()){
            case "male" -> Gender.MALE;
            case "female" -> Gender.FEMALE;
            default -> null;
        };
        // create bean for check syntax
        BeanGender beanGender = new BeanGender(gender);
        BeanAge beanAge = new BeanAge(Integer.parseInt(ageTextField.getText()));
        BeanHeight beanHeight = new BeanHeight(Float.parseFloat(heightTextField.getText()));
        BeanWeight beanWeight = new BeanWeight(Float.parseFloat(weightTextField.getText()));
        BeanActivity beanActivity = new BeanActivity(activity);
        BeanTarget beanTarget = new BeanTarget(targetSelected.getText());
        String ageRange = beanAge.verifyAge(Integer.parseInt(ageTextField.getText()));
        String heightRange = beanHeight.verifyHeight(Float.parseFloat(heightTextField.getText()));
        String weightRange = beanWeight.verifyWeight(Float.parseFloat(weightTextField.getText()));
        // strings values null if checks are ok
        if (ageRange == null && heightRange == null && weightRange == null){
            try {
                // in this case I can call the application controller, which will call the tdee calculator to get the tdee
                ApplicationControllerCalculateTdee applicationControllerCalculateTdee = new ApplicationControllerCalculateTdee(beanAge, beanHeight, beanWeight, beanGender, beanActivity, beanTarget);
                // now I can calculate my tdee
                double kcal = applicationControllerCalculateTdee.calculateTdee();
                // I pass the calculated tdee to the page that will display the results
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fitnesshelp/calculateTdee3.fxml"));
                Parent root = loader.load();
                GraphicsControllerCalculateTdee3 graphicsControllerCalculateTdee3 = loader.getController();
                graphicsControllerCalculateTdee3.initialize(kcal, targetSelected.getText());
                // finally switch to the final page
                Scene scene = new Scene(root);
                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                currentStage.setScene(scene);
            } catch (IOException e){
                emptyAllertLabel.setText(e.getMessage());
                emptyAllertLabel.setOpacity(1);
            }
        } else if (ageRange != null){
            // age is out of the range
            emptyAllertLabel.setText(ageRange);
            emptyAllertLabel.setOpacity(1);
            calculateButton.setDisable(true);
            calculateButton.setOpacity(0);
            nextButton.setDisable(false);
        } else if (heightRange != null) {
            // height is out of the range
            emptyAllertLabel.setText(heightRange);
            emptyAllertLabel.setOpacity(1);
            calculateButton.setDisable(true);
            calculateButton.setOpacity(0);
            nextButton.setDisable(false);
        } else {
            // weight is out of the range
            emptyAllertLabel.setText(weightRange);
            emptyAllertLabel.setOpacity(1);
            calculateButton.setDisable(true);
            calculateButton.setOpacity(0);
            nextButton.setDisable(false);
        }
    }

}
