package com.example.fitnesshelp.application_controllers;

import com.example.fitnesshelp.bean.BeanPassword;
import com.example.fitnesshelp.bean.BeanUsername;
import com.example.fitnesshelp.dao.DaoImplLogin;
import com.example.fitnesshelp.exception.NotExistsUsersException;

import java.io.IOException;
import java.sql.SQLException;

public class ApplicationControllerLogin {
    private final String username;
    private final String password;

    public ApplicationControllerLogin(BeanUsername beanUsername, BeanPassword beanPassword) throws SQLException, IOException, NotExistsUsersException {
        this.username = beanUsername.getUsername();
        this.password = beanPassword.getPassword();
        checkUserAccount();
    }

    public void checkUserAccount() throws SQLException, IOException, NotExistsUsersException {
        DaoImplLogin daoImplLogin = new DaoImplLogin();
        // this method returns true if this account exist
        if(daoImplLogin.login(username, password)){
            // user is logged in
        } else {
            // the account does not exist
            throw new NotExistsUsersException("invalid credentials");
        }
    }

}
