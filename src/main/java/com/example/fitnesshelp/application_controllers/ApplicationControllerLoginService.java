package com.example.fitnesshelp.application_controllers;

import com.example.fitnesshelp.bean.BeanLogin;
import com.example.fitnesshelp.dao.DaoImplLogin;

public class ApplicationControllerLoginService {
    private final String email;
    private final String password;

    public ApplicationControllerLoginService(BeanLogin beanLogin) {
        this.email = beanLogin.getEmail();
        this.password = beanLogin.getPassword();
    }

    public boolean isValidUser(String username, String password) {
        // Effettua la verifica con un database o dati di esempio
        DaoImplLogin check = new DaoImplLogin("C:\\Users\\Samuele\\OneDrive - Universita' degli Studi di Roma Tor Vergata\\Università\\Materie\\3 anno\\ISPW\\src\\main\\java\\com\\example\\fitnesshelp\\fileSystem");
        return check.authenticate(username, password);
    }
}
