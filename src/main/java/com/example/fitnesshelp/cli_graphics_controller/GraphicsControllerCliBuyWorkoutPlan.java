package com.example.fitnesshelp.cli_graphics_controller;

import com.example.fitnesshelp.application_controllers.ApplicationControllerBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.entities.State;
import com.example.fitnesshelp.entities.WorkoutPlan;
import com.example.fitnesshelp.exception.ExerciseLoadException;
import com.example.fitnesshelp.exception.PurchaseUserLoadException;
import com.example.fitnesshelp.exception.TdeeRemoveException;
import com.example.fitnesshelp.utils.Printer;
import com.example.fitnesshelp.utils.UtilityAccess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class GraphicsControllerCliBuyWorkoutPlan {
    private static final String INVALID_NUMBER_MESSAGE = "\nWrite correct number";

    public void showMenu() throws IOException, SQLException, TdeeRemoveException, ExerciseLoadException, PurchaseUserLoadException {
        BeanState beanState = new BeanState(UtilityAccess.getState());
        ApplicationControllerBuyWorkoutPlan applicationControllerBuyWorkoutPlan = new ApplicationControllerBuyWorkoutPlan(beanState);
        List<WorkoutPlan> workoutPlanList = applicationControllerBuyWorkoutPlan.checkWorkoutPlan();

        boolean exit = true;
        while (exit) {
            printWorkoutPlanList(workoutPlanList);

            Printer.print("\nSelect an option:");
            Printer.print("1: Return to home");
            Printer.print("2: Get info workout");
            Printer.print("3: Get preview workout");
            Printer.print("4: Buy workout");

            String userInput = getUserInput();

            switch (userInput) {
                case "1" -> {
                    backToHomePage();
                    exit = false;
                }
                case "2" -> getInfoWorkout(workoutPlanList);
                case "3" -> getPreviewWorkout(workoutPlanList);
                case "4" -> buyWorkout(workoutPlanList);
                default -> Printer.print("Invalid option.");
            }
        }
    }

    // Separate methods for options 2, 3 and 4 to reduce complexity

    private void getInfoWorkout(List<WorkoutPlan> workoutPlanList) throws IOException, ExerciseLoadException, SQLException, TdeeRemoveException, PurchaseUserLoadException {
        while (true) {
            Printer.print("\nWrite the number of the workout you want to get info about:");
            int numberInput = Integer.parseInt(getUserInput());
            if (numberInput >= 1 && numberInput <= workoutPlanList.size()) {
                GraphicsControllerCliBuyInfoWorkoutPlan infoController = new GraphicsControllerCliBuyInfoWorkoutPlan();
                infoController.setIndex(workoutPlanList.get(numberInput - 1));
                break;
            } else {
                Printer.print(INVALID_NUMBER_MESSAGE);
            }
        }
    }

    private void getPreviewWorkout(List<WorkoutPlan> workoutPlanList) throws IOException, ExerciseLoadException, SQLException, TdeeRemoveException, PurchaseUserLoadException {
        while (true) {
            Printer.print("\nWrite the number of the workout you want to get preview about:");
            int numberInput = Integer.parseInt(getUserInput());
            if (numberInput >= 1 && numberInput <= workoutPlanList.size()) {
                GraphicsControllerCliBuyPreviewWorkoutPlan graphicsControllerCliBuyPreviewWorkoutPlan = new GraphicsControllerCliBuyPreviewWorkoutPlan();
                graphicsControllerCliBuyPreviewWorkoutPlan.setIndex(workoutPlanList.get(numberInput - 1));
                break;
            } else {
                Printer.print(INVALID_NUMBER_MESSAGE);
            }
        }
    }

    private void buyWorkout(List<WorkoutPlan> workoutPlanList) throws IOException, TdeeRemoveException, SQLException, ExerciseLoadException, PurchaseUserLoadException {
        if (UtilityAccess.getState() == State.LOGGED_IN) {
            while (true) {
                Printer.print("\nWrite the number of the workout you want to buy about:");
                int numberInput = Integer.parseInt(getUserInput());
                if (numberInput >= 1 && numberInput <= workoutPlanList.size()) {
                    GraphicsControllerCliBuyWorkoutPlanSetPayments infoController = new GraphicsControllerCliBuyWorkoutPlanSetPayments();
                    infoController.saveWorkout(workoutPlanList.get(numberInput - 1));
                    break;
                } else {
                    Printer.print(INVALID_NUMBER_MESSAGE);
                }
            }
        } else {
            Printer.print("\nTo purchase a workout you must be logged in");
            GraphicsControllerCliLoginPage graphicsControllerCliLoginPage = new GraphicsControllerCliLoginPage();
            graphicsControllerCliLoginPage.viewAccessPage();
        }
    }

    private void printWorkoutPlanList(List<WorkoutPlan> workoutPlanList) {
        Printer.print("-------------------WORKOUT PLAN SOLD PAGE-------------------\n");

        int index = 1;
        for (WorkoutPlan workoutPlan : workoutPlanList) {
            Printer.print("\n_________");
            Printer.print(index + " Workout name:" + workoutPlan.getName());
            Printer.print(" Prize: " + workoutPlan.getPrize());
            Printer.print("_________");
            index++;
        }
    }

    private String getUserInput() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine().trim();
    }

    private void backToHomePage() throws IOException, SQLException, TdeeRemoveException {
        GraphicsControllerCliHomePage homePage = new GraphicsControllerCliHomePage();
        homePage.displayHomepage();
    }
}
