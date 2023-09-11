package com.example.fitnesshelp.application_controllers;

import com.example.fitnesshelp.bean.BeanBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanPurchase;
import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.bean.BeanUsername;
import com.example.fitnesshelp.dao.DaoEntity;
import com.example.fitnesshelp.entities.Exercise;
import com.example.fitnesshelp.entities.Purchase;
import com.example.fitnesshelp.entities.WorkoutPlan;
import com.example.fitnesshelp.exception.ExerciseLoadException;
import com.example.fitnesshelp.exception.WorkoutPlanLoadException;
import com.example.fitnesshelp.factory.FactoryDao;
import com.example.fitnesshelp.factory.TypeOfEntity;
import com.example.fitnesshelp.factory.TypeOfPersistence;
import com.example.fitnesshelp.utils.UtilityAccess;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class ApplicationControllerBuyWorkoutPlan {
    String state;

    public ApplicationControllerBuyWorkoutPlan(BeanState stateUser) {
        this.state = stateUser.toString();
    }

    @SuppressWarnings("unchecked")
    public List<WorkoutPlan> checkWorkoutPlan() throws IOException, SQLException {
        FactoryDao factoryDao = new FactoryDao();
        return factoryDao.useDao(TypeOfPersistence.FILE_SYSTEM, TypeOfEntity.WORKOUT_PLAN).showData(UtilityAccess.getUsername());
    }

    @SuppressWarnings("unchecked")
    public List<WorkoutPlan> checkUserWorkoutPlan(BeanUsername beanUsername) throws WorkoutPlanLoadException, SQLException, IOException {
        FactoryDao factoryDao = new FactoryDao();
        DaoEntity<WorkoutPlan> daoEntity = factoryDao.useDao(TypeOfPersistence.FILE_SYSTEM, TypeOfEntity.WORKOUT_PLAN);

        List<WorkoutPlan> workoutUser = new ArrayList<>();
        try {
            List<WorkoutPlan> workoutPlanList = daoEntity.showData(beanUsername.getUsername());
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


    @SuppressWarnings("unchecked")
    public List<Exercise> checkExercise() throws IOException, SQLException {
        FactoryDao factoryDao = new FactoryDao();
        return factoryDao.useDao(TypeOfPersistence.FILE_SYSTEM, TypeOfEntity.EXERCISE).showData(UtilityAccess.getUsername());
    }

    @SuppressWarnings("unchecked")
    public List<Exercise> checkUserExercise(BeanBuyWorkoutPlan beanBuyWorkoutPlan) throws ExerciseLoadException, SQLException, IOException {
        FactoryDao factoryDao = new FactoryDao();
        DaoEntity<Exercise> daoEntity = factoryDao.useDao(TypeOfPersistence.FILE_SYSTEM, TypeOfEntity.EXERCISE);

        List<Exercise> exerciseUser = new ArrayList<>();
        try {
            List<Exercise> exerciseTotal = daoEntity.showData(UtilityAccess.getUsername());
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

    @SuppressWarnings("unchecked")
    public void createPurchase(BeanPurchase purchaseToSave) throws SQLException, IOException {
        FactoryDao factoryDao = new FactoryDao();
        factoryDao.useDao(TypeOfPersistence.FILE_SYSTEM, TypeOfEntity.PURCHASE).saveData(purchaseToSave);
    }

    @SuppressWarnings("unchecked")
    public List<Purchase> checkPurchase() throws SQLException, IOException {
        FactoryDao factoryDao = new FactoryDao();
        return factoryDao.useDao(TypeOfPersistence.FILE_SYSTEM, TypeOfEntity.PURCHASE).showData(UtilityAccess.getUsername());
    }

    @SuppressWarnings("unchecked")
    public List<Purchase> checkUserPurchase(BeanUsername beanUsername) throws SQLException, IOException {
        FactoryDao factoryDao = new FactoryDao();
        DaoEntity<Purchase> daoEntity = factoryDao.useDao(TypeOfPersistence.FILE_SYSTEM, TypeOfEntity.PURCHASE);

        List<Purchase> purchaseUser = new ArrayList<>();
        List<Purchase> purchaseTotal = daoEntity.showData(UtilityAccess.getUsername());
        for (Purchase purchase : purchaseTotal) {
            if (purchase.getUsername().equals(beanUsername.getUsername())) {
                purchaseUser.add(purchase);
            }
        }
        return purchaseUser;
    }

}
