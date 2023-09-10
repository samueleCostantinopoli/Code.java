package com.example.fitnesshelp.cli_graphics_controller;

import com.example.fitnesshelp.application_controllers.ApplicationControllerCalculateTdee;
import com.example.fitnesshelp.entities.Macro;
import com.example.fitnesshelp.entities.Tdee;
import com.example.fitnesshelp.exception.TdeeRemoveException;
import com.example.fitnesshelp.factory.TypeOfPersistence;
import com.example.fitnesshelp.utils.Printer;
import com.example.fitnesshelp.utils.UtilityAccess;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

public class GraphicsControllerCliCalculateTdee3 {

    public void showResult(double kcal, String target) throws IOException, SQLException, TdeeRemoveException {
        Printer.print("------------------------YOUR TDEE-----------------------\n");
        DecimalFormat decimalFormat = new DecimalFormat("#");
        String formattedNumber = decimalFormat.format(kcal);
        Printer.print(target + " - calories per day: " + Integer.parseInt(formattedNumber));

        List<Macro> macroList = requestMacroList(formattedNumber);

        selectQuantityOfCarb(macroList, Integer.parseInt(formattedNumber), target);

    }

    private List<Macro> requestMacroList(String formattedNumber) {
        String modCarb = "moderate carb";
        String lowCarb = "lower carb";
        String highCarb = "higher carb";

        ApplicationControllerCalculateTdee applicationControllerCalculateTdee = new ApplicationControllerCalculateTdee();
        List<Macro> macroList = applicationControllerCalculateTdee.requestMacroList(Integer.parseInt(formattedNumber));

        int quantityIndex = 0;
        for (Macro macro : macroList) {
            String plan = switch (quantityIndex) {
                case 0 -> modCarb;
                case 1 -> lowCarb;
                case 2 -> highCarb;
                default -> null;
            };

            printMacroDetails(plan, macro);
            quantityIndex++;
        }

        return macroList;
    }

    private void selectQuantityOfCarb(List<Macro> macroList, int kcal, String target) throws IOException, SQLException, TdeeRemoveException {
        String modCarb = "moderate carb";
        String lowCarb = "lower carb";
        String highCarb = "higher carb";

        Printer.print("\nTo select a quantity of carb, type:\n1 for moderate carb\n2 for lower carb\n3 for higher carb\nor 4 to esc\n");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String quantity = "";
        Macro macro = new Macro(0f, 0f, 0f);

        while (!quantity.equals(modCarb) && !quantity.equals(lowCarb) && !quantity.equals(highCarb)) {
            String choice = bufferedReader.readLine();
            if (!isNumeric(choice)) {
                Printer.print("Please, digit a number\n");
            } else {
                switch (Integer.parseInt(choice)) {
                    case 1 -> {
                        macro = new Macro(macroList.get(0).getPro(), macroList.get(0).getFat(), macroList.get(0).getCarb());
                        quantity = modCarb;
                    }
                    case 2 -> {
                        macro = new Macro(macroList.get(1).getPro(), macroList.get(1).getFat(), macroList.get(1).getCarb());
                        quantity = lowCarb;
                    }
                    case 3 -> {
                        macro = new Macro(macroList.get(2).getPro(), macroList.get(2).getFat(), macroList.get(2).getCarb());
                        quantity = highCarb;
                    }
                    case 4 -> backToHomePage();
                    default -> Printer.print("Please, select a plan\n");
                }
            }
        }

        createAndSaveTdee(kcal, macro, quantity, target);
    }

    private void printMacroDetails(String plan, Macro macro) {
        Printer.print(plan + ":\n");
        Printer.print("Protein: " + macro.getPro());
        Printer.print("Fat: " + macro.getFat());
        Printer.print("Carb: " + macro.getCarb());
        Printer.print("------------------------");
    }

    private void createAndSaveTdee(int kcal, Macro macro, String quantity, String target) throws IOException, SQLException, TdeeRemoveException {

        Tdee tdee = new Tdee(kcal, UtilityAccess.getUsername(), macro.getPro(), macro.getFat(), macro.getCarb(), target, quantity);

        TypeOfPersistence typeOfPersistence = promptPersistenceType();

        if (typeOfPersistence == TypeOfPersistence.JDBC) {
            saveTdeeInDatabase(tdee);
        } else if (typeOfPersistence == TypeOfPersistence.FILE_SYSTEM) {
            saveTdeeInFileSystem(tdee);
        }

        // tdee saved, switch to 'my tdee' page
        Printer.print("tdee saved!\n");
        GraphicsControllerCliCalculateTdee0 graphicsControllerCliCalculateTdee0 = new GraphicsControllerCliCalculateTdee0();
        graphicsControllerCliCalculateTdee0.showTdee();
    }

    private TypeOfPersistence promptPersistenceType() throws IOException {
        TypeOfPersistence typeOfPersistence = null;
        Printer.print("where do you want to save the tdee?\n1 to save only in database\n2 to save in the file system\n ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (typeOfPersistence != TypeOfPersistence.JDBC && typeOfPersistence != TypeOfPersistence.FILE_SYSTEM) {
            String choicePersistance = bufferedReader.readLine();
            if (!isNumeric(choicePersistance)) {
                Printer.print("Please, digit a number\n");
            } else {
                if (Integer.parseInt(choicePersistance) == 2) {
                    typeOfPersistence = TypeOfPersistence.FILE_SYSTEM;
                } else if (Integer.parseInt(choicePersistance) == 1) {
                    typeOfPersistence = TypeOfPersistence.JDBC;
                } else {
                    Printer.print("Please, enter one of following numbers: 1, 2\n");
                }
            }
        }

        return typeOfPersistence;
    }

    private void saveTdeeInDatabase(Tdee tdee) throws SQLException, IOException {
        ApplicationControllerCalculateTdee applicationControllerCalculateTdee = new ApplicationControllerCalculateTdee();
        applicationControllerCalculateTdee.saveTdee(TypeOfPersistence.JDBC, tdee);
    }

    private void saveTdeeInFileSystem(Tdee tdee) throws IOException, SQLException {
        ApplicationControllerCalculateTdee applicationControllerCalculateTdee = new ApplicationControllerCalculateTdee();
        // Save only in the file system
        applicationControllerCalculateTdee.saveTdee(TypeOfPersistence.FILE_SYSTEM, tdee);
        // Also save in the db by default
        applicationControllerCalculateTdee.saveTdee(TypeOfPersistence.JDBC, tdee);
    }

    public void backToHomePage() throws SQLException, IOException, TdeeRemoveException {
        GraphicsControllerCliHomePage graphicsControllerCliHomePage = new GraphicsControllerCliHomePage();
        graphicsControllerCliHomePage.displayHomepage();
    }

    private boolean isNumeric(String str) {
        // this method verify if the age, weight and height are numeric
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
