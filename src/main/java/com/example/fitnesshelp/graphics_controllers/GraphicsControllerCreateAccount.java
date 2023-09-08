package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerRegistration;
import com.example.fitnesshelp.bean.BeanAccountType;
import com.example.fitnesshelp.bean.BeanEmail;
import com.example.fitnesshelp.bean.BeanPassword;
import com.example.fitnesshelp.bean.BeanUsername;
import com.example.fitnesshelp.entities.Account;
import com.example.fitnesshelp.entities.State;
import com.example.fitnesshelp.entities.TypeOfUser;
import com.example.fitnesshelp.exception.EmailAlreadyExistException;
import com.example.fitnesshelp.exception.UsernameAlreadyExistException;
import com.example.fitnesshelp.utils.UtilityAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;

public class GraphicsControllerCreateAccount extends GraphicsControllerHomePage {


    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private RadioButton normalAccountRadioButton;

    @FXML
    private RadioButton personalTrainerAccountRadioButton;

    @FXML
    private Label registrationErrorMessageLabel;

    @FXML
    private TextField usernameField;

    @FXML
    void initialize() {
        passwordField.setPromptText("\u2022\u2022\u2022\u2022\u2022");
    }

    // radio button switch
    @FXML
    void clickedOnRadioButtonNormalAccount() {
        if (normalAccountRadioButton.isSelected()) {
            personalTrainerAccountRadioButton.setSelected(false);
        }
    }

    @FXML
    void clickedOnRadioButtonPersonalTrainerAccount() {
        if (personalTrainerAccountRadioButton.isSelected()) {
            normalAccountRadioButton.setSelected(false);
        }
    }

    @FXML
    void clickedOnButtonRegister(ActionEvent event) {
        if (!areFieldsValid()) {
            return;
        }

        try {
            BeanEmail beanEmail = new BeanEmail(emailField.getText());
            BeanPassword beanPassword = new BeanPassword(passwordField.getText());
            BeanUsername beanUsername = new BeanUsername(usernameField.getText());

            String emailSyntax = beanEmail.emailCehck(emailField.getText());
            String usernameLength = beanUsername.checkUsernameLength(usernameField.getText());
            String passwordComplexity = beanPassword.passwordCheck(passwordField.getText());

            if (emailSyntax != null || usernameLength != null || passwordComplexity != null) {
                showRegistrationError(emailSyntax, usernameLength, passwordComplexity);
            } else {
                TypeOfUser role = normalAccountRadioButton.isSelected() ? TypeOfUser.NORMAL : TypeOfUser.PERSONAL_TRAINER;
                BeanAccountType beanAccountType = new BeanAccountType(role.toString());

                ApplicationControllerRegistration applicationControllerRegistration =
                        new ApplicationControllerRegistration(beanUsername, beanEmail, beanPassword, beanAccountType);

                applicationControllerRegistration.checkCredentials();

                handleSuccessfulRegistration(event, role);
            }
        } catch (EmailAlreadyExistException | UsernameAlreadyExistException | SQLException | IOException e) {
            registrationErrorMessageLabel.setText(e.getMessage());
            registrationErrorMessageLabel.setOpacity(1);
        }
    }

    private boolean areFieldsValid() {
        return !usernameField.getText().isEmpty() && !passwordField.getText().isEmpty()
                && !emailField.getText().isEmpty()
                && (normalAccountRadioButton.isSelected() || personalTrainerAccountRadioButton.isSelected());
    }

    private void showRegistrationError(String emailSyntax, String usernameLength, String passwordComplexity) {
        String errorMessage = "";
        if (emailSyntax != null) {
            errorMessage += emailSyntax + "\n";
        }
        if (usernameLength != null) {
            errorMessage += usernameLength + "\n";
        }
        if (passwordComplexity != null) {
            errorMessage += passwordComplexity + "\n";
        }
        registrationErrorMessageLabel.setText(errorMessage.trim());
        registrationErrorMessageLabel.setOpacity(1);
    }

    private void handleSuccessfulRegistration(ActionEvent event, TypeOfUser role) throws IOException {
        usernameField.setDisable(true);
        emailField.setDisable(true);
        passwordField.setDisable(true);
        registrationErrorMessageLabel.setOpacity(0);

        UtilityAccess.setAccount(new Account(usernameField.getText(), passwordField.getText(), role, emailField.getText(), State.NOT_LOGGED_IN));

        setStageToSwitch("/com/example/fitnesshelp/login");
        switchStage(event);
    }


    public void clickedOnButtonHomeHyperlink(ActionEvent event) throws IOException {
        setStageToSwitch("/com/example/fitnesshelp/homePage");
        switchStage(event);
    }
}
