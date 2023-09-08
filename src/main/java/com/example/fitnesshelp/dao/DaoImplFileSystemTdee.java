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
        throw new UnsupportedOperationException("showData method is implemented in the dao of db by default");
    }

    @Override
    public void removeData(Tdee entity){
        // this method is empty because by default this operation
        // are made on db
    }

    private static final String FILE_NAME = "myTdee.txt";

    @Override
    public void saveData(Tdee instance) throws SQLException, IOException {
        Tdee tdee = new Tdee(instance.getKcal(), instance.getUsername(), instance.getPro(), instance.getFat(), instance.getCarb(), instance.getTarget(), instance.getQuantity());
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            String tdeeLocal = convertTdeeInTxt(tdee);
            fileWriter.write(tdeeLocal);
            fileWriter.newLine();
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
