package com.example.fitnesshelp.dao;

import com.example.fitnesshelp.entities.Tdee;
import com.example.fitnesshelp.entities.TypeOfUser;
import com.example.fitnesshelp.utils.UtilityAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DaoImplLogin implements DaoLogin{
    private Connection connection;

    public DaoImplLogin() throws SQLException, IOException {
        connection = SingletonConnection.getInstance().getConnection();
    }

    @Override
    public boolean login(String username, String password) {
        boolean loginState = false;
        try (CallableStatement cs = connection.prepareCall("{call login(?, ?, ?, ?)}")) {
            cs.setString(1, password);
            cs.setString(2, username);
            cs.registerOutParameter(3, Types.BOOLEAN);
            cs.registerOutParameter(4, Types.CHAR);
            ResultSet rs = cs.executeQuery();
            loginState = cs.getBoolean(3);
            String role = cs.getString(4);
            TypeOfUser typeOfUser;
            typeOfUser = switch (role){
                case "normal user" -> TypeOfUser.NORMAL;
                case "personal trainer" -> TypeOfUser.PERSONAL_TRAINER;
                default -> null;
            };
            UtilityAccess.setTypeOfUser(typeOfUser);
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestisci l'eccezione
        }
        return loginState;
    }
}
