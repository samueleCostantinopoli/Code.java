package com.example.fitnesshelp.controllerGrafici;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class CalculateTdee1 extends HomePage{

    @FXML
    private Hyperlink accountHyperlink;

    @FXML
    private Hyperlink buyWorkoutPlanHyperlink;

    @FXML
    private Hyperlink findAGymNearMeHyperlink;

    @FXML
    private Hyperlink homeHyperlink;

    @FXML
    private ImageView homeImageView;

    @FXML
    private Hyperlink logoutHyperlink;

    @FXML
    private ImageView logoutImageView;

    @FXML
    private Hyperlink myTrainingDiaryHyperlink;

    @FXML
    private Hyperlink myWorkoutPlanHyperlink;

    @FXML
    private Label nameSurname;

    @FXML
    private Hyperlink personalTrainerHyperlink1;

    @FXML
    private ImageView profileImage;

    @FXML
    private Button startButton;

    @FXML
    private Hyperlink tdeeCalculatorHyperlink;

    @FXML
    private Hyperlink tdeeCalculatorHyperlink1;

    @FXML
    private Label title;

    @FXML
    private Label welcome;

    @FXML
    void clickedOnAccountHyperlink(ActionEvent event) throws IOException {
        stageToSwitch= "/com/example/fitnesshelp/account";
        switchStage(event);
    }

    @FXML
    void clickedOnButtonNext(ActionEvent event) throws  IOException{
        stageToSwitch= "/com/example/fitnesshelp/calculateTdee2";
        switchStage(event);
    }

    @FXML
    void clickedOnTdeeCalculatorHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/calculateTdee1";
        switchStage(event);
    }
}
