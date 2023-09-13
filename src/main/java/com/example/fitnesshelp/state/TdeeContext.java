package com.example.fitnesshelp.state;

import com.example.fitnesshelp.entities.Questionnaire;

public class TdeeContext implements TdeeState{
    // this method call 'calculateTdee' based on the state that is currently setted
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
