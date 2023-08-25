package com.example.fitnesshelp.dao;

import com.example.fitnesshelp.entities.State;

import java.io.IOException;
import java.sql.*;

public class DaoImplRegistration implements DaoRegistration{

    private Connection connection;

    public DaoImplRegistration() throws SQLException, IOException {
        connection = SingletonConnection.getInstance().getConnection();
    }

    @Override
    public boolean checkRegistration(String email, String username){
        boolean checkForRegistration = false;
        try (CallableStatement cs = connection.prepareCall("{call check_registration(?, ?)}")) {
            cs.setString(1, email);
            cs.setString(2, username);
            cs.registerOutParameter(3, Types.BOOLEAN);
            ResultSet rs = cs.executeQuery();
            checkForRegistration = cs.getBoolean(3);
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestisci l'eccezione
        }
        return checkForRegistration;
    }

    @Override
    public void registration(String email, String password, State role, String username){
        try (CallableStatement cs = connection.prepareCall("{call registration(?, ?, ?, ?)}")) {
            cs.setString(1, email);
            cs.setString(2, password);
            cs.setString(3, role.toString());
            cs.setString(4, username);
            ResultSet rs = cs.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestisci l'eccezione
        }
    }
}
