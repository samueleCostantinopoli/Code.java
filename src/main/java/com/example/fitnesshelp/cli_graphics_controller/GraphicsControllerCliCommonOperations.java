package com.example.fitnesshelp.cli_graphics_controller;

import com.example.fitnesshelp.exception.ExerciseLoadException;
import com.example.fitnesshelp.exception.PurchaseUserLoadException;
import com.example.fitnesshelp.exception.TdeeRemoveException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class GraphicsControllerCliCommonOperations {
    private GraphicsControllerCliCommonOperations() {
        // Private constructor to hide the implicit public one
    }

    public static void backToBuyWorkoutPlan() throws SQLException, IOException, TdeeRemoveException, ExerciseLoadException, PurchaseUserLoadException {
        GraphicsControllerCliBuyWorkoutPlan graphicsControllerCliBuyWorkoutPlan = new GraphicsControllerCliBuyWorkoutPlan();
        graphicsControllerCliBuyWorkoutPlan.showMenu();
    }

    public static void backToHomePage() throws IOException, SQLException, TdeeRemoveException {
        GraphicsControllerCliHomePage homePage = new GraphicsControllerCliHomePage();
        homePage.displayHomepage();
    }

    public static String getUserInput() throws IOException {
        // to get user input
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine().trim();
    }
}

