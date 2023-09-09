package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerLogin;
import com.example.fitnesshelp.bean.BeanPassword;
import com.example.fitnesshelp.bean.BeanUsername;
import com.example.fitnesshelp.entities.State;
import com.example.fitnesshelp.exception.NotExistsUsersException;
import com.example.fitnesshelp.utils.UtilityAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.sql.SQLException;

public class GraphicsControllerLogin extends GraphicsControllerHomePage {

    @FXML
    private Button buttonCreateAccount;

    @FXML
    private Button buttonLogin;


    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorMessageLabel;

    private BeanUsername beanUsername;
    private BeanPassword beanPassword;

    @FXML
    void initialize() {
        passwordField.setPromptText("\u2022\u2022\u2022\u2022\u2022");
    }

    @FXML
    void clickedOnButtonCreateAccount(ActionEvent event) throws IOException {
        setStageToSwitch("/com/example/fitnesshelp/createAccount");
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
                    ApplicationControllerLogin applicationControllerLogin = new ApplicationControllerLogin(beanUsername, beanPassword);
                    applicationControllerLogin.checkUserAccount();
                    // successful login
                    UtilityAccess.setUsername(usernameField.getText());
                    UtilityAccess.setPassword(passwordField.getText());
                    UtilityAccess.setState(State.LOGGED_IN);
                    usernameField.setDisable(true);
                    passwordField.setDisable(true);
                    buttonLogin.setDisable(true);
                    buttonCreateAccount.setDisable(true);
                    errorMessageLabel.setOpacity(0);
                    // switch to home page
                    setUsernameLabel();
                    setStageToSwitch("/com/example/fitnesshelp/homePage");
                    switchStage(event);
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
    }
}
