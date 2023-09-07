package com.example.fitnesshelp.cli_graphics_controller;

import com.example.fitnesshelp.application_controllers.ApplicationControllerCalculateTdee;
import com.example.fitnesshelp.entities.Tdee;
import com.example.fitnesshelp.exception.TdeeRemoveException;
import com.example.fitnesshelp.utils.Printer;
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

            Printer.print("\nSelect an option:");
            Printer.print("1: Return to home");
            Printer.print("2: Calculate new tdee");
            Printer.print("3: Delete a tdee");

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
                default -> Printer.print("Invalid option.");
            }
        }
    }

    private void printTdeeList(List<Tdee> tdeeList) {
        // this method print all tdee of user
        int index = 0;
        for (Tdee tdee : tdeeList) {
            Printer.print("\nTDEE #" + index);
            Printer.print("Kcal: " + tdee.getKcal());
            Printer.print("Protein: " + tdee.getPro());
            Printer.print("Fat: " + tdee.getFat());
            Printer.print("Carb: " + tdee.getCarb());
            Printer.print("Target: " + tdee.getTarget());
            Printer.print("Quantity: " + tdee.getQuantity());

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
        Printer.print("Type 'delete <TDEE number>' to delete a TDEE");
        String deleteCommand = getUserInput();

        if (!isValidDeleteCommand(deleteCommand)) {
            Printer.print("Invalid command.");
            return;
        }

        int tdeeToDelete = extractTdeeToDelete(deleteCommand);

        if (tdeeToDelete < 0 || tdeeToDelete >= tdeeList.size()) {
            Printer.print("Invalid TDEE number.");
            return;
        }

        Tdee tdee = tdeeList.get(tdeeToDelete);
        tdeeList.remove(tdeeToDelete);

        try {
            applicationControllerCalculateTdee.removeTdee(tdee);
            Printer.print("tdee deleted\n");
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
