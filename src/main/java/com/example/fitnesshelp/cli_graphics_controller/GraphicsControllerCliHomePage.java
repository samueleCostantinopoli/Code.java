package com.example.fitnesshelp.cli_graphics_controller;


import com.example.fitnesshelp.dao.SingletonConnection;
import com.example.fitnesshelp.entities.State;
import com.example.fitnesshelp.utils.Printer;
import com.example.fitnesshelp.utils.UtilityAccess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;


public class GraphicsControllerCliHomePage {

    public void displayHomepage() throws IOException, SQLException {

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        Printer.print("------------------------------------------HOME------------------------------------------\n" +
                "Type:\n" +
                "1 to create your workout\n" +
                "2 to view your workouts\n" +
                "3 to calculate your Tdee\n" +
                "4 to find a gym near you\n" +
                "5 to look for a personal trainer\n" +
                "6 to buy workout plan\n" +
                "7 to look your training diary\n" +
                "8 to log in\n" +
                "9 to log out\n" +
                "10 to look your account\n" +
                "11 to exit the application");
        while(true){
            String choice = bufferedReader.readLine();
            try {
                Integer.parseInt(choice);
            } catch (NumberFormatException e) {
                Printer.error("Digit a number\n");
                System.exit(-1);
            }

            int choiceNumber = Integer.parseInt(choice);
            if(choiceNumber == 1){
                Printer.print("'Create workout' has not been implemented, it will be available soon\nSelect another function\n");
            }
            if(choiceNumber == 2){
                Printer.print("'Your workout' has not been implemented, it will be available soon\nSelect another function\n");
            }
            if(choiceNumber == 3){
                // switch to calculate tdee page
                GraphicsControllerCliCalculateTdee1 graphicsControllerCliCalculateTdee1 = new GraphicsControllerCliCalculateTdee1();
                graphicsControllerCliCalculateTdee1.showMenu();
            }
            if(choiceNumber == 4){
                Printer.print("'Find a gym near me' has not been implemented, it will be available soon\nSelect another function\n");
            }
            if(choiceNumber == 5){
                Printer.print("'Look for a personal trainer' has not been implemented, it will be available soon\nSelect another function\n");
            }
            if(choiceNumber == 6){
                GraphicsControllerCliBuyWorkoutPlan graphicsControllerCliBuyWorkoutPlan = new GraphicsControllerCliBuyWorkoutPlan();
                graphicsControllerCliBuyWorkoutPlan.showMenu();
            }
            if(choiceNumber == 7){
                Printer.print("'My training diary' has not been implemented, it will be available soon\nSelect another function\n");
            }
            if(choiceNumber == 8){
                // if user is not logged in, go to login page
                if (UtilityAccess.getState() == State.NOT_LOGGED_IN) {
                    GraphicsControllerCliLoginPage graphicsControllerCliLoginPage = new GraphicsControllerCliLoginPage();
                    graphicsControllerCliLoginPage.viewAccessPage();
                } else {
                    System.out.println("you are already logged in, go to logout before\n");
                }
            }
            if(choiceNumber == 9){
                // logout
                UtilityAccess.setState(State.NOT_LOGGED_IN);
                GraphicsControllerCliLoginPage graphicsControllerCliLoginPage = new GraphicsControllerCliLoginPage();
                graphicsControllerCliLoginPage.viewAccessPage();
            }
            if(choiceNumber == 10){
                //TODO my account
            }
            if(choiceNumber == 11){
                // close application
                SingletonConnection.closeConnection();
                Printer.print("Thank you for using the application, goodbye\n");
                System.exit(0);
                break;
            }
            Printer.print("Try again with one of the following numbers:\n1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11\n");

        }
    }
}