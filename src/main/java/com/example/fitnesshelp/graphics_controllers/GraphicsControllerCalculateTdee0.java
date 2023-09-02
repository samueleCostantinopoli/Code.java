package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerCalculateTdee;
import com.example.fitnesshelp.entities.Tdee;
import com.example.fitnesshelp.factory.TypeOfPersistence;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class GraphicsControllerCalculateTdee0 extends GraphicsControllerHomePage{

    @FXML
    private ImageView deleteTdeeImageView;

    @FXML
    private Hyperlink tdeeCalculatorHyperlink1;

    @FXML
    private Label carbElementLabel;

    @FXML
    private HBox elementHbox;

    @FXML
    private Label fatElementLabel;

    @FXML
    private Label kcalElementLabel;

    @FXML
    private Label proElementLabel;

    @FXML
    private Label quantityElementLabel;

    @FXML
    private Label targetElementLabel;

    @FXML
    private VBox tdeeListVBox;

    @FXML
    void initialize() throws SQLException, IOException {
        String imagePath = "/com/example/fitnesshelp/delete.png";
        URL imageURL = getClass().getResource(imagePath);


        // call the application controller to request the list of tdee calculated
        ApplicationControllerCalculateTdee applicationControllerCalculateTdee = new ApplicationControllerCalculateTdee();
        List<Tdee> tdeeList = applicationControllerCalculateTdee.requestTdeeList();

        // I iterate dynamically to create the list of tdee
        for (Tdee tdee : tdeeList) {
            elementHbox = new HBox(); // this row contains all element
            elementHbox.setPrefHeight(50);

            // creation labels for each attributes
            kcalElementLabel = new Label("kcal: " + tdee.getKcal());
            proElementLabel = new Label("pro: " + tdee.getPro());
            fatElementLabel = new Label("fat: " + tdee.getFat());
            carbElementLabel = new Label("carb: " + tdee.getCarb());
            targetElementLabel = new Label("" + tdee.getTarget());
            quantityElementLabel = new Label("" + tdee.getQuantity());

            // image view button for delete tdee selected

            deleteTdeeImageView = new ImageView(imageURL.toExternalForm());
            deleteTdeeImageView.setFitHeight(30);
            deleteTdeeImageView.setFitWidth(30);
            deleteTdeeImageView.setOnMouseClicked(event -> {
                try {
                    clickedOnDeleteTdeeImageView(event);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            Insets labelMargin = new Insets(5, 12, 5, 12); // Imposta i margini desiderati (sinistra, alto, destra, basso)
            HBox.setMargin(kcalElementLabel, labelMargin);
            HBox.setMargin(proElementLabel, labelMargin);
            HBox.setMargin(fatElementLabel, labelMargin);
            HBox.setMargin(carbElementLabel, labelMargin);
            HBox.setMargin(targetElementLabel, labelMargin);
            HBox.setMargin(quantityElementLabel, labelMargin);

            // add element in the row
            elementHbox.getChildren().addAll(kcalElementLabel, proElementLabel, fatElementLabel, carbElementLabel, targetElementLabel, quantityElementLabel, deleteTdeeImageView);

            // add row in VBox
            tdeeListVBox.getChildren().add(elementHbox);
        }
    }

    // check this
    @FXML
    void clickedOnDeleteTdeeImageView(MouseEvent event) throws SQLException, IOException {
        // this image view, on click, delete the tdee on the same row from
        HBox rowToRemove = (HBox) ((ImageView) event.getSource()).getParent();
        Tdee tdee = (Tdee) rowToRemove.getUserData();
        // Rimuovi la riga dall'interfaccia grafica
        tdeeListVBox.getChildren().remove(rowToRemove);
        // now I call application controller to remove the tdee from db
        ApplicationControllerCalculateTdee applicationControllerCalculateTdee = new ApplicationControllerCalculateTdee();
        applicationControllerCalculateTdee.removeTdee(tdee);
    }

}
