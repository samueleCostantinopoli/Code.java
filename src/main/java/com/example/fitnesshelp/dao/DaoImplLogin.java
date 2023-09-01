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
            String typeOfUser = cs.getString(4);
            UtilityAccess.setUsername(typeOfUser);
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestisci l'eccezione
        }
        return loginState;
    }


    /*
    private Map<String, String> users;
    private File userFile;
    public DaoImplLogin(String filePath) {
        users = new HashMap<>();
        userFile = new File(filePath);
        loadUsersFromFile();
    }

    private void loadUsersFromFile() {
        if (!userFile.exists()) {
            createDefaultUserFile(userFile);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createDefaultUserFile(File file) {
        try {
            if (!file.createNewFile()) {// Crea il file vuoto se non esiste
                System.out.println("error");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean authenticate(String username, String password) {
        String storedPassword = users.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
     */
}
