package com.example.fitnesshelp.dao;

import com.example.fitnesshelp.entities.Exercise;
import com.example.fitnesshelp.entities.WorkoutPlan;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class DaoImplFilSystemWorkoutPlan implements DaoEntity<WorkoutPlan>{

    private static final String FILE_NAME = "WorkoutPlan.txt";
    List<String> lines = new ArrayList<>();


    @Override
    public List<WorkoutPlan> showData(String username) throws IOException {
        File fileSys = new File(FILE_NAME);
        List<WorkoutPlan> workoutPlans = new ArrayList<>();

        if (!fileSys.exists()) {
            try {
                fileSys.createNewFile();
            } catch (IOException e) {
                throw new IOException("Problem creating file\n");
            }
        }

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
                    System.out.println(workoutPlan.getName() + workoutPlan.getPrize());
                }
                workoutName = reader.readLine(); 
            }
        } catch (IOException e) {
            // 
        }

        return workoutPlans;
    }

    @Override
    public void removeData(WorkoutPlan entity) throws SQLException, IOException {
        // questo metodo ho dovuto aggiungerlo per forza avendolo aggiunto nell'interfaccia
    }


    private int statusSave;

    @Override
    public void saveData(WorkoutPlan instance) throws SQLException, IOException {
        WorkoutPlan workoutPlan = new WorkoutPlan(instance.getName(), instance.getDay(), instance.getUsername(), instance.getPrize());
        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE_NAME,true));
            convertWorkoutInTxt(workoutPlan);
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
            System.out.println(String.valueOf(workoutPlan.getPrize()));
            fileWriter.write(String.valueOf(workoutPlan.getPrize()));

            fileWriter.newLine();
            fileWriter.close();
            statusSave =0;
        } catch (IOException e) {
            statusSave =1;
            throw new IOException("Problem with file writer\n");
        }
    }
    private String convertWorkoutInTxt(WorkoutPlan workoutPlan){
        return "Workout name: "+ workoutPlan.getName()+"\nNumber of day:"+ workoutPlan.getDay() +"\nCreator: "+workoutPlan.getUsername();
    }
    public int getEsito(){
        return this.statusSave;
    }
}
