package com.example.fitnesshelp.application_controllers;

import static org.junit.Assert.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.example.fitnesshelp.bean.BeanBuyWorkoutPlan;
import com.example.fitnesshelp.bean.BeanState;
import com.example.fitnesshelp.bean.BeanUsername;
import com.example.fitnesshelp.entities.Exercise;
import com.example.fitnesshelp.entities.Purchase;
import com.example.fitnesshelp.entities.WorkoutPlan;
import com.example.fitnesshelp.utils.UtilityAccess;
import org.junit.Test;


public class ApplicationControllerBuyWorkoutPlanTest {
    // Samuele Costantinopoli test
    // 1 test
     @Test
     public void checkUserWorkoutPlan() throws Exception {
         // Creiamo un'istanza di ApplicationControllerBuyWorkoutPlan
         ApplicationControllerBuyWorkoutPlan applicationControllerBuyWorkoutPlan = new ApplicationControllerBuyWorkoutPlan(new BeanState(UtilityAccess.getState()));

         // Eseguiamo il metodo da testare
         BeanUsername beanUsername = new BeanUsername("user");
         List<WorkoutPlan> result = applicationControllerBuyWorkoutPlan.checkUserWorkoutPlan(beanUsername);

         // Verifica che i workout plan nella lista abbiano username corrispondente
         for (WorkoutPlan workoutPlan : result) {
             assertEquals( "user", workoutPlan.getUsername());
         }
     }

    // 2 test
    @Test
    public void checkUserExercise() throws SQLException, IOException {
         // I check exercise of user
         ApplicationControllerBuyWorkoutPlan applicationControllerBuyWorkoutPlan = new ApplicationControllerBuyWorkoutPlan(new BeanState(UtilityAccess.getState()));

        BeanBuyWorkoutPlan beanBuyWorkoutPlan = new BeanBuyWorkoutPlan("Arms", 2.5,"user");
        List<Exercise> result = applicationControllerBuyWorkoutPlan.checkUserExercise(beanBuyWorkoutPlan);

        // Check result and confront with string of requested exercise name
        for (Exercise exercise : result) {
            assertEquals("Arms", exercise.getWorkoutPlan().getName());
            assertEquals("user", exercise.getWorkoutPlan().getUsername());

        }
        // Sapendo che gli exercise di questo Workout sono 2:
        // assertEquals(2, result.size());
    }

    // 3 test
    @Test
    public void checkUserPurchase() throws SQLException, IOException {
        // I check all purchase of specific user (with Username)
         ApplicationControllerBuyWorkoutPlan applicationControllerBuyWorkoutPlan = new ApplicationControllerBuyWorkoutPlan(new BeanState(UtilityAccess.getState()));
        // I use method checkUserPurchase to have specific purchase
        List<Purchase> result = applicationControllerBuyWorkoutPlan.checkUserPurchase(new BeanUsername("samuele"));

        // Check result and confront with string (Username) of user
        for (Purchase purchase : result) {
            assertEquals("samuele", purchase.getUsername());
        }
        // Sapendo che i purchase di questo utente sono 4:
        //assertEquals(4, result.size());
    }
}
