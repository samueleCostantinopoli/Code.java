package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.entities.State;
import com.example.fitnesshelp.entities.WorkoutPlan;
import com.example.fitnesshelp.utils.UtilityAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

// Class per infoBuyWorkoutPlan
public class GraphicsControllerBuyInfoWorkoutPlan extends GraphicsControllerHomePage {

    @FXML
    private Label CommentExtra;

    @FXML
    private Label InsertDate;

    @FXML
    private Label NamePT;

    @FXML
    private Label NameForm;

    @FXML
    private Label NameWorkout;

    @FXML
    private Label errorLoginMessageLabel;
    @FXML
    private Button errorLoginMessageButton;

    @FXML
    Button priceWorkoutPlan2Button;
    public WorkoutPlan workoutPlan;
    public GraphicsControllerBuyInfoWorkoutPlan() throws IOException {
    }

    public void setIndex(WorkoutPlan currentWorkout) {
        workoutPlan = currentWorkout;
        priceWorkoutPlan2Button.setText(currentWorkout.getPrize() + " €");
        NameForm.setText(currentWorkout.getName());
        NameWorkout.setText(currentWorkout.getName());
        NamePT.setText(currentWorkout.getUsername());
        InsertDate.setText(currentWorkout.getDay());
        CommentExtra.setText("Prize: " + currentWorkout.getPrize());
    }

    @FXML
    void clickedOnButtonPreviewWorkoutPlan(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fitnesshelp/buyPreviewWorkoutPlan.fxml"));
        Parent root = loader.load();
        GraphicsControllerBuyPreviewWorkoutPlan previewWorkoutPlanController = loader.getController();
        previewWorkoutPlanController.setIndex(workoutPlan);
        Stage home = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene primary = new Scene(root);
        home.setScene(primary);
        home.show();
    }

    @FXML
    public void clickedOnButtonPriceWorkoutPlan(ActionEvent event) throws IOException {
        if(UtilityAccess.getState() == State.LOGGED_IN) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fitnesshelp/buyWorkoutPlan1.fxml"));
            Parent root = loader.load();
            GraphicsControllerBuyWorkoutPlan1 infoController1 = loader.getController();
            infoController1.SaveWorkout(workoutPlan);
            Stage home = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene primary = new Scene(root);
            home.setScene(primary);
            home.show();
        } else {
            errorLoginMessageLabel.setOpacity(1);
            errorLoginMessageButton.setOpacity(1);
        }
    }

    public void clickedOnButtonPageOneBuyWorkoutPlan(ActionEvent event) throws IOException {
        stageToSwitch= "/com/example/fitnesshelp/buyWorkoutPlan";
        switchStage(event);
    }
}
