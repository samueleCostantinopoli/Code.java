package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerLogin;
import com.example.fitnesshelp.bean.BeanPassword;
import com.example.fitnesshelp.bean.BeanUsername;
import com.example.fitnesshelp.exception.NotExistsUsersException;
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
import java.sql.SQLException;

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
    private Label errorMessageLabel;

    @FXML
    private Label welcome;
    private Stage stage;
    private Scene scene;
    private FXMLLoader root;

    private BeanUsername beanUsername;
    private BeanPassword beanPassword;

    @FXML
    void clickedOnButtonCreateAccount(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/createAccount";
        switchStage(event);
    }

    @FXML
    void clickedOnButtonLogin(ActionEvent event) {
        // check if the fields are empty
        if (usernameField.getText().equals("") ||  passwordField.getText().equals("")) {
            errorMessageLabel.setText("some field are empty");
            errorMessageLabel.setOpacity(1);
        }else{
            // check username length and password complexity
            beanUsername = new BeanUsername(usernameField.getText());
            beanPassword = new BeanPassword(passwordField.getText());
            String usernameLength = beanUsername.checkUsernameLength(usernameField.getText());
            String passwordComplexity = beanPassword.passwordCheck(passwordField.getText());
            // strings are null if checks are ok
            if(usernameLength == null && passwordComplexity == null) {
                // in this case I call the application controller
                try {
                    ApplicationControllerLogin applicationControllerLoginService = new ApplicationControllerLogin(beanUsername, beanPassword);
                    usernameField.setDisable(true);
                    passwordField.setDisable(true);
                    buttonLogin.setDisable(true);
                    buttonCreateAccount.setDisable(true);
                    errorMessageLabel.setOpacity(0);
                }catch (NotExistsUsersException | SQLException | IOException e){
                    errorMessageLabel.setText(e.getMessage());
                    errorMessageLabel.setOpacity(1);
                }
                // in these cases there is an error on username or password
            }else if(usernameLength == null && passwordComplexity != null){
                errorMessageLabel.setText(passwordComplexity);
                errorMessageLabel.setOpacity(1);
            }else{
                errorMessageLabel.setText(usernameLength);
                errorMessageLabel.setOpacity(1);
            }
        }


        // questa parte commentata da errore, eliminala se non serve, nel dubbio l'ho lasciata

        /*
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


        // Crea un'istanza del servizio degli utenti
        //ApplicationControllerLoginService userService = new ApplicationControllerLoginService(beanUsername, beanPassword);

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
