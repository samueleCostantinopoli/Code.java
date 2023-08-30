package com.example.fitnesshelp.dao;

import com.example.fitnesshelp.entities.WorkoutPlan;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoImplFilSystemWorkoutPlan implements DaoEntity<WorkoutPlan>{

    private static final String FILE_NAME = "WorkoutPlan.txt";
    List<String> lines = new ArrayList<>();
    @Override
    public List<WorkoutPlan> showData(String username) throws IOException {
        return null;
    }

    public List<String> checkWorkout () throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String WorkoutName = reader.readLine(); // read the first line
            while (!WorkoutName.trim().isEmpty()) {
                lines.add(WorkoutName);
                System.out.println(WorkoutName); // print the line
                WorkoutName = reader.readLine(); // read another line
            }
        } catch (IOException e) {
            throw new IOException("Problem with file read\n");
        }
        return lines;
    }


    //variabile che viene cambiata in base all'esito del salvataggio della buca stradale nel file system
    //molto utile nel momento di testare il metodo SaveEntitaStradale
    private int statusSave;

    @Override
    public void saveData(WorkoutPlan instance) throws SQLException, IOException {
        WorkoutPlan workoutPlan = new WorkoutPlan(instance.getName(), instance.getDay(), instance.getUsername());
        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE_NAME,true));
            String workoutPlanLocal = convertWorkoutInTxt(workoutPlan);
            fileWriter.write(workoutPlanLocal);
            //vado a capo cosi la prossima volta che si scrive su quel file e' tutto piu ordinato e la segnalazione
            //nuova non si attaccherà alla vecchia
            fileWriter.newLine();
            fileWriter.close();
            statusSave =0;
        } catch (IOException e) {
            statusSave =1;
            throw new IOException("Problem with file writer\n");
        }
    }
    private String convertWorkoutInTxt(WorkoutPlan workoutPlan){
        return "Workout name: "+ workoutPlan.getName()+"\nCreator: "+workoutPlan.getUsername()+"\nState: Not in database";
    }
    public int getEsito(){
        return this.statusSave;
    }
}
