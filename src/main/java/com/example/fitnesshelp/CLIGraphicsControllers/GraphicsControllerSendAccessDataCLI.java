package com.example.fitnesshelp.CLIGraphicsControllers;

import com.example.fitnesshelp.ComandLineInterface.cliHomePage;
import com.example.fitnesshelp.bean.BeanPassword;
import com.example.fitnesshelp.bean.BeanUsername;

import java.io.IOException;

public class GraphicsControllerSendAccessDataCLI {
    private cliHomePage homePage=new cliHomePage();
    private String username;
    private String password;
    private BeanUsername beanUsername;
    private BeanPassword beanPassword;
    public GraphicsControllerSendAccessDataCLI(String username, String password){
        this.username=username;
        this.password=password;
    }
    public void sendDataBean() throws IOException {
        beanUsername = new BeanUsername(username);
        beanPassword = new BeanPassword(password);
        //svolgo prima i controlli sulla email inserita dall'utente, verifico cioè se è sintatticamente corretta
        String usernameCheck = beanUsername.getUsername();
        //se l'email è sintatticamente corretta vado avanti altrimenti counico l'errore all'utente
        /*
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
*/
    }


    private void backToHome() throws IOException {
        homePage.displayHomepage();
    }
}