package com.example.fitnesshelp.dao;

import com.example.fitnesshelp.entities.Purchase;

import java.util.List;

public class DaoImplJDBCPurchase implements DaoEntity<Purchase>{
    @Override
    public void saveData(Purchase purchase){
        //Not implemented because I use the file system and it was not required to use the database for me as I am from the automation course
    }

    @Override
    public List<Purchase> showData(String username){
        //Not implemented because I use the file system and it was not required to use the database for me as I am from the automation course
        throw new UnsupportedOperationException("showData method is implemented in the dao of db by default");
    }

    @Override
    public void removeData(Purchase entity) {
        //Not implemented because I use the file system and it was not required to use the database for me as I am from the automation course
    }
}
