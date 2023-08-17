package com.example.fitnesshelp.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ModelLogin {
    private Map<String, String> users;
    private File userFile;
    public ModelLogin(String filePath) {
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
}
