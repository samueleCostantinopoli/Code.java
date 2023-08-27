package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerRegistration;
import com.example.fitnesshelp.bean.BeanAccountType;
import com.example.fitnesshelp.bean.BeanEmail;
import com.example.fitnesshelp.bean.BeanPassword;
import com.example.fitnesshelp.bean.BeanUsername;
import com.example.fitnesshelp.entities.TypeOfUser;
import com.example.fitnesshelp.exception.EmailAlreadyExistException;
import com.example.fitnesshelp.exception.UsernameAlreadyExistException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;

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
    private RadioButton normalAccountRadioButton;

    @FXML
    private RadioButton personalTrainerAccountRadioButton;

    @FXML
    private Label registrationErrorMessageLabel;

    @FXML
    private TextField usernameField;

    private BeanPassword beanPassword;
    private BeanUsername beanUsername;
    private BeanEmail beanEmail;
    private BeanAccountType beanAccountType;

    // radio button switch
    @FXML
    void clickedOnRadioButtonNormalAccount(ActionEvent event) {
        if (normalAccountRadioButton.isSelected()) {
            personalTrainerAccountRadioButton.setSelected(false);
        }
    }

    @FXML
    void clickedOnRadioButtonPersonalTrainerAccount(ActionEvent event) {
        if (personalTrainerAccountRadioButton.isSelected()) {
            normalAccountRadioButton.setSelected(false);
        }
    }

    @FXML
    void clickedOnButtonRegister(ActionEvent event) {
        // check if the fields are empty
        if (usernameField.getText().equals("") ||  passwordField.getText().equals("") || emailField.getText().equals("") || (!normalAccountRadioButton.isSelected() && !personalTrainerAccountRadioButton.isSelected())) {
            registrationErrorMessageLabel.setText("some field are empty");
            registrationErrorMessageLabel.setOpacity(1);
        }else{
            // check username length, password complexity and email syntax
            beanEmail = new BeanEmail(emailField.getText());
            beanPassword = new BeanPassword(passwordField.getText());
            beanUsername = new BeanUsername(usernameField.getText());
            String emailSyntax = beanEmail.emailCehck(emailField.getText());
            String usernameLength = beanUsername.checkUsernameLength(usernameField.getText());
            String passwordComplexity = beanPassword.passwordCheck(passwordField.getText());
            // strings are null if checks are ok
            // check radio button value to set the type of account
            if(normalAccountRadioButton.isSelected()) beanAccountType = new BeanAccountType("normal user");
            else beanAccountType = new BeanAccountType("personal trainer");
            if(usernameLength == null && passwordComplexity == null && emailSyntax == null){
                // in this case I call the application controller
                try{
                    ApplicationControllerRegistration applicationControllerRegistration = new ApplicationControllerRegistration(beanUsername, beanEmail, beanPassword, beanAccountType);
                    // successful registration
                    usernameField.setDisable(true);
                    emailField.setDisable(true);
                    passwordField.setDisable(true);
                    registrationErrorMessageLabel.setOpacity(0);
                    // switch to login page
                    stageToSwitch = "/com/example/fitnesshelp/login";
                    switchStage(event);
                }catch (EmailAlreadyExistException | UsernameAlreadyExistException | java.sql.SQLException | IOException e){
                    registrationErrorMessageLabel.setText(e.getMessage());
                    registrationErrorMessageLabel.setOpacity(1);
                }
            } else if (emailSyntax != null && usernameLength != null && passwordComplexity == null) {
                registrationErrorMessageLabel.setText(emailSyntax + "\n" + usernameLength);
                registrationErrorMessageLabel.setOpacity(1);
            } else if (emailSyntax == null && usernameLength != null && passwordComplexity != null) {
                registrationErrorMessageLabel.setText(passwordComplexity + "\n" + usernameLength);
                registrationErrorMessageLabel.setOpacity(1);
            } else if (emailSyntax != null && usernameLength == null && passwordComplexity == null) {
                registrationErrorMessageLabel.setText(emailSyntax);
                registrationErrorMessageLabel.setOpacity(1);
            } else if (emailSyntax != null && usernameLength == null && passwordComplexity != null) {
                registrationErrorMessageLabel.setText(emailSyntax + "\n" + passwordComplexity);
                registrationErrorMessageLabel.setOpacity(1);
            } else if (emailSyntax == null && usernameLength != null && passwordComplexity == null) {
                registrationErrorMessageLabel.setText(usernameLength);
                registrationErrorMessageLabel.setOpacity(1);
            } else if (emailSyntax == null && usernameLength == null && passwordComplexity != null) {
                registrationErrorMessageLabel.setText(passwordComplexity);
                registrationErrorMessageLabel.setOpacity(1);
            }
        }
    }

    public void clickedOnButtonHomeHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/homePage";
        switchStage(event);
    }
}
