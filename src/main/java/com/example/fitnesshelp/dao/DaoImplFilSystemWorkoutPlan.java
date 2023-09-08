package com.example.fitnesshelp.dao;


import com.example.fitnesshelp.entities.WorkoutPlan;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class DaoImplFilSystemWorkoutPlan implements DaoEntity<WorkoutPlan>{

    private static final String FILE_NAME = "WorkoutPlan.txt";

    @Override
    public void saveData(WorkoutPlan instance) throws SQLException, IOException {
        WorkoutPlan workoutPlan = new WorkoutPlan(instance.getName(), instance.getDay(), instance.getUsername(), instance.getPrize());

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            fileWriter.write(workoutPlan.getName());
            fileWriter.write("-");
            fileWriter.write(workoutPlan.getDay());

            String username = workoutPlan.getUsername();
            fileWriter.write("-");
            if (username != null) {
                fileWriter.write(username);
            } else {
                fileWriter.write("UsernameNotAvailable");
            }
            fileWriter.write("-");
            fileWriter.write(String.valueOf(workoutPlan.getPrize()));

            fileWriter.newLine();

            statusSave = 0;
        } catch (IOException e) {
            statusSave = 1;
            throw new IOException("Problem with file writer\n");
        }
    }


    @Override
    public List<WorkoutPlan> showData(String username) throws IOException {
        List<WorkoutPlan> workoutPlans = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String workoutName = reader.readLine(); // read the first line
            while (workoutName != null) {
                String[] parts = workoutName.split("-");
                if (parts.length == 4) {
                    String name = parts[0].trim();
                    String category = parts[1].trim();
                    String description = parts[2].trim();
                    double prize;
                    try {
                        prize = Double.parseDouble(parts[3].trim());
                    } catch (NumberFormatException e) {
                        prize = 5.0;
                    }
                    WorkoutPlan workoutPlan = new WorkoutPlan(name, category, description, prize);
                    workoutPlans.add(workoutPlan);
                }
                workoutName = reader.readLine(); 
            }
        } catch (IOException e) {
            // 
        }

        return workoutPlans;
    }

    @Override
    public void removeData(WorkoutPlan entity) {
        // questo metodo ho dovuto aggiungerlo per forza avendolo aggiunto nell'interfaccia
    }


    private int statusSave;

    public int getEsito(){
        return this.statusSave;
    }
}
