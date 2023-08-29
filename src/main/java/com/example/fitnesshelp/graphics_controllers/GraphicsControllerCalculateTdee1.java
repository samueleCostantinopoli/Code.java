package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.entities.State;
import com.example.fitnesshelp.utils.UtilityAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.SQLException;

public class GraphicsControllerCalculateTdee1 extends GraphicsControllerHomePage{

    @FXML
    private Button myTdeeButton;

    @FXML
    private Button startButton;

    @FXML
    private Label errorLoginMessageLabel;

    @FXML
    private Hyperlink tdeeCalculatorHyperlink1;

    @FXML
    void clickedOnButtonStart(ActionEvent event) throws  IOException{
        // check if the user is logged in
        if(UtilityAccess.getState() == State.LOGGED_IN) {
            stageToSwitch = "/com/example/fitnesshelp/calculateTdee2";
            switchStage(event);
        } else {
            errorLoginMessageLabel.setOpacity(1);
        }
    }

    @FXML
    void clickedOnButtonMyTdee(ActionEvent event) throws IOException, SQLException {
        // this method shows all tdee that user has saved
        if(UtilityAccess.getState() == State.LOGGED_IN) {
            GraphicsControllerCalculateTdee0 graphicsControllerCalculateTdee0 = new GraphicsControllerCalculateTdee0();
            graphicsControllerCalculateTdee0.initialize();
            stageToSwitch = "/com/example/fitnesshelp/calculateTdee0";
            switchStage(event);
        } else {
            errorLoginMessageLabel.setOpacity(1);
        }
    }
}
