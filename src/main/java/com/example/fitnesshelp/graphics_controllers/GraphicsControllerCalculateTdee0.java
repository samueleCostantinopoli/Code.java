package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerCalculateTdee;
import com.example.fitnesshelp.bean.BeanAge;
import com.example.fitnesshelp.bean.BeanGender;
import com.example.fitnesshelp.bean.BeanHeight;
import com.example.fitnesshelp.bean.BeanWeight;
import com.example.fitnesshelp.entities.Tdee;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GraphicsControllerCalculateTdee0 extends GraphicsControllerHomePage{

    @FXML
    private ImageView deleteImageView;

    @FXML
    private Hyperlink tdeeCalculatorHyperlink1;

    @FXML
    private VBox tdeeListVBox;

    // TO DO: il vbox non mostra alcun elemento

    @FXML
    void initialize() throws SQLException, IOException {
        // call the application controller to request the list of tdee calculated
        ApplicationControllerCalculateTdee applicationControllerCalculateTdee = new ApplicationControllerCalculateTdee();
        List<Tdee> tdeeList = applicationControllerCalculateTdee.requestTdeeList();

        tdeeListVBox = new VBox();

        // I iterate dynamically to create the list of tdee
        for (Tdee tdee : tdeeList) {
            createAndAddRow(tdee);
        }
    }

    @FXML
    void clickedOnDeleteImageView(MouseEvent event) {
        // this image view, on click, delete the tdee on the same row from
    }

    public void createAndAddRow(Tdee tdee) {
        // this method show all tdee that user has saved
        HBox tdeeElementHBox = new HBox(); // this row contains all element

        // creation labels for each attributes
        Label kcalLabel = new Label("kcal" + tdee.getKcal());
        Label proLabel = new Label("pro" + tdee.getPro());
        Label fatLabel = new Label("fat" + tdee.getFat());
        Label carbLabel = new Label("carb" + tdee.getCarb());
        Label targetLabel = new Label("target" + tdee.getTarget());
        Label quantityLabel = new Label("quantity" + tdee.getQuantity());

        // image view button for delete tdee selected
        /*
        ImageView deleteImageView = new ImageView("src/main/resources/com.example.fitnesshelp/delete.png");
        deleteImageView.setFitHeight(20);
        deleteImageView.setFitWidth(20);
        deleteImageView.setOnMouseClicked(event -> clickedOnDeleteImageView(event));
         */

        // add element in the row
        tdeeElementHBox.getChildren().addAll(kcalLabel, proLabel, fatLabel, carbLabel, targetLabel, quantityLabel);

        // add row in VBox
        tdeeListVBox.getChildren().add(tdeeElementHBox);
    }

}
