package com.example.fitnesshelp.cli_graphics_controller;

import com.example.fitnesshelp.application_controllers.ApplicationControllerCalculateTdee;
import com.example.fitnesshelp.entities.Tdee;
import com.example.fitnesshelp.exception.TdeeRemoveException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class GraphicsControllerCliCalculateTdee0 {
    public void showTdee() throws SQLException, IOException, TdeeRemoveException {
        ApplicationControllerCalculateTdee applicationControllerCalculateTdee = new ApplicationControllerCalculateTdee();
        List<Tdee> tdeeList = applicationControllerCalculateTdee.requestTdeeList();

        boolean exit = true;
        while (exit) {
            printTdeeList(tdeeList);

            System.out.println("\nSelect an option:");
            System.out.println("1: Return to home");
            System.out.println("2: Calculate new tdee");
            System.out.println("3: Delete a tdee");

            String userInput = getUserInput();

            switch (userInput) {
                case "1" -> {
                    backToHomePage();
                    exit = false;
                }
                case "2" -> {
                    GraphicsControllerCliCalculateTdee2 graphicsControllerCliCalculateTdee2 = new GraphicsControllerCliCalculateTdee2();
                    graphicsControllerCliCalculateTdee2.showQuestionnaire();
                    exit = false;
                }
                case "3" -> deleteTdee(tdeeList);
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void printTdeeList(List<Tdee> tdeeList) {
        // this method print all tdee of user
        int index = 0;
        for (Tdee tdee : tdeeList) {
            System.out.println("\nTDEE #" + index);
            System.out.println("Kcal: " + tdee.getKcal());
            System.out.println("Protein: " + tdee.getPro());
            System.out.println("Fat: " + tdee.getFat());
            System.out.println("Carb: " + tdee.getCarb());
            System.out.println("Target: " + tdee.getTarget());
            System.out.println("Quantity: " + tdee.getQuantity());

            index++;
        }
    }

    private String getUserInput() throws IOException {
        // to get user input
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine().trim();
    }

    private void deleteTdee(List<Tdee> tdeeList) throws IOException, TdeeRemoveException {
        // to delete a tdee
        // command to insert: 'delete #tdee'
        ApplicationControllerCalculateTdee applicationControllerCalculateTdee = new ApplicationControllerCalculateTdee();
        System.out.println("Type 'delete <TDEE number>' to delete a TDEE");
        String deleteCommand = getUserInput();

        if (!isValidDeleteCommand(deleteCommand)) {
            System.out.println("Invalid command.");
            return;
        }

        int tdeeToDelete = extractTdeeToDelete(deleteCommand);

        if (tdeeToDelete < 0 || tdeeToDelete >= tdeeList.size()) {
            System.out.println("Invalid TDEE number.");
            return;
        }

        Tdee tdee = tdeeList.get(tdeeToDelete);
        tdeeList.remove(tdeeToDelete);

        try {
            applicationControllerCalculateTdee.removeTdee(tdee);
            System.out.println("tdee deleted\n");
        } catch (SQLException e) {
            // remove failed
            throw new TdeeRemoveException("Error while removing TDEE", e);
        }
    }

    private boolean isValidDeleteCommand(String command) {
        // to check if command to delete is correct
        return command.startsWith("delete ") && command.split(" ").length == 2;
    }

    private int extractTdeeToDelete(String command) {
        // number of tdee to remove
        String[] parts = command.split(" ");
        return Integer.parseInt(parts[1]);
    }

    private void backToHomePage() throws IOException, SQLException, TdeeRemoveException {
        GraphicsControllerCliHomePage homePage = new GraphicsControllerCliHomePage();
        homePage.displayHomepage();
    }

}
