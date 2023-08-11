package com.example.fitnesshelp.controllerGrafici;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PersonalTrainer extends HomePage{

    @FXML
    private Label NameSurnameAge1;

    @FXML
    private Label NameSurnameAge2;

    @FXML
    private Hyperlink accountHyperlink;

    @FXML
    private Hyperlink buyWorkoutPlanHyperlink;

    @FXML
    private Button contacts1Button;

    @FXML
    private Button contacts2Button;

    @FXML
    private AnchorPane dataPersonal1Pane;

    @FXML
    private AnchorPane dataPersonal2Pane;

    @FXML
    private Label description2Personal1;

    @FXML
    private Label descriptionPersonal1;

    @FXML
    private Label descriptionPersonal2;

    @FXML
    private Hyperlink findAGymNearMeHyperlink;

    @FXML
    private Hyperlink homeHyperlink;

    @FXML
    private ImageView homeImageView;

    @FXML
    private Hyperlink logoutHyperlink;

    @FXML
    private ImageView logoutImageView;

    @FXML
    private Hyperlink myTrainingDiaryHyperlink;

    @FXML
    private Hyperlink myWorkoutPlanHyperlink;

    @FXML
    private Label nameSurname;

    @FXML
    private Button nextPersonalButton;

    @FXML
    private Button pageOnePersonalButton;

    @FXML
    private Button pageTreePersonalButton;

    @FXML
    private Button pageTwoPersonalButton;

    @FXML
    private AnchorPane personal1Pane;

    @FXML
    private AnchorPane personal2Pane1;

    @FXML
    private Hyperlink personalTrainerHyperlink;

    @FXML
    private ImageView profileImage;

    @FXML
    private Label title;

    @FXML
    private Button viewProfile1Button;

    @FXML
    private Button viewProfile2Button;

    @FXML
    private Button viewWorkoutPlans1Button;

    @FXML
    private Button viewWorkoutPlans2Button;

    @FXML
    private Label welocme;
    private Stage stage;
    private Scene scene;
    private FXMLLoader root;
    @FXML
    void clickedOnAccountHyperlink(ActionEvent event) throws IOException{
        stageToSwitch= "/com/example/fitnesshelp/account";
        switchStage(event);
    }

    @FXML
    void clickedOnButtonContacts(ActionEvent event) {

    }

    @FXML
    void clickedOnButtonNextPersonal(ActionEvent event) {

    }

    @FXML
    void clickedOnButtonPageOnePersonal(ActionEvent event) {

    }

    @FXML
    void clickedOnButtonPageTreePersonal(ActionEvent event) {

    }

    @FXML
    void clickedOnButtonPageTwoPersonal(ActionEvent event) {

    }

    @FXML
    void clickedOnButtonViewProfile(ActionEvent event) {

    }

    @FXML
    void clickedOnButtonViewWorkoutPlans(ActionEvent event) {

    }

    @FXML
    void clickedOnBuyWorkoutPlanHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/buyWorkoutPlan";
        switchStage(event);
    }

    @FXML
    void clickedOnFindAGymNearMeHyperlink(ActionEvent event) throws IOException{
        stageToSwitch = "/com/example/fitnesshelp/findAGymNearMe";
        switchStage(event);
    }


    @FXML
    void clickedOnHomeHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/HomePage";
        switchStage(event);
    }

    @FXML
    void clickedOnLogoutHyperlink(ActionEvent event) throws IOException{
        stageToSwitch = "/com/example/fitnesshelp/login";
        switchStage(event);
    }

    @FXML
    void clickedOnMyTrainingDiaryHyperlink(ActionEvent event) throws IOException{
        stageToSwitch = "/com/example/fitnesshelp/trainingDiary";
        switchStage(event);
    }

    @FXML
    void clickedOnMyWorkoutPlanHyperlink(ActionEvent event) throws IOException{
        stageToSwitch = "/com/example/fitnesshelp/myWorkoutPlan";
        switchStage(event);
    }

    @FXML
    void clickedOnPersonalTrainerHyperlink(ActionEvent event) throws IOException{
        stageToSwitch = "/com/example/fitnesshelp/personalTrainer";
        switchStage(event);
    }

    public void clickedOnTdeeCalculatorHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/calculateTdee1";
        switchStage(event);
    }
}
