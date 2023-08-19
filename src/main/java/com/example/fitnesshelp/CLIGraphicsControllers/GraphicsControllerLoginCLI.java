package com.example.fitnesshelp.CLIGraphicsControllers;

import com.example.fitnesshelp.ComandLineInterface.cliLoginPage;

import java.io.IOException;

public class GraphicsControllerLoginCLI {
    private cliLoginPage loginPage;

    public void Access() throws IOException{
        this.loginPage = new cliLoginPage();
        try {
            loginPage.viewAccessPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
