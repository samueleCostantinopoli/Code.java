package com.example.fitnesshelp.cli_graphics_controller;

import com.example.fitnesshelp.application_controllers.ApplicationControllerBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.entities.Purchase;
import com.example.fitnesshelp.entities.WorkoutPlan;
import com.example.fitnesshelp.exception.TdeeRemoveException;
import com.example.fitnesshelp.utils.Printer;
import com.example.fitnesshelp.utils.UtilityAccess;
import javafx.event.ActionEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class GraphicsControllerCliBuyWorkoutPlan2 {

    public GraphicsControllerCliBuyWorkoutPlan2() throws IOException {
    }

    public Purchase newPurchase;
    ApplicationControllerBuyWorkoutPlan applicationControllerBuyWorkoutPlan = new ApplicationControllerBuyWorkoutPlan(new BeanState(UtilityAccess.getState()));
    List<WorkoutPlan> workoutPlanList = applicationControllerBuyWorkoutPlan.checkWorkoutPlan();

    public void savePurchase(WorkoutPlan thisWorkout) throws SQLException, IOException, TdeeRemoveException {
        newPurchase = new Purchase(GenerateId(), thisWorkout.getPrize(), TakeDate(), UtilityAccess.getUsername(), thisWorkout);

        Printer.print("\n-------------------PURCHASE RECAP-------------------");
        Printer.print("ID: " + newPurchase.getIdPurchase());
        Printer.print("Prize: " + newPurchase.getWorkoutPlan().getPrize());
        Printer.print("Date: " + newPurchase.getDate());
        Printer.print("Username of creator: " + newPurchase.getWorkoutPlan().getUsername());
        Printer.print("Workout name: " + thisWorkout.getName());

        applicationControllerBuyWorkoutPlan.createPurchase(newPurchase);

        boolean exit = true;
        while (exit) {

            Printer.print("1: Return to home");
            Printer.print("2: Return to workout");
            Printer.print("3: ");


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

                    exit = false;
                }
                default -> Printer.print("Invalid option.");
            }
        }
    }


    private Date TakeDate() {
        return new Date();
    }

    private int GenerateId() {
        Random random = new Random();
        // Generate int random ID
        int id = random.nextInt(Integer.MAX_VALUE);
        return id;
    }

    private String getUserInput() throws IOException {
        // to get user input
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine().trim();
    }

    private void backToBuyWorkoutPlan() throws SQLException, IOException, TdeeRemoveException {
        GraphicsControllerCliBuyWorkoutPlan graphicsControllerCliBuyWorkoutPlan = new GraphicsControllerCliBuyWorkoutPlan();
        graphicsControllerCliBuyWorkoutPlan.showMenu();
    }

    private void backToHomePage() throws IOException, SQLException, TdeeRemoveException {
        GraphicsControllerCliHomePage homePage = new GraphicsControllerCliHomePage();
        homePage.displayHomepage();
    }
}
