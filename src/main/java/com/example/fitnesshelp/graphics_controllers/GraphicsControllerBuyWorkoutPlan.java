package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.entities.Purchase;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class GraphicsControllerBuyWorkoutPlan extends GraphicsControllerHomePage implements Initializable {

    @FXML
    private Label NameSurnameAge1;

    @FXML
    private Label NameSurnameAge11;

    @FXML
    private AnchorPane WorkoutPlan1Pane;

    @FXML
    private AnchorPane WorkoutPlan2Pane;

    @FXML
    private Hyperlink accountHyperlink;

    @FXML
    private Hyperlink buyWorkoutPlanHyperlink;

    @FXML
    private Hyperlink buyWorkoutPlanHyperlink1;

    @FXML
    private AnchorPane dataWorkoutPlan1Pane;

    @FXML
    private AnchorPane dataWorkoutPlan2Pane;

    @FXML
    private Hyperlink findAGymNearMeHyperlink;

    @FXML
    private Button infoWorkoutPlan1Button;

    @FXML
    private Button infoWorkoutPlan2Button;
    @FXML
    private Button nextBuyWorkoutPlanButton;

    @FXML
    private Button pageOneBuyWorkoutPlanButton;

    @FXML
    private Button pageTreeBuyWorkoutPlanButton;

    @FXML
    private Button pageTwoBuyWorkoutPlanButton;

    @FXML
    private Hyperlink personalTrainerHyperlink;

    @FXML
    private Hyperlink personalTrainerHyperlink1;

    @FXML
    private Button previewWorkoutPlan1Button;

    @FXML
    private Button previewWorkoutPlan2Button;

    @FXML
    private Button priceWorkoutPlan1Button;

    @FXML
    private Button priceWorkoutPlan2Button;

    @FXML
    private ImageView profileImage;

    @FXML
    private Label title;

    @FXML
    private Label errorLoginMessageLabel;
    @FXML
    private Button errorLoginMessageButton;

    @FXML
    private VBox anchorPaneContainer;

    public GraphicsControllerBuyWorkoutPlan() throws SQLException, IOException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int numberOfAnchorPanes = 0;
        try {
            numberOfAnchorPanes = readValueFromFileSystem();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < numberOfAnchorPanes; i++) {
            AnchorPane anchorPane = null;
            anchorPane = createAnchorPane(i, listWorkouts.get(i),new Purchase(0, listWorkouts.get(i).getPrize(),new Date(), UtilityAccess.getUsername(), listWorkouts.get(i)));
            anchorPaneContainer.getChildren().add(anchorPane);
        }
    }
    BeanState beanState = new BeanState(UtilityAccess.getState());
    ApplicationControllerBuyWorkoutPlan applicationControllerBuyWorkoutPlan = new ApplicationControllerBuyWorkoutPlan(beanState);
    List<WorkoutPlan> listWorkouts = applicationControllerBuyWorkoutPlan.checkWorkoutPlan();
    private int readValueFromFileSystem() throws SQLException, IOException {
        // Read value from the file system
        return applicationControllerBuyWorkoutPlan.checkWorkoutPlan().size();
    }

    @FXML
    void clickedOnButtonInfoWorkoutPlan(ActionEvent event, int currentIndex) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fitnesshelp/buyInfoWorkoutPlan.fxml"));

        // controller del nuovo layout
        GraphicsControllerBuyInfoWorkoutPlan buyInfoController = loader.getController();

        // Imposta i dati direttamente sul controller
        buyInfoController.setNamePT(listWorkouts.get(currentIndex).getUsername());
        buyInfoController.setNameWorkout(listWorkouts.get(currentIndex).getName());
        buyInfoController.setInsertDate(listWorkouts.get(currentIndex).getDay());
        buyInfoController.setCommentExtra(String.valueOf(listWorkouts.get(currentIndex).getPrize()));
        stageToSwitch = "/com/example/fitnesshelp/buyInfoWorkoutPlan";
        switchStage(event);
    }

    @FXML
    void clickedOnButtonPreviewWorkoutPlan(ActionEvent event, int currentIndex) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/buyPreviewWorkoutPlan";
        switchStage(event);
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

    private AnchorPane createAnchorPane(int numberOfAnchorPanes, WorkoutPlan workoutPlan,Purchase purchase) {
        AnchorPane anchorPane = new AnchorPane();
        for (int i = 0; i <= numberOfAnchorPanes; i++) {
            AnchorPane anchorPaneView = new AnchorPane();
            anchorPaneView.setPrefHeight(115.0);
            anchorPaneView.setPrefWidth(601.0);
            anchorPaneView.setStyle("-fx-background-color: #dcdcdc;");

            Button priceButton = new Button(String.valueOf(workoutPlan.getPrize()));
            priceButton.setLayoutX(546.0);
            priceButton.setLayoutY(72.0);
            priceButton.setStyle("-fx-background-color: #231717;");
            priceButton.setTextFill(Color.WHITE);
            priceButton.setFont(new Font(14.0));

            Button previewButton = new Button("preview");
            previewButton.setLayoutX(469.0);
            previewButton.setLayoutY(72.0);

            int currentIndex = i;
            previewButton.setOnAction(event -> {
                try {
                    clickedOnButtonPreviewWorkoutPlan(event,currentIndex);
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
                    clickedOnButtonInfoWorkoutPlan(event, currentIndex);
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

            Label nameLabel = new Label(workoutPlan.getName());
            nameLabel.setLayoutX(6.0);
            nameLabel.setLayoutY(11.0);
            nameLabel.setTextFill(Color.WHITE);
            nameLabel.setFont(new Font(14.0));

            dataPane.getChildren().add(nameLabel);
            anchorPaneView.getChildren().addAll(priceButton, previewButton, infoButton, dataPane);


            // workoutPlanContainer.getChildren().add(anchorPane);
            return anchorPaneView;
        }
        return anchorPane;
    }
}
