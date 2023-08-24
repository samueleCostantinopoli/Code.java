package com.example.fitnesshelp.graphics_controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class GraphicsControllerCreateAccount extends GraphicsControllerHomePage {

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
    private Button registerButton;

    @FXML
    private Label username;

    @FXML
    private TextField usernameField;

    @FXML
    void clickedOnButtonRegister(ActionEvent event) {

    }

    public void clickedOnButtonHomeHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/homePage";
        switchStage(event);
    }
}
