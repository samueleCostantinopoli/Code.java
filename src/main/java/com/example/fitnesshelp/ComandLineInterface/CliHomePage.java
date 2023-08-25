package com.example.fitnesshelp.ComandLineInterface;

import com.example.fitnesshelp.CLIGraphicsControllers.GraphicsControllerHomePageCLI;
import com.example.fitnesshelp.CLIGraphicsControllers.GraphicsControllerLoginCLI;
import com.example.fitnesshelp.graphics_controllers.GraphicsControllerHomePage;
import com.example.fitnesshelp.graphics_controllers.GraphicsControllerLogin;
import com.example.fitnesshelp.utils.Printer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class cliHomePage {
    private GraphicsControllerLoginCLI graphicsControllerLoginCLI = new GraphicsControllerLoginCLI();
    private GraphicsControllerHomePageCLI graphicsControllerHomePageCLI = new GraphicsControllerHomePageCLI();

    public void displayHomepage() throws IOException {

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        Printer.print("------------------------------------------HOME------------------------------------------\n" +
                "digita:\n" +
                "1 per creare il tuo workout\n" +
                "2 per visualizzare i tuoi workout\n" +
                "3 per calcolare la tua Tdee\n" +
                "4 per trovare una palestra vicino a te\n" +
                "5 per cercare un personal trainer\n" +
                "6 per comprare una scheda di allenamento\n" +
                "7 per entrare nel tuo diario di allenamento\n" +
                "8 per accedere al tuo account\n" +
                "9 per uscire dall'applicazione");
        while(true){
            String scelta=bufferedReader.readLine();
            try {
                Integer.parseInt(scelta);
            } catch (NumberFormatException e) {
                Printer.error("la prossima volta accertati di digitare un numero ");
                System.exit(-1);
            }
            //l'utente ha inserito effettivamente dei numeri
            int numeroScelta = Integer.parseInt(scelta);
            if(numeroScelta == 1){
                this.graphicsControllerHomePageCLI.CreateWorkout();
                break;
            }
            if(numeroScelta == 2){
                Printer.print("la funzione per lasciare una recensione ancora non e' stata implementata, presto sarà disponibile");
                Printer.print("seleziona un'altra funzione");
            }
            if(numeroScelta == 3){
                Printer.print("la funzione per suggerire nuove funzioni ancora non e' stata implementata, presto sarà disponibile");
                Printer.print("seleziona un'altra funzione");
            }
            if(numeroScelta == 4){
                Printer.print("la funzione per suggerire nuove funzioni ancora non e' stata implementata, presto sarà disponibile");
                Printer.print("seleziona un'altra funzione");
            }
            if(numeroScelta == 5){
                Printer.print("la funzione per suggerire nuove funzioni ancora non e' stata implementata, presto sarà disponibile");
                Printer.print("seleziona un'altra funzione");
            }
            if(numeroScelta == 6){
                Printer.print("la funzione per suggerire nuove funzioni ancora non e' stata implementata, presto sarà disponibile");
                Printer.print("seleziona un'altra funzione");
            }
            if(numeroScelta == 7){
                Printer.print("la funzione per suggerire nuove funzioni ancora non e' stata implementata, presto sarà disponibile");
                Printer.print("seleziona un'altra funzione");
            }
            //TODO numeri scelta

            if(numeroScelta==8){
                //l'utente vuole fare il login
                this.graphicsControllerLoginCLI.Access();
            }
            if(numeroScelta==9){
                /*
                SingletonConnessione.closeConnection();
                //per come è strutturata l'applicazione non si entra mai in questa eccezione, ho provato in tutti i
                //modi ma non viene mai generata un eccezione sql exception
                */
                Printer.print("grazie per aver usato l'applicazione, arrivederci =)");
                System.exit(0);
            }
            Printer.print("riprova con uno tra i seguenti numeri : 1, 2, 3, 6, 8, 9\n");

        }
    }
}