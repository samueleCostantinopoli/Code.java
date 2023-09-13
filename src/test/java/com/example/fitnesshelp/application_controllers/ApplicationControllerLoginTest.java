package com.example.fitnesshelp.application_controllers;

import com.example.fitnesshelp.dao.DaoImplLogin;
import org.junit.Test;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class ApplicationControllerLoginTest {
    // Leonardo Pompili
    // this test verify that login failed with this false credentials
    @Test
    public void checkUserAccount() throws SQLException, IOException {
        DaoImplLogin daoImplLogin = new DaoImplLogin();
        boolean result = daoImplLogin.login("username", "password");
        assertFalse(result);
    }
}