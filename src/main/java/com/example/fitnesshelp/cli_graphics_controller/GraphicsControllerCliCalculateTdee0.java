package com.example.fitnesshelp.cli_graphics_controller;

import com.example.fitnesshelp.application_controllers.ApplicationControllerCalculateTdee;
import com.example.fitnesshelp.entities.Tdee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class GraphicsControllerCliCalculateTdee0 {
    public void showTdee() throws SQLException, IOException {
        // call the application controller to request the list of tdee calculated
        ApplicationControllerCalculateTdee applicationControllerCalculateTdee = new ApplicationControllerCalculateTdee();
        List<Tdee> tdeeList = applicationControllerCalculateTdee.requestTdeeList();

        boolean exit = true;
        while (exit) {
            // print tdee
            int index = 0; // used for delete tdee
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

            // after print all tdee of list
            System.out.println("\nSelect an option:");
            System.out.println("1: Return to home");
            System.out.println("2: Calculate new tdee");
            System.out.println("3: Delete a tdee");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String userInput = bufferedReader.readLine();

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
                case "3" -> {
                    // delete a tdee
                    System.out.println("Type 'delete <TDEE number>' to delete a TDEE");
                    String deleteCommand = bufferedReader.readLine().trim();

                    // delete check
                    if (deleteCommand.startsWith("delete ")) {
                        String[] parts = deleteCommand.split(" ");
                        if (parts.length == 2) {
                            try {
                                int tdeeToDelete = Integer.parseInt(parts[1]);
                                if (tdeeToDelete >= 0 && tdeeToDelete < tdeeList.size()) { // Verifica che il numero TDEE sia valido.
                                    Tdee tdee = tdeeList.get(tdeeToDelete);
                                    tdeeList.remove(tdeeToDelete);
                                    // now I call application controller to delete this tdee from db
                                    applicationControllerCalculateTdee.removeTdee(tdee);
                                    System.out.println("tdee deleted\n");
                                } else {
                                    System.out.println("Invalid TDEE number.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid TDEE number.");
                            }
                        } else {
                            System.out.println("Invalid command.");
                        }
                    } else {
                        System.out.println("Invalid command.");
                    }
                }
                default -> System.out.println("Invalid option.");
            }
        }

    }

    private void backToHomePage() throws IOException, SQLException {
        GraphicsControllerCliHomePage homePage = new GraphicsControllerCliHomePage();
        homePage.displayHomepage();
    }

}
