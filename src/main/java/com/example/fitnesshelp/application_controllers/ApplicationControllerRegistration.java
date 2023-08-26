package com.example.fitnesshelp.application_controllers;

import com.example.fitnesshelp.bean.BeanAccountType;
import com.example.fitnesshelp.bean.BeanEmail;
import com.example.fitnesshelp.bean.BeanPassword;
import com.example.fitnesshelp.bean.BeanUsername;
import com.example.fitnesshelp.dao.DaoImplLogin;
import com.example.fitnesshelp.dao.DaoImplRegistration;
import com.example.fitnesshelp.entities.TypeOfUser;
import com.example.fitnesshelp.exception.EmailAlreadyExistException;
import com.example.fitnesshelp.exception.NotExistsUsersException;
import com.example.fitnesshelp.exception.UsernameAlreadyExistException;

import java.io.IOException;
import java.sql.SQLException;

public class ApplicationControllerRegistration {

    private final String username;
    private final String password;
    private final String typeOfUser;
    private final String email;

    public ApplicationControllerRegistration(BeanUsername beanUsername, BeanEmail beanEmail, BeanPassword beanPassword, BeanAccountType beanAccountType) throws SQLException, IOException, EmailAlreadyExistException, UsernameAlreadyExistException {
        this.username = beanUsername.getUsername();
        this.password = beanPassword.getPassword();
        this.email = beanEmail.getEmail();
        this.typeOfUser = beanAccountType.getTypeOfUser();
        checkCredentials();
    }

    public void checkCredentials() throws SQLException, IOException, EmailAlreadyExistException, UsernameAlreadyExistException {
        DaoImplRegistration daoImplRegistration = new DaoImplRegistration();
        // this method returns true if credentials not already exists
        if (daoImplRegistration.checkEmail(email) && daoImplRegistration.checkUsername(username)){
            // the user can be registered now
            daoImplRegistration.registration(email, password, typeOfUser, username);
            return;
        } else if (!daoImplRegistration.checkEmail(email)) {
            // email already exist
            throw new EmailAlreadyExistException("email already used for another account");
        } else {
            // username is already used
            throw new UsernameAlreadyExistException("this username is already used, insert another one");
        }
    }
}
