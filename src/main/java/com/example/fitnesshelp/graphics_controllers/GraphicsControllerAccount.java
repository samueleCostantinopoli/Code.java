package com.example.fitnesshelp.graphics_controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class GraphicsControllerAccount extends GraphicsControllerHomePage {
    @FXML
    private Label username;

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
    private Label password;

    @FXML
    private ImageView showPassword;

    @FXML
    private Button switchAccountButton;

    @FXML
    private Button viewPurchaseButton;

    @FXML
    private Label zoomEmail;

    @FXML
    private ImageView zoomProfileImage1;
    private Stage stage;
    private Scene scene;
    private FXMLLoader root;
    @FXML
    void clickedOnAccountHyperlink(ActionEvent event) throws IOException{
        stageToSwitch= "/com/example/fitnesshelp/account";
        switchStage(event);
    }

    @FXML
    void clickedOnButtonChangeEmail(ActionEvent event) {

    }

    @FXML
    void clickedOnButtonChangePassword(ActionEvent event) {

    }

    @FXML
    void clickedOnButtonViewPurchase(ActionEvent event) {

    }
}


