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
    public List<Tdee> showData(){
        return null;
    }
}
