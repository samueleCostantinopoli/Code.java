package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerCalculateTdee;
import com.example.fitnesshelp.entities.Macro;
import com.example.fitnesshelp.entities.Tdee;
import com.example.fitnesshelp.factory.TypeOfPersistence;
import com.example.fitnesshelp.utils.UtilityAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

public class GraphicsControllerCalculateTdee3 extends GraphicsControllerHomePage{

    @FXML
    private RadioButton higherCarbRadioButton;

    @FXML
    private RadioButton lowerCarbRadioButton;

    @FXML
    private RadioButton moderateCarbRadioButton;

    @FXML
    private Label higherCarbsText;

    @FXML
    private Label higherProText;

    @FXML
    private Label lowerProText;

    @FXML
    private Label lowerCarbsText;

    @FXML
    private Label lowerFatsText;

    @FXML
    private Label higherFatsText;

    @FXML
    private Label moderateCarbsText;

    @FXML
    private Label moderateFatsText;

    @FXML
    private Label moderateProText;

    @FXML
    private Label errorCarbLabel;

    @FXML
    private Button saveDBButton;

    @FXML
    private Button saveFSButton;

    @FXML
    private Button showMacroButton;

    @FXML
    private Label stateNameLabel;

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
    private Label caloriesLabel;

    private ToggleGroup quantityToggleGroup;

    @FXML
    void clickedOnButtonMacro(ActionEvent event) {
        // this button show macro partition and set disable the buttons to save tdee
        showMacroButton.setDisable(true);
        showMacroButton.setOpacity(0);
        saveFSButton.setDisable(false);
        saveDBButton.setDisable(false);

        moderateCarbRadioButton.setOpacity(1);
        moderateCarbRadioButton.setDisable(false);
        moderateProLabel.setOpacity(1);
        moderateProText.setOpacity(1);
        moderateFatsLabel.setOpacity(1);
        moderateFatsText.setOpacity(1);
        moderateCarbLabel.setOpacity(1);
        moderateCarbsText.setOpacity(1);

        lowerCarbRadioButton.setOpacity(1);
        lowerCarbRadioButton.setDisable(false);
        lowerProLabel.setOpacity(1);
        lowerProText.setOpacity(1);
        lowerFatsLabel.setOpacity(1);
        lowerFatsText.setOpacity(1);
        lowerCarbLabel.setOpacity(1);
        lowerCarbsText.setOpacity(1);

        higherCarbRadioButton.setOpacity(1);
        higherCarbRadioButton.setDisable(false);
        higherProLabel.setOpacity(1);
        higherProText.setOpacity(1);
        higherFatsLabel.setOpacity(1);
        higherFatsText.setOpacity(1);
        higherCarbLabel.setOpacity(1);
        higherCarbsText.setOpacity(1);
    }


    @FXML
    void initialize(double kcal, String target){
        // initialize radio button
        quantityToggleGroup = new ToggleGroup();
        moderateCarbRadioButton.setToggleGroup(quantityToggleGroup);
        lowerCarbRadioButton.setToggleGroup(quantityToggleGroup);
        higherCarbRadioButton.setToggleGroup(quantityToggleGroup);
        // disable possibility to save tdee before macro selection
        saveDBButton.setDisable(true);
        saveFSButton.setDisable(true);
        moderateCarbRadioButton.setDisable(true);
        lowerCarbRadioButton.setDisable(true);
        higherCarbRadioButton.setDisable(true);
        // take only integer part of kcal
        DecimalFormat decimalFormat = new DecimalFormat("#");
        String formattedNumber = decimalFormat.format(kcal);
        // in this method I set the page to show the result
        caloriesLabel.setText("" + formattedNumber);
        stateNameLabel.setText(target);
        // now I can request the partition of macro at tdee calculator via application controller
        List<Macro> macroList;
        ApplicationControllerCalculateTdee applicationControllerCalculateTdee = new ApplicationControllerCalculateTdee();
        macroList = applicationControllerCalculateTdee.requestMacroList(Integer.parseInt(formattedNumber));
        // then I can set the labal text with correct values
        Macro moderateCarb = macroList.get(0);
        moderateProLabel.setText("" + moderateCarb.getPro());
        moderateFatsLabel.setText("" + moderateCarb.getFat());
        moderateCarbLabel.setText("" + moderateCarb.getCarb());
        Macro lowerCarb = macroList.get(1);
        lowerProLabel.setText("" + lowerCarb.getPro());
        lowerFatsLabel.setText("" + lowerCarb.getFat());
        lowerCarbLabel.setText("" + lowerCarb.getCarb());
        Macro higherCarb = macroList.get(2);
        higherProLabel.setText("" + higherCarb.getPro());
        higherFatsLabel.setText("" + higherCarb.getFat());
        higherCarbLabel.setText("" + higherCarb.getCarb());
    }

