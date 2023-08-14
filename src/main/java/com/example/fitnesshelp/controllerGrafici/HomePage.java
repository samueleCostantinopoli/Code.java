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

public class HomePage {

    @FXML
    private Hyperlink accountHyperlink;

    @FXML
    private Hyperlink buyWorkoutPlanHyperlink;

    @FXML
    private Button createNewButton;

    @FXML
    private Hyperlink findAGymNearMeHyperlink;

    @FXML
    private Hyperlink homeHyperlink;

    @FXML
    private ImageView homeImage;

    @FXML
    private Hyperlink logoutHyperlink;

    @FXML
    private ImageView logoutImage;

    @FXML
    private Hyperlink myTrainingDiaryHyperlink;

    @FXML
    private Hyperlink myWorkoutPlanHyperlink;

    @FXML
    private Label nameSurname;

    @FXML
    private Hyperlink personalTrainerHyperlink;

    @FXML
    private ImageView profileImage;

    @FXML
    private Label simpleDescription;

    @FXML
    private Label simpleDescription2;

    @FXML
    private Label title;

    @FXML
    private Label welcome;

    private Stage home;
    private Scene primary;
    private FXMLLoader root;
    public String stageToSwitch;
    @FXML
    void clickedOnAccountHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/account";
        switchStage(event);
    }
    @FXML
    void clickedOnButtonCreateNew(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/createWorkout";
        switchStage(event);
    }
    @FXML
    void clickedOnBuyWorkoutPlanHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/buyWorkoutPlan";
        switchStage(event);
    }
    @FXML
    void clickedOnFindAGymNearMeHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/findAGymNearMe";
        switchStage(event);
    }
    @FXML
    void clickedOnHomeHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/homePage";
        switchStage(event);
    }
    @FXML
    void clickedOnLogoutHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/login";
        switchStage(event);
    }
    @FXML
    void clickedOnMyTrainingDiaryHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/trainingDiary";
        switchStage(event);
    }
    @FXML
    void clickedOnMyWorkoutPlanHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/myWorkoutPlan";
        switchStage(event);
    }
    @FXML
    void clickedOnPersonalTrainerHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/personalTrainer";
        switchStage(event);
    }
    @FXML
    void clickedOnTdeeCalculatorHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/calculateTdee1";
        switchStage(event);
    }

    void switchStage(ActionEvent event) throws IOException {
        FXMLLoader root = new FXMLLoader(getClass().getResource(stageToSwitch + ".fxml"));
        Stage home = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene primary = new Scene(root.load());
        home.setScene(primary);
        home.show();
    }
}
