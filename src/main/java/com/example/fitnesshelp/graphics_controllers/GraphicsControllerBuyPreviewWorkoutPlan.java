package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.entities.Exercise;
import com.example.fitnesshelp.entities.WorkoutPlan;
import com.example.fitnesshelp.utils.UtilityAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.List;

public class GraphicsControllerBuyPreviewWorkoutPlan extends GraphicsControllerHomePage {

    @FXML
    Label insertPreview;

    ApplicationControllerBuyWorkoutPlan applicationControllerBuyWorkoutPlan = new ApplicationControllerBuyWorkoutPlan(new BeanState(UtilityAccess.getState()));
    List<Exercise> exerciseList = applicationControllerBuyWorkoutPlan.checkExercise();

    public GraphicsControllerBuyPreviewWorkoutPlan() throws IOException {
    }

    public void setIndex(WorkoutPlan workoutPlan) {
        int index = 0;
        while (!exerciseList.get(index).getWorkoutPlan().getName().isEmpty()){
            if(workoutPlan.getName().equals(exerciseList.get(index).getWorkoutPlan().getName()))
                insertPreview.setText(exerciseList.get(index).getExercise());
            index++;
        }
    }

    @FXML
    public void clickedOnButtonInfoWorkoutPlan(ActionEvent event) throws IOException {
        stageToSwitch= "/com/example/fitnesshelp/buyInfoWorkoutPlan";
        switchStage(event);
    }


    @FXML
    void clickedOnButtonPageOneBuyWorkoutPlan(ActionEvent event) throws IOException {
        stageToSwitch= "/com/example/fitnesshelp/buyWorkoutPlan";
        switchStage(event);
    }


    @FXML
    void clickedOnButtonPriceWorkoutPlan(ActionEvent event) {

    }


}
