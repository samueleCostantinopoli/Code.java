package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.entities.Exercise;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GraphicsControllerBuyPreviewWorkoutPlan extends GraphicsControllerHomePage {

    @FXML
    public Label nameWorkout;
    @FXML
    Label insertPreview;

    @FXML
    Button priceWorkoutPlan2Button;

    @FXML
    private Label errorLoginMessageLabel;
    @FXML
    private Button errorLoginMessageButton;

    ApplicationControllerBuyWorkoutPlan applicationControllerBuyWorkoutPlan = new ApplicationControllerBuyWorkoutPlan(new BeanState(UtilityAccess.getState()));
    List<Exercise> exerciseList = applicationControllerBuyWorkoutPlan.checkExercise();


    private WorkoutPlan currentWorkout;

    public WorkoutPlan getWorkoutPlan() {
        return currentWorkout;
    }

    public GraphicsControllerBuyPreviewWorkoutPlan() throws IOException, SQLException {
        // Only for exception
    }

    public void getIndexWorkout(WorkoutPlan workoutPlan) {
        priceWorkoutPlan2Button.setText(workoutPlan.getPrize() + " €");
        nameWorkout.setText(workoutPlan.getName());
        this.currentWorkout = workoutPlan;


        List<String> exercise = new ArrayList<>();
        if (!exerciseList.isEmpty()) {
            for (Exercise value : exerciseList) {
                if (workoutPlan.getName().equals(value.getWorkoutPlan().getName()))
                    exercise.add(value.getExerciseName().trim() + "\n");
            }
            String exerciseText = String.join("\n", exercise);
            insertPreview.setText(exerciseText);
        }
    }

    @FXML
    public void clickedOnButtonInfoWorkoutPlan(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fitnesshelp/buyInfoWorkoutPlan.fxml"));
        Parent root = loader.load();
        GraphicsControllerBuyInfoWorkoutPlan controller = loader.getController();
        controller.getIndexWorkout(this.currentWorkout);
        Stage home = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene primary = new Scene(root);
        home.setScene(primary);
        home.show();
    }


    @FXML
    void clickedOnButtonPageOneBuyWorkoutPlan(ActionEvent event) throws IOException {
        setStageToSwitch("/com/example/fitnesshelp/buyWorkoutPlan");
        switchStage(event);
    }


    @FXML
    void clickedOnButtonPriceWorkoutPlan(ActionEvent event) throws IOException {
        if(UtilityAccess.getState() == State.LOGGED_IN) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fitnesshelp/buyWorkoutPlanSetPayments.fxml"));
            Parent root = loader.load();
            GraphicsControllerBuyWorkoutPlanSetPayments infoController1 = loader.getController();
            infoController1.checkInformation(this.currentWorkout);
            Stage home = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene primary = new Scene(root);
            home.setScene(primary);
            home.show();
        } else {
            errorLoginMessageLabel.setOpacity(1);
            errorLoginMessageButton.setOpacity(1);
        }
    }
}
