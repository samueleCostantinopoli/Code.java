package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.entities.State;
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

public class GraphicsControllerHomePage {

    @FXML
    private Label usernameLabel;


    private String stageToSwitch;

    static final String LOGIN = "/com/example/fitnesshelp/login";

    @FXML
    private Label errorLoginMessageLabel;
    @FXML
    private Button errorLoginMessageButton;

    public String getStageToSwitch() {
        return stageToSwitch;
    }

    public void setStageToSwitch(String stageToSwitch){
        this.stageToSwitch = stageToSwitch;
    }

    @FXML
    void clickedOnAccountHyperlink(ActionEvent event) throws IOException {
        if (UtilityAccess.getState() == State.LOGGED_IN) {
            stageToSwitch = "/com/example/fitnesshelp/account";
            switchStage(event);
        }
    }

    @FXML
    void clickedOnLoginHyperlink(ActionEvent event) throws IOException {
        if(UtilityAccess.getState() == State.NOT_LOGGED_IN){
            stageToSwitch = LOGIN;
            switchStage(event);
        }
    }

    @FXML
    void clickedOnButtonCreateNew(ActionEvent event) throws IOException {
        if(UtilityAccess.getState() == State.LOGGED_IN) {
            stageToSwitch = "/com/example/fitnesshelp/customWorkout";
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fitnesshelp/customWorkout.fxml"));
            Parent root = loader.load();
            GraphicsControllerCreateWorkoutPlan controller = loader.getController();
            controller.initialize();

            // Continua con la restante logica per la visualizzazione della scena
            switchStage(event);
        } else {
            errorLoginMessageLabel.setOpacity(1);
            errorLoginMessageButton.setOpacity(1);
        }
    }

    @FXML
    void clickedOnBuyWorkoutPlanHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/buyWorkoutPlan";
        switchStage(event);
    }
    @FXML
    void clickedOnFindAGymNearMeHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/findAGymNearMe";
        switchStage(event);
    }
    @FXML
    void clickedOnHomeHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/homePage";
        switchStage(event);
    }
    @FXML
    void clickedOnLogoutHyperlink(ActionEvent event) throws IOException {
        UtilityAccess.setUsername("admin");
        UtilityAccess.setState(State.NOT_LOGGED_IN);
        stageToSwitch = LOGIN;
        switchStage(event);
    }
    @FXML
    void clickedOnMyTrainingDiaryHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/trainingDiary";
        switchStage(event);
    }
    @FXML
    void clickedOnMyWorkoutPlanHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/myWorkoutPlan";
        switchStage(event);
    }
    @FXML
    void clickedOnPersonalTrainerHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/personalTrainer";
        switchStage(event);
    }
    @FXML
    void clickedOnTdeeCalculatorHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/calculateTdee1";
        switchStage(event);
    }

    public void clickedOnButtonErrorLoginMessageButton(ActionEvent event) throws IOException {
        stageToSwitch = LOGIN;
        switchStage(event);
    }


    void switchStage(ActionEvent event) throws IOException {
        FXMLLoader root = new FXMLLoader(getClass().getResource(getStageToSwitch() + ".fxml"));
        Stage home = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene primary = new Scene(root.load());
        home.setScene(primary);
        home.show();
    }

    @FXML
    void setUsernameLabel(){
        usernameLabel.setText(UtilityAccess.getUsername());
    }
}
