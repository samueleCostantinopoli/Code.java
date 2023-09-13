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
    private Label commentExtra;

    @FXML
    private Label insertDate;

    @FXML
    private Label namePT;

    @FXML
    private Label nameForm;

    @FXML
    private Label nameWorkout;

    @FXML
    private Label errorLoginMessageLabel;
    @FXML
    private Button errorLoginMessageButton;

    @FXML
    Button priceWorkoutPlan2Button;
    private WorkoutPlan currentWorkout;

    public WorkoutPlan getWorkoutPlan() { return currentWorkout;}

    public void getIndexWorkout(WorkoutPlan currentWorkout) {
        this.currentWorkout = currentWorkout;
        priceWorkoutPlan2Button.setText(currentWorkout.getPrize() + " €");
        nameForm.setText(currentWorkout.getName());
        nameWorkout.setText(currentWorkout.getName());
        namePT.setText(currentWorkout.getUsername());
        insertDate.setText(currentWorkout.getDay());
        commentExtra.setText("Prize: " + currentWorkout.getPrize());
    }

    @FXML
    void clickedOnButtonPreviewWorkoutPlan(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fitnesshelp/buyPreviewWorkoutPlan.fxml"));
        Parent root = loader.load();
        GraphicsControllerBuyPreviewWorkoutPlan previewWorkoutPlanController = loader.getController();
        previewWorkoutPlanController.getIndexWorkout(currentWorkout);
        Stage home = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene primary = new Scene(root);
        home.setScene(primary);
        home.show();
    }

    @FXML
    public void clickedOnButtonPriceWorkoutPlan(ActionEvent event) throws IOException {
        if(UtilityAccess.getState() == State.LOGGED_IN) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fitnesshelp/buyWorkoutPlanSetPayments.fxml"));
            Parent root = loader.load();
            GraphicsControllerBuyWorkoutPlanSetPayments infoController1 = loader.getController();
            infoController1.checkInformation(currentWorkout);
            Stage home = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene primary = new Scene(root);
            home.setScene(primary);
            home.show();
        } else {
            errorLoginMessageLabel.setOpacity(1);
            errorLoginMessageButton.setOpacity(1);
        }
    }

    @FXML
    public void clickedOnButtonPageOneBuyWorkoutPlan(ActionEvent event) throws IOException {
        setStageToSwitch("/com/example/fitnesshelp/buyWorkoutPlan");
        switchStage(event);
    }
}