    @FXML
    void clickedOnButtonSaveDB(ActionEvent event) throws IOException, SQLException {
        errorCarbLabel.setOpacity(0);
            // Check if user has selected the quantity of carb
            RadioButton quantitySelected = (RadioButton) quantityToggleGroup.getSelectedToggle();

            if (quantitySelected == null || quantitySelected.getText().isEmpty()) {
                errorCarbLabel.setOpacity(1);
            } else {
                saveData(event, TypeOfPersistence.JDBC, quantitySelected);
                // Back to summary page
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fitnesshelp/calculateTdee0.fxml"));
                Parent root = loader.load();
                GraphicsControllerCalculateTdee0 graphicsControllerCalculateTdee0 = loader.getController();
                graphicsControllerCalculateTdee0.initialize();
                Scene scene = new Scene(root);
                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                currentStage.setScene(scene);
            }

    }


    @FXML
    void clickedOnButtonSaveFS(ActionEvent event) throws SQLException, IOException {

            // Check if user has selected the quantity of carb
            RadioButton quantitySelected = (RadioButton) quantityToggleGroup.getSelectedToggle();

            if (quantitySelected == null || quantitySelected.getText().isEmpty()) {
                errorCarbLabel.setOpacity(1);
            } else {
                saveData(event, TypeOfPersistence.JDBC, quantitySelected);
                saveData(event, TypeOfPersistence.FILE_SYSTEM, quantitySelected);
                // Back to summary page
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fitnesshelp/calculateTdee0.fxml"));
                Parent root = loader.load();
                GraphicsControllerCalculateTdee0 graphicsControllerCalculateTdee0 = loader.getController();
                graphicsControllerCalculateTdee0.initialize();
                Scene scene = new Scene(root);
                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                currentStage.setScene(scene);
            }

    }

    @FXML
    private void saveData(ActionEvent event, TypeOfPersistence typeOfPersistence, RadioButton quantitySelected) throws IOException, SQLException {
        // set data that user has selected
        String quantity = switch (quantitySelected.getText()) {
            case "Moderate carb (30/35/35)" -> "moderate carb";
            case "Lower carb (40/40/20)" -> "lower carb";
            case "Higher carb (30/20/50)" -> "higher carb";
            default -> "";
        };
        Macro macro = switch (quantitySelected.getText()) {
            case "Moderate carb (30/35/35)" -> new Macro(Float.parseFloat(moderateProLabel.getText()), Float.parseFloat(moderateFatsLabel.getText()), Float.parseFloat(moderateCarbLabel.getText()));
            case "Lower carb (40/40/20)" -> new Macro(Float.parseFloat(lowerProLabel.getText()), Float.parseFloat(lowerFatsLabel.getText()), Float.parseFloat(lowerCarbLabel.getText()));
            case "Higher carb (30/20/50)" -> new Macro(Float.parseFloat(higherProLabel.getText()), Float.parseFloat(higherFatsLabel.getText()), Float.parseFloat(higherCarbLabel.getText()));
            default -> null;
        };
        Tdee tdee = new Tdee(Integer.parseInt(caloriesLabel.getText()), UtilityAccess.getUsername(), macro.getPro(), macro.getFat(), macro.getCarb(), stateNameLabel.getText().toLowerCase(), quantity);
        // call application controller to save data
        ApplicationControllerCalculateTdee applicationControllerCalculateTdee = new ApplicationControllerCalculateTdee();
        applicationControllerCalculateTdee.saveTdee(typeOfPersistence, tdee);
    }

}
