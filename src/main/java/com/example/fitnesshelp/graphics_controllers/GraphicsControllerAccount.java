package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.utils.UtilityAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

import static com.example.fitnesshelp.entities.State.LOGGED_IN;

public class GraphicsControllerAccount extends GraphicsControllerHomePage {
    public final String ACCOUNT= "/com/example/fitnesshelp/account";

    @FXML
    void clickedOnAccountHyperlink(ActionEvent event) throws IOException{
        stageToSwitch= ACCOUNT;
        switchStage(event);
    }

    @FXML
    void clickedOnButtonChangeEmail(ActionEvent event) throws IOException {
        stageToSwitch= ACCOUNT;
        switchStage(event);
    }

    @FXML
    void clickedOnButtonChangePassword(ActionEvent event) throws IOException {
        stageToSwitch= ACCOUNT;
        switchStage(event);
    }

    @FXML
    void clickedOnButtonViewPurchase(ActionEvent event) throws IOException {
        if(UtilityAccess.getState().equals(LOGGED_IN)) {
            stageToSwitch = "/com/example/fitnesshelp/accountPurchase";
            switchStage(event);
        }
    }
}


