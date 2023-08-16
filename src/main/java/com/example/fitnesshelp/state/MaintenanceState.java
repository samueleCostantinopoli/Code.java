package com.example.fitnesshelp.state;

import com.example.fitnesshelp.entities.Questionnaire;
import com.example.fitnesshelp.entities.Tdee;

public class MaintenanceState implements TdeeState{

    @Override
    public Tdee calculateTdee(Questionnaire questionnaire){
        return null;
    }
}
