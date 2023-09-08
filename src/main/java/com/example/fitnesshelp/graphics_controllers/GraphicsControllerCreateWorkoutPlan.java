package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerCreateWorkoutPlan;
import com.example.fitnesshelp.bean.BeanCustomWorkoutData;
import com.example.fitnesshelp.entities.*;
import com.example.fitnesshelp.utils.UtilityAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class GraphicsControllerCreateWorkoutPlan extends GraphicsControllerHomePage {

    @FXML
    private Button addCustomExercise;

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
    private Button startButton;
    @FXML
    private TextField priceTextField;

    private int exerciseNumber = 1;
    private boolean remove = false;
    private boolean saveWorkout = false;

    public void onClickStartButton() {
        startButton.setVisible(false);
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
        }
    }

    @FXML
    void clickedOnButtonAddCustomExercise() {
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
            default -> nameCustomExerciseTextField1.setOpacity(0);
        }
        if(exerciseNumber < 6) exerciseNumber ++;
    }

    @FXML
    void clickedOnButtonRemoveCustomExercise() {
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
                default -> nameCustomExerciseTextField1.setOpacity(0);
            }
            exerciseNumber --;
        }
    }

    @FXML
    void writeOnWorkoutName(){
        customeWorkoutNameLabel.setOpacity(0);
    }

    @FXML
    void clickedOnButtonSaveCustomWorkout(ActionEvent event) throws IOException, SQLException {
        customFieldEmpty.setOpacity(0);

        if (validateFields()) {
            BeanCustomWorkoutData dataBean = createCustomWorkoutData();

            if (saveWorkout) {
                ApplicationControllerCreateWorkoutPlan applicationControllerCreateWorkoutPlan = new ApplicationControllerCreateWorkoutPlan();
                applicationControllerCreateWorkoutPlan.receiveCustomWorkoutData(dataBean);
                navigateToHomePage(event);
            }

            if (customFieldEmpty.getOpacity() == 0) {
                saveWorkout = true;
            }
        }
    }

    private boolean validateFields() {
        emptyTextFieldCheck(nameCustomExerciseTextField1, customSetTextfield1, customRepstextFields1, customRestTextField1, muscleCustomTextField1);
        emptyTextFieldCheck(nameCustomExerciseTextField2, customSetTextfield2, customRepstextFields2, customRestTextField2, muscleCustomTextField2);
        emptyTextFieldCheck(nameCustomExerciseTextField3, customSetTextfield3, customRepstextFields3, customRestTextField3, muscleCustomTextField3);
        emptyTextFieldCheck(nameCustomExerciseTextField4, customSetTextfield4, customRepstextFields4, customRestTextField4, muscleCustomTextField4);
        emptyTextFieldCheck(nameCustomExerciseTextField5, customSetTextfield5, customRepstextFields5, customRestTextField5, muscleCustomTextField5);
        emptyTextFieldCheck(nameCustomExerciseTextField6, customSetTextfield6, customRepstextFields6, customRestTextField6, muscleCustomTextField6);

        return customFieldEmpty.getOpacity() == 0;
    }

    private BeanCustomWorkoutData createCustomWorkoutData() {
        BeanCustomWorkoutData dataBean = new BeanCustomWorkoutData();

        WorkoutPlan workoutPlan = createWorkoutPlan();

        addExercise(dataBean, workoutPlan, nameCustomExerciseTextField1, muscleCustomTextField1, customSetTextfield1, customRepstextFields1, customRestTextField1);
        addExercise(dataBean, workoutPlan, nameCustomExerciseTextField2, muscleCustomTextField2, customSetTextfield2, customRepstextFields2, customRestTextField2);
        addExercise(dataBean, workoutPlan, nameCustomExerciseTextField3, muscleCustomTextField3, customSetTextfield3, customRepstextFields3, customRestTextField3);
        addExercise(dataBean, workoutPlan, nameCustomExerciseTextField4, muscleCustomTextField4, customSetTextfield4, customRepstextFields4, customRestTextField4);
        addExercise(dataBean, workoutPlan, nameCustomExerciseTextField5, muscleCustomTextField5, customSetTextfield5, customRepstextFields5, customRestTextField5);
        addExercise(dataBean, workoutPlan, nameCustomExerciseTextField6, muscleCustomTextField6, customSetTextfield6, customRepstextFields6, customRestTextField6);

        return dataBean;
    }

    private WorkoutPlan createWorkoutPlan() {
        String workoutName = nameCustomWorkoutTextField.getText();
        String workoutCategory = String.valueOf((exerciseNumber / 3) + 1);
        String workoutUsername = UtilityAccess.getUsername();

        double workoutPrice = -10;
        if (UtilityAccess.getTypeOfUser().equals(TypeOfUser.PERSONAL_TRAINER)) {
            if (!priceTextField.getText().isEmpty()) {
                workoutPrice = Double.parseDouble(priceTextField.getText());
            }
        }

        return new WorkoutPlan(workoutName, workoutCategory, workoutUsername, workoutPrice);
    }

    private void addExercise(BeanCustomWorkoutData dataBean, WorkoutPlan workoutPlan, TextField nameTextField,
                             TextField muscleTextField, TextField setTextField, TextField repsTextField, TextField restTextField) {
        if (!nameTextField.getText().isEmpty()) {
            Exercise exercise = new Exercise(nameTextField.getText(), Muscle.valueOf(muscleTextField.getText()),
                    parseInt(setTextField.getText()), parseInt(repsTextField.getText()), parseFloat(restTextField.getText()), workoutPlan);
            dataBean.setExercise(exercise);
        }
    }

    private void navigateToHomePage(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/homePage";
        switchStage(event);
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
