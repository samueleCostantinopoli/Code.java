package com.example.fitnesshelp.application_controllers;

import com.example.fitnesshelp.bean.BeanBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.bean.BeanUsername;
import com.example.fitnesshelp.dao.DaoImplFilSystemWorkoutPlan;
import com.example.fitnesshelp.dao.DaoImplFileSystemExercise;
import com.example.fitnesshelp.dao.DaoImplFileSystemPurchase;
import com.example.fitnesshelp.entities.Exercise;
import com.example.fitnesshelp.entities.Purchase;
import com.example.fitnesshelp.entities.WorkoutPlan;
import com.example.fitnesshelp.exception.ExerciseLoadException;
import com.example.fitnesshelp.exception.PurchaseUserLoadException;
import com.example.fitnesshelp.exception.WorkoutPlanLoadException;
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

    public List<WorkoutPlan> checkUserWorkoutPlan(BeanUsername beanUsername) throws WorkoutPlanLoadException {
        DaoImplFilSystemWorkoutPlan daoImplFilSystemWorkoutPlan = new DaoImplFilSystemWorkoutPlan();
        List<WorkoutPlan> workoutUser = new ArrayList<>();
        try {
            List<WorkoutPlan> workoutPlanList = daoImplFilSystemWorkoutPlan.showData(beanUsername.getUsername());
            for (WorkoutPlan workoutPlan : workoutPlanList) {
                if (workoutPlan.getUsername().equals(beanUsername.getUsername())) {
                    workoutUser.add(workoutPlan);
                }
            }
        } catch (IOException e) {
        throw new WorkoutPlanLoadException("Error loading workout plans: " + e.getMessage());
        }
        return workoutUser;
    }


    public List<Exercise> checkExercise() throws IOException {
        DaoImplFileSystemExercise daoImplFileSystemExercise = new DaoImplFileSystemExercise();
        return daoImplFileSystemExercise.showData(UtilityAccess.getUsername());
    }

    public List<Exercise> checkUserExercise(BeanBuyWorkoutPlan beanBuyWorkoutPlan) throws ExerciseLoadException {
        DaoImplFileSystemExercise daoImplFileSystemExercise = new DaoImplFileSystemExercise();
        List<Exercise> exerciseUser = new ArrayList<>();
        try {
            List<Exercise> exerciseTotal = daoImplFileSystemExercise.showData(UtilityAccess.getUsername());
            for (Exercise exercise : exerciseTotal) {
                if (exercise.getWorkoutPlan().getName().equals(beanBuyWorkoutPlan.getName())
                        && exercise.getWorkoutPlan().getUsername().equals(beanBuyWorkoutPlan.getUsername())
                        && exercise.getWorkoutPlan().getPrize() == beanBuyWorkoutPlan.getPrize()) {
                    exerciseUser.add(exercise);
                }
            }
        } catch (IOException e) {
            throw new ExerciseLoadException("Error loading workout plans: " + e.getMessage());
        }
        return exerciseUser;
    }

    public void createPurchase(Purchase purchaseToSave) throws SQLException, IOException {
        DaoImplFileSystemPurchase daoImplFileSystemPurchase = new DaoImplFileSystemPurchase();
        daoImplFileSystemPurchase.saveData(purchaseToSave);
    }

    public List<Purchase> checkPurchase() {
        DaoImplFileSystemPurchase daoImplFileSystemPurchase = new DaoImplFileSystemPurchase();
        return daoImplFileSystemPurchase.showData(UtilityAccess.getUsername());
    }

    public List<Purchase> checkUserPurchase(BeanUsername beanUsername) {
        DaoImplFileSystemPurchase daoImplFileSystemPurchase = new DaoImplFileSystemPurchase();
        List<Purchase> purchaseUser = new ArrayList<>();
        List<Purchase> purchaseTotal = daoImplFileSystemPurchase.showData(UtilityAccess.getUsername());
        for (Purchase purchase : purchaseTotal) {
            if (purchase.getUsername().equals(beanUsername.getUsername())) {
                purchaseUser.add(purchase);
            }
        }
        return purchaseUser;
    }

}
