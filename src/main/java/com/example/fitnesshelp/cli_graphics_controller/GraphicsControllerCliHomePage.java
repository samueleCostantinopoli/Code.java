package com.example.fitnesshelp.cli_graphics_controller;

import com.example.fitnesshelp.dao.SingletonConnection;
import com.example.fitnesshelp.entities.State;
import com.example.fitnesshelp.exception.ExerciseLoadException;
import com.example.fitnesshelp.exception.PurchaseUserLoadException;
import com.example.fitnesshelp.exception.TdeeRemoveException;
import com.example.fitnesshelp.utils.Printer;
import com.example.fitnesshelp.utils.UtilityAccess;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class GraphicsControllerCliHomePage {

    public void displayHomepage() throws IOException, SQLException, TdeeRemoveException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Printer.print("""
            ------------------------------------------HOME------------------------------------------
            Type:
            1 to create your workout
            2 to view your workouts
            3 to calculate your Tdee
            4 to find a gym near you
            5 to look for a personal trainer
            6 to buy workout plan
            7 to look your training diary
            8 to log in
            9 to log out
            10 to look your account
            11 to exit the application""");

        boolean exitRequested = false;

        while (!exitRequested) {
            String choice = bufferedReader.readLine();
            try {
                int choiceNumber = Integer.parseInt(choice);
                exitRequested = handleChoice(choiceNumber);
            } catch (NumberFormatException | ExerciseLoadException | PurchaseUserLoadException e) {
                Printer.error("Digit a number\n");
            }
        }
    }

    private boolean handleChoice(int choiceNumber) throws IOException, SQLException, TdeeRemoveException, ExerciseLoadException, PurchaseUserLoadException {
        switch (choiceNumber) {
            case 1 -> {
                handleCreateWorkout();
                return false;
            }
            case 2 -> {
                handleViewWorkouts();
                return false;
            }
            case 3 -> {
                handleCalculateTdee();
                return false;
            }
            case 4 -> {
                handleFindGym();
                return false;
            }
            case 5 -> {
                handleFindPersonalTrainer();
                return false;
            }
            case 6 -> {
                handleBuyWorkoutPlan();
                return false;
            }
            case 7 -> {
                handleViewTrainingDiary();
                return false;
            }
            case 8 -> {
                handleLogin();
                return false;
            }
            case 9 -> {
                handleLogout();
                return true;
            }
            case 10 -> {
                handleViewAccount();
                return false;
            }
            case 11 -> {
                handleCloseApplication();
                return true;
            }
            default -> {
                Printer.print("Try again with one of the following numbers:\n1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11\n");
                return false;
            }
        }
    }


    // Implementa i metodi handleXxx per ciascuna opzione
    private void handleCreateWorkout() {
        Printer.print("'Create workout' has not been implemented, it will be available soon\nSelect another function\n");
    }

    private void handleViewWorkouts() {
        Printer.print("'Your workout' has not been implemented, it will be available soon\nSelect another function\n");
    }

    private void handleCalculateTdee() throws IOException, SQLException, TdeeRemoveException {
        GraphicsControllerCliCalculateTdee1 graphicsControllerCliCalculateTdee1 = new GraphicsControllerCliCalculateTdee1();
        graphicsControllerCliCalculateTdee1.showMenu();
    }

    private void handleFindGym() {
        Printer.print("'Find a gym near me' has not been implemented, it will be available soon\nSelect another function\n");
    }

    private void handleFindPersonalTrainer() {
        Printer.print("'Look for a personal trainer' has not been implemented, it will be available soon\nSelect another function\n");
    }

    private void handleBuyWorkoutPlan() throws IOException, SQLException, TdeeRemoveException, ExerciseLoadException, PurchaseUserLoadException {
        GraphicsControllerCliBuyWorkoutPlan graphicsControllerCliBuyWorkoutPlan = new GraphicsControllerCliBuyWorkoutPlan();
        graphicsControllerCliBuyWorkoutPlan.showMenu();
    }

    private void handleViewTrainingDiary() {
        Printer.print("'My training diary' has not been implemented, it will be available soon\nSelect another function\n");
    }

    private void handleLogin() throws IOException, SQLException, TdeeRemoveException {
        if (UtilityAccess.getState() == State.NOT_LOGGED_IN) {
            GraphicsControllerCliLoginPage graphicsControllerCliLoginPage = new GraphicsControllerCliLoginPage();
            graphicsControllerCliLoginPage.viewAccessPage();
        } else {
            Printer.print("you are already logged in, go to logout before\n");
        }
    }

    private void handleLogout() throws IOException, SQLException, TdeeRemoveException {
        UtilityAccess.setState(State.NOT_LOGGED_IN);
        GraphicsControllerCliLoginPage graphicsControllerCliLoginPage = new GraphicsControllerCliLoginPage();
        graphicsControllerCliLoginPage.viewAccessPage();
    }

    private void handleViewAccount() throws SQLException, IOException, TdeeRemoveException, PurchaseUserLoadException {
        if (UtilityAccess.getState().equals(State.LOGGED_IN)) {
            GraphicsControllerCliAccount graphicsControllerCliAccount = new GraphicsControllerCliAccount();
            graphicsControllerCliAccount.viewAccount();
        } else {
            Printer.print("\nTo access to account section you must be logged in\n");
        }
    }

    private void handleCloseApplication() throws SQLException {
        SingletonConnection.closeConnection();
        Printer.print("Thank you for using the application, goodbye\n");
        System.exit(0);
    }

}