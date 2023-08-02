package com.example.fitnesshelp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Account {
    @FXML
    private Label NameAndSurname;

    @FXML
    private Hyperlink accountHyperlink;

    @FXML
    private Hyperlink buyWorkoutPlanHyperlink;

    @FXML
    private Button changeEmailButton;

    @FXML
    private ImageView changeNameImageView;

    @FXML
    private Button changePasswordButton;

    @FXML
    private ImageView changeProfilePictureImageView1;

    @FXML
    private Label email;

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
    private Label password;

    @FXML
    private Hyperlink personalTrainerHyperlink1;

    @FXML
    private ImageView profileImage;

    @FXML
    private ImageView showPassword;

    @FXML
    private Button switchAccountButton;

    @FXML
    private Label title;

    @FXML
    private Button viewPurchaseButton;

    @FXML
    private Label welocme;

    @FXML
    private Label zoomEmail;

    @FXML
    private ImageView zoomProfileImage1;
    private Stage stage;
    private Scene scene;
    private FXMLLoader root;
    @FXML
    void clickedOnAccountHyperlink(ActionEvent event) throws IOException{
        root = new FXMLLoader(getClass().getResource("account.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void clickedOnButtonChangeEmail(ActionEvent event) {

    }

    @FXML
    void clickedOnButtonChangePassword(ActionEvent event) {

    }

    @FXML
    void clickedOnButtonSwitchAccount(ActionEvent event) {

    }

    @FXML
    void clickedOnButtonViewPurchase(ActionEvent event) {

    }

    @FXML
    void clickedOnBuyWorkoutPlanHyperlink(ActionEvent event) throws IOException {
        root = new FXMLLoader(getClass().getResource("buyWorkoutPlan.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void clickedOnFindAGymNearMeHyperlink(ActionEvent event) throws IOException{
        root = new FXMLLoader(getClass().getResource("findAGymNearMe.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void clickedOnHomeHyperlink(ActionEvent event) throws IOException{
        root = new FXMLLoader(getClass().getResource("homePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void clickedOnLogoutHyperlink(ActionEvent event) throws IOException{
        root = new FXMLLoader(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void clickedOnMyTrainingDiaryHyperlink(ActionEvent event) throws IOException{
        root = new FXMLLoader(getClass().getResource("trainingDiary.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void clickedOnMyWorkoutPlanHyperlink(ActionEvent event) throws IOException{
        root = new FXMLLoader(getClass().getResource("myWorkoutPlan.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void clickedOnPersonalTrainerHyperlink(ActionEvent event) throws IOException{
        root = new FXMLLoader(getClass().getResource("personalTrainer.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();
    }

}


