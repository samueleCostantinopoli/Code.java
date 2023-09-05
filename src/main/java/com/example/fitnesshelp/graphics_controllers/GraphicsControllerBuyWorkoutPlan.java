package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.entities.State;
import com.example.fitnesshelp.entities.WorkoutPlan;
import com.example.fitnesshelp.utils.UtilityAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GraphicsControllerBuyWorkoutPlan extends GraphicsControllerHomePage implements Initializable {

    @FXML
    private Label errorLoginMessageLabel;
    @FXML
    private Button errorLoginMessageButton;

    @FXML
    private VBox anchorPaneContainer;

    public GraphicsControllerBuyWorkoutPlan() throws IOException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int numberOfAnchorPanes = 0;
        try {
            numberOfAnchorPanes = readValueFromFileSystem();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

        List<AnchorPane> anchorPanes = createAnchorPanes(numberOfAnchorPanes, listWorkouts);
        anchorPaneContainer.getChildren().addAll(anchorPanes);
    }
    BeanState beanState = new BeanState(UtilityAccess.getState());
    ApplicationControllerBuyWorkoutPlan applicationControllerBuyWorkoutPlan = new ApplicationControllerBuyWorkoutPlan(beanState);
    List<WorkoutPlan> listWorkouts = applicationControllerBuyWorkoutPlan.checkWorkoutPlan();
    private int readValueFromFileSystem() throws SQLException, IOException {
        // Read value from the file system
        return applicationControllerBuyWorkoutPlan.checkWorkoutPlan().size();
    }

    @FXML
    void clickedOnButtonInfoWorkoutPlan(ActionEvent event, int CurrentWorkout) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fitnesshelp/buyInfoWorkoutPlan.fxml"));
        Parent root = loader.load();
        GraphicsControllerBuyInfoWorkoutPlan infoController = loader.getController();
        infoController.setIndex(listWorkouts.get(CurrentWorkout));
        Stage home = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene primary = new Scene(root);
        home.setScene(primary);
        home.show();
    }


    @FXML
    void clickedOnButtonPreviewWorkoutPlan(ActionEvent event, int CurrentWorkout) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fitnesshelp/buyPreviewWorkoutPlan.fxml"));
        Parent root = loader.load();
        GraphicsControllerBuyPreviewWorkoutPlan previewWorkoutPlanController = loader.getController();
        previewWorkoutPlanController.setIndex(listWorkouts.get(CurrentWorkout));
        Stage home = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene primary = new Scene(root);
        home.setScene(primary);
        home.show();
    }

    @FXML
    void clickedOnButtonPriceWorkoutPlan(ActionEvent event) throws IOException {
        if(UtilityAccess.getState() == State.LOGGED_IN) {
            GraphicsControllerBuyWorkoutPlan1 graphicsControllerBuyWorkoutPlan1 = new GraphicsControllerBuyWorkoutPlan1();
            stageToSwitch = "/com/example/fitnesshelp/buyWorkoutPlan1";
            switchStage(event);
        } else {
            errorLoginMessageLabel.setOpacity(1);
            errorLoginMessageButton.setOpacity(1);
        }
        BeanState state = new BeanState(UtilityAccess.getState());
        BeanBuyWorkoutPlan beanBuyWorkoutPlan = new BeanBuyWorkoutPlan(10); //TODO aggiornare il prezzo
        ApplicationControllerBuyWorkoutPlan applicationControllerBuyWorkoutPlan = new ApplicationControllerBuyWorkoutPlan(state);
    }



    @FXML
    void clickedOnBuyWorkoutPlanHyperlink(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/buyWorkoutPlan";
        switchStage(event);
    }

    @FXML
    void clickedOnBuyWorkoutPlanHyperlink1(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/buyWorkoutPlan";
        switchStage(event);
    }


    public void clickedOnPurchaseBuyWorkoutPlanButton(ActionEvent event) {
    }

    private List<AnchorPane> createAnchorPanes(int numberOfAnchorPanes, List<WorkoutPlan> workoutPlanList) {
        List<AnchorPane> anchorPanes = new ArrayList<>();
        for (int i = 0; i < numberOfAnchorPanes; i++) {
            AnchorPane anchorPaneView = new AnchorPane();
            anchorPaneView.setPrefHeight(115.0);
            anchorPaneView.setPrefWidth(601.0);
            anchorPaneView.setStyle("-fx-background-color: #dcdcdc;");

            Button priceButton = new Button(String.valueOf(workoutPlanList.get(i).getPrize()));
            priceButton.setLayoutX(546.0);
            priceButton.setLayoutY(72.0);
            priceButton.setStyle("-fx-background-color: #231717;");
            priceButton.setTextFill(Color.WHITE);
            priceButton.setFont(new Font(14.0));

            Button previewButton = new Button("preview");
            previewButton.setLayoutX(469.0);
            previewButton.setLayoutY(72.0);
            int finalI = i;
            previewButton.setOnAction(event -> {
                try {
                    clickedOnButtonPreviewWorkoutPlan(event, finalI);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            previewButton.setStyle("-fx-background-color: #231717;");
            previewButton.setTextFill(Color.WHITE);
            previewButton.setFont(new Font(14.0));

            Button infoButton = new Button("info");
            infoButton.setLayoutX(415.0);
            infoButton.setLayoutY(72.0);
            infoButton.setOnAction(event -> {
                try {
                    clickedOnButtonInfoWorkoutPlan(event, finalI);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            infoButton.setStyle("-fx-background-color: #231717;");
            infoButton.setTextFill(Color.WHITE);
            infoButton.setFont(new Font(14.0));

            AnchorPane dataPane = new AnchorPane();
            dataPane.setPrefHeight(40.0);
            dataPane.setPrefWidth(609.0);
            dataPane.setStyle("-fx-background-color: #464646;");

            Label nameLabel = new Label(workoutPlanList.get(i).getName());
            nameLabel.setLayoutX(6.0);
            nameLabel.setLayoutY(11.0);
            nameLabel.setTextFill(Color.WHITE);
            nameLabel.setFont(new Font(14.0));
            dataPane.getChildren().add(nameLabel);
            anchorPaneView.getChildren().addAll(priceButton, previewButton, infoButton, dataPane);


            // workoutPlanContainer.getChildren().add(anchorPane);
            anchorPanes.add(anchorPaneView);
        }
        return anchorPanes;
    }
}
