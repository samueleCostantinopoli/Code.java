package com.example.fitnesshelp.dao;

import com.example.fitnesshelp.entities.Purchase;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DaoImplJDBCPurchase implements DaoEntity<Purchase>{
    @Override
    public void saveData(Purchase purchase){}

    @Override
    public List<Purchase> showData(String username){
        return null;
    }

    @Override
    public void removeData(Purchase entity) throws SQLException, IOException {

    }
}
