package com.example.fitnesshelp.dao;

import com.example.fitnesshelp.entities.Exercise;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DaoImplJDBCExercise implements DaoEntity<Exercise> {
    @Override
    public void saveData(Exercise entity) throws SQLException, IOException {
        //Not implemented because I use the file system and it was not required to use the database for me as I am from the automation course
    }

    @Override
    public List showData(String username) throws IOException {
        //Not implemented because I use the file system and it was not required to use the database for me as I am from the automation course
        throw new UnsupportedOperationException("showData method is implemented in the dao of db by default");
    }

    @Override
    public void removeData(Exercise entity) throws SQLException, IOException {
        //Not implemented because I use the file system and it was not required to use the database for me as I am from the automation course

    }
}
