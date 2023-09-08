package com.example.fitnesshelp.cli_graphics_controller;

import com.example.fitnesshelp.entities.State;
import com.example.fitnesshelp.entities.WorkoutPlan;
import com.example.fitnesshelp.exception.ExerciseLoadException;
import com.example.fitnesshelp.exception.PurchaseUserLoadException;
import com.example.fitnesshelp.exception.TdeeRemoveException;
import com.example.fitnesshelp.utils.Printer;
import com.example.fitnesshelp.utils.UtilityAccess;
import java.io.IOException;
import java.sql.SQLException;

import static com.example.fitnesshelp.cli_graphics_controller.GraphicsControllerCliCommonOperations.getUserInput;

public class GraphicsControllerCliBuyInfoWorkoutPlan {

    public void setIndex(WorkoutPlan currentWorkout) throws IOException, SQLException, TdeeRemoveException, ExerciseLoadException, PurchaseUserLoadException {
        boolean exit = true;
        while (exit) {
            printWorkoutPlan(currentWorkout);

            Printer.print("1: Return to home");
            Printer.print("2: Return to workout");
            Printer.print("3: Get preview workout");
            Printer.print("4: Buy workout");
            String userInput = getUserInput();

            switch (userInput) {
                case "1" -> GraphicsControllerCliCommonOperations.backToHomePage();
                case "2" -> GraphicsControllerCliCommonOperations.backToBuyWorkoutPlan();
                case "3" -> {
                    GraphicsControllerCliBuyInfoWorkoutPlan infoController = new GraphicsControllerCliBuyInfoWorkoutPlan();
                    infoController.setIndex(currentWorkout);
                    exit = false;
                }
                case "4" -> {
                    if (UtilityAccess.getState() == State.LOGGED_IN) {
                        GraphicsControllerCliBuyWorkoutPlan1 infoController = new GraphicsControllerCliBuyWorkoutPlan1();
                        infoController.saveWorkout(currentWorkout);

                    } else {
                        Printer.print("\nTo purchase a workout you must be logged in");
                        GraphicsControllerCliLoginPage graphicsControllerCliLoginPage = new GraphicsControllerCliLoginPage();
                        graphicsControllerCliLoginPage.viewAccessPage();
                    }
                    exit = false;
                }
                default -> Printer.print("Invalid option.");
            }
        }
    }

    public void printWorkoutPlan(WorkoutPlan workoutPlan) {
        Printer.print("-------------------WORKOUT PREVIEW PAGE-------------------");
        Printer.print("Workout name:" + workoutPlan.getName());
        Printer.print("_________");
        Printer.print("Workout offered for sale by: " + workoutPlan.getUsername());
        Printer.print("Training for: " + workoutPlan.getName());
        Printer.print("Day of training: " + workoutPlan.getDay() );
        Printer.print("Other useful information: prize: " + workoutPlan.getPrize());
        Printer.print("_________");

    }

}


