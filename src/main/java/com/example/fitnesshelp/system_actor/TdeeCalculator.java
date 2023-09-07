package com.example.fitnesshelp.system_actor;

import com.example.fitnesshelp.entities.Macro;
import com.example.fitnesshelp.entities.Questionnaire;
import com.example.fitnesshelp.state.*;
import java.util.ArrayList;
import java.util.List;

public class TdeeCalculator {

    public double calculateTdee(Questionnaire questionnaire, String target){
        double kcal;
        TdeeContext tdeeContext = new TdeeContext();
        if (target.equals("Maintenance")){
            TdeeState tdeeState = new MaintenanceState();
            tdeeContext.setState(tdeeState);
        } else if (target.equals("Bulking")) {
            TdeeState tdeeState = new BulkingState();
            tdeeContext.setState(tdeeState);
        } else {
            TdeeState tdeeState = new CuttingState();
            tdeeContext.setState(tdeeState);
        }
        kcal = tdeeContext.calculateTdee(questionnaire);
        return kcal;
    }

    public List<Macro> calculateMacro(int kcal){
        List<Macro> macroList = new ArrayList<>();
        float proPerc;
        float fatPerc;
        float carbPerc;

        // first element of list is "moderate carb"
        proPerc = truncateToOneDecimal((float) (kcal*0.30/4));
        fatPerc = truncateToOneDecimal((float) (kcal*0.35/9));
        carbPerc = truncateToOneDecimal((float) (kcal*0.35/4));
        Macro moderateCarb = new Macro(proPerc, fatPerc, carbPerc);
        macroList.add(moderateCarb);

        // second element of list is "lower carb"
        proPerc = truncateToOneDecimal((float) (kcal*0.40/4));
        fatPerc = truncateToOneDecimal((float) (kcal*0.40/9));
        carbPerc = truncateToOneDecimal((float) (kcal*0.20/4));
        Macro lowerCarb = new Macro(proPerc, fatPerc, carbPerc);
        macroList.add(lowerCarb);

        // third element of list is "higher carb"
        proPerc = truncateToOneDecimal((float) (kcal*0.30/4));
        fatPerc = truncateToOneDecimal((float) (kcal*0.20/9));
        carbPerc = truncateToOneDecimal((float) (kcal*0.50/4));
        Macro higherCarb = new Macro(proPerc, fatPerc, carbPerc);
        macroList.add(higherCarb);

        return macroList;
    }

    public float truncateToOneDecimal(float value) {
        // this is used to take integer part and only one number of decimal part
        int intValue = (int) value;
        int decimalValue = (int) ((value - intValue) * 10);
        return (float) (intValue + decimalValue / 10.0);
    }


}
