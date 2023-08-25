package com.example.fitnesshelp.CLIGraphicsControllers;

import com.example.fitnesshelp.ComandLineInterface.CliLoginPage;

import java.io.IOException;

public class GraphicsControllerLoginCLI {
    private CliLoginPage loginPage;

    public void Access() throws IOException{
        this.loginPage = new CliLoginPage();
        try {
            loginPage.viewAccessPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
