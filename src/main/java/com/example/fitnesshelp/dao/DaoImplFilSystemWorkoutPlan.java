package com.example.fitnesshelp.dao;

import com.example.fitnesshelp.entities.WorkoutPlan;
import com.example.fitnesshelp.exception.ExceptionErrorReadPass;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DaoImplFilSystemWorkoutPlan implements DaoEntity<WorkoutPlan>{

    @Override
    public List<WorkoutPlan> showData(){
        return null;
    }

    //dao che si occupa di salvare l'entità WorkoutPlan nel file system
    private static final String FILE_NAME = "WorkoutPlan.txt";
    //variabile che viene cambiata in base all'esito del salvataggio della buca stradale nel file system
    //molto utile nel momento di testare il metodo SaveEntitaStradale
    private int statusSave;

    @Override
    public void saveData(WorkoutPlan instance) throws SQLException, IOException {
        //se sono qui voglio salvare su file system la buca
        WorkoutPlan workoutPlan = new WorkoutPlan(instance.getName(), instance.getDay(), instance.getUsername());
        //adesso devo salvarla in locale
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
            throw new IOException("problema con il file writer");
        }
    }
    private String convertWorkoutInTxt(WorkoutPlan workoutPlan){
        return "Nome del workout "+ workoutPlan.getName()+"\ncreato da: "+workoutPlan.getUsername()+"\nstato: ancora non segnalato al database";
    }
    public int getEsito(){
        return this.statusSave;
    }
}
