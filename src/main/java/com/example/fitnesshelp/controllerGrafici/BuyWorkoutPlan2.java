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
    private Hyperlink personalTrainerHyperlink1;

    @FXML
    private Label prerequisites;

    @FXML
    private Label preview;

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
}
