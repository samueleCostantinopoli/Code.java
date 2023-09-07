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

public class GraphicsControllerCliBuyWorkoutPlan1 {
    public void SaveWorkout(int numberWorkout) throws IOException, SQLException, TdeeRemoveException {

        boolean exit = true;
        while (exit) {

            Printer.print("\nSelect a payment method: ");
            Printer.print("1: Credit card");
            Printer.print("2: PayPal ");
            Printer.print("3: Bitcoin ");

            Printer.print("Or write 4 for back to the home");


            String userInput = getUserInput();

            switch (userInput) {
                case "1" -> {
                    while (exit) {
                        Printer.print("\nWrite the number of the workout you want to get info about:");

                        int numberInput= Integer.parseInt(getUserInput());

                    }
                }
                case "2" -> {
                    while (exit) {
                        Printer.print("\nWrite the number of the workout you want to get preview about:");

                        int numberInput = Integer.parseInt(getUserInput());

                    }
                }
                case "3" -> {
                    if(UtilityAccess.getState() == State.LOGGED_IN) {
                        while (exit) {
                            Printer.print("\nWrite the number of the workout you want to buy about:");

                            int numberInput = Integer.parseInt(getUserInput());


                        }
                    } else {
                        Printer.print("\nTo purchase a workout you must be logged in");
                        GraphicsControllerCliLoginPage graphicsControllerCliLoginPage = new GraphicsControllerCliLoginPage();
                        graphicsControllerCliLoginPage.viewAccessPage();
                    }
                    exit = false;
                }
                case "4" -> {
                    backToHomePage();
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

    private void backToHomePage() throws IOException, SQLException, TdeeRemoveException {
        GraphicsControllerCliHomePage homePage = new GraphicsControllerCliHomePage();
        homePage.displayHomepage();
    }

    private void printPaymentsMethods(List<WorkoutPlan> workoutPlanList) {
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
}
