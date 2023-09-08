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


public class GraphicsControllerBuyWorkoutPlanSetPayments extends GraphicsControllerHomePage {

    @FXML
    public TextField cardNumberTextField;
    @FXML
    public TextField expiresTextField;
    @FXML
    public TextField cvvTextField;
    @FXML
    public TextField firstNameTextField;
    @FXML
    public TextField lastNameTextField;
    @FXML
    public TextField streetAddressTextField;
    @FXML
    public TextField apartmentTextField;
    @FXML
    public TextField cityTextField;
    @FXML
    public TextField zipCodeTextField;
    @FXML
    public TextField mobileTextField;
    @FXML
    public TextField emailTextField;
    @FXML
    public Button purchaseBuyWorkoutPlanButton;
    @FXML
    private ChoiceBox<String> stateChoiceBox;

    @FXML
    private Button hyperLinkButton;

    @FXML
    CheckBox checkCreditCardBox;

    @FXML
    CheckBox checkPayPal;

    @FXML
    CheckBox checkBitcoin;

    @FXML
    private AnchorPane workoutPlan1;

    @FXML
    Button backPaymentMethodsButton;

    @FXML
    ImageView bitcoinAddress;

    @FXML
    Label errorLoginMessageLabel;

    private WebView webView;
    private WebEngine webEngine;

    public final String PAYPAL = "PayPal Log In";

    WorkoutPlan currentWorkout;

    void saveWorkout(WorkoutPlan thisWorkout) {
        currentWorkout = thisWorkout;
        checkCreditCardBox.setOnAction(event -> {
            if (checkCreditCardBox.isSelected()) {
                // If CheckCreditCard is checked, uncheck the others
                hyperLinkButton.setVisible(false);
                checkPayPal.setSelected(false);
                checkBitcoin.setSelected(false);
                setCreditCard(true);
                purchaseBuyWorkoutPlanButton.setVisible(true);
            }
        });
        checkPayPal.setOnAction(event -> {
            if (checkPayPal.isSelected()) {
                setCreditCard(false);
                // If CheckPayPal is checked, uncheck the others
                checkCreditCardBox.setSelected(false);
                checkBitcoin.setSelected(false);
                hyperLinkButton.setText(PAYPAL);
                hyperLinkButton.setVisible(true);
            }
        });
        checkBitcoin.setOnAction(event -> {
            if (checkBitcoin.isSelected()) {
                setCreditCard(false);
                // If CheckBitcoin is selected, deselected other
                checkCreditCardBox.setSelected(false);
                checkPayPal.setSelected(false);
                hyperLinkButton.setText("Bitcoin address");
                hyperLinkButton.setVisible(true);
            }
        });
    }

    private boolean checkCreditCard() {
        return !cardNumberTextField.getText().isEmpty() &&
                !expiresTextField.getText().isEmpty() &&
                !cvvTextField.getText().isEmpty() &&
                !firstNameTextField.getText().isEmpty() &&
                !lastNameTextField.getText().isEmpty() &&
                !streetAddressTextField.getText().isEmpty() &&
                !apartmentTextField.getText().isEmpty() &&
                !cityTextField.getText().isEmpty() &&
                !zipCodeTextField.getText().isEmpty() &&
                !mobileTextField.getText().isEmpty() &&
                !stateChoiceBox.getSelectionModel().isEmpty()
                && !emailTextField.getText().isEmpty();
    }

    private void setCreditCard(boolean state){
        cardNumberTextField.setVisible(state);
        expiresTextField.setVisible(state);
        cvvTextField.setVisible(state);
        firstNameTextField.setVisible(state);
        lastNameTextField.setVisible(state);
        streetAddressTextField.setVisible(state);
        apartmentTextField.setVisible(state);
        cityTextField.setVisible(state);
        zipCodeTextField.setVisible(state);
        mobileTextField.setVisible(state);
        emailTextField.setVisible(state);
        stateChoiceBox.setVisible(state);
    }


    @FXML
    private void onActionHyperLinkButton() {
        if(hyperLinkButton.getText().equals(PAYPAL)) {
            // I load the PayPal web page into the WebView
            webView = new WebView();
            webEngine = webView.getEngine();

            // I add the WebView to the container in the UI
            workoutPlan1.getChildren().add(webView);
            webEngine.load("https://www.paypal.me/sCostantinopoli");

        } else {
            bitcoinAddress.setVisible(true);
        }
        checkCreditCardBox.setVisible(false);
        checkPayPal.setVisible(false);
        checkBitcoin.setVisible(false);
        purchaseBuyWorkoutPlanButton.setVisible(true);
        backPaymentMethodsButton.setVisible(true);
        backPaymentMethodsButton.setStyle("-fx-background-color: #FF0000; -fx-text-fill: white;");
    }

    public void clickedOnPurchaseBuyWorkoutPlanButton(ActionEvent event) throws IOException, SQLException {
        if(!checkPayPal.isVisible() && !checkBitcoin.isVisible()){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fitnesshelp/buyWorkoutPlanPurchase.fxml"));
            Parent root = loader.load();
            GraphicsControllerBuyWorkoutPlanPurchase infoController2 = loader.getController();
            infoController2.savePurchase(currentWorkout);

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
        if(hyperLinkButton.getText().equals(PAYPAL)) {
            // Remove WebView
            workoutPlan1.getChildren().remove(webView);
            webEngine.getLoadWorker().cancel();
        }
        else {
            bitcoinAddress.setVisible(false);
        }
        purchaseBuyWorkoutPlanButton.setVisible(false);
        backPaymentMethodsButton.setVisible(false);
        checkCreditCardBox.setVisible(true);
        checkPayPal.setVisible(true);
        checkBitcoin.setVisible(true);
    }
}

