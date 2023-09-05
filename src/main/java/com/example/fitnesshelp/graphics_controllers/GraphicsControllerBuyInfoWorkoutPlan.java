package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.entities.WorkoutPlan;
import com.example.fitnesshelp.utils.UtilityAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.jar.Attributes;

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
    private Button previewWorkoutPlan2Button;

    public GraphicsControllerBuyInfoWorkoutPlan() throws IOException {
    }

    public void setIndex(WorkoutPlan currentWorkout) {
        NameScheda.setText(currentWorkout.getName());
        NameWorkout.setText(currentWorkout.getName());
        NamePT.setText(currentWorkout.getUsername());
        InsertDate.setText(currentWorkout.getDay());
        CommentExtra.setText("Prize: " + currentWorkout.getPrize());
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
