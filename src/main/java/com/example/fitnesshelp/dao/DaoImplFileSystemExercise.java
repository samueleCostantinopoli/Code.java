package com.example.fitnesshelp.dao;

import com.example.fitnesshelp.entities.Exercise;
import com.example.fitnesshelp.entities.Muscle;
import com.example.fitnesshelp.entities.WorkoutPlan;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoImplFileSystemExercise implements DaoEntity<Exercise>{

    private static final String FILE_NAME = "Exercise.txt";

    private int statusSave;


    @Override
    public void saveData(Exercise instance) throws SQLException, IOException {
        Exercise exerciseToSave = new Exercise(instance.getExercise(), instance.getMuscle(), instance.getSets(), instance.getReps(), instance.getRest(), instance.getWorkoutPlan());
        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE_NAME,true));
            fileWriter.write(exerciseToSave.getExercise());
            fileWriter.write("-");
            fileWriter.write(String.valueOf(exerciseToSave.getMuscle()));
            fileWriter.write("-");
            fileWriter.write(String.valueOf(exerciseToSave.getSets()));
            fileWriter.write("-");
            fileWriter.write(exerciseToSave.getReps());
            fileWriter.write("-");
            fileWriter.write(exerciseToSave.getWorkoutPlan().getName());
            fileWriter.write("-");
            fileWriter.write(exerciseToSave.getWorkoutPlan().getDay());
            fileWriter.write("-");
            fileWriter.write(exerciseToSave.getWorkoutPlan().getUsername());
            fileWriter.write("-");
            fileWriter.write(String.valueOf(exerciseToSave.getWorkoutPlan().getPrize()));

            fileWriter.newLine();
            fileWriter.close();
            statusSave =0;
        } catch (IOException e) {
            statusSave =1;
            throw new IOException("Problem with file writer\n");
        }
    }

    @Override
    public List showData(String username) throws IOException {
        List<Exercise> exerciseList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String exerciseName = reader.readLine(); // read the first line
            while (exerciseName != null) {
                String[] parts = exerciseName.split("-");
                if (parts.length == 9) {
                    String name = parts[0].trim();
                    Muscle muscle = Muscle.valueOf(parts[1].trim());
                    int sets = Integer.parseInt(parts[2].trim());
                    int reps = Integer.parseInt(parts[3].trim());
                    float rest = Float.parseFloat(parts[4].trim());
                    WorkoutPlan workoutAssociated = new WorkoutPlan(parts[5].trim(), parts[6].trim(), parts[7], Double.parseDouble(parts[8]) );

                    Exercise exercise = new Exercise(name, muscle, sets, reps, rest, workoutAssociated);
                    exerciseList.add(exercise);
                }
                exerciseName = reader.readLine();
            }
        } catch (IOException e) {
            //
        }
        return exerciseList;
    }


    @Override
    public void removeData(Exercise entity) throws SQLException, IOException {

    }
}
