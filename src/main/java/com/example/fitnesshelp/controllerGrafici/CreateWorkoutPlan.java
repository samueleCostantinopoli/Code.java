package com.example.fitnesshelp.controllerGrafici;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.util.Objects;

public class CreateWorkoutPlan extends HomePage{

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

    private int exerciseNumber = 1;
    private boolean remove = false;
    private boolean saveWorkout = false;

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
    void clickedOnButtonSaveCustomWorkout(ActionEvent event) throws IOException {
        customFieldEmpty.setOpacity(0);
        //controllo che i textField di ogni esercizio non siano vuoti
        emptyTextFieldCheck(nameCustomExerciseTextField1, customSetTextfield1, customRepstextFields1, customRestTextField1, muscleCustomTextField1);
        emptyTextFieldCheck(nameCustomExerciseTextField2, customSetTextfield2, customRepstextFields2, customRestTextField2, muscleCustomTextField2);
        emptyTextFieldCheck(nameCustomExerciseTextField3, customSetTextfield3, customRepstextFields3, customRestTextField3, muscleCustomTextField3);
        emptyTextFieldCheck(nameCustomExerciseTextField4, customSetTextfield4, customRepstextFields4, customRestTextField4, muscleCustomTextField4);
        emptyTextFieldCheck(nameCustomExerciseTextField5, customSetTextfield5, customRepstextFields5, customRestTextField5, muscleCustomTextField5);
        emptyTextFieldCheck(nameCustomExerciseTextField6, customSetTextfield6, customRepstextFields6, customRestTextField6, muscleCustomTextField6);

        if(customFieldEmpty.getOpacity() == 0) saveWorkout = true;

        if(saveWorkout){
            stageToSwitch = "homePage";
            switchStage(event);
        }

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
