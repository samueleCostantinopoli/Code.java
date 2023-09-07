package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerCalculateTdee;
import com.example.fitnesshelp.entities.Tdee;
import com.example.fitnesshelp.utils.UtilityAccess;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
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

    void initialize() throws SQLException, IOException {
        // get image for delete from properties
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
                } catch (SQLException | IOException e) {
                    throw new RuntimeException(e);
                }
            });

            Insets labelMargin = new Insets(5, 12, 5, 12);
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

        // extract text from label
        String kcalText = ((Label)rowToRemove.getChildren().get(0)).getText();
        String proText = ((Label)rowToRemove.getChildren().get(1)).getText();
        String fatText = ((Label)rowToRemove.getChildren().get(2)).getText();
        String carbText = ((Label)rowToRemove.getChildren().get(3)).getText();
        String targetText = ((Label)rowToRemove.getChildren().get(4)).getText();
        String quantityText = ((Label)rowToRemove.getChildren().get(5)).getText();

        // remove row from VBox
        tdeeListVBox.getChildren().remove(rowToRemove);

        // create new tdee and set values
        int kcal = Integer.parseInt(kcalText.split(": ")[1]);
        float pro = Float.parseFloat(proText.split(": ")[1]);
        float fat = Float.parseFloat(fatText.split(": ")[1]);
        float carb = Float.parseFloat(carbText.split(": ")[1]);
        Tdee tdee = new Tdee(kcal, UtilityAccess.getUsername(), pro, fat, carb, targetText, quantityText);
        // now I can call application controller to delete this tdee
        ApplicationControllerCalculateTdee applicationControllerCalculateTdee = new ApplicationControllerCalculateTdee();
        applicationControllerCalculateTdee.removeTdee(tdee);
    }


}
