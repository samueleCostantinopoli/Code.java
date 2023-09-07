package com.example.fitnesshelp.cli_graphics_controller;

import com.example.fitnesshelp.application_controllers.ApplicationControllerRegistration;
import com.example.fitnesshelp.bean.BeanAccountType;
import com.example.fitnesshelp.bean.BeanEmail;
import com.example.fitnesshelp.bean.BeanPassword;
import com.example.fitnesshelp.bean.BeanUsername;
import com.example.fitnesshelp.exception.EmailAlreadyExistException;
import com.example.fitnesshelp.exception.TdeeRemoveException;
import com.example.fitnesshelp.exception.UsernameAlreadyExistException;
import com.example.fitnesshelp.utils.Printer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class GraphicsControllerCliCreateAccount {

    private final BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
    private BeanPassword beanPassword;
    private BeanUsername beanUsername;
    private BeanEmail beanEmail;
    private BeanAccountType beanAccountType;

    public void showRegistration() throws IOException, SQLException, TdeeRemoveException {
        Printer.print("--------------------------PAGE CREATE ACCOUNT----------------------------\n");

        getUsername();
        getEmail();
        getPassword();
        getAccountType();

        // now I can call the application controller to register
        try {
            ApplicationControllerRegistration applicationControllerRegistration = new ApplicationControllerRegistration(beanUsername, beanEmail, beanPassword, beanAccountType);
            applicationControllerRegistration.checkCredentials();
            // successful registration
            System.out.println("successful registration\nnow you can login!\n");
            // switch to login page
            GraphicsControllerCliLoginPage graphicsControllerCliLoginPage = new GraphicsControllerCliLoginPage();
            graphicsControllerCliLoginPage.viewAccessPage();
        } catch (EmailAlreadyExistException | UsernameAlreadyExistException | SQLException | IOException e) {
            System.out.println("" + e.getMessage());
            System.out.println("\nregistration failed, try again\n");
            backToHomePage();
        }
    }

    private void getUsername() throws IOException, SQLException, TdeeRemoveException {
        System.out.println("Type your username (type esc to go back): ");
        String usernameCheck = "";
        String username = "";
        while (username.equals("") || usernameCheck != null) {
            username = bufferedReader.readLine();
            if (verifyExitInput(username)) {
                // The user wants to go back to the home
                backToHomePage();
                return;
            }
            if (username.equals("")) {
                System.out.println("please, enter your username or type 'esc' to go back: ");
            }
            beanUsername = new BeanUsername(username);
            usernameCheck = beanUsername.checkUsernameLength(username);
            if (usernameCheck != null) {
                System.out.println(usernameCheck + "\nRe-insert username: ");
            }
        }
    }

    private void getEmail() throws IOException, SQLException, TdeeRemoveException {
        System.out.println("Type your email (type esc to go back): ");
        String emailCheck = "";
        String email = "";
        while (email.equals("") || emailCheck != null) {
            email = bufferedReader.readLine();
            if (verifyExitInput(email)) {
                // The user wants to go back to the home
                backToHomePage();
                return;
            }
            if (email.equals("")) {
                System.out.println("please, enter your email or type 'esc' to go back: ");
            }
            beanEmail = new BeanEmail(email);
            emailCheck = beanEmail.emailCehck(email);
            if (emailCheck != null) {
                System.out.println(emailCheck + "\nRe-insert email: ");
            }
        }
    }

    private void getPassword() throws IOException, SQLException, TdeeRemoveException {
        System.out.println("Type your password (type esc to go back): ");
        String passwordCheck = "";
        String password = "";
        while (password.equals("") || passwordCheck != null) {
            password = bufferedReader.readLine();
            if (verifyExitInput(password)) {
                // The user wants to go back to the home
                backToHomePage();
                return;
            }
            if (password.equals("")) {
                System.out.println("please, enter your password: ");
            }
            beanPassword = new BeanPassword(password);
            passwordCheck = beanPassword.passwordCheck(password);
            if (passwordCheck != null) {
                System.out.println(passwordCheck + "Re-insert password: ");
            }
        }
    }

    private void getAccountType() throws IOException, SQLException, TdeeRemoveException {
        System.out.println("Select your role (type esc to go back)\nType 1 for normal account or 2 for personal trainer account: ");
        String role;
        boolean exit = false;
        while (!exit) {
            role = bufferedReader.readLine();
            if (verifyExitInput(role)) {
                // The user wants to go back to the home
                backToHomePage();
                return;
            }
            String typeOfUser;
            if (role.equals("1")) {
                typeOfUser = "normal user";
                beanAccountType = new BeanAccountType(typeOfUser);
                exit = true;
            }
            if (role.equals("2")) {
                typeOfUser = "personal trainer";
                beanAccountType = new BeanAccountType(typeOfUser);
                exit = true;
            }
            if (!role.equals("1") && !role.equals("2")) {
                System.out.println("Invalid choice. Please select 1 for normal account or 2 for personal trainer account: ");
            }
        }
    }

// Rest of your methods


    private boolean verifyExitInput(String email){
        return email.equalsIgnoreCase("esc");

    }
    private void backToHomePage() throws IOException, SQLException, TdeeRemoveException {
        GraphicsControllerCliHomePage homePage = new GraphicsControllerCliHomePage();
        homePage.displayHomepage();
    }
}
