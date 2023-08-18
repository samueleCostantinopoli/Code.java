package com.example.fitnesshelp.state;

import com.example.fitnesshelp.entities.Questionnaire;
import com.example.fitnesshelp.entities.Tdee;

public class TdeeContext implements TdeeState{

    private TdeeState state;

    public void setState(TdeeState state){
        this.state = state;
    }

    public TdeeState getState(){
        return this.state;
    }

    @Override
    public double calculateTdee(Questionnaire questionnaire){
        return state.calculateTdee(questionnaire);
    }
}
