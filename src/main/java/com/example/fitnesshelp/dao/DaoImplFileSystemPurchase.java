package com.example.fitnesshelp.dao;

import com.example.fitnesshelp.entities.Purchase;
import com.example.fitnesshelp.entities.WorkoutPlan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DaoImplFileSystemPurchase implements DaoEntity<Purchase>{
    //dao che si occupa di salvare l'entità WorkoutPlan nel file system
    private static final String FILE_NAME = "Purchase.txt";
    //variabile che viene cambiata in base all'esito del salvataggio della buca stradale nel file system
    //molto utile nel momento di testare il metodo SaveEntitaStradale
    private int statusSave;

    @Override
    public void saveData(Purchase instance) throws SQLException, IOException {
        //se sono qui voglio salvare su file system la buca
        Purchase purchase = new Purchase(instance.getIdPurchase(), instance.getPrice(), instance.getDate(), instance.getUsername(),instance.getWorkoutPlan());
        //adesso devo salvarla in locale
        try {
            //imposto a true il secondo parametro del costruttore del file writer, in questo modo non c'e' sovrascrittura
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE_NAME,true));
            String purchaseLocal = convertWorkoutInTxt(purchase);
            fileWriter.write(purchaseLocal);
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
    private String convertWorkoutInTxt(Purchase purchase){
        return "ID pagamento "+ purchase.getIdPurchase()+
                "\nCosto del workout "+ purchase.getPrice()+
                "\nacquistato il giorno: "+purchase.getDate()+
                "\ncreato da: "+purchase.getUsername()+
                "\nnome workout: "+purchase.getWorkoutPlan()+
                "\nstato: ancora non segnalato al database";
    }
    public int getEsito(){
        return this.statusSave;
    }

    @Override
    public List<Purchase> showData(String username){
        return null;
    }

}
