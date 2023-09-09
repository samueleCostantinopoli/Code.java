package com.example.fitnesshelp.cli_graphics_controller;

import com.example.fitnesshelp.application_controllers.ApplicationControllerBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.bean.BeanUsername;
import com.example.fitnesshelp.entities.Purchase;
import com.example.fitnesshelp.exception.PurchaseUserLoadException;
import com.example.fitnesshelp.exception.TdeeRemoveException;
import com.example.fitnesshelp.utils.Printer;
import com.example.fitnesshelp.utils.UtilityAccess;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class GraphicsControllerCliAccountPurchase {
    BeanState beanState = new BeanState(UtilityAccess.getState());
    ApplicationControllerBuyWorkoutPlan applicationControllerBuyWorkoutPlan = new ApplicationControllerBuyWorkoutPlan(beanState);
    BeanUsername beanUsername = new BeanUsername(UtilityAccess.getUsername());
    List<Purchase> purchaseList = applicationControllerBuyWorkoutPlan.checkUserPurchase(beanUsername);

    public GraphicsControllerCliAccountPurchase() throws SQLException, IOException {
        // Only for exception
    }

    public void showPurchase() throws IOException, SQLException, TdeeRemoveException, PurchaseUserLoadException {
        boolean exit = true;

        while (exit) {
            printPurchaseList(purchaseList);
            Printer.print("1: Back to account");
            Printer.print("2: Return to home");

            String userInput = getUserInput();

            switch (userInput) {
                case "1" -> {
                    GraphicsControllerCliAccount graphicsControllerCliAccount = new GraphicsControllerCliAccount();
                    graphicsControllerCliAccount.viewAccount();
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

    private void printPurchaseList(List<Purchase> purchaseList) {
        // this method print all tdee of user
        Printer.print("\n-------------------PURCHASE HISTORY-------------------");

        int index = 1;
        for (Purchase purchase : purchaseList) {
            Printer.print("\n_________");
            Printer.print(index + " ID:" + purchase.getIdPurchase());
            Printer.print(" Prize: " + purchase.getPrice());
            Printer.print("Date: " + purchase.getDate().toString());
            Printer.print("Username: " + purchase.getUsername());
            Printer.print("Workout Plan: " + purchase.getWorkoutPlan().getName());
            Printer.print("_________");
            index++;
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
