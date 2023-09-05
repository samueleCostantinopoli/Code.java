package com.example.fitnesshelp.ComandLineInterface;

import com.example.fitnesshelp.entities.State;
import com.example.fitnesshelp.utils.Printer;
import com.example.fitnesshelp.utils.UtilityAccess;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class GraphicsControllerCliCalculateTdee1 {

    // private GraphicsControllerCliHomePage graphicsControllerCliHomePage = new GraphicsControllerCliHomePage();

    public void showMenu() throws IOException, SQLException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        if(UtilityAccess.getState() == State.LOGGED_IN) {
            Printer.print("""
                    ------------------------------------CALCULATE TDEE-----------------------------------
                    Type:
                    1 to view your tdee
                    2 to calculate a new tdee
                    3 to return to the home""");
            while (true) {
                String choice = bufferedReader.readLine();
                try {
                    Integer.parseInt(choice);
                } catch (NumberFormatException e) {
                    Printer.error("Digit a number\n");
                    System.exit(-1);
                }
                int choiceNumber = Integer.parseInt(choice);
                switch (choiceNumber) {
                    case 1 -> {
                        GraphicsControllerCliCalculateTdee0 graphicsControllerCliCalculateTdee0 = new GraphicsControllerCliCalculateTdee0();
                        graphicsControllerCliCalculateTdee0.showTdee();
                    }
                    case 2 -> {
                        GraphicsControllerCliCalculateTdee2 graphicsControllerCliCalculateTdee2 = new GraphicsControllerCliCalculateTdee2();
                        graphicsControllerCliCalculateTdee2.showQuestionnaire();
                    }
                    case 3 -> {
                        switchToHome();
                        return;
                    }
                    default -> Printer.error("Invalid choice\n");
                }
            }
        } else {
            System.out.println("you must be logged in to view or calculate a tdee\ntype\n1: to login\n2 to return to the home\n");
            while (true) {
                String choice = bufferedReader.readLine();
                try {
                    Integer.parseInt(choice);
                } catch (NumberFormatException e) {
                    Printer.error("Digit a number\n");
                    System.exit(-1);
                }
                int choiceNumber = Integer.parseInt(choice);
                if (choiceNumber == 1) {
                    // go to login page
                } else {
                    switchToHome();
                    return;
                }
            }
        }
    }

    public void switchToHome(){}
}
