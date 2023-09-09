package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.bean.BeanUsername;
import com.example.fitnesshelp.entities.Purchase;
import com.example.fitnesshelp.utils.UtilityAccess;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GraphicsControllerAccountPurchase extends GraphicsControllerHomePage implements Initializable {

    @FXML
    public VBox anchorPaneContainer;
    @FXML
    public ScrollPane scrollPane;

    BeanState beanState = new BeanState(UtilityAccess.getState());
    ApplicationControllerBuyWorkoutPlan applicationControllerBuyWorkoutPlan = new ApplicationControllerBuyWorkoutPlan(beanState);
    BeanUsername beanUsername = new BeanUsername(UtilityAccess.getUsername());
    List<Purchase> purchaseList = applicationControllerBuyWorkoutPlan.checkUserPurchase(beanUsername);

    public GraphicsControllerAccountPurchase() throws SQLException, IOException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int numberOfAnchorPanes;
        numberOfAnchorPanes = readValueFromFileSystem();
        List<AnchorPane> anchorPanes = createAnchorPanes(numberOfAnchorPanes, purchaseList);
        anchorPaneContainer.getChildren().addAll(anchorPanes);
    }

    private int readValueFromFileSystem() {
        // Read value from the file system
        return purchaseList.size();
    }

    private List<AnchorPane> createAnchorPanes(int numberOfAnchorPanes, List<Purchase> purchaseList) {

        List<AnchorPane> anchorPanes = new ArrayList<>();
        for (int index = 0; index < numberOfAnchorPanes; index++) {

            // I create a new AnchorPane
            AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPrefWidth(400);
            anchorPane.setPrefHeight(100);

            // I create the labels to display the Purchase information
            Label idLabel = new Label("ID: " + purchaseList.get(index).getIdPurchase());
            Label priceLabel = new Label("Price: " + purchaseList.get(index).getPrice());
            Label dateLabel = new Label("Date: " + purchaseList.get(index).getDate().toString());
            Label usernameLabel = new Label("Username: " + purchaseList.get(index).getUsername());
            Label workoutPlanLabel = new Label("Workout Plan: " + purchaseList.get(index).getWorkoutPlan().getName());

            // I place the labels inside the AnchorPane
            AnchorPane.setTopAnchor(idLabel, 10.0);
            AnchorPane.setLeftAnchor(idLabel, 10.0);
            AnchorPane.setTopAnchor(priceLabel, 30.0);
            AnchorPane.setLeftAnchor(priceLabel, 10.0);
            AnchorPane.setTopAnchor(dateLabel, 50.0);
            AnchorPane.setLeftAnchor(dateLabel, 10.0);
            AnchorPane.setTopAnchor(usernameLabel, 70.0);
            AnchorPane.setLeftAnchor(usernameLabel, 10.0);
            AnchorPane.setTopAnchor(workoutPlanLabel, 90.0);
            AnchorPane.setLeftAnchor(workoutPlanLabel, 10.0);

            // I add the labels to the AnchorPane
            anchorPane.getChildren().addAll(idLabel, priceLabel, dateLabel, usernameLabel, workoutPlanLabel);

            // I add the AnchorPane to the list
            anchorPanes.add(anchorPane);
        }
        return anchorPanes;

    }
}
