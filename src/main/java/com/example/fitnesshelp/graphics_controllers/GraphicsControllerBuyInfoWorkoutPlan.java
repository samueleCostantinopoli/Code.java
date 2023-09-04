package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.entities.WorkoutPlan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

// Classe per infoBuyWorkoutPlan
public class GraphicsControllerBuyInfoWorkoutPlan extends GraphicsControllerHomePage {

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

    public GraphicsControllerBuyInfoWorkoutPlan() {
        // Costruttore senza argomenti
    }
    public void setNamePT(String name) {
        NamePT.setText(name);
    }

    public void setNameWorkout(String name) {
        NameWorkout.setText(name);
    }

    public void setInsertDate(String date) {
        InsertDate.setText(date);
    }

    public void setCommentExtra(String comment) {
        CommentExtra.setText(comment);
    }


    @FXML
    void clickedOnButtonPreviewWorkoutPlan(ActionEvent event) throws IOException {
        stageToSwitch= "/com/example/fitnesshelp/buyPreviewWorkoutPlan";
        switchStage(event);
    }

    @FXML
    public void clickedOnButtonPriceWorkoutPlan(ActionEvent event) {

    }

    public void clickedOnButtonPageOneBuyWorkoutPlan(ActionEvent event) throws IOException {
        stageToSwitch= "/com/example/fitnesshelp/buyWorkoutPlan";
        switchStage(event);
    }
}
