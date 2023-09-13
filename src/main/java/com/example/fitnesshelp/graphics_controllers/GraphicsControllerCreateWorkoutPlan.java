package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerCreateWorkoutPlan;
import com.example.fitnesshelp.bean.BeanCustomWorkoutData;
import com.example.fitnesshelp.entities.*;
import com.example.fitnesshelp.utils.UtilityAccess;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import com.example.fitnesshelp.entities.Muscle;


public class GraphicsControllerCreateWorkoutPlan extends GraphicsControllerHomePage {

    @FXML
    public Label priceText;

    @FXML
    public ChoiceBox<Muscle> muscleCustomChoiceBox1;
    @FXML
    public ChoiceBox<Muscle> muscleCustomChoiceBox2;
    @FXML
    public ChoiceBox<Muscle> muscleCustomChoiceBox3;
    @FXML
    public ChoiceBox<Muscle> muscleCustomChoiceBox4;
    @FXML
    public ChoiceBox<Muscle> muscleCustomChoiceBox5;
    @FXML
    public ChoiceBox<Muscle> muscleCustomChoiceBox6;
    @FXML
    private Button addCustomExercise;

    @FXML
    private Label customeWorkoutNameLabel;

    @FXML
    private Label customFieldEmpty;

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

    public void initialize() {
        // Inizializza i ChoiceBox con i valori dell'enum Muscle
        muscleCustomChoiceBox1.setItems(FXCollections.observableArrayList(Muscle.values()));
        muscleCustomChoiceBox2.setItems(FXCollections.observableArrayList(Muscle.values()));
        muscleCustomChoiceBox3.setItems(FXCollections.observableArrayList(Muscle.values()));
        muscleCustomChoiceBox4.setItems(FXCollections.observableArrayList(Muscle.values()));
        muscleCustomChoiceBox5.setItems(FXCollections.observableArrayList(Muscle.values()));
        muscleCustomChoiceBox6.setItems(FXCollections.observableArrayList(Muscle.values()));
    }

