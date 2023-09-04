package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerCreateWorkoutPlan;
import com.example.fitnesshelp.bean.BeanCustomWorkoutData;
import com.example.fitnesshelp.entities.*;
import com.example.fitnesshelp.utils.UtilityAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class GraphicsControllerCreateWorkoutPlan extends GraphicsControllerHomePage {

    @FXML
    private Button addCustomExercise;

    @FXML
    private Hyperlink backHyperlink;

    @FXML
    private ImageView backImageView;

    @FXML
    private Hyperlink customHyperlink;

    @FXML
    private Label customeWorkoutNameLabel;

    @FXML
    private Label customFieldEmpty;

    @FXML
    private TextField muscleCustomTextField1;

    @FXML
    private TextField muscleCustomTextField2;

    @FXML
    private TextField muscleCustomTextField3;

    @FXML
    private TextField muscleCustomTextField4;

    @FXML
    private TextField muscleCustomTextField5;

    @FXML
    private TextField muscleCustomTextField6;

    @FXML
    private TextField customRepstextFields1;

    @FXML
    private TextField customRepstextFields2;

    @FXML
    private TextField customRepstextFields3;

    @FXML
    private TextField customRepstextFields4;

    @FXML
    private TextField customRepstextFields5;

    @FXML
    private TextField customRepstextFields6;


    @FXML
    private TextField customRestTextField1;

    @FXML
    private TextField customRestTextField2;

    @FXML
    private TextField customRestTextField3;

    @FXML
    private TextField customRestTextField4;

    @FXML
    private TextField customRestTextField5;

    @FXML
    private TextField customRestTextField6;


    @FXML
    private TextField customSetTextfield1;

    @FXML
    private TextField customSetTextfield2;

    @FXML
    private TextField customSetTextfield3;

    @FXML
    private TextField customSetTextfield4;

    @FXML
    private TextField customSetTextfield5;

    @FXML
    private TextField customSetTextfield6;

    @FXML
    private Label infoBar;

    @FXML
    private TextField nameCustomExerciseTextField1;

    @FXML
    private TextField nameCustomExerciseTextField2;

    @FXML
    private TextField nameCustomExerciseTextField3;

    @FXML
    private TextField nameCustomExerciseTextField4;

    @FXML
    private TextField nameCustomExerciseTextField5;

    @FXML
    private TextField nameCustomExerciseTextField6;

    @FXML
    private Button removeCustomExercise;

    @FXML
    private TextField nameCustomWorkoutTextField;

    @FXML
    private Button saveCustomWorkout;

    @FXML
    private Button StartButton;
    @FXML
    private TextField priceTextField;
    @FXML
    private Label customePriceNameLabel1;

    private int exerciseNumber = 1;
    private boolean remove = false;
    private boolean saveWorkout = false;

    public void OnClickStartButton() {
        StartButton.setVisible(false);
        infoBar.setVisible(true);
        nameCustomExerciseTextField1.setVisible(true);
        muscleCustomTextField1.setVisible(true);
        customSetTextfield1.setVisible(true);
        customRepstextFields1.setVisible(true);
        customRestTextField1.setVisible(true);
        addCustomExercise.setVisible(true);
        saveCustomWorkout.setVisible(true);
        removeCustomExercise.setVisible(true);
        nameCustomWorkoutTextField.setVisible(true);
        customeWorkoutNameLabel.setVisible(true);
        if(UtilityAccess.getTypeOfUser().equals(TypeOfUser.PERSONAL_TRAINER)){
            priceTextField.setVisible(true);
            customePriceNameLabel1.setVisible(true);
        }
    }

    @FXML
    void clickedOnButtonAddCustomExercise(ActionEvent event) {
        remove = true;
        removeCustomExercise.setOpacity(1);
        switch (exerciseNumber) {
            case 1 -> {
                nameCustomExerciseTextField2.setOpacity(1);
                customSetTextfield2.setOpacity(1);
                customRepstextFields2.setOpacity(1);
                customRestTextField2.setOpacity(1);
                muscleCustomTextField2.setOpacity(1);
            }
            case 2 -> {
                nameCustomExerciseTextField3.setOpacity(1);
                customSetTextfield3.setOpacity(1);
                customRepstextFields3.setOpacity(1);
                customRestTextField3.setOpacity(1);
                muscleCustomTextField3.setOpacity(1);
            }
            case 3 -> {
                nameCustomExerciseTextField4.setOpacity(1);
                customSetTextfield4.setOpacity(1);
                customRepstextFields4.setOpacity(1);
                customRestTextField4.setOpacity(1);
                muscleCustomTextField4.setOpacity(1);
            }
            case 4 -> {
                nameCustomExerciseTextField5.setOpacity(1);
                customSetTextfield5.setOpacity(1);
                customRepstextFields5.setOpacity(1);
                customRestTextField5.setOpacity(1);
                muscleCustomTextField5.setOpacity(1);
            }
            case 5 -> {
                nameCustomExerciseTextField6.setOpacity(1);
                customSetTextfield6.setOpacity(1);
                customRepstextFields6.setOpacity(1);
                customRestTextField6.setOpacity(1);
                muscleCustomTextField6.setOpacity(1);
            }
        }
        if(exerciseNumber < 6) exerciseNumber ++;
    }

    @FXML
    void clickedOnButtonRemoveCustomExercise(ActionEvent event) {
        if(remove) {
            switch (exerciseNumber) {
                case 2 -> {
                    nameCustomExerciseTextField2.setOpacity(0);
                    customSetTextfield2.setOpacity(0);
                    customRepstextFields2.setOpacity(0);
                    customRestTextField2.setOpacity(0);
                    muscleCustomTextField2.setOpacity(0);
                    removeCustomExercise.setOpacity(0);
                    remove = false;
                }
                case 3 -> {
                    nameCustomExerciseTextField3.setOpacity(0);
                    customSetTextfield3.setOpacity(0);
                    customRepstextFields3.setOpacity(0);
                    customRestTextField3.setOpacity(0);
                    muscleCustomTextField3.setOpacity(0);
                }
                case 4 -> {
                    nameCustomExerciseTextField4.setOpacity(0);
                    customSetTextfield4.setOpacity(0);
                    customRepstextFields4.setOpacity(0);
                    customRestTextField4.setOpacity(0);
                    muscleCustomTextField4.setOpacity(0);
                }
                case 5 -> {
                    nameCustomExerciseTextField5.setOpacity(0);
                    customSetTextfield5.setOpacity(0);
                    customRepstextFields5.setOpacity(0);
                    customRestTextField5.setOpacity(0);
                    muscleCustomTextField5.setOpacity(0);
                }
                case 6 -> {
                    nameCustomExerciseTextField6.setOpacity(0);
                    customSetTextfield6.setOpacity(0);
                    customRepstextFields6.setOpacity(0);
                    customRestTextField6.setOpacity(0);
                    muscleCustomTextField6.setOpacity(0);
                }
            }
            exerciseNumber --;
        }
    }

    @FXML
    void writeOnWorkoutName(KeyEvent event){
        customeWorkoutNameLabel.setOpacity(0);
    }

    @FXML
    void clickedOnButtonSaveCustomWorkout(ActionEvent event) throws IOException, SQLException {
        customFieldEmpty.setOpacity(0);
        //controllo che i textField di ogni esercizio non siano vuoti
        emptyTextFieldCheck(nameCustomExerciseTextField1, customSetTextfield1, customRepstextFields1, customRestTextField1, muscleCustomTextField1);
        emptyTextFieldCheck(nameCustomExerciseTextField2, customSetTextfield2, customRepstextFields2, customRestTextField2, muscleCustomTextField2);
        emptyTextFieldCheck(nameCustomExerciseTextField3, customSetTextfield3, customRepstextFields3, customRestTextField3, muscleCustomTextField3);
        emptyTextFieldCheck(nameCustomExerciseTextField4, customSetTextfield4, customRepstextFields4, customRestTextField4, muscleCustomTextField4);
        emptyTextFieldCheck(nameCustomExerciseTextField5, customSetTextfield5, customRepstextFields5, customRestTextField5, muscleCustomTextField5);
        emptyTextFieldCheck(nameCustomExerciseTextField6, customSetTextfield6, customRepstextFields6, customRestTextField6, muscleCustomTextField6);

        BeanCustomWorkoutData dataBean = new BeanCustomWorkoutData();
        if(UtilityAccess.getTypeOfUser().equals(TypeOfUser.PERSONAL_TRAINER)){
            WorkoutPlan workoutPlanPT = new WorkoutPlan(nameCustomWorkoutTextField.getText(), String.valueOf(exerciseNumber/3), UtilityAccess.getUsername(), Double.parseDouble(priceTextField.getText()));
            Exercise exercise1PT = new Exercise(nameCustomExerciseTextField1.getText(), Muscle.valueOf(muscleCustomTextField1.getText()), parseInt(customSetTextfield1.getText()),parseInt(customRepstextFields1.getText()), parseFloat(customRestTextField1.getText()), workoutPlanPT);
            dataBean.setExercise1(exercise1PT);
            if(!nameCustomExerciseTextField2.getText().isEmpty() ){
                Exercise exercise2PT = new Exercise(nameCustomExerciseTextField2.getText(), Muscle.valueOf(muscleCustomTextField2.getText()), parseInt(customSetTextfield2.getText()),parseInt(customRepstextFields2.getText()), parseFloat(customRestTextField2.getText()), workoutPlanPT);
                dataBean.setExercise2(exercise2PT);
            }
            if(!nameCustomExerciseTextField3.getText().isEmpty() ){
                Exercise exercise3PT = new Exercise(nameCustomExerciseTextField3.getText(), Muscle.valueOf(muscleCustomTextField3.getText()), parseInt(customSetTextfield3.getText()),parseInt(customRepstextFields3.getText()), parseFloat(customRestTextField3.getText()), workoutPlanPT);
                dataBean.setExercise3(exercise3PT);
            }
            if(!nameCustomExerciseTextField4.getText().isEmpty() ){
                Exercise exercise4PT = new Exercise(nameCustomExerciseTextField4.getText(), Muscle.valueOf(muscleCustomTextField4.getText()), parseInt(customSetTextfield4.getText()),parseInt(customRepstextFields4.getText()), parseFloat(customRestTextField4.getText()), workoutPlanPT);
                dataBean.setExercise4(exercise4PT);
            }
            if(!nameCustomExerciseTextField5.getText().isEmpty() ){
                Exercise exercise5PT = new Exercise(nameCustomExerciseTextField5.getText(), Muscle.valueOf(muscleCustomTextField5.getText()), parseInt(customSetTextfield5.getText()),parseInt(customRepstextFields5.getText()), parseFloat(customRestTextField5.getText()), workoutPlanPT);
                dataBean.setExercise5(exercise5PT);
            }
            if(!nameCustomExerciseTextField6.getText().isEmpty() ) {
                Exercise exercise6PT = new Exercise(nameCustomExerciseTextField6.getText(), Muscle.valueOf(muscleCustomTextField6.getText()), parseInt(customSetTextfield6.getText()), parseInt(customRepstextFields6.getText()), parseFloat(customRestTextField6.getText()), workoutPlanPT);
                dataBean.setExercise6(exercise6PT);
            }
        }
        else {
            WorkoutPlan workoutPlan = new WorkoutPlan(nameCustomWorkoutTextField.getText(), String.valueOf(exerciseNumber / 3), UtilityAccess.getUsername(), 0);

            Exercise exercise1 = new Exercise(nameCustomExerciseTextField1.getText(), Muscle.valueOf(muscleCustomTextField1.getText()), parseInt(customSetTextfield1.getText()), parseInt(customRepstextFields1.getText()), parseFloat(customRestTextField1.getText()), workoutPlan);
            dataBean.setExercise1(exercise1);
            if (!nameCustomExerciseTextField2.getText().isEmpty()) {
                Exercise exercise2 = new Exercise(nameCustomExerciseTextField2.getText(), Muscle.valueOf(muscleCustomTextField2.getText()), parseInt(customSetTextfield2.getText()), parseInt(customRepstextFields2.getText()), parseFloat(customRestTextField2.getText()), workoutPlan);
                dataBean.setExercise2(exercise2);
            }
            if (!nameCustomExerciseTextField3.getText().isEmpty()) {
                Exercise exercise3 = new Exercise(nameCustomExerciseTextField3.getText(), Muscle.valueOf(muscleCustomTextField3.getText()), parseInt(customSetTextfield3.getText()), parseInt(customRepstextFields3.getText()), parseFloat(customRestTextField3.getText()), workoutPlan);
                dataBean.setExercise3(exercise3);
            }
            if (!nameCustomExerciseTextField4.getText().isEmpty()) {
                Exercise exercise4 = new Exercise(nameCustomExerciseTextField4.getText(), Muscle.valueOf(muscleCustomTextField4.getText()), parseInt(customSetTextfield4.getText()), parseInt(customRepstextFields4.getText()), parseFloat(customRestTextField4.getText()), workoutPlan);
                dataBean.setExercise4(exercise4);
            }
            if (!nameCustomExerciseTextField5.getText().isEmpty()) {
                Exercise exercise5 = new Exercise(nameCustomExerciseTextField5.getText(), Muscle.valueOf(muscleCustomTextField5.getText()), parseInt(customSetTextfield5.getText()), parseInt(customRepstextFields5.getText()), parseFloat(customRestTextField5.getText()), workoutPlan);
                dataBean.setExercise5(exercise5);
            }
            if (!nameCustomExerciseTextField6.getText().isEmpty()) {
                Exercise exercise6 = new Exercise(nameCustomExerciseTextField6.getText(), Muscle.valueOf(muscleCustomTextField6.getText()), parseInt(customSetTextfield6.getText()), parseInt(customRepstextFields6.getText()), parseFloat(customRestTextField6.getText()), workoutPlan);
                dataBean.setExercise6(exercise6);
            }
        }


        if(saveWorkout){
            // Richiama il controller applicativo e passa il bean
            ApplicationControllerCreateWorkoutPlan applicationControllerCreateWorkoutPlan = new ApplicationControllerCreateWorkoutPlan();
            applicationControllerCreateWorkoutPlan.receiveCustomWorkoutData(dataBean);

            stageToSwitch = "/com/example/fitnesshelp/homePage";
            switchStage(event);
        }

        if(customFieldEmpty.getOpacity() == 0) saveWorkout = true;

    }


    void emptyTextFieldCheck(TextField textField1, TextField textField2, TextField textField3, TextField textField4, TextField textField5){
        if(Objects.equals(textField1.getText(), "") && textField2.getOpacity() == 1) customFieldEmpty.setOpacity(1);
        if(Objects.equals(textField2.getText(), "") && textField2.getOpacity() == 1) customFieldEmpty.setOpacity(1);
        if(Objects.equals(textField3.getText(), "") && textField3.getOpacity() == 1) customFieldEmpty.setOpacity(1);
        if(Objects.equals(textField4.getText(), "") && textField4.getOpacity() == 1) customFieldEmpty.setOpacity(1);
        if(Objects.equals(textField5.getText(), "") && textField5.getOpacity() == 1) customFieldEmpty.setOpacity(1);
    }
    @FXML
    void clickedOnHyperlinkBack(ActionEvent event) throws IOException {
        stageToSwitch = "createWorkout";
        switchStage(event);
    }


}
