package com.example.fitnesshelp.dao;

import com.example.fitnesshelp.entities.Tdee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DaoImplFileSystemTdee implements DaoEntity<Tdee>{

    @Override
    public List<Tdee> showData(String username){
        return null;
    }


    //dao che si occupa di salvare l'entità Tdee nel file system
    private static final String FILE_NAME = "Tdee.txt";
    private int statusSave;

    @Override
    public void saveData(Tdee instance) throws SQLException, IOException {
        Tdee tdee = new Tdee(instance.getKcal(), instance.getUsername(), instance.getPro(), instance.getFat(), instance.getCarb(), instance.getTarget(), instance.getQuantity());
        try {
            //imposto a true il secondo parametro del costruttore del file writer, in questo modo non c'e' sovrascrittura
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE_NAME,true));
            String tdeeLocal = convertTdeeInTxt(tdee);
            fileWriter.write(tdeeLocal);
            //vado a capo cosi la prossima volta che si scrive su quel file e' tutto piu ordinato e la segnalazione
            fileWriter.newLine();
            fileWriter.close();
            //tutto e' andato a buon fine, esito assumerà un valore che indica il successo
            statusSave =0;
        } catch (IOException e) {
            statusSave =1;
            throw new IOException("Problem with file writer\n");
        }
    }
    private String convertTdeeInTxt(Tdee tdee){
        return "Kcal: "+ tdee.getKcal()+
                "\nProtein: "+tdee.getPro()+
                "\nFat: "+tdee.getFat()+
                "\nCarbo: "+tdee.getCarb()+
                "\nTarget: "+tdee.getTarget()+
                "\nQuantity: "+tdee.getQuantity()+
                "\nState: Not in database";
    }
    public int getEsito(){
        return this.statusSave;
    }

}
