package com.example.fitnesshelp.cli_graphics_controller;

import com.example.fitnesshelp.entities.State;
import com.example.fitnesshelp.entities.WorkoutPlan;
import com.example.fitnesshelp.exception.TdeeRemoveException;
import com.example.fitnesshelp.utils.Printer;
import com.example.fitnesshelp.utils.UtilityAccess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GraphicsControllerCliBuyWorkoutPlan1 {

    String CardNumber;
    String ExpiresCard;

    int CVV;

    String FirstName;
    String LastName;
    String StreetAddress;
    String Apartment;
    String City;
    String StateUser;
    int ZIPcode;
    String MobileNumber;
    String Email;




    // Crea una lista di stringhe con i nomi dei paesi
    List<String> countryList = new ArrayList<>();


    public void SaveWorkout(int numberWorkout) throws IOException, SQLException, TdeeRemoveException {

        boolean exit = true;
        while (exit) {

            Printer.print("\nSelect a payment method: ");
            Printer.print("1: Credit card");
            Printer.print("2: PayPal ");
            Printer.print("3: Bitcoin ");

            Printer.print("Or write 4 for back to the home");


            String userInput = getUserInput();

            switch (userInput) {
                case "1" -> {
                    creditCardInput();
                }
                case "2" -> {
                    while (exit) {
                        Printer.print("\nWrite the number of the workout you want to get preview about:");

                        int numberInput = Integer.parseInt(getUserInput());

                    }
                }
                case "3" -> {
                    if(UtilityAccess.getState() == State.LOGGED_IN) {
                        while (exit) {
                            Printer.print("\nWrite the number of the workout you want to buy about:");

                            int numberInput = Integer.parseInt(getUserInput());


                        }
                    } else {
                        Printer.print("\nTo purchase a workout you must be logged in");
                        GraphicsControllerCliLoginPage graphicsControllerCliLoginPage = new GraphicsControllerCliLoginPage();
                        graphicsControllerCliLoginPage.viewAccessPage();
                    }
                    exit = false;
                }
                case "4" -> {
                    backToHomePage();
                    exit = false;
                }
                default -> Printer.print("Invalid option.");
            }
        }
    }

    private void creditCardInput() throws IOException, SQLException, TdeeRemoveException {
        boolean exit = true;
        while (exit) {
            Printer.print("\nInsert Card number: ");
            String userInput = getUserInput();
            if(userInput.length() == 16 ){
                CardNumber = userInput;

                Printer.print("\nInsert Expires Card: ");
                String userInputExpires = getUserInput();
                if (userInputExpires.length() >= 4){
                    ExpiresCard = userInputExpires;

                    Printer.print("\nInsert CVV: ");
                    int userInputCVV = Integer.parseInt(getUserInput());
                    if (String.valueOf(userInputCVV).length() == 3){
                        CVV = userInputCVV;
                        Printer.print("\nEnter the First name written on the credit card: ");
                        String userInputFirstName = getUserInput();
                        if (userInputFirstName.length() < 1){
                            FirstName = userInputFirstName;
                            Printer.print("\nEnter the Last name written on the credit card: ");
                            String userInputLastName = getUserInput();
                            if (userInputLastName.length() < 1) {
                                LastName = userInputFirstName;
                                Printer.print("\nEnter street address: ");
                                String userStreetAddress = getUserInput();
                                if(userStreetAddress.length() < 3){
                                    StreetAddress = userStreetAddress;
                                    Printer.print("\nEnter apartment, building, ... : ");
                                    String userApartment = getUserInput();
                                    if (userApartment.length() < 2){
                                        Apartment = userApartment;
                                        Printer.print("\nEnter Nation: ");
                                        String userNation = getUserInput();
                                        if(userNation.length() < 2){
                                            StateUser = userNation;
                                            Printer.print("\nEnter ZIP code: ");
                                            int userZIPCode = Integer.parseInt(getUserInput());
                                            if (String.valueOf(userZIPCode).length() == 5 ){
                                                ZIPcode = userZIPCode;
                                                Printer.print("\nEnter mobile number: ");
                                                String userMobile = getUserInput();
                                                if (userMobile.length() < 9){
                                                    MobileNumber = userMobile;
                                                    Printer.print("\nEnter email: ");
                                                    String userEmail = getUserInput();
                                                    if (userEmail.length() < 4){
                                                        Email = userEmail;
                                                        Printer.print("\nInsertion completed, continue with payment? Enter \"yes\" to continue and \"no\" to return to the home page: ");
                                                        String userRespost = getUserInput();
                                                        if (userRespost.equals("yes")){
                                                            exit = true;
                                                        }else if (userRespost.equals("no")) {
                                                            backToHomePage();
                                                        } else Printer.print("\nInsertion completed, continue with payment? Enter \"yes\" to continue and \"no\" to return to the home page: ");;
                                                    } else Printer.print("Invalid value, check that you have entered email");
                                                } else Printer.print("Invalid value, check that you have entered mobile number");
                                            }else Printer.print("Invalid value, check that you have entered ZIP code, 5 number");
                                        }else Printer.print("Invalid value");
                                    } else Printer.print("Invalid value");
                                } else Printer.print("Invalid value");
                            } else Printer.print("Invalid value");
                        } else Printer.print("Invalid value");
                    } else Printer.print("Invalid value, check that you have entered CVV, 3 number");
                } else Printer.print("Invalid value, check that you have entered all the digits");
            } else Printer.print("Invalid value, check that you have entered all the digits");
        }
    }


    private String getUserInput() throws IOException {
        // to get user input
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine().trim();
    }

    private void backToHomePage() throws IOException, SQLException, TdeeRemoveException {
        GraphicsControllerCliHomePage homePage = new GraphicsControllerCliHomePage();
        homePage.displayHomepage();
    }

    private void printPaymentsMethods(List<WorkoutPlan> workoutPlanList) {
        // this method print all tdee of user
        //Printer.print("-------------------WORKOUT PLAN SOLD PAGE-------------------\n");

        int index = 1;
        for (WorkoutPlan workoutPlan : workoutPlanList) {
            Printer.print("\n_________");
            Printer.print(index + " Workout name:" + workoutPlan.getName());
            Printer.print(" Prize: " + workoutPlan.getPrize());
            Printer.print("_________");
            index++;
        }
    }
}
