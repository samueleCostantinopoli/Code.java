package com.example.fitnesshelp;

import com.example.fitnesshelp.ComandLineInterface.CliHomePage;
import com.example.fitnesshelp.entities.*;
import com.example.fitnesshelp.utils.Printer;
import com.example.fitnesshelp.entities.Account;
import com.example.fitnesshelp.utils.UtilityAccess;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import static com.example.fitnesshelp.entities.TypeOfUser.NORMAL;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/fitnesshelp/homePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Welcome to Fitness Helper!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException, SQLException {

        //l'app viene lanciata, creiamo quindi un utente di default che possiede come stato di default offline
        String admin = "admin";
        String email = "email@gmail.com";
        TypeOfUser type = NORMAL;

        UtilityAccess.setAccount(new Account("admin", "admin", NORMAL, null, State.NOT_LOGGED_IN));
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        Printer.print("---------------------------------------------------------------------");
        while(true){
            Printer.print("digitare:\n1 per visualizzare l'app con l'interfaccia grafica\n2 per visualizzare l'app in linea di comando");
            String scelta=bufferedReader.readLine();
            try {
                Integer.parseInt(scelta);
            } catch (NumberFormatException e) {
                //di default lancio l'interfaccia grafica
                launch();
                break;
            }
            //l'utente ha inserito effettivamente dei numeri
            int numeroScelta = Integer.parseInt(scelta);
            if(numeroScelta==1) {
                //è stata scelta l'interfaccia grafica
                launch();
                System.exit(0);
            }else if(numeroScelta==2) {
                //è stata scelta la linea di comando
                CliHomePage cliHomePage = new CliHomePage();
                cliHomePage.displayHomepage();
                System.exit(0);
            }
            Printer.print("mi spiace, prova a digitare 1 oppure 2");
            Printer.print("---------------------------------------------------------------------");
        }

        launch();
    }
}