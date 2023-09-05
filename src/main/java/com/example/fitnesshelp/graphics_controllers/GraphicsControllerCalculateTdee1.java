package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.entities.State;
import com.example.fitnesshelp.utils.UtilityAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fitnesshelp/calculateTdee2.fxml"));
            Parent root = loader.load();
            GraphicsControllerCalculateTdee2 graphicsControllerCalculateTdee2 = loader.getController();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(scene);
        } else {
            errorLoginMessageLabel.setOpacity(1);
        }
    }

    @FXML
    void clickedOnButtonMyTdee(ActionEvent event) throws IOException {
        // this method shows all tdee that user has saved
        if(UtilityAccess.getState() == State.LOGGED_IN) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fitnesshelp/calculateTdee0.fxml"));
            Parent root = loader.load();
            GraphicsControllerCalculateTdee0 graphicsControllerCalculateTdee0 = loader.getController();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(scene);
        } else {
            errorLoginMessageLabel.setOpacity(1);
        }
    }
}
