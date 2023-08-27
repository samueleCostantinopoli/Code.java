package com.example.fitnesshelp.dao;

import com.example.fitnesshelp.entities.WorkoutPlan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DaoImplFilSystemWorkoutPlan implements DaoEntity<WorkoutPlan>{

    @Override
    public List<WorkoutPlan> showData(String username){
        return null;
    }

    //dao che si occupa di salvare l'entità WorkoutPlan nel file system
    private static final String FILE_NAME = "WorkoutPlan.txt";
    //variabile che viene cambiata in base all'esito del salvataggio della buca stradale nel file system
    //molto utile nel momento di testare il metodo SaveEntitaStradale
    private int statusSave;

    @Override
    public void saveData(WorkoutPlan instance) throws SQLException, IOException {
        WorkoutPlan workoutPlan = new WorkoutPlan(instance.getName(), instance.getDay(), instance.getUsername());
        try {
            //imposto a true il secondo parametro del costruttore del file writer, in questo modo non c'e' sovrascrittura
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE_NAME,true));
            String workoutPlanLocal = convertWorkoutInTxt(workoutPlan);
            fileWriter.write(workoutPlanLocal);
            //vado a capo cosi la prossima volta che si scrive su quel file e' tutto piu ordinato e la segnalazione
            //nuova non si attaccherà alla vecchia
            fileWriter.newLine();
            fileWriter.close();
            //tutto e' andato a buon fine, esito assumerà un valore che indica il successo
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
