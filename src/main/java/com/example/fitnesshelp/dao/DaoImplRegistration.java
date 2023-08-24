package com.example.fitnesshelp.dao;

import com.example.fitnesshelp.entities.State;

public class DaoImplRegistration implements DaoRegistration{

    @Override
    public boolean checkRegistration(String email, String username){
        return false;
    }

    @Override
    public void registration(String email, String password, State role, String username){}
}
