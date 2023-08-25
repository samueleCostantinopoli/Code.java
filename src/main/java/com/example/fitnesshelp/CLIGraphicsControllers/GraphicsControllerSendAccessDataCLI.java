package com.example.fitnesshelp.CLIGraphicsControllers;

import com.example.fitnesshelp.ComandLineInterface.CliHomePage;
import com.example.fitnesshelp.application_controllers.ApplicationControllerLoginService;
import com.example.fitnesshelp.bean.BeanPassword;
import com.example.fitnesshelp.bean.BeanUsername;
import com.example.fitnesshelp.utils.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class GraphicsControllerSendAccessDataCLI {
    private CliHomePage homePage=new CliHomePage();
    private String username;
    private String password;
    private BeanUsername beanUsername;
    private BeanPassword beanPassword;
    public GraphicsControllerSendAccessDataCLI(String username, String password){
        this.username=username;
        this.password=password;
    }
    public void sendDataBean() throws IOException, SQLException {
        beanUsername = new BeanUsername(username);
        beanPassword = new BeanPassword(password);
        String usernameCheck = beanUsername.getUsername();
        // if the username is syntactically correct I go on otherwise I communicate the error to the user
        if (usernameCheck == null) {
            //mando il bean al controller applicativo
            try {
                new ApplicationControllerLoginService(beanUsername, beanPassword);
                // if no exception has occurred, it means that the access has been carried out successfully
                Printer.print("Logged in, press any key to return to home");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                if(bufferedReader.readLine().length()>=1){
                    backToHome();
                }
            }catch(IOException e){
                Printer.error(e.getMessage());
                backToHome();
            }
        }else{
            Printer.error(usernameCheck);
            backToHome();
        }
    }


    private void backToHome() throws IOException, SQLException {
        homePage.displayHomepage();
    }
}