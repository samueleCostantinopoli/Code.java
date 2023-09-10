package com.example.fitnesshelp.cli_graphics_controller;

import com.example.fitnesshelp.application_controllers.ApplicationControllerLogin;
import com.example.fitnesshelp.bean.BeanPassword;
import com.example.fitnesshelp.bean.BeanUsername;
import com.example.fitnesshelp.entities.State;
import com.example.fitnesshelp.exception.NotExistsUsersException;
import com.example.fitnesshelp.exception.TdeeRemoveException;
import com.example.fitnesshelp.utils.Printer;
import com.example.fitnesshelp.utils.UtilityAccess;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class GraphicsControllerCliLoginPage {
    private final BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
    private BeanUsername beanUsername;
    private BeanPassword beanPassword;

    public void viewAccessPage() throws IOException, SQLException, TdeeRemoveException {
        Printer.print("--------------------------PAGE LOG IN----------------------------\n");

        if (!askUserIfAccountExists()) {
            // User wants to register
            GraphicsControllerCliCreateAccount graphicsControllerCliRegistration = new GraphicsControllerCliCreateAccount();
            graphicsControllerCliRegistration.showRegistration();
            return;
        }

        String username = askForUsername();
        if (username == null) {
            // User wants to go back to the home page
            backToHomePage();
            return;
        }

        String password = askForPassword();
        if (password == null) {
            // User wants to go back to the home page
            backToHomePage();
            return;
        }

        // Attempt to log in
        try {
            ApplicationControllerLogin applicationControllerLogin = new ApplicationControllerLogin(beanUsername, beanPassword);
            applicationControllerLogin.checkUserAccount();
            // Successful login
            UtilityAccess.setUsername(username);
            UtilityAccess.setState(State.LOGGED_IN);
            Printer.print("Successful login\n");
            // Switch to home page
            backToHomePage();
        } catch (NotExistsUsersException | SQLException | IOException e) {
            Printer.print("" + e.getMessage());
            Printer.print("\nLogin failed, try logging in again\n");
            backToHomePage();
        }
    }

    private boolean askUserIfAccountExists() throws IOException {
        Printer.print("Do you have an account yet?\ntype 'yes' to login or 'no' to register\n");
        String accountChoice = "";
        while (!accountChoice.equals("yes")) {
            accountChoice = bufferedReader.readLine();
            if (!accountChoice.equals("yes") && !accountChoice.equals("no")) {
                Printer.print("Please, type 'yes' to login or 'no' to register: ");
            }
            if (accountChoice.equals("no")) {
                return false;
            }
        }
        return true;
    }

    private String askForUsername() throws IOException {
        Printer.print("Type your username (type esc to go back): ");
        String username = "";
        String usernameCheck = "";
        while (username.equals("") || usernameCheck != null) {
            username = bufferedReader.readLine();
            if (verifyExitInput(username)) {
                // The user wants to go back to the home
                return null;
            }
            if (username.equals("")) {
                Printer.print("Please, enter your username or type 'esc' to go back: ");
            }
            beanUsername = new BeanUsername(username);
            usernameCheck = beanUsername.checkUsernameLength(username);
            if (usernameCheck != null) {
                Printer.print(usernameCheck + "\nRe-insert username: ");
            }
        }
        return username;
    }

    private String askForPassword() throws IOException {
        Printer.print("Type your password (type esc to go back): ");
        String password = "";
        String passwordCheck = "";
        while (password.equals("") || passwordCheck != null) {
            password = bufferedReader.readLine();
            if (verifyExitInput(password)) {
                // The user wants to go back to the home
                return null;
            }
            if (password.equals("")) {
                Printer.print("Please, enter your password: ");
            }
            beanPassword = new BeanPassword(password);
            passwordCheck = beanPassword.passwordCheck(password);
            if (passwordCheck != null) {
                Printer.print(passwordCheck + "Re-insert password: ");
            }
        }
        return password;
    }

    private boolean verifyExitInput(String email){
        return email.equalsIgnoreCase("esc");

    }
    private void backToHomePage() throws IOException, SQLException, TdeeRemoveException {
        GraphicsControllerCliHomePage homePage = new GraphicsControllerCliHomePage();
        homePage.displayHomepage();
    }
}
