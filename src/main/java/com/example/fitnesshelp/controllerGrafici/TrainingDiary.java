package com.example.fitnesshelp.controllerGrafici;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
    private Label welocme;
    private Stage stage;
    private Scene scene;
    private FXMLLoader root;
    @FXML
    void clickedOnAccountHyperlink(ActionEvent event) throws IOException{
        stageToSwitch= "/com/example/fitnesshelp/account";
        switchStage(event);
    }

    @FXML
    void clickedOnButtonAddNote(ActionEvent event) {

    }

    @FXML
    void clickedOnBuyWorkoutPlanHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/buyWorkoutPlan";
        switchStage(event);
    }

    @FXML
    void clickedOnFindAGymNearMeHyperlink(ActionEvent event) throws IOException{
        stageToSwitch = "/com/example/fitnesshelp/findAGymNearMe";
        switchStage(event);
    }


    @FXML
    void clickedOnHomeHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/HomePage";
        switchStage(event);
    }

    @FXML
    void clickedOnLogoutHyperlink(ActionEvent event) throws IOException{
        stageToSwitch = "/com/example/fitnesshelp/login";
        switchStage(event);
    }

    @FXML
    void clickedOnMyTrainingDiaryHyperlink(ActionEvent event) throws IOException{
        stageToSwitch = "/com/example/fitnesshelp/trainingDiary";
        switchStage(event);
    }

    @FXML
    void clickedOnMyWorkoutPlanHyperlink(ActionEvent event) throws IOException{
        stageToSwitch = "/com/example/fitnesshelp/myWorkoutPlan";
        switchStage(event);
    }

    @FXML
    void clickedOnPersonalTrainerHyperlink(ActionEvent event) throws IOException{
        stageToSwitch = "/com/example/fitnesshelp/personalTrainer";
        switchStage(event);
    }

    public void clickedOnTdeeCalculatorHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/calculateTdee1";
        switchStage(event);
    }
}
