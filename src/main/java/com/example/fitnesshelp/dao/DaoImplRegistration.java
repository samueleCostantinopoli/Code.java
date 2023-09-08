package com.example.fitnesshelp.dao;

import java.io.IOException;
import java.sql.*;

public class DaoImplRegistration implements DaoRegistration{

    private Connection connection;

    public DaoImplRegistration() throws SQLException, IOException {
        connection = SingletonConnection.getInstance().getConnection();
    }

    @Override
    public boolean checkEmail(String email){
        boolean checkForEmail = false;
        try (CallableStatement cs = connection.prepareCall("{call check_email(?, ?)}")) {
            cs.setString(1, email);
            cs.registerOutParameter(2, Types.BOOLEAN);
            cs.executeQuery();
            checkForEmail = cs.getBoolean(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkForEmail;
    }

    @Override
    public boolean checkUsername(String username){
        boolean checkForUsername = false;
        try (CallableStatement cs = connection.prepareCall("{call check_username(?, ?)}")) {
            cs.setString(1, username);
            cs.registerOutParameter(2, Types.BOOLEAN);
            cs.executeQuery();
            checkForUsername = cs.getBoolean(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkForUsername;
    }

    @Override
    public void registration(String email, String password, String typeOfUser, String username){
        try (CallableStatement cs = connection.prepareCall("{call registration(?, ?, ?, ?)}")) {
            cs.setString(1, email);
            cs.setString(2, password);
            cs.setString(3, typeOfUser);
            cs.setString(4, username);
            cs.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
