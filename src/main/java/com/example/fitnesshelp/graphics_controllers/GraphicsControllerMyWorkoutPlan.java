package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.application_controllers.ApplicationControllerBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.bean.BeanUsername;
import com.example.fitnesshelp.entities.Exercise;
import com.example.fitnesshelp.entities.Purchase;
import com.example.fitnesshelp.entities.WorkoutPlan;
import com.example.fitnesshelp.exception.ExerciseLoadException;
import com.example.fitnesshelp.exception.WorkoutPlanLoadException;
import com.example.fitnesshelp.utils.UtilityAccess;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


import java.io.IOException;
import java.net.URL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GraphicsControllerMyWorkoutPlan extends GraphicsControllerHomePage implements Initializable {


    @FXML
    Label simpleDescription;

    @FXML
    Label simpleDescription2;

    @FXML
    private VBox anchorPaneContainer;


    public GraphicsControllerMyWorkoutPlan() throws WorkoutPlanLoadException, SQLException, IOException {
        // Only for exception
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int numberOfAnchorPanes;
        numberOfAnchorPanes = readValueFromFileSystem();
        if(numberOfAnchorPanes > 0){
            simpleDescription.setVisible(false);
            simpleDescription2.setVisible(false);
            List<AnchorPane> anchorPanes;
            try {
                anchorPanes = createAnchorPanes(numberOfAnchorPanes, listWorkouts);
            } catch (SQLException | IOException e) {
                throw new ExerciseLoadException("Exercise exception");
            }
            anchorPaneContainer.getChildren().addAll(anchorPanes);
        }
        else{
            simpleDescription.setVisible(true);
            simpleDescription2.setVisible(true);
        }
    }
    BeanState beanState = new BeanState(UtilityAccess.getState());
    ApplicationControllerBuyWorkoutPlan applicationControllerBuyWorkoutPlan = new ApplicationControllerBuyWorkoutPlan(beanState);

    BeanUsername beanUsername =new BeanUsername(UtilityAccess.getUsername());
    List<WorkoutPlan> listWorkouts = applicationControllerBuyWorkoutPlan.checkUserWorkoutPlan(beanUsername);
    List<Purchase> listPurchaseUser = applicationControllerBuyWorkoutPlan.checkUserPurchase(beanUsername);

    private int readValueFromFileSystem(){
        // Read value from the file system
        for (Purchase purchase : listPurchaseUser) {
            listWorkouts.add(purchase.getWorkoutPlan());
        }
        return listWorkouts.size();
    }

    private List<AnchorPane> createAnchorPanes(int numberOfAnchorPanes, List<WorkoutPlan> workoutPlanList) throws ExerciseLoadException, SQLException, IOException {
        List<AnchorPane> anchorPanes = new ArrayList<>();

        for (int index = 0; index < numberOfAnchorPanes; index++) {
            WorkoutPlan workoutPlan = workoutPlanList.get(index);

            // Creazione dell'AnchorPane completo con titolo e altre informazioni
            AnchorPane anchorPane = createAnchorPane(workoutPlan);

            anchorPanes.add(anchorPane);
        }
        return anchorPanes;
    }

    private AnchorPane createAnchorPane(WorkoutPlan workoutPlan) throws ExerciseLoadException, SQLException, IOException {
        // Creazione dell'AnchorPane per il titolo del workout
        AnchorPane anchorPaneTitle = createTitleAnchorPane(workoutPlan.getName());

        // Creazione dell'AnchorPane per le altre informazioni
        AnchorPane anchorPaneInfo = createInfoAnchorPane(workoutPlan);

        // Posizionamento dell'AnchorPane delle altre informazioni sotto l'AnchorPane del titolo
        AnchorPane.setTopAnchor(anchorPaneInfo, 40.0);

        // Creazione dell'AnchorPane completo con titolo e altre informazioni
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefHeight(115.0);
        anchorPane.setPrefWidth(585.0);
        anchorPane.setStyle("-fx-background-color: #dcdcdc;");
        anchorPane.getChildren().addAll(anchorPaneTitle, anchorPaneInfo);

        return anchorPane;
    }

    private AnchorPane createTitleAnchorPane(String title) {
        AnchorPane anchorPaneTitle = new AnchorPane();
        anchorPaneTitle.setPrefHeight(40.0);
        anchorPaneTitle.setPrefWidth(585.0);
        anchorPaneTitle.setStyle("-fx-background-color: #231717;");

        Label titleLabel = new Label("Workout Title: " + title);
        titleLabel.setFont(Font.font("System", 16.0));
        titleLabel.setTextFill(Color.WHITE);

        AnchorPane.setTopAnchor(titleLabel, 10.0);
        AnchorPane.setLeftAnchor(titleLabel, 10.0);

        anchorPaneTitle.getChildren().addAll(titleLabel);

        return anchorPaneTitle;
    }

    private AnchorPane createInfoAnchorPane(WorkoutPlan workoutPlan) throws ExerciseLoadException, SQLException, IOException {
        AnchorPane anchorPaneInfo = new AnchorPane();
        anchorPaneInfo.setPrefWidth(585.0);
        anchorPaneInfo.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: black; -fx-border-width: 1px;");

        List<Exercise> exerciseList = applicationControllerBuyWorkoutPlan.checkUserExercise(
                new BeanBuyWorkoutPlan(workoutPlan.getName(), workoutPlan.getPrize(), workoutPlan.getUsername())
        );

        double verticalPosition = 10.0; // Inizializza la posizione verticale

        // Creazione delle label per le informazioni delle esercitazioni
        for (Exercise exercise : exerciseList) {
            Label exerciseLabel = new Label("Exercise: " + exercise.getExerciseName());
            Label muscleLabel = new Label("Muscle: " + exercise.getMuscle());
            Label setsLabel = new Label("Number of Sets: " + exercise.getSets());
            Label repsLabel = new Label("Number of Reps: " + exercise.getReps());

            AnchorPane.setTopAnchor(exerciseLabel, verticalPosition);
            AnchorPane.setLeftAnchor(exerciseLabel, 10.0);
            AnchorPane.setTopAnchor(muscleLabel, verticalPosition + 20.0);
            AnchorPane.setLeftAnchor(muscleLabel, 10.0);
            AnchorPane.setTopAnchor(setsLabel, verticalPosition + 40.0);
            AnchorPane.setLeftAnchor(setsLabel, 10.0);
            AnchorPane.setTopAnchor(repsLabel, verticalPosition + 60.0);
            AnchorPane.setLeftAnchor(repsLabel, 10.0);

            anchorPaneInfo.getChildren().addAll(exerciseLabel, muscleLabel, setsLabel, repsLabel);

            // Aggiunta di una linea orizzontale per separare gli esercizi
            Separator separator = new Separator();
            separator.setPrefWidth(555.0); // Imposta la larghezza della linea
            AnchorPane.setTopAnchor(separator, verticalPosition + 80.0); // Posiziona sotto l'ultimo campo dell'esercizio
            AnchorPane.setLeftAnchor(separator, 10.0);

            anchorPaneInfo.getChildren().add(separator);

            // Aggiorna la posizione verticale per il prossimo esercizio
            verticalPosition += 100.0;
        }

        return anchorPaneInfo;
    }
}
