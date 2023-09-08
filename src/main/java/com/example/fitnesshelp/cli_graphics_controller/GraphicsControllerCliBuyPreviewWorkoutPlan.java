package com.example.fitnesshelp.cli_graphics_controller;

import com.example.fitnesshelp.application_controllers.ApplicationControllerBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.entities.Exercise;
import com.example.fitnesshelp.entities.State;
import com.example.fitnesshelp.entities.WorkoutPlan;
import com.example.fitnesshelp.exception.TdeeRemoveException;
import com.example.fitnesshelp.utils.Printer;
import com.example.fitnesshelp.utils.UtilityAccess;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class GraphicsControllerCliBuyPreviewWorkoutPlan {


    public void setIndex(WorkoutPlan currentWorkout) throws IOException, SQLException, TdeeRemoveException {
        ApplicationControllerBuyWorkoutPlan applicationControllerBuyWorkoutPlan = new ApplicationControllerBuyWorkoutPlan(new BeanState(UtilityAccess.getState()));
        BeanBuyWorkoutPlan beanBuyWorkoutPlan = new BeanBuyWorkoutPlan(currentWorkout.getName(), currentWorkout.getPrize(), currentWorkout.getUsername());

        List<Exercise> exerciseList = applicationControllerBuyWorkoutPlan.checkUserExercise(beanBuyWorkoutPlan);

        boolean exit = true;
        while (exit) {
            printWorkoutPlan(exerciseList);

            Printer.print("1: Return to home");
            Printer.print("2: Return to workout");
            Printer.print("3: Get info workout");
            Printer.print("4: Buy workout");
            Printer.print("");

            String userInput = getUserInput();

            switch (userInput) {
                case "1" -> {
                    backToHomePage();
                    exit = false;
                }
                case "2" -> {
                    backToBuyWorkoutPlan();
                    exit = false;
                }
                case "3" -> {
                    GraphicsControllerCliBuyInfoWorkoutPlan infoController = new GraphicsControllerCliBuyInfoWorkoutPlan();
                    infoController.setIndex(currentWorkout);
                    exit = false;

                }
                case "4" -> {
                    if (UtilityAccess.getState() == State.LOGGED_IN) {
                        GraphicsControllerCliBuyWorkoutPlan1 infoController = new GraphicsControllerCliBuyWorkoutPlan1();
                        infoController.SaveWorkout(currentWorkout);

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

    private void backToBuyWorkoutPlan() throws SQLException, IOException, TdeeRemoveException {
        GraphicsControllerCliBuyWorkoutPlan graphicsControllerCliBuyWorkoutPlan = new GraphicsControllerCliBuyWorkoutPlan();
        graphicsControllerCliBuyWorkoutPlan.showMenu();
    }


    private void backToHomePage() throws IOException, SQLException, TdeeRemoveException {
        GraphicsControllerCliHomePage homePage = new GraphicsControllerCliHomePage();
        homePage.displayHomepage();
    }

    private String getUserInput() throws IOException {
        // to get user input
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine().trim();
    }

    public void printWorkoutPlan(List<Exercise> exerciseList) {
        Printer.print("-------------------WORKOUT PREVIEW PAGE-------------------");
        Printer.print("Workout name:" + exerciseList.get(0).getWorkoutPlan().getName());
        int index = 1;
        for (Exercise exercise : exerciseList) {
            Printer.print("_________");
            Printer.print(index + " Exercise: " + exercise.getExercise());
            Printer.print("Muscle:" + exercise.getMuscle());
            Printer.print("Sets: " + exercise.getSets());
            Printer.print("Reps: " + exercise.getReps());
            Printer.print("Rest: " + exercise.getRest() + " seconds");
            Printer.print("_________");
            index++;
        }
    }

}
