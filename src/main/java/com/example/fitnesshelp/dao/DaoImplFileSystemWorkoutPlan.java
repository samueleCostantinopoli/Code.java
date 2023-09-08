package com.example.fitnesshelp.dao;

import com.example.fitnesshelp.entities.WorkoutPlan;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DaoImplFileSystemWorkoutPlan implements DaoEntity<WorkoutPlan> {

    private static final String FILE_NAME = "WorkoutPlan.txt";

    @Override
    public void saveData(WorkoutPlan instance) throws SQLException, IOException {
        WorkoutPlan workoutPlan = new WorkoutPlan(instance.getName(), instance.getDay(), instance.getUsername(), instance.getPrize());

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writeWorkoutPlanToFile(workoutPlan, fileWriter);
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
                    WorkoutPlan workoutPlan = createWorkoutPlanFromParts(parts);
                    workoutPlans.add(workoutPlan);
                }
                workoutName = reader.readLine();
            }
        } catch (IOException e) {
            // Handle the exception as needed
        }

        return workoutPlans;
    }

    @Override
    public void removeData(WorkoutPlan entity) {
        // Questo metodo è stato aggiunto per forza avendolo aggiunto nell'interfaccia
    }

    private void writeWorkoutPlanToFile(WorkoutPlan workoutPlan, BufferedWriter fileWriter) throws IOException {
        fileWriter.write(workoutPlan.getName());
        fileWriter.write("-");
        fileWriter.write(workoutPlan.getDay());

        String username = workoutPlan.getUsername();
        fileWriter.write("-");
        fileWriter.write(Objects.requireNonNullElse(username, "UsernameNotAvailable"));
        fileWriter.write("-");
        fileWriter.write(String.valueOf(workoutPlan.getPrize()));

        fileWriter.newLine();
    }

    private WorkoutPlan createWorkoutPlanFromParts(String[] parts) {
        String name = parts[0].trim();
        String category = parts[1].trim();
        String description = parts[2].trim();
        double prize;
        try {
            prize = Double.parseDouble(parts[3].trim());
        } catch (NumberFormatException e) {
            prize = 5.0;
        }
        return new WorkoutPlan(name, category, description, prize);
    }

    private int statusSave;

    public int getEsito() {
        return this.statusSave;
    }
}
