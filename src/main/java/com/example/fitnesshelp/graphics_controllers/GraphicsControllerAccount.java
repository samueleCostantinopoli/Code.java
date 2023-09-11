package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.utils.UtilityAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;

import static com.example.fitnesshelp.entities.State.LOGGED_IN;

public class GraphicsControllerAccount extends GraphicsControllerHomePage {

    @FXML
    private Label email;

    @FXML
    private Label username;

    @FXML
    private Label password;

    @FXML
    private Label zoomEmail;

    @FXML
    private Label realPasswordLabel;

    @FXML
    private ImageView showPassword;


    @FXML
    public void initialize(){
        realPasswordLabel.setOpacity(0);
        zoomEmail.setText(UtilityAccess.getEmail());
        email.setText(UtilityAccess.getEmail());
        username.setText(UtilityAccess.getUsername());
        realPasswordLabel.setText(UtilityAccess.getPassword());
    }

    @FXML
    void clickedOnShowPassword() {
        if(password.getOpacity() == 0){
            realPasswordLabel.setOpacity(0);
            password.setOpacity(1);
        } else {
            password.setOpacity(0);
            realPasswordLabel.setOpacity(1);
        }
    }

    @FXML
    void clickedOnButtonViewPurchase(ActionEvent event) throws IOException {
        if(UtilityAccess.getState().equals(LOGGED_IN)) {
            setStageToSwitch("/com/example/fitnesshelp/accountPurchase");
            switchStage(event);
        }
    }
}


