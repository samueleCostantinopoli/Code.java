package com.example.fitnesshelp.CLIGraphicsControllers;

import com.example.fitnesshelp.ComandLineInterface.cliHomePage;
import com.example.fitnesshelp.application_controllers.ApplicationControllerLoginService;
import com.example.fitnesshelp.bean.BeanLogin;
import com.example.fitnesshelp.exception.ExceptionErrorReadPass;
import com.example.fitnesshelp.exception.ExceptionNotExistsUsers;
import com.example.fitnesshelp.exception.SQLException;
import com.example.fitnesshelp.utils.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GraphicsControllerSendAccessDataCLI {
    private cliHomePage homePage=new cliHomePage();
    private String email;
    private String password;
    private BeanLogin beanAccessoUtente;
    public GraphicsControllerSendAccessDataCLI(String email, String password){
        this.email=email;
        this.password=password;
    }
    public void sendDataBean() throws IOException {
        beanAccessoUtente = new BeanLogin(email, password);
        //svolgo prima i controlli sulla email inserita dall'utente, verifico cioè se è sintatticamente corretta
        String controlliSintatticiEmail = beanAccessoUtente.svolgiControlli();
        //se l'email è sintatticamente corretta vado avanti altrimenti counico l'errore all'utente
        if (controlliSintatticiEmail == null) {
            //mando il bean al controller applicativo
            try {
                new ApplicationControllerLoginService(beanAccessoUtente);
                // se non si e' verificata nessuna eccezione vuol dire che l'accesso e' stato effettuato con successo
                Printer.print("Accesso effettuato, premi qualsiasi tasto per tornare alla home");
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
                if(bufferedReader.readLine().length()>=1){
                    backToHome();
                }
            }catch(IOException e){
                Printer.error(e.getMessage());
                backToHome();
            }
        }else{
            Printer.error(controlliSintatticiEmail);
            backToHome();
        }

    }
    private void backToHome() throws IOException {
        homePage.displayHomepage();
    }
}