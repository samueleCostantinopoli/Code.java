package com.example.fitnesshelp.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface DaoEntity<T> {
    //methods common to all dao
    void saveData(T entity) throws SQLException, IOException;
    List<T> showData();
}
