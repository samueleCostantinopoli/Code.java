package com.example.fitnesshelp.ComandLineInterface;

import com.example.fitnesshelp.utils.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class CliLoginPage {
    private BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
    private String username;
    private String password;

    public void viewAccessPage() throws IOException, SQLException {
        Printer.print("--------------------------PAGE LOG IN----------------------------\n" +
                "Type your email (type esc to go back):");
        this.username = bufferedReader.readLine();
        Printer.print("Enter your password (if you typed esc to go back, type any letter now):");
        this.password = bufferedReader.readLine();
        if(verifyExitInput(username)){
            // The user wants to go back to the home
            backToHomePage();
        }
        if (username.equals("") || password.equals("")) {
            Printer.error("Enter an email and password");
            backToHomePage();
        }
        // I send this data to the graphics controller which sends them to the bean


    }
    private boolean verifyExitInput(String email){
        return email.equalsIgnoreCase("esc");

    }
    private void backToHomePage() throws IOException, SQLException {
        CliHomePage homePage = new CliHomePage();
        homePage.displayHomepage();
    }
}
