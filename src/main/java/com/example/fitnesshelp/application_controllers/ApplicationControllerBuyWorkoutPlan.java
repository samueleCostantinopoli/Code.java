package com.example.fitnesshelp.application_controllers;

import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.bean.BeanUsername;
import com.example.fitnesshelp.dao.DaoImplFilSystemWorkoutPlan;
import com.example.fitnesshelp.dao.DaoImplFileSystemExercise;
import com.example.fitnesshelp.dao.DaoImplFileSystemPurchase;
import com.example.fitnesshelp.entities.Exercise;
import com.example.fitnesshelp.entities.Purchase;
import com.example.fitnesshelp.entities.WorkoutPlan;
import com.example.fitnesshelp.utils.UtilityAccess;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ApplicationControllerBuyWorkoutPlan {
    int prize;
    String state;

    public ApplicationControllerBuyWorkoutPlan(BeanState stateUser) {
        this.state = stateUser.toString();
    }

    public List<WorkoutPlan> checkWorkoutPlan() throws IOException {
        DaoImplFilSystemWorkoutPlan daoImplFilSystemWorkoutPlan = new DaoImplFilSystemWorkoutPlan();
        return daoImplFilSystemWorkoutPlan.showData(UtilityAccess.getUsername());
    }

    public List<Exercise> checkExercise() throws IOException {
        DaoImplFileSystemExercise daoImplFileSystemExercise = new DaoImplFileSystemExercise();
        return daoImplFileSystemExercise.showData(UtilityAccess.getUsername());
    }

    public void createPurchase(Purchase purchaseToSave) throws SQLException, IOException {
        DaoImplFileSystemPurchase daoImplFileSystemPurchase = new DaoImplFileSystemPurchase();
        daoImplFileSystemPurchase.saveData(purchaseToSave);
    }

    public List<Purchase> checkPurchase() throws IOException {
        DaoImplFileSystemPurchase daoImplFileSystemPurchase = new DaoImplFileSystemPurchase();
        return daoImplFileSystemPurchase.showData(UtilityAccess.getUsername());
    }

    public List<Purchase> checkUserPurchase(BeanUsername beanUsername) throws IOException {
        DaoImplFileSystemPurchase daoImplFileSystemPurchase = new DaoImplFileSystemPurchase();
        List<Purchase> purchaseTotal = daoImplFileSystemPurchase.showData(UtilityAccess.getUsername());
        List<Purchase> purchaseUser = new ArrayList<>();
        for (Purchase purchase : purchaseTotal) {
            if (purchase.getUsername().equals(beanUsername.getUsername())) {
                purchaseUser.add(purchase);
            }
        }
        return purchaseUser;
    }
}
