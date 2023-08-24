package com.example.fitnesshelp.dao;

import com.example.fitnesshelp.entities.State;

public interface DaoRegistration {
    // all the methods that the registration should contain
    boolean checkRegistration(String email, String username);
    void registration(String email, String password, State role, String username);
}
