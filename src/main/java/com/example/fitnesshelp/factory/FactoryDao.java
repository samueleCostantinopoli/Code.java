package com.example.fitnesshelp.factory;

import com.example.fitnesshelp.dao.*;

import java.io.IOException;
import java.sql.SQLException;

public class FactoryDao {
    // this factory returns a kind of dao based on type of persistance
    public DaoEntity useDao(TypeOfPersistence typeOfPersistence, TypeOfEntity typeOfEntity) throws SQLException, IOException {
        if(typeOfPersistence == TypeOfPersistence.JDBC){
            switch(typeOfEntity){
                case TDEE -> {
                    return new DaoImplJDBCTdee();
                }
                case PURCHASE -> {
                    return new DaoImplJDBCPurchase();
                }
                case WORKOUT_PLAN -> {
                    return new DaoImplJDBCWorkoutPlan();
                }
            }
        }else{
            switch (typeOfEntity){
                case TDEE -> {
                    return new DaoImplFileSystemTdee();
                }
                case PURCHASE -> {
                    return new DaoImplFileSystemPurchase();
                }
                case WORKOUT_PLAN -> {
                    return new DaoImplFileSystemWorkoutPlan();
                }
            }
        }
        return null;
    }
}
