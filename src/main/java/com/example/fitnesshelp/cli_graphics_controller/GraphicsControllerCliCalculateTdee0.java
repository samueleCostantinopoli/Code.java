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

        // print tdee
        int index = 0; // used for delete tdee
        for (Tdee tdee : tdeeList) {
            System.out.println("TDEE #" + index);
            System.out.println("Kcal: " + tdee.getKcal());
            System.out.println("Protein: " + tdee.getPro());
            System.out.println("Fat: " + tdee.getFat());
            System.out.println("Carb: " + tdee.getCarb());
            System.out.println("Target: " + tdee.getTarget());
            System.out.println("Quantity: " + tdee.getQuantity());

            index++;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // after print all tdee of list
        System.out.println("Select an option:");
        System.out.println("1: Return to home");
        System.out.println("2: Calculate new tdee");
        System.out.println("3: Delete a TDEE (type 'delete <TDEE number>')");

        String userInput = bufferedReader.readLine();

        switch (userInput) {
            case "1":
                // Torna alla home
                // Inserisci il codice per tornare alla home
                break;
            case "2":
                // Vai a un altro controller
                // Inserisci il codice per andare a un altro controller
                break;
            case "3":
                // Elimina un TDEE
                System.out.println("Type 'delete <TDEE number>' to delete a TDEE");
                String deleteCommand = bufferedReader.readLine();

                // Esegui la verifica e l'eliminazione del TDEE
                if (deleteCommand.startsWith("delete ")) {
                    String[] parts = deleteCommand.split(" ");
                    if (parts.length == 2) {
                        try {
                            int tdeeToDelete = Integer.parseInt(parts[1]);
                            // Inserisci il codice per eliminare il TDEE alla posizione 'tdeeToDelete' dalla lista
                            // Esempio: tdeeList.remove(tdeeToDelete);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid TDEE number.");
                        }
                    } else {
                        System.out.println("Invalid command.");
                    }
                } else {
                    System.out.println("Invalid command.");
                }
                break;
            default:
                System.out.println("Invalid option.");
        }

    }
}
