package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerLoginService;
import com.example.fitnesshelp.bean.BeanLogin;
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
    private Label usernameLabel;

    @FXML
    private TextField usernameField;

    @FXML
    private Hyperlink homeHyperlink;

    @FXML
    private Label passwordLabel;

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
    void clickedOnButtonCreateAccount(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/createAccount";
        switchStage(event);
    }

    @FXML
    void clickedOnButtonLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        BeanLogin beanLogin = new BeanLogin(username, password);
        // Crea un'istanza del servizio degli utenti
        ApplicationControllerLoginService userService = new ApplicationControllerLoginService(beanLogin);
/*
        if (userService.isValidUser(username, password)) {
            statusLabel.setText("Login riuscito");
            showAndHideDialogWithDuration(3000); // Mostra il dialogo per 3 secondi
        } else {
            statusLabel.setText("Login non riuscito");
            showAndHideDialogWithDuration(3000); // Mostra il dialogo per 3 secondi

        }

 */
    }

}
