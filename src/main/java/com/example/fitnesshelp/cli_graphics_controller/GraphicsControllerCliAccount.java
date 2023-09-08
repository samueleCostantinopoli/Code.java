package com.example.fitnesshelp.cli_graphics_controller;

import com.example.fitnesshelp.exception.TdeeRemoveException;
import com.example.fitnesshelp.utils.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class GraphicsControllerCliAccount {
    public void viewAccount() throws IOException, SQLException, TdeeRemoveException {

        Printer.print("\n-------------------MY ACCOUNT-------------------");

        boolean exit = true;
        while (exit) {

            Printer.print("1: Check your purchase history");
            Printer.print("2: Return to home");


            String userInput = getUserInput();

            switch (userInput) {
                case "1" -> {
                    GraphicsControllerCliAccountPurchase graphicsControllerCliAccountPurchase = new GraphicsControllerCliAccountPurchase();
                    graphicsControllerCliAccountPurchase.showPurchase();
                    exit = false;
                }
                case "2" -> {
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
}
