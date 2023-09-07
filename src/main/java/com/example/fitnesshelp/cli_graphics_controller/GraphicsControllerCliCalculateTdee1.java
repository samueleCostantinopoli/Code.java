package com.example.fitnesshelp.cli_graphics_controller;

import com.example.fitnesshelp.entities.State;
import com.example.fitnesshelp.exception.TdeeRemoveException;
import com.example.fitnesshelp.utils.Printer;
import com.example.fitnesshelp.utils.UtilityAccess;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class GraphicsControllerCliCalculateTdee1 {

    public void showMenu() throws IOException, SQLException, TdeeRemoveException {
        if (UtilityAccess.getState() == State.LOGGED_IN) {
            printLoggedInMenu();

            while (true) {
                String choice = getUserInput();
                int choiceNumber = parseChoice(choice);

                switch (choiceNumber) {
                    case 1 -> handleViewTdee();
                    case 2 -> handleCalculateTdee();
                    case 3 -> {
                        backToHomePage();
                        return;
                    }
                    default -> Printer.error("Invalid choice\n");
                }
            }
        } else {
            printLoggedOutMenu();

            while (true) {
                String choice = getUserInput();
                int choiceNumber = parseChoice(choice);

                if (choiceNumber == 1) {
                    handleLogin();
                    break;
                } else if (choiceNumber == 2) {
                    backToHomePage();
                    return;
                }
            }
        }
    }

    private void printLoggedInMenu() {
        Printer.print("""
            ------------------------------------CALCULATE TDEE-----------------------------------
            Type:
            1 to view your tdee
            2 to calculate a new tdee
            3 to return to the home""");
    }

    private void printLoggedOutMenu() {
        Printer.print("you must be logged in to view or calculate a tdee\ntype\n1 to login\n2 to return to the home");
    }

    private String getUserInput() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String choice;

        while (true) {
            try {
                choice = bufferedReader.readLine();
                Integer.parseInt(choice);
                break;
            } catch (NumberFormatException e) {
                Printer.error("Digit a number\n");
                System.exit(-1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return choice;
    }

    private int parseChoice(String choice) {
        return Integer.parseInt(choice);
    }

    private void handleViewTdee() throws SQLException, IOException, TdeeRemoveException {
        GraphicsControllerCliCalculateTdee0 graphicsControllerCliCalculateTdee0 = new GraphicsControllerCliCalculateTdee0();
        graphicsControllerCliCalculateTdee0.showTdee();
    }

    private void handleCalculateTdee() throws SQLException, IOException, TdeeRemoveException {
        GraphicsControllerCliCalculateTdee2 graphicsControllerCliCalculateTdee2 = new GraphicsControllerCliCalculateTdee2();
        graphicsControllerCliCalculateTdee2.showQuestionnaire();
    }

    private void handleLogin() throws SQLException, IOException, TdeeRemoveException {
        GraphicsControllerCliLoginPage graphicsControllerCliLoginPage = new GraphicsControllerCliLoginPage();
        graphicsControllerCliLoginPage.viewAccessPage();
    }

    public void backToHomePage() throws SQLException, IOException, TdeeRemoveException {
        GraphicsControllerCliHomePage graphicsControllerCliHomePage = new GraphicsControllerCliHomePage();
        graphicsControllerCliHomePage.displayHomepage();
    }
}
