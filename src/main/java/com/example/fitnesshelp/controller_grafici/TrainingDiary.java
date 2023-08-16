package com.example.fitnesshelp.controller_grafici;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class TrainingDiary extends HomePage{

    @FXML
    private Hyperlink accountHyperlink;

    @FXML
    private Button addNoteButton;

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
    private Label noteDescription;

    @FXML
    private Hyperlink personalTrainerHyperlink1;

    @FXML
    private ImageView profileImage;

    @FXML
    private Label title;

    @FXML
    private Hyperlink trainingDiaryHyperlink;

    @FXML
    void clickedOnButtonAddNote(ActionEvent event) {

    }


    void clickedOnTdeeCalculatorHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/calculateTdee1";
        switchStage(event);
    }
}
