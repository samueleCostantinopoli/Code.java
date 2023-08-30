package com.example.fitnesshelp.graphics_controllers;

import com.sun.javafx.menu.MenuItemBase;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


import java.io.*;

import java.io.IOException;
import java.net.*;


public class GraphicsControllerBuyWorkoutPlan2 extends GraphicsControllerHomePage {

    @FXML
    private Button PayPalButton;

    @FXML
    private void initialize() {
        // Metodo di inizializzazione
    }

    @FXML
    private void OnActionPayPalButton(ActionEvent event) throws IOException {
        String url = "https://www.google.com"; // L'URL della pagina web da aprire

        try {
            URL webpageUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) webpageUrl.openConnection();

            // Imposta il metodo della richiesta HTTP (GET)
            connection.setRequestMethod("GET");

            // Ottiene la risposta dal server
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder content = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }

                reader.close();

                // Stampa il contenuto della pagina web
                System.out.println(content.toString());
            } else {
                System.out.println("Errore nella connessione: " + responseCode);
            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickedOnPurchaseBuyWorkoutPlanButton(ActionEvent event) {
    }

    public void clickedOnBuyWorkoutPlanHyperlink1(ActionEvent event) {
    }
}

