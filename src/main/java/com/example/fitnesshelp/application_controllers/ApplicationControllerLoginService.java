package com.example.fitnesshelp.application_controllers;

import com.example.fitnesshelp.bean.BeanLogin;
import com.example.fitnesshelp.model.ModelLogin;

public class ApplicationControllerLoginService {
    private final String email;
    private final String password;

    public ApplicationControllerLoginService(BeanLogin beanLogin) {
        this.email = beanLogin.getEmail();
        this.password = beanLogin.getPassword();
    }

    public boolean isValidUser(String username, String password) {
        // Effettua la verifica con un database o dati di esempio
        ModelLogin check = new ModelLogin("C:\\Users\\Samuele\\OneDrive - Universita' degli Studi di Roma Tor Vergata\\Università\\Materie\\3 anno\\ISPW\\src\\main\\java\\com\\example\\fitnesshelp\\fileSystem");
        return check.authenticate(username, password);
    }
}
