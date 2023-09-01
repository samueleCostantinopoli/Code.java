package com.example.fitnesshelp.state;

import com.example.fitnesshelp.entities.Gender;
import com.example.fitnesshelp.entities.Questionnaire;

public class CuttingState implements TdeeState{

    private double kcalCut;
    private double mbCut;
    private double actCut;

    @Override
    public double calculateTdee(Questionnaire questionnaire){
        if(questionnaire.getGender() == Gender.MALE){
            mbCut = 88.362 + (13.397*questionnaire.getWeight()) + (4.799*questionnaire.getHeight()) - (5.677* questionnaire.getAge());
        } else {
            mbCut = 447.593 + (9.247*questionnaire.getWeight()) + (3.098*questionnaire.getHeight()) - (4.330* questionnaire.getAge());
        }

        actCut = switch (questionnaire.getActivity()){
            case SEDENTARY -> 1.05;
            case LIGHT_EXERCISE -> 1.2;
            case MODERATE_EXERCISE -> 1.35;
            case HEAVY_EXERCISE -> 1.5;
            case ATHLETE -> 1.65;
        };

        kcalCut = mbCut*actCut + mbCut*0.1 - 500;

        return kcalCut;
    }
}
