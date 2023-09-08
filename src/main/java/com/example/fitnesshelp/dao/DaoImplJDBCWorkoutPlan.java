package com.example.fitnesshelp.dao;

import com.example.fitnesshelp.entities.WorkoutPlan;



import java.util.List;

public class DaoImplJDBCWorkoutPlan implements DaoEntity<WorkoutPlan>{
    @Override
    public void saveData(WorkoutPlan workoutPlan){
        //Not implemented because I use the file system and it was not required to use the database for me as I am from the automation course

    }

    @Override
    public List<WorkoutPlan> showData(String username){

        //Not implemented because I use the file system and it was not required to use the database for me as I am from the automation course
        return null;
    }

    @Override
    public void removeData(WorkoutPlan entity) {
        //Not implemented because I use the file system and it was not required to use the database for me as I am from the automation course

    }
}
