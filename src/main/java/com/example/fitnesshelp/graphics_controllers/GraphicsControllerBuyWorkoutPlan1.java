package com.example.fitnesshelp.graphics_controllers;

import com.example.fitnesshelp.entities.WorkoutPlan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


public class GraphicsControllerBuyWorkoutPlan1 extends GraphicsControllerHomePage {

    @FXML
    public TextField CardNumberTextField;
    @FXML
    public TextField ExpiresTextField;
    @FXML
    public TextField CVVTextField;
    @FXML
    public TextField FirstNameTextField;
    @FXML
    public TextField LastNameTextField;
    @FXML
    public TextField StreetAddressTextField;
    @FXML
    public TextField ApartmentTextField;
    @FXML
    public TextField CityTextField;
    @FXML
    public TextField ZipCodeTextField;
    @FXML
    public TextField MobileTextField;
    @FXML
    public TextField EmailTextField;
    public Button purchaseBuyWorkoutPlanButton;
    @FXML
    private ChoiceBox<String> StateChoiceBox;

    @FXML
    private Button HyperLinkButton;

    @FXML
    CheckBox CheckCreditCard;

    @FXML
    CheckBox CheckPayPal;

    @FXML
    CheckBox CheckBitcoin;

    @FXML
    private AnchorPane WorkoutPlan1;

    @FXML
    Button BackPaymentMethodsButton;

    @FXML
    ImageView BitcoinAddress;

    @FXML
    Label errorLoginMessageLabel;

    private WebView webView;
    private WebEngine webEngine;

    WorkoutPlan CurrentWorkout;

    public GraphicsControllerBuyWorkoutPlan1() {
    }

    void SaveWorkout(WorkoutPlan thisWorkout) {
        CurrentWorkout = thisWorkout;
        CheckCreditCard.setOnAction(event -> {
            if (CheckCreditCard.isSelected()) {
                // If CheckCreditCard is checked, uncheck the others
                HyperLinkButton.setVisible(false);
                CheckPayPal.setSelected(false);
                CheckBitcoin.setSelected(false);
                SetCreditCard(true);
                purchaseBuyWorkoutPlanButton.setVisible(true);
            }
        });
        CheckPayPal.setOnAction(event -> {
            if (CheckPayPal.isSelected()) {
                SetCreditCard(false);
                // If CheckPayPal is checked, uncheck the others
                CheckCreditCard.setSelected(false);
                CheckBitcoin.setSelected(false);
                HyperLinkButton.setText("PayPal Log In");
                HyperLinkButton.setVisible(true);
            }
        });
        CheckBitcoin.setOnAction(event -> {
            if (CheckBitcoin.isSelected()) {
                SetCreditCard(false);
                // If CheckBitcoin is selected, deselected other
                CheckCreditCard.setSelected(false);
                CheckPayPal.setSelected(false);
                HyperLinkButton.setText("Bitcoin address");
                HyperLinkButton.setVisible(true);
            }
        });
    }

    private boolean checkCreditCard() {
        return !CardNumberTextField.getText().isEmpty() &&
                !ExpiresTextField.getText().isEmpty() &&
                !CVVTextField.getText().isEmpty() &&
                !FirstNameTextField.getText().isEmpty() &&
                !LastNameTextField.getText().isEmpty() &&
                !StreetAddressTextField.getText().isEmpty() &&
                !ApartmentTextField.getText().isEmpty() &&
                !CityTextField.getText().isEmpty() &&
                !ZipCodeTextField.getText().isEmpty() &&
                !MobileTextField.getText().isEmpty() &&
                !StateChoiceBox.getSelectionModel().isEmpty()
                && !EmailTextField.getText().isEmpty();
    }

    private void SetCreditCard(boolean state){
        CardNumberTextField.setVisible(state);
        ExpiresTextField.setVisible(state);
        CVVTextField.setVisible(state);
        FirstNameTextField.setVisible(state);
        LastNameTextField.setVisible(state);
        StreetAddressTextField.setVisible(state);
        ApartmentTextField.setVisible(state);
        CityTextField.setVisible(state);
        ZipCodeTextField.setVisible(state);
        MobileTextField.setVisible(state);
        EmailTextField.setVisible(state);
        StateChoiceBox.setVisible(state);
    }


    @FXML
    private void OnActionHyperLinkButton() {
        if(HyperLinkButton.getText().equals("PayPal Log In")) {
            // I load the PayPal web page into the WebView
            webView = new WebView();
            webEngine = webView.getEngine();

            // I add the WebView to the container in the UI
            WorkoutPlan1.getChildren().add(webView);
            webEngine.load("https://www.paypal.me/sCostantinopoli");

        } else {
            BitcoinAddress.setVisible(true);
        }
        CheckCreditCard.setVisible(false);
        CheckPayPal.setVisible(false);
        CheckBitcoin.setVisible(false);
        purchaseBuyWorkoutPlanButton.setVisible(true);
        BackPaymentMethodsButton.setVisible(true);
        BackPaymentMethodsButton.setStyle("-fx-background-color: #FF0000; -fx-text-fill: white;");
    }

    public void clickedOnPurchaseBuyWorkoutPlanButton(ActionEvent event) throws IOException, SQLException {
        if(!CheckPayPal.isVisible() && !CheckBitcoin.isVisible()){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fitnesshelp/buyWorkoutPlan2.fxml"));
            Parent root = loader.load();
            GraphicsControllerBuyWorkoutPlan2 infoController2 = loader.getController();
            infoController2.savePurchase(CurrentWorkout);

            Stage home = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene primary = new Scene(root);
            home.setScene(primary);
            home.show();
        }
        else {
            if(!checkCreditCard()){
                errorLoginMessageLabel.setOpacity(1);
            }
        }
    }

    public void clickedOnBuyWorkoutPlanHyperlink1(ActionEvent event) throws IOException {
        stageToSwitch = "/com/example/fitnesshelp/buyWorkoutPlan";
        switchStage(event);
    }

    public void clickedOnBackPaymentMethodsButton() {
        if(HyperLinkButton.getText().equals("PayPal Log In")) {
            // Remove WebView
            WorkoutPlan1.getChildren().remove(webView);
            webEngine.getLoadWorker().cancel();
        }
        else {
            BitcoinAddress.setVisible(false);
        }
        purchaseBuyWorkoutPlanButton.setVisible(false);
        BackPaymentMethodsButton.setVisible(false);
        CheckCreditCard.setVisible(true);
        CheckPayPal.setVisible(true);
        CheckBitcoin.setVisible(true);
    }
}

