package com.example.fitnesshelp;

import com.example.fitnesshelp.cli_graphics_controller.GraphicsControllerCliHomePage;
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
        // The app is launched, so we create a default user who has offline by default
        UtilityAccess.setAccount(new Account("admin", "admin", NORMAL, null, State.NOT_LOGGED_IN));
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        Printer.print("---------------------------------------------------------------------");
        while(true){
            Printer.print("Type:\n1 to view the app with the graphical interface\n2 to view the app in command line");
            String choice=bufferedReader.readLine();
            try {
                Integer.parseInt(choice);
            } catch (NumberFormatException e) {
                // by default, I launch the graphical interface
                launch();
                break;
            }
            //l'utente ha inserito effettivamente dei numeri
            int numberChoice = Integer.parseInt(choice);
            if(numberChoice==1) {
                // the graphical interface has been chosen
                launch();
                System.exit(0);
            }else if(numberChoice==2) {
                GraphicsControllerCliHomePage cliHomePage = new GraphicsControllerCliHomePage();
                cliHomePage.displayHomepage();
                System.exit(0);
            }
            Printer.print("Sorry, try typing 1 or 2\n");
        }
        launch();
    }
}