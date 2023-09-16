package com.example.fitnesshelp.cli_graphics_controller;

import com.example.fitnesshelp.entities.WorkoutPlan;
import com.example.fitnesshelp.exception.ExerciseLoadException;
import com.example.fitnesshelp.exception.PurchaseUserLoadException;
import com.example.fitnesshelp.exception.TdeeRemoveException;
import com.example.fitnesshelp.utils.Printer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class GraphicsControllerCliBuyWorkoutPlanSetPayments {

    String cardNumber;
    String expiresCard;
    int cvv;
    String firstName;
    String lastName;
    String streetAddress;
    String apartment;
    String city;
    String stateUser;
    int zipCode;
    String mobileNumber;
    String email;

    WorkoutPlan thisWorkout;

    public void saveWorkout(WorkoutPlan workout) throws IOException, SQLException, TdeeRemoveException, ExerciseLoadException, PurchaseUserLoadException {
        thisWorkout = workout;
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
                    paymentDone();
                    exit = false;
                }
                case "2" -> {
                    payPalInput();
                    paymentDone();
                    exit = false;

                }
                case "3" -> {
                    bitcoinInput();
                    paymentDone();
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

    private void paymentDone() throws SQLException, IOException, TdeeRemoveException, ExerciseLoadException, PurchaseUserLoadException {
        try {
            Thread.sleep(5000); // Attend for 5 second
        } catch (InterruptedException e) {
            // Restore the stopped state of the current thread
            Thread.currentThread().interrupt();
            Printer.print("Problem with payments");
        }
        Printer.print("\nPayment done");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Restore the stopped state of the current thread
            Thread.currentThread().interrupt();
        }

        GraphicsControllerCliBuyWorkoutPlanPurchase graphicsControllerCliBuyWorkoutPlanPurchase = new GraphicsControllerCliBuyWorkoutPlanPurchase();
        graphicsControllerCliBuyWorkoutPlanPurchase.savePurchase(thisWorkout);
    }


    private void bitcoinInput() {
        Printer.print("\nNot yet implemented");
        Printer.print("""
                if you want you can make a donation ;). Bitcoin address:
                "-------------------bc1qqu4l3sueuqxm9fdr9puqp4vl905lq57l4zzcz2-------------------
                """);
    }

    private void payPalInput() {
        Printer.print("\nNot yet implemented");
        Printer.print("""
                if you want you can make a donation ;)
                "-------------------https://www.paypal.me/sCostantinopoli
                """);

    }

    private void creditCardInput() throws IOException, SQLException, TdeeRemoveException {
        boolean exit = true;

        while (exit) {
            cardNumber = getCreditCardNumber();
            expiresCard = getExpiresCard();
            cvv = getCVV();
            firstName = getFirstName();
            lastName = getLastName();
            streetAddress = getStreetAddress();
            apartment = getApartment();
            city = getCity();
            stateUser = getState();
            zipCode = getZIPCode();
            mobileNumber = getMobileNumber();
            email = getEmail();

            Printer.print("\nInsertion completed, continue with payment? Enter \"yes\" to continue and \"no\" to return to the home page: ");
            String userAnswer = getUserInput();

            if (userAnswer.equals("yes")) {
                exit = false;
            } else if (userAnswer.equals("no")) {
                backToHomePage();
            } else {
                Printer.print("\nInvalid answer, please enter \"yes\" or \"no\".");
            }
        }
    }

    private String getCreditCardNumber() throws IOException {
        while (true) {
            Printer.print("\nInsert Card number: ");
            String userInput = getUserInput();

            if (userInput.length() == 16) {
                return userInput;
            } else {
                Printer.print("Invalid value, check that you have entered all 16 digits.");
            }
        }
    }

    private String getExpiresCard() throws IOException {
        while (true) {
            Printer.print("\nInsert Expires Card: ");
            String userInputExpires = getUserInput();

            if (userInputExpires.length() >= 4) {
                return userInputExpires;
            } else {
                Printer.print("Invalid value, check that you have entered all the required digits.");
            }
        }
    }

    private String getFirstName() throws IOException {
        while (true) {
            Printer.print("\nEnter the First name written on the credit card: ");
            String userInputFirstName = getUserInput();

            if (userInputFirstName.length() > 1) {
                return userInputFirstName;
            } else {
                Printer.print("Invalid value, please enter a valid First Name.");
            }
        }
    }

    private String getLastName() throws IOException {
        while (true) {
            Printer.print("\nEnter the Last name written on the credit card: ");
            String userInputLastName = getUserInput();

            if (userInputLastName.length() > 1) {
                return userInputLastName;
            } else {
                Printer.print("Invalid value, please enter a valid Last Name.");
            }
        }
    }

    private String getStreetAddress() throws IOException {
        while (true) {
            Printer.print("\nEnter street address: ");
            String userStreetAddress = getUserInput();

            if (userStreetAddress.length() > 3) {
                return userStreetAddress;
            } else {
                Printer.print("Invalid value, please enter a valid Street Address.");
            }
        }
    }

    private String getApartment() throws IOException {
        while (true) {
            Printer.print("\nEnter apartment, building, ... : ");
            String userApartment = getUserInput();

            if (userApartment.length() > 2) {
                return userApartment;
            } else {
                Printer.print("Invalid value, please enter a valid Apartment/Building.");
            }
        }
    }

    private String getCity() throws IOException {
        while (true) {
            Printer.print("\nEnter city: ");
            String userCity = getUserInput();

            if (userCity.length() > 2) {
                return userCity;
            } else {
                Printer.print("Invalid value, please enter a valid City.");
            }
        }
    }

    private String getState() throws IOException {
        while (true) {
            Printer.print("\nEnter Nation: ");
            String userNation = getUserInput();

            if (userNation.length() > 2) {
                return userNation;
            } else {
                Printer.print("Invalid value, please enter a valid Nation.");
            }
        }
    }

    private int getZIPCode() throws IOException {
        while (true) {
            Printer.print("\nEnter ZIP code: ");
            int userZIPCode = Integer.parseInt(getUserInput());

            if (String.valueOf(userZIPCode).length() == 5) {
                return userZIPCode;
            } else {
                Printer.print("Invalid value, please enter a valid ZIP code with 5 digits.");
            }
        }
    }

    private String getMobileNumber() throws IOException {
        while (true) {
            Printer.print("\nEnter mobile number: ");
            String userMobile = getUserInput();

            if (userMobile.length() < 9) {
                return userMobile;
            } else {
                Printer.print("Invalid value, please enter a valid Mobile Number.");
            }
        }
    }

    private int getCVV() throws IOException {
        while (true) {
            Printer.print("\nInsert CVV: ");
            int userInputCVV = Integer.parseInt(getUserInput());

            if (String.valueOf(userInputCVV).length() == 3) {
                return userInputCVV;
            } else {
                Printer.print("Invalid value, check that you have entered CVV, 3 numbers.");
            }
        }
    }

    private String getEmail() throws IOException {
        while (true) {
            Printer.print("\nEnter email: ");
            String userEmail = getUserInput();

            if (userEmail.length() >= 4) {
                return userEmail;
            } else {
                Printer.print("Invalid value, check that you have entered an email.");
            }
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
}
