package com.example.fitnesshelp.cli_graphics_controller;


import com.example.fitnesshelp.dao.SingletonConnection;
import com.example.fitnesshelp.utils.Printer;
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
                "9 to exit the application");
        while(true){
            String scelta=bufferedReader.readLine();
            try {
                Integer.parseInt(scelta);
            } catch (NumberFormatException e) {
                Printer.error("Digit a number\n");
                System.exit(-1);
            }
            //l'utente ha inserito effettivamente dei numeri
            int numeroScelta = Integer.parseInt(scelta);
            if(numeroScelta == 1){
                break;
            }
            if(numeroScelta == 2){
                Printer.print("The feature has not been implemented, it will be available soon\n");
                Printer.print("Select another function\n");
            }
            if(numeroScelta == 3){
                Printer.print("The feature has not been implemented, it will be available soon\n");
                Printer.print("Select another function\n");
            }
            if(numeroScelta == 4){
                Printer.print("The feature has not been implemented, it will be available soon\n");
                Printer.print("Select another function\n");
            }
            if(numeroScelta == 5){
                Printer.print("The feature has not been implemented, it will be available soon\n");
                Printer.print("Select another function\n");
            }
            if(numeroScelta == 6){
                Printer.print("The feature has not been implemented, it will be available soon\n");
                Printer.print("Select another function\n");
            }
            if(numeroScelta == 7){
                Printer.print("The feature has not been implemented, it will be available soon\n");
                Printer.print("Select another function\n");
            }
            //TODO numeri scelta

            if(numeroScelta==8){
                //l'utente vuole fare il login
            }
            if(numeroScelta==9){

                SingletonConnection.closeConnection();

                Printer.print("Thank you for using the application, goodbye\n");
                System.exit(0);
            }
            Printer.print("Try again with one of the following numbers: 1, 2, 3, 6, 8, 9\n");

        }
    }
}