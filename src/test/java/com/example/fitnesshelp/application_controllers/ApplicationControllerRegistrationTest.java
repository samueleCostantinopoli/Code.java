package com.example.fitnesshelp.application_controllers;

import com.example.fitnesshelp.dao.DaoImplRegistration;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class ApplicationControllerRegistrationTest {
    // Leonardo Pompili
    // this test verify the username of aan existing account is present on db
    @Test
    public void checkCredentials() throws SQLException, IOException {
        DaoImplRegistration daoImplRegistration = new DaoImplRegistration();
        boolean result = daoImplRegistration.checkUsername("leo2001");
        assertFalse(result);
    }
}