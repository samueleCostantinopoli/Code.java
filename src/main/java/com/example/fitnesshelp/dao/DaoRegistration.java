package com.example.fitnesshelp.dao;

public interface DaoRegistration{
    // all the methods that the registration should contain
    boolean checkEmail(String email);
    boolean checkUsername(String username);
    void registration(String email, String password, String typeOfUser, String username);
}
