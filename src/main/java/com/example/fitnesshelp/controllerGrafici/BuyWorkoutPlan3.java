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
// Classe per infoBuyWorkoutPlan
public class BuyWorkoutPlan3 extends HomePage{

    @FXML
    private Label CommentExtra;

    @FXML
    private Label InsertDate;

    @FXML
    private Label NamePT;

    @FXML
    private Label NameScheda;

    @FXML
    private Label NameSurnameAge11;

    @FXML
    private Label NameWorkout;

    @FXML
    private Label Text1;

    @FXML
    private Label Text2;

    @FXML
    private Label Text3;

    @FXML
    private Label Text4;

    @FXML
    private Button previewWorkoutPlan2Button;

    public void BuyInfoWorkoutPlan(Label commentExtra) {
        CommentExtra = commentExtra;
    }

    @FXML
    void clickedOnButtonPreviewWorkoutPlan(ActionEvent event) throws IOException {
        stageToSwitch= "/com/example/fitnesshelp/buyPreviewWorkoutPlan";
        switchStage(event);
    }

    @FXML
    public void clickedOnButtonPriceWorkoutPlan(ActionEvent event) {

    }

    public void clickedOnButtonNextBuyWorkoutPlan(ActionEvent event) {
    }

    public void clickedOnButtonPageOneBuyWorkoutPlan(ActionEvent event) {
    }

    public void clickedOnButtonPageTwoBuyWorkoutPlan(ActionEvent event) {
    }

    public void clickedOnButtonPageTreeBuyWorkoutPlan(ActionEvent event) {
    }
}
