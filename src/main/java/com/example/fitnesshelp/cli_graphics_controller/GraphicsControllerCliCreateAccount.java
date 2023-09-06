package com.example.fitnesshelp.cli_graphics_controller;

import com.example.fitnesshelp.application_controllers.ApplicationControllerLogin;
import com.example.fitnesshelp.application_controllers.ApplicationControllerRegistration;
import com.example.fitnesshelp.bean.BeanAccountType;
import com.example.fitnesshelp.bean.BeanEmail;
import com.example.fitnesshelp.bean.BeanPassword;
import com.example.fitnesshelp.bean.BeanUsername;
import com.example.fitnesshelp.entities.Account;
import com.example.fitnesshelp.entities.Activity;
import com.example.fitnesshelp.entities.State;
import com.example.fitnesshelp.entities.TypeOfUser;
import com.example.fitnesshelp.exception.EmailAlreadyExistException;
import com.example.fitnesshelp.exception.NotExistsUsersException;
import com.example.fitnesshelp.exception.UsernameAlreadyExistException;
import com.example.fitnesshelp.utils.Printer;
import com.example.fitnesshelp.utils.UtilityAccess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class GraphicsControllerCliCreateAccount {

    private BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
    private BeanPassword beanPassword;
    private BeanUsername beanUsername;
    private BeanEmail beanEmail;
    private BeanAccountType beanAccountType;
    private String username;
    private String password;
    private String email;
    private String typeOfUser;

    public void showRegistration() throws IOException, SQLException {
        Printer.print("--------------------------PAGE CREATE ACCOUNT----------------------------\n");

        // insert username
        System.out.println("Type your username (type esc to go back): ");
        String usernameCheck = "";
        username = "";
        while(username.equals("") || usernameCheck != null) {
            this.username = bufferedReader.readLine();
            if(verifyExitInput(username)){
                // The user wants to go back to the home
                backToHomePage();
                break;
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

        // insert email
        System.out.println("Type your email (type esc to go back): ");
        String emailCheck = "";
        email = "";
        while(email.equals("") || emailCheck != null) {
            this.email = bufferedReader.readLine();
            if(verifyExitInput(email)){
                // The user wants to go back to the home
                backToHomePage();
                break;
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

        // insert password
        System.out.println("Type your password (type esc to go back): ");
        String passwordCheck = "";
        password = "";
        while(password.equals("") || passwordCheck != null) {
            this.password = bufferedReader.readLine();
            if(verifyExitInput(password)){
                // The user wants to go back to the home
                backToHomePage();
                break;
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

        // insert type of account
        System.out.println("Select your role (type esc to go back)\nType 1 for normal account or 2 for personal trainer account: ");
        String role = "";
        boolean exit = false;
        while (!exit){
            role = bufferedReader.readLine();
            if(verifyExitInput(password)){
                // The user wants to go back to the home
                backToHomePage();
                exit = true;
            }
            if (role.equals("1")){
                this.typeOfUser = "normal user";
                beanAccountType = new BeanAccountType(typeOfUser);
                exit = true;
            }
            if (role.equals("2")){
                this.typeOfUser = "personal trainer";
                beanAccountType = new BeanAccountType(typeOfUser);
                exit = true;
            }
            if (!role.equals("1") && !role.equals("2")) {
                System.out.println("please, enter your email or type 'esc' to go back: ");
            }
        }

        // now I can call the application controller to register
        try {
            ApplicationControllerRegistration applicationControllerRegistration = new ApplicationControllerRegistration(beanUsername, beanEmail, beanPassword, beanAccountType);
            applicationControllerRegistration.checkCredentials();
            // successful registration
            System.out.println("successful registration\nnow you can login!\n");
            // switch to login page
            GraphicsControllerCliLoginPage graphicsControllerCliLoginPage = new GraphicsControllerCliLoginPage();
            graphicsControllerCliLoginPage.viewAccessPage();
        }catch (EmailAlreadyExistException | UsernameAlreadyExistException | SQLException | IOException e){
            System.out.println("" + e.getMessage());
            System.out.println("\nregistration failed, try again\n");
            backToHomePage();
        }
    }

    private boolean verifyExitInput(String email){
        return email.equalsIgnoreCase("esc");

    }
    private void backToHomePage() throws IOException, SQLException {
        GraphicsControllerCliHomePage homePage = new GraphicsControllerCliHomePage();
        homePage.displayHomepage();
    }
}
