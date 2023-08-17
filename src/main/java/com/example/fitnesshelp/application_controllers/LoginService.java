package com.example.fitnesshelp.application_controllers;

import com.example.fitnesshelp.model.Login;

public class LoginService {
    private final String username;
    private final String password;

    public LoginService(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValidUser(String username, String password) {
        // Effettua la verifica con un database o dati di esempio
        // In questo esempio, controlliamo se l'utente è "admin" con password "password"
        Login check = new Login("com/example/fitnesshelp/fileSystem");
        return check.authenticate(username, password);
    }
}
