package com.example.fitnesshelp.cli_graphics_controller;

import com.example.fitnesshelp.application_controllers.ApplicationControllerCalculateTdee;
import com.example.fitnesshelp.entities.Macro;
import com.example.fitnesshelp.entities.Tdee;
import com.example.fitnesshelp.factory.TypeOfPersistence;
import com.example.fitnesshelp.utils.UtilityAccess;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

public class GraphicsControllerCliCalculateTdee3 {

    public void showResult(double kcal, String target) throws IOException, SQLException {
        System.out.println("------------------------YOUR TDEE-----------------------\n");
        // take only integer part of kcal
        DecimalFormat decimalFormat = new DecimalFormat("#");
        String formattedNumber = decimalFormat.format(kcal);
        System.out.println(target + " - calories per day: " + Integer.parseInt(formattedNumber));
        String modCarb = "moderate carb";
        String lowCarb = "lower carb";
        String highCarb = "higher carb";
        System.out.println("\nFor select a quantity of carb, type:\n1 for moderate carb\n2 for lower carb\n3 for higher carb\n");
        // now I can request the partition of macro at tdee calculator via application controller
        List<Macro> macroList;
        ApplicationControllerCalculateTdee applicationControllerCalculateTdee = new ApplicationControllerCalculateTdee();
        macroList = applicationControllerCalculateTdee.requestMacroList(Integer.parseInt(formattedNumber));
        int quantityIndex = 0;
        for (Macro macro : macroList) {

            String plan = switch (quantityIndex){
                case 0 -> modCarb;
                case 1 -> lowCarb;
                case 2 -> highCarb;
                default -> null;
            };

            System.out.println(plan + ":\n");
            System.out.println("Protein: " + macro.getPro());
            System.out.println("Fat: " + macro.getFat());
            System.out.println("Carb: " + macro.getCarb());
            System.out.println("------------------------");

            quantityIndex ++;
        }
        // select a plan
        System.out.println("\nTo select a quantity of carb, type:\n1 for moderate carb\n2 for lower carb\n3 for higher carb\nor 4 to esc\n");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String quantity = "";
        Macro macro = new Macro(0f, 0f, 0f);
        while (!quantity.equals("moderate carb") && !quantity.equals("lower carb") && !quantity.equals("higher carb")){
            String choice = bufferedReader.readLine();
            switch (Integer.parseInt(choice)){
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
                default -> System.out.println("Please, select a plan\n");
            }
        }

        // create a tdee based on choices of user
        Tdee tdee = new Tdee(Integer.parseInt(formattedNumber), UtilityAccess.getUsername(), macro.getPro(), macro.getFat(), macro.getCarb(), target, quantity);

        // save tdee in db/fs
        TypeOfPersistence typeOfPersistence = null;
        System.out.println("where do you want to save the tdee?\n1 to save only in database\n2 to save in the file system\n ");
        while (typeOfPersistence != TypeOfPersistence.JDBC && typeOfPersistence != TypeOfPersistence.FILE_SYSTEM){
            String choicePersistance = bufferedReader.readLine();
            if (Integer.parseInt(choicePersistance) == 2){
                // save only in file system
                applicationControllerCalculateTdee.saveTdee(TypeOfPersistence.FILE_SYSTEM, tdee);
                // also save in the db by default
                applicationControllerCalculateTdee.saveTdee(TypeOfPersistence.JDBC, tdee);
                typeOfPersistence = TypeOfPersistence.FILE_SYSTEM;
            }
            if (Integer.parseInt(choicePersistance) == 1){
                applicationControllerCalculateTdee.saveTdee(TypeOfPersistence.JDBC, tdee);
                typeOfPersistence = TypeOfPersistence.JDBC;
            }
            System.out.println("Please, enter one of following number: 1, 2\n");
        }

        // tdee saved, switch on 'my tdee' page
        System.out.println("tdee saved!\n");
        GraphicsControllerCliCalculateTdee0 graphicsControllerCliCalculateTdee0 = new GraphicsControllerCliCalculateTdee0();
        graphicsControllerCliCalculateTdee0.showTdee();

    }

    public void backToHomePage() throws SQLException, IOException {
        GraphicsControllerCliHomePage graphicsControllerCliHomePage = new GraphicsControllerCliHomePage();
        graphicsControllerCliHomePage.displayHomepage();
    }
}
