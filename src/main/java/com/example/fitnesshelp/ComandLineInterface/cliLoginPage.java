package com.example.fitnesshelp.ComandLineInterface;

import com.example.fitnesshelp.CLIGraphicsControllers.GraphicsControllerSendAccessDataCLI;
import com.example.fitnesshelp.utils.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cliLoginPage {
    private BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;

    public void viewAccessPage() throws IOException {
        Printer.print("--------------------------Pagina log in----------------------------\n" +
                "digita la tua email ( digita esc per tornare indietro):");
        this.email=bufferedReader.readLine();
        Printer.print("inserisci la tua password ( se hai digitato esc per tornare indietro, digita qualsiasi lettera ora): ");
        this.password=bufferedReader.readLine();
        //controlla se l'utente e' voluto tornare indietro
        if(verifyExitInput(email)){
            //l'utente vuole tornare alla home
            backToHomePage();
        }
        if (email.equals("") || password.equals("")) {
            Printer.error("Inserisci una email e una password");
            backToHomePage();
        }
        //mando questi dati al controller grafico il quale li manda al bean
        GraphicsControllerSendAccessDataCLI graphicsControllerSendAccessDataCLI=new GraphicsControllerSendAccessDataCLI(this.email,this.password);
        graphicsControllerSendAccessDataCLI.sendDataBean();

    }
    private boolean verifyExitInput(String email){
        return email.equalsIgnoreCase("esc");

    }
    private void backToHomePage() throws IOException {
        cliHomePage homePage = new cliHomePage();
        homePage.displayHomepage();
    }
}
