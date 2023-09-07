package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.bean.BeanUsername;
import com.example.fitnesshelp.entities.Purchase;
import com.example.fitnesshelp.utils.UtilityAccess;
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

    public VBox anchorPaneContainer;
    public ScrollPane scrollPane;

    BeanState beanState = new BeanState(UtilityAccess.getState());
    ApplicationControllerBuyWorkoutPlan applicationControllerBuyWorkoutPlan = new ApplicationControllerBuyWorkoutPlan(beanState);
    BeanUsername beanUsername = new BeanUsername(UtilityAccess.getUsername());
    List<Purchase> purchaseList = applicationControllerBuyWorkoutPlan.checkUserPurchase(beanUsername);

    public GraphicsControllerAccountPurchase() throws IOException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int numberOfAnchorPanes;
        try {
            numberOfAnchorPanes = readValueFromFileSystem();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        List<AnchorPane> anchorPanes = createAnchorPanes(numberOfAnchorPanes, purchaseList);
        anchorPaneContainer.getChildren().addAll(anchorPanes);
    }

    private int readValueFromFileSystem() throws SQLException, IOException {
        // Read value from the file system
        return purchaseList.size();
    }

    private List<AnchorPane> createAnchorPanes(int numberOfAnchorPanes, List<Purchase> purchaseList) {

        List<AnchorPane> anchorPanes = new ArrayList<>();
        for (int index = 0; index < numberOfAnchorPanes; index++) {

            // Crea un nuovo AnchorPane
            AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPrefWidth(400); // Imposta la larghezza desiderata
            anchorPane.setPrefHeight(100); // Imposta l'altezza desiderata

            // Crea le label per visualizzare le informazioni di Purchase
            Label idLabel = new Label("ID: " + purchaseList.get(index).getIdPurchase());
            Label priceLabel = new Label("Price: " + purchaseList.get(index).getPrice());
            Label dateLabel = new Label("Date: " + purchaseList.get(index).getDate().toString());
            Label usernameLabel = new Label("Username: " + purchaseList.get(index).getUsername());
            Label workoutPlanLabel = new Label("Workout Plan: " + purchaseList.get(index).getWorkoutPlan().toString());

            // Posiziona le label all'interno dell'AnchorPane
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

            // Aggiungi le label all'AnchorPane
            anchorPane.getChildren().addAll(idLabel, priceLabel, dateLabel, usernameLabel, workoutPlanLabel);

            // Aggiungi l'AnchorPane alla lista
            anchorPanes.add(anchorPane);
        }
        return anchorPanes;
    }
}
