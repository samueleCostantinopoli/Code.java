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
    private BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
    private String username;
    private String password;
    private BeanUsername beanUsername;
    private BeanPassword beanPassword;

    public void viewAccessPage() throws IOException, SQLException, TdeeRemoveException {
        Printer.print("--------------------------PAGE LOG IN----------------------------\n");

        // possibility to register if user don't have an account
        System.out.println("You have an account yet? ");
        String accountChoice = "";
        while (!accountChoice.equals("yes")){
            accountChoice = bufferedReader.readLine();
            if (!accountChoice.equals("yes") && !accountChoice.equals("no")) {
                System.out.println("please, type 'yes' to login or 'no' to register: ");
            }
            if (accountChoice.equals("no")) {
                GraphicsControllerCliCreateAccount graphicsControllerCliRegistration = new GraphicsControllerCliCreateAccount();
                graphicsControllerCliRegistration.showRegistration();
                break;
            }
        }

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

        // now I call application controller to login
        try {
            ApplicationControllerLogin applicationControllerLogin = new ApplicationControllerLogin(beanUsername, beanPassword);
            applicationControllerLogin.checkUserAccount();
            // successful login
            UtilityAccess.setUsername(username);
            UtilityAccess.setState(State.LOGGED_IN);
            System.out.println("successful login\n");
            // switch to home page
            backToHomePage();
        }catch (NotExistsUsersException | SQLException | IOException e){
            System.out.println("" + e.getMessage());
            System.out.println("\nlogin failed, try logging in again\n");
            backToHomePage();
        }

    }

    private boolean verifyExitInput(String email){
        return email.equalsIgnoreCase("esc");

    }
    private void backToHomePage() throws IOException, SQLException, TdeeRemoveException {
        GraphicsControllerCliHomePage homePage = new GraphicsControllerCliHomePage();
        homePage.displayHomepage();
    }
}
