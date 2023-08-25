package com.example.fitnesshelp.dao;

import com.example.fitnesshelp.entities.Tdee;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DaoImplJDBCTdee implements DaoEntity<Tdee>{

    private Connection connection;

    public DaoImplJDBCTdee() throws SQLException, IOException {
        connection = SingletonConnection.getInstance().getConnection();
    }

    @Override
    public void saveData(Tdee tdee) throws SQLException {
        try (CallableStatement cs = connection.prepareCall("{call add_tdee(?, ?, ?, ?, ?, ?, ?)}")) {
            cs.setDouble(1, tdee.getKcal());
            cs.setString(2, tdee.getTarget());
            cs.setString(3, tdee.getQuantity());
            cs.setFloat(4, tdee.getPro());
            cs.setFloat(5, tdee.getFat());
            cs.setFloat(6, tdee.getCarb());
            cs.setString(7, tdee.getUsername());
            ResultSet rs = cs.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestisci l'eccezione
        }
    }

    @Override
    public List<Tdee> showData(String username){
        List<Tdee> listOfTdee = null;
        try (CallableStatement cs = connection.prepareCall("{call list_of_tdee(?)}")) {
            cs.setString(1, username);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                int kcal = rs.getInt("kcal");
                String user = rs.getString("username");
                float pro = rs.getFloat("pro");
                float fat = rs.getFloat("fat");
                float carb = rs.getFloat("carb");
                String target = rs.getString("target");
                String quantity = rs.getString("quantity");

                Tdee tdee = new Tdee(kcal, user, pro, fat, carb, target, quantity);
                listOfTdee.add(tdee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestisci l'eccezione
        }
        return listOfTdee;
    }
}
