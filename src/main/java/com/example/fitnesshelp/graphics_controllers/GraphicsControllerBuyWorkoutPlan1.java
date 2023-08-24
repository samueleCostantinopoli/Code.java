package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.entities.Account;
import com.example.fitnesshelp.utils.UtilityAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class GraphicsControllerBuyWorkoutPlan1 extends GraphicsControllerHomePage {

    @FXML
    private Label NameSurnameAge1;

    @FXML
    private Label NameSurnameAge11;

    @FXML
    private AnchorPane WorkoutPlan1Pane;

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
    private AnchorPane dataWorkoutPlan2Pane;

    @FXML
    private Hyperlink findAGymNearMeHyperlink;

    @FXML
    private Button infoWorkoutPlan1Button;

    @FXML
    private Button infoWorkoutPlan2Button;
    @FXML
    private Button nextBuyWorkoutPlanButton;

    @FXML
    private Button pageOneBuyWorkoutPlanButton;

    @FXML
    private Button pageTreeBuyWorkoutPlanButton;

    @FXML
    private Button pageTwoBuyWorkoutPlanButton;

    @FXML
    private Hyperlink personalTrainerHyperlink;

    @FXML
    private Hyperlink personalTrainerHyperlink1;

    @FXML
    private Button previewWorkoutPlan1Button;

    @FXML
    private Button previewWorkoutPlan2Button;

    @FXML
    private Button priceWorkoutPlan1Button;

    @FXML
    private Button priceWorkoutPlan2Button;

    @FXML
    private ImageView profileImage;

    @FXML
    private Label title;

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
    void clickedOnButtonPreviewWorkoutPlan(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/buyPreviewWorkoutPlan";
        switchStage(event);
    }

    @FXML
    void clickedOnButtonPriceWorkoutPlan(ActionEvent event) {
        BeanState state = new BeanState(UtilityAccess.getState());
        BeanBuyWorkoutPlan beanBuyWorkoutPlan = new BeanBuyWorkoutPlan(10); //TODO aggiornare il prezzo
        ApplicationControllerBuyWorkoutPlan applicationControllerBuyWorkoutPlan = new ApplicationControllerBuyWorkoutPlan(state, beanBuyWorkoutPlan);
    }

    @FXML
    void clickedOnBuyWorkoutPlanHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/buyWorkoutPlan";
        switchStage(event);
    }

    @FXML
    void clickedOnBuyWorkoutPlanHyperlink1(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/buyWorkoutPlan";
        switchStage(event);
    }

}
