package com.example.fitnesshelp.dao;

import com.example.fitnesshelp.entities.WorkoutPlan;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DaoImplJDBCWorkoutPlan implements DaoEntity<WorkoutPlan>{
    @Override
    public void saveData(WorkoutPlan workoutPlan){}

    @Override
    public List<WorkoutPlan> showData(String username){
        return null;
    }

    @Override
    public void removeData(WorkoutPlan entity) throws SQLException, IOException {

    }
}
