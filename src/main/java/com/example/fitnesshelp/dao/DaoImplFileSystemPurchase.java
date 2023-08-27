package com.example.fitnesshelp.dao;

import com.example.fitnesshelp.entities.Purchase;
import com.example.fitnesshelp.entities.WorkoutPlan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DaoImplFileSystemPurchase implements DaoEntity<Purchase>{
    //dao che si occupa di salvare l'entità Purchase nel file system
    private static final String FILE_NAME = "Purchase.txt";
    private int statusSave;

    @Override
    public void saveData(Purchase instance) throws SQLException, IOException {
        Purchase purchase = new Purchase(instance.getIdPurchase(), instance.getPrice(), instance.getDate(), instance.getUsername(),instance.getWorkoutPlan());
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
                "\nWorkout cost: "+ purchase.getPrice()+
                "\nDate of purchase: "+purchase.getDate()+
                "\nCreator: "+purchase.getUsername()+
                "\nWorkout name: "+purchase.getWorkoutPlan()+
                "\nState: Not in database";
    }
    public int getEsito(){
        return this.statusSave;
    }

    @Override
    public List<Purchase> showData(String username){
        return null;
    }

}
