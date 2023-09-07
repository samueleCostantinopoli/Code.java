package com.example.fitnesshelp.dao;

import com.example.fitnesshelp.entities.Purchase;
import com.example.fitnesshelp.entities.WorkoutPlan;

import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DaoImplFileSystemPurchase implements DaoEntity<Purchase>{
    //dao che si occupa di salvare l'entità Purchase nel file system
    private static final String FILE_NAME = "Purchase.txt";

    @Override
    public void saveData(Purchase instance) throws SQLException, IOException {
        Purchase purchase = new Purchase(instance.getIdPurchase(), instance.getPrice(), instance.getDate(), instance.getUsername(), instance.getWorkoutPlan());
        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE_NAME, true));

            fileWriter.write(String.valueOf(purchase.getIdPurchase()));
            fileWriter.write("-");
            fileWriter.write(String.valueOf(purchase.getPrice()));
            fileWriter.write("-");
            fileWriter.write(String.valueOf(purchase.getDate()));
            fileWriter.write("-");
            fileWriter.write(purchase.getUsername());
            fileWriter.write("-");
            fileWriter.write(purchase.getWorkoutPlan().getName());
            fileWriter.write("-");
            fileWriter.write(purchase.getWorkoutPlan().getDay());
            fileWriter.write("-");
            fileWriter.write(purchase.getWorkoutPlan().getUsername());
            fileWriter.write("-");
            fileWriter.write(String.valueOf(purchase.getWorkoutPlan().getPrize()));

            fileWriter.newLine();
            fileWriter.close();
        } catch (IOException e) {
            throw new IOException("Problem with file writer\n");
        }
    }


    @Override
    public List<Purchase> showData(String username){
        List<Purchase> purchaseArrayList = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String purchaseDate = reader.readLine(); // read the first line
            while (purchaseDate != null) {
                String[] parts = purchaseDate.split("-");
                if (parts.length == 8) {
                    int ID = Integer.parseInt(parts[0]);
                    double price = Double.parseDouble(parts[1]);
                    Date date = dateFormat.parse(parts[2]);
                    String userBuyer = parts[3].trim();
                    WorkoutPlan workoutAssociated = new WorkoutPlan(parts[4], parts[5], parts[6], Double.parseDouble(parts[7]));

                    Purchase purchase = new Purchase(ID, price, date, userBuyer, workoutAssociated);
                    purchaseArrayList.add(purchase);
                }
                purchaseDate = reader.readLine();

            }
        } catch (IOException | ParseException e) {
            System.out.println("Problem with read file\n");
            e.printStackTrace(); // Stampa il messaggio di errore
        }
        return purchaseArrayList;
    }

    @Override
    public void removeData(Purchase entity) throws SQLException, IOException {

    }

}
