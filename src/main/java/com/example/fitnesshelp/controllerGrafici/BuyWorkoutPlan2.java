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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class BuyWorkoutPlan2 extends HomePage{

    @FXML
    private Label NameSurnameAge1;

    @FXML
    private AnchorPane WorkoutPlan2Pane;

    @FXML
    private Hyperlink accountHyperlink;

    @FXML
    private Hyperlink buyWorkoutPlanHyperlink;

    @FXML
    private Hyperlink buyWorkoutPlanHyperlink1;

    @FXML
    private AnchorPane dataWorkoutPlan1Pane;

    @FXML
    private Hyperlink findAGymNearMeHyperlink;

    @FXML
    private Hyperlink homeHyperlink;

    @FXML
    private ImageView homeImageView;

    @FXML
    private Button infoWorkoutPlan2Button;

    @FXML
    private Label insertPrerequisites;

    @FXML
    private Label insertPreview;

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
    private Button nextBuyWorkoutPlanButton;

    @FXML
    private Button pageOneBuyWorkoutPlanButton;

    @FXML
    private Button pageTreeBuyWorkoutPlanButton;

    @FXML
    private Button pageTwoBuyWorkoutPlanButton;

    @FXML
    private Hyperlink personalTrainerHyperlink1;

    @FXML
    private Label prerequisites;

    @FXML
    private Label preview;

    @FXML
    private Button priceWorkoutPlan2Button;

    @FXML
    private ImageView profileImage;

    @FXML
    private Label title;

    @FXML
    private Label welocme;

    private Stage stage;
    private Scene scene;
    private FXMLLoader root;

    @FXML
    void clickedOnAccountHyperlink(ActionEvent event) throws IOException {
        stageToSwitch= "/com/example/fitnesshelp/account";
        switchStage(event);
    }

    @FXML
    void clickedOnButtonInfoWorkoutPlan(ActionEvent event) throws IOException {
        stageToSwitch= "/com/example/fitnesshelp/buyInfoWorkoutPlan";
        switchStage(event);
    }

    @FXML
    void clickedOnButtonNextBuyWorkoutPlan(ActionEvent event) {

    }

    @FXML
    void clickedOnButtonPageOneBuyWorkoutPlan(ActionEvent event) {

    }

    @FXML
    void clickedOnButtonPageTreeBuyWorkoutPlan(ActionEvent event) {

    }

    @FXML
    void clickedOnButtonPageTwoBuyWorkoutPlan(ActionEvent event) {

    }

    @FXML
    void clickedOnButtonPriceWorkoutPlan(ActionEvent event) {

    }

    @FXML
    void clickedOnBuyWorkoutPlanHyperlink(ActionEvent event) throws IOException {
        stageToSwitch= "/com/example/fitnesshelp/buyWorkoutPlan";
        switchStage(event);
    }

    @FXML
    void clickedOnBuyWorkoutPlanHyperlink1(ActionEvent event) throws IOException {
        stageToSwitch= "/com/example/fitnesshelp/buyWorkoutPlan";
        switchStage(event);
    }

    @FXML
    void clickedOnFindAGymNearMeHyperlink(ActionEvent event) throws IOException {
        stageToSwitch= "/com/example/fitnesshelp/findAGymNearMe";
        switchStage(event);
    }

    @FXML
    void clickedOnHomeHyperlink(ActionEvent event) throws IOException {
        stageToSwitch= "/com/example/fitnesshelp/HomePage";
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

    public void clickedOnTdeeCalculatorHyperlink(ActionEvent event) throws IOException{
        stageToSwitch = "/com/example/fitnesshelp/calculateTdee1";
        switchStage(event);
    }
}
