package com.example.fitnesshelp.cli_graphics_controller;

import com.example.fitnesshelp.application_controllers.ApplicationControllerBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanState;
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

public class GraphicsControllerCliBuyWorkoutPlan {
    public void showMenu() throws IOException, SQLException, TdeeRemoveException {
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
                case "2" -> {
                    while (exit) {
                        Printer.print("\nWrite the number of the workout you want to get info about:");

                        int numberInput= Integer.parseInt(getUserInput());
                        if(numberInput <= workoutPlanList.size()){
                            GraphicsControllerCliBuyInfoWorkoutPlan infoController = new GraphicsControllerCliBuyInfoWorkoutPlan();
                            infoController.setIndex(workoutPlanList.get(numberInput-1));
                            exit = false;
                        }
                        else {
                            Printer.print("\nWrite correct number");
                        }
                    }
                }
                case "3" -> {
                    while (exit) {
                        Printer.print("\nWrite the number of the workout you want to get preview about:");

                        int numberInput = Integer.parseInt(getUserInput());
                        if(numberInput <= workoutPlanList.size()){
                            GraphicsControllerCliBuyPreviewWorkoutPlan graphicsControllerCliBuyPreviewWorkoutPlan = new GraphicsControllerCliBuyPreviewWorkoutPlan();
                            graphicsControllerCliBuyPreviewWorkoutPlan.setIndex(workoutPlanList.get(numberInput-1));
                            exit = false;
                        }
                        else {
                            Printer.print("\nWrite correct number");
                        }
                    }
                }
                case "4" -> {
                    if(UtilityAccess.getState() == State.LOGGED_IN) {
                        while (exit) {
                            Printer.print("\nWrite the number of the workout you want to buy about:");

                            int numberInput = Integer.parseInt(getUserInput());
                            if(numberInput <= workoutPlanList.size()){
                                GraphicsControllerCliBuyWorkoutPlan1 infoController = new GraphicsControllerCliBuyWorkoutPlan1();
                                infoController.SaveWorkout(workoutPlanList.get(numberInput-1));
                            }
                            else {
                                Printer.print("\nWrite correct number");
                            }

                        }
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


    private String getUserInput() throws IOException {
        // to get user input
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine().trim();
    }

    private void printWorkoutPlanList(List<WorkoutPlan> workoutPlanList) {
        // this method print all tdee of user
        Printer.print("---------WORKOUT PLAN SOLD PAGE---------\n");
        //Printer.print("-------------------WORKOUT PLAN SOLD PAGE-------------------\n");

        int index = 1;
        for (WorkoutPlan workoutPlan : workoutPlanList) {
            Printer.print("\n_________");
            Printer.print(index + " Workout name:" + workoutPlan.getName());
            Printer.print(" Prize: " + workoutPlan.getPrize());
            Printer.print("_________");
            index++;
        }
    }

    private void backToHomePage() throws IOException, SQLException, TdeeRemoveException {
        GraphicsControllerCliHomePage homePage = new GraphicsControllerCliHomePage();
        homePage.displayHomepage();
    }
}
