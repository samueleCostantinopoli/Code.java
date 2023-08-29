package com.example.fitnesshelp.system_actor;

import com.example.fitnesshelp.entities.Questionnaire;
import com.example.fitnesshelp.state.*;

public class TdeeCalculator {

    public double calculateTdee(Questionnaire questionnaire, String target){
        double kcal;
        TdeeContext tdeeContext = new TdeeContext();
        if (target == "Maintenance"){
            TdeeState tdeeState = new MaintenanceState();
            tdeeContext.setState(tdeeState);
        } else if (target == "Bulking") {
            TdeeState tdeeState = new BulkingState();
            tdeeContext.setState(tdeeState);
        } else {
            TdeeState tdeeState = new CuttingState();
            tdeeContext.setState(tdeeState);
        }
        kcal = tdeeContext.calculateTdee(questionnaire);
        return kcal;
    }

}
