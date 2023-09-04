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

    @Override
    public void removeData(Tdee entity){
    }

    private static final String FILE_NAME = "myTdee.txt";

    @Override
    public void saveData(Tdee instance) throws SQLException, IOException {
        Tdee tdee = new Tdee(instance.getKcal(), instance.getUsername(), instance.getPro(), instance.getFat(), instance.getCarb(), instance.getTarget(), instance.getQuantity());
        try {
            // I set the second parameter of the constructor of the file writer to true, in this way there is no overwriting
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE_NAME,true));
            String tdeeLocal = convertTdeeInTxt(tdee);
            fileWriter.write(tdeeLocal);
            fileWriter.newLine();
            fileWriter.close();
        } catch (IOException e) {
            throw new IOException("Problem with file writer\n");
        }
    }
    private String convertTdeeInTxt(Tdee tdee){
        return "Kcal: "+ tdee.getKcal()+
                "\nProtein: "+tdee.getPro()+
                "\nFat: "+tdee.getFat()+
                "\nCarb: "+tdee.getCarb()+
                "\nTarget: "+tdee.getTarget()+
                "\nQuantity: "+tdee.getQuantity();
    }

}
