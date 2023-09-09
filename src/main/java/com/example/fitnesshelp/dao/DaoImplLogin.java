package com.example.fitnesshelp.dao;

import com.example.fitnesshelp.entities.TypeOfUser;
import com.example.fitnesshelp.utils.Printer;
import com.example.fitnesshelp.utils.UtilityAccess;
import java.io.IOException;
import java.sql.*;

public class DaoImplLogin implements DaoLogin{
    private Connection connection;

    public DaoImplLogin() throws SQLException, IOException {
        connection = SingletonConnection.getInstance().getConnection();
    }

    @Override
    public boolean login(String username, String password) {
        boolean loginState = false;
        try (CallableStatement cs = connection.prepareCall("{call login(?, ?, ?, ?, ?)}")) {
            cs.setString(1, password);
            cs.setString(2, username);
            cs.registerOutParameter(3, Types.BOOLEAN);
            cs.registerOutParameter(4, Types.CHAR);
            cs.registerOutParameter(5, Types.CHAR);
            cs.executeQuery();
            loginState = cs.getBoolean(3);
            String role = cs.getString(4);
            String email = cs.getString(5);
            TypeOfUser typeOfUser = null;
            if (loginState) {
                typeOfUser = switch (role) {
                    case "normal user" -> TypeOfUser.NORMAL;
                    case "personal trainer" -> TypeOfUser.PERSONAL_TRAINER;
                    default -> null;
                };
            }
            UtilityAccess.setTypeOfUser(typeOfUser);
            UtilityAccess.setEmail(email);
        } catch (SQLException e) {
            Printer.print("Error: " + e.getMessage());
            return false;
        }
        return loginState;
    }
}
