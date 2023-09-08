package com.example.fitnesshelp.graphics_controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class GraphicsControllerFindAGymNearMe extends GraphicsControllerHomePage {

    @FXML
    void clickedOnButtonShowAllGym(ActionEvent event) {

    }

    @FXML
    void clickedOnButtonViewInfoGym1(ActionEvent event) {

    }

    @FXML
    void clickedOnButtonViewInfoGym2(ActionEvent event) {

    }

    public void clickedOnTdeeCalculatorHyperlink(ActionEvent event) throws IOException{
        stageToSwitch = "/com/example/fitnesshelp/calculateTdee1";
        switchStage(event);
    }
}
