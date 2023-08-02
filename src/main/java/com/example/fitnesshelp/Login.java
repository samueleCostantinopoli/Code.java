package com.example.fitnesshelp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {

    @FXML
    private Button buttonCreateAccount;

    @FXML
    private Button buttonLogin;

    @FXML
    private Label email;

    @FXML
    private TextField emailField;

    @FXML
    private Hyperlink homeHyperlink;

    @FXML
    private Label password;

    @FXML
    private TextField passwordField;

    @FXML
    private Label title;

    @FXML
    private Label welcome;
    private Stage stage;
    private Scene scene;
    private FXMLLoader root;
    @FXML
    void clickedOnButtonCreateAccount(ActionEvent event) {

    }

    @FXML
    void clickedOnHomeHyperlink(ActionEvent event) throws IOException {
        root = new FXMLLoader(getClass().getResource("homePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void clickedOnButtonLogin(ActionEvent event) {

    }

}