    public void onClickStartButton() {
        startButton.setVisible(false);
        infoBar.setVisible(true);
        nameCustomExerciseTextField1.setVisible(true);
        muscleCustomChoiceBox1.setVisible(true);
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
            priceText.setVisible(true);
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
                muscleCustomChoiceBox2.setOpacity(1);
            }
            case 2 ->
                setOpacity2(1);
            case 3 ->
                setOpacity3(1);
            case 4 ->
                setOpacity4(1);
            case 5 ->
                setOpacity5(1);
            default -> nameCustomExerciseTextField1.setOpacity(0);
        }
        if(exerciseNumber < 6) exerciseNumber ++;
    }


    private void setOpacity2(int value){
        nameCustomExerciseTextField2.setOpacity(value);
        customSetTextfield2.setOpacity(value);
        customRepstextFields2.setOpacity(value);
        customRestTextField2.setOpacity(value);
        muscleCustomChoiceBox2.setOpacity(value);
    }

    private void setOpacity3(int value){
        nameCustomExerciseTextField3.setOpacity(value);
        customSetTextfield3.setOpacity(value);
        customRepstextFields3.setOpacity(value);
        customRestTextField3.setOpacity(value);
        muscleCustomChoiceBox3.setOpacity(value);
    }

    private void setOpacity4(int value){
        nameCustomExerciseTextField4.setOpacity(value);
        customSetTextfield4.setOpacity(value);
        customRepstextFields4.setOpacity(value);
        customRestTextField4.setOpacity(value);
        muscleCustomChoiceBox4.setOpacity(value);
    }

    private void setOpacity5(int value){
        nameCustomExerciseTextField5.setOpacity(value);
        customSetTextfield5.setOpacity(value);
        customRepstextFields5.setOpacity(value);
        customRestTextField5.setOpacity(value);
        muscleCustomChoiceBox5.setOpacity(value);
    }


    @FXML
    void clickedOnButtonRemoveCustomExercise() {
        if(remove) {
            switch (exerciseNumber) {
                case 2 -> setOpacity2(0);
                case 3 -> setOpacity3(0);
                case 4 -> setOpacity4(0);
                case 5 -> setOpacity5(0);
                case 6 -> {
                nameCustomExerciseTextField6.setOpacity(0);
                customSetTextfield6.setOpacity(0);
                customRepstextFields6.setOpacity(0);
                customRestTextField6.setOpacity(0);
                muscleCustomChoiceBox6.setOpacity(0);
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
        emptyTextFieldCheck(nameCustomExerciseTextField1, customSetTextfield1, customRepstextFields1, customRestTextField1, muscleCustomChoiceBox1);
        emptyTextFieldCheck(nameCustomExerciseTextField2, customSetTextfield2, customRepstextFields2, customRestTextField2, muscleCustomChoiceBox2);
        emptyTextFieldCheck(nameCustomExerciseTextField3, customSetTextfield3, customRepstextFields3, customRestTextField3, muscleCustomChoiceBox3);
        emptyTextFieldCheck(nameCustomExerciseTextField4, customSetTextfield4, customRepstextFields4, customRestTextField4, muscleCustomChoiceBox4);
        emptyTextFieldCheck(nameCustomExerciseTextField5, customSetTextfield5, customRepstextFields5, customRestTextField5, muscleCustomChoiceBox5);
        emptyTextFieldCheck(nameCustomExerciseTextField6, customSetTextfield6, customRepstextFields6, customRestTextField6, muscleCustomChoiceBox6);

        return customFieldEmpty.getOpacity() == 0;
    }

    private BeanCustomWorkoutData createCustomWorkoutData() {
        BeanCustomWorkoutData dataBean = new BeanCustomWorkoutData();

        WorkoutPlan workoutPlan = createWorkoutPlan();

        addExercise(dataBean, workoutPlan, nameCustomExerciseTextField1, muscleCustomChoiceBox1, customSetTextfield1, customRepstextFields1, customRestTextField1);
        addExercise(dataBean, workoutPlan, nameCustomExerciseTextField2, muscleCustomChoiceBox2, customSetTextfield2, customRepstextFields2, customRestTextField2);
        addExercise(dataBean, workoutPlan, nameCustomExerciseTextField3, muscleCustomChoiceBox3, customSetTextfield3, customRepstextFields3, customRestTextField3);
        addExercise(dataBean, workoutPlan, nameCustomExerciseTextField4, muscleCustomChoiceBox4, customSetTextfield4, customRepstextFields4, customRestTextField4);
        addExercise(dataBean, workoutPlan, nameCustomExerciseTextField5, muscleCustomChoiceBox5, customSetTextfield5, customRepstextFields5, customRestTextField5);
        addExercise(dataBean, workoutPlan, nameCustomExerciseTextField6, muscleCustomChoiceBox6, customSetTextfield6, customRepstextFields6, customRestTextField6);

        return dataBean;
    }

    private WorkoutPlan createWorkoutPlan() {
        String workoutName = nameCustomWorkoutTextField.getText();
        String workoutCategory = String.valueOf((exerciseNumber / 3) + 1);
        String workoutUsername = UtilityAccess.getUsername();

        double workoutPrice = 0;
        if (UtilityAccess.getTypeOfUser().equals(TypeOfUser.PERSONAL_TRAINER) && !priceTextField.getText().isEmpty()) {
            workoutPrice = Double.parseDouble(priceTextField.getText());
        }

        return new WorkoutPlan(workoutName, workoutCategory, workoutUsername, workoutPrice);
    }

    private void addExercise(BeanCustomWorkoutData dataBean, WorkoutPlan workoutPlan, TextField nameTextField,
                             ChoiceBox muscleTextField, TextField setTextField, TextField repsTextField, TextField restTextField) {
        if (!nameTextField.getText().isEmpty()) {
            Exercise exercise = new Exercise(nameTextField.getText(), Muscle.valueOf(String.valueOf(muscleTextField.getValue())),
                    parseInt(setTextField.getText()), parseInt(repsTextField.getText()), parseFloat(restTextField.getText()), workoutPlan);
            dataBean.setExercise(exercise);
        }
    }

    private void navigateToHomePage(ActionEvent event) throws IOException {
        setStageToSwitch("/com/example/fitnesshelp/homePage");
        switchStage(event);
    }


    void emptyTextFieldCheck(TextField textField1, TextField textField2, TextField textField3, TextField textField4, ChoiceBox choiceBoxMuscle){
        if(Objects.equals(textField1.getText(), "") && textField2.getOpacity() == 1) customFieldEmpty.setOpacity(1);
        if(Objects.equals(textField2.getText(), "") && textField2.getOpacity() == 1) customFieldEmpty.setOpacity(1);
        if(Objects.equals(textField3.getText(), "") && textField3.getOpacity() == 1) customFieldEmpty.setOpacity(1);
        if(Objects.equals(textField4.getText(), "") && textField4.getOpacity() == 1) customFieldEmpty.setOpacity(1);
        if(Objects.equals(choiceBoxMuscle.getValue(), "") && choiceBoxMuscle.getOpacity() == 1) customFieldEmpty.setOpacity(1);
    }
    @FXML
    void clickedOnHyperlinkBack(ActionEvent event) throws IOException {
        setStageToSwitch("createWorkout");
        switchStage(event);
    }
}
