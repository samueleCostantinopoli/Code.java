package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.LoginService;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class GraphicsControllerLogin extends GraphicsControllerHomePage {

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
    private Label statusLabel;

    @FXML
    private Label welcome;
    private Stage stage;
    private Scene scene;
    private FXMLLoader root;

    // Metodo per mostrare il dialogo per un breve periodo di tempo
    public void showAndHideDialogWithDuration(long milliseconds) {
        statusLabel.setVisible(true);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(milliseconds), event -> {
                    closeDialog();
                })
        );
        timeline.play();
    }

    @FXML
    private void closeDialog() {
        statusLabel.setVisible(false);
    }
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
        String username = emailField.getText();
        String password = passwordField.getText();

        // Crea un'istanza del servizio degli utenti
        LoginService userService = new LoginService(username, password);

        if (userService.isValidUser(username, password)) {
            statusLabel.setText("Login riuscito");
            showAndHideDialogWithDuration(3000); // Mostra il dialogo per 3 secondi
        } else {
            statusLabel.setText("Login non riuscito");
            showAndHideDialogWithDuration(3000); // Mostra il dialogo per 3 secondi

        }
    }

}
