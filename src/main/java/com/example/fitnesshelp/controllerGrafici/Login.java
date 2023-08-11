package com.example.fitnesshelp.controllerGrafici;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login extends HomePage{

    @FXML
    private Button buttonCreateAccount;

    @FXML
    private Button buttonLogin;

    @FXML
    private Label email;

    @FXML
    private TextField emailField;

    @FXML
    private Hyperlink homeHyperlink;

    @FXML
    private Label password;

    @FXML
    private TextField passwordField;

    @FXML
    private Label title;

    @FXML
    private Label welcome;
    private Stage stage;
    private Scene scene;
    private FXMLLoader root;
    @FXML
    void clickedOnButtonCreateAccount(ActionEvent event) {

    }

    @FXML
    void clickedOnHomeHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/homePage";
        switchStage(event);
    }

    @FXML
    void clickedOnButtonLogin(ActionEvent event) {

    }

}
