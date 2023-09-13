package com.example.fitnesshelp.application_controllers;

import com.example.fitnesshelp.entities.Activity;
import com.example.fitnesshelp.entities.Gender;
import com.example.fitnesshelp.entities.Questionnaire;
import com.example.fitnesshelp.system_actor.TdeeCalculator;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApplicationControllerCalculateTdeeTest {
    // Leonardo Pompili
    // this test verify that the TDEE for this data are different from 2222 kcal
    @Test
    public void calculateTdee() {
        Questionnaire questionnaire = new Questionnaire(Gender.MALE, 30, 80, 180, Activity.SEDENTARY);
        double kcal;
        TdeeCalculator tdeeCalculator = new TdeeCalculator();
        kcal = tdeeCalculator.calculateTdee(questionnaire, "maintenance");
        assertNotEquals(2222.0, kcal, 0.001);
    }
}