package com.example.fitnesshelp.state;

import com.example.fitnesshelp.entities.Questionnaire;
import com.example.fitnesshelp.entities.Tdee;

public interface TdeeState {

    public Tdee calculateTdee(Questionnaire questionnaire);
}
