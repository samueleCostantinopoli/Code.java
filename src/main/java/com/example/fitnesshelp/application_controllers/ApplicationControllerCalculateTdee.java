package com.example.fitnesshelp.application_controllers;

import com.example.fitnesshelp.bean.*;
import com.example.fitnesshelp.entities.Activity;
import com.example.fitnesshelp.entities.Gender;
import com.example.fitnesshelp.entities.Questionnaire;
import com.example.fitnesshelp.entities.Tdee;
import com.example.fitnesshelp.factory.FactoryDao;
import com.example.fitnesshelp.factory.TypeOfEntity;
import com.example.fitnesshelp.factory.TypeOfPersistence;
import com.example.fitnesshelp.state.*;
import com.example.fitnesshelp.system_actor.TdeeCalculator;
import com.example.fitnesshelp.utils.UtilityAccess;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ApplicationControllerCalculateTdee {

    private int age;
    private float height;
    private float weight;
    private Gender gender;
    private Activity activity;
    private String target;

    private TypeOfPersistence typeOfPersistence;

    public ApplicationControllerCalculateTdee(BeanAge beanAge, BeanHeight beanHeight, BeanWeight beanWeight, BeanGender beanGender, BeanActivity beanActivity, BeanTarget beanTarget){
        this.age = beanAge.getAge();
        this.height = beanHeight.getHeight();
        this.weight = beanWeight.getWeight();
        this.gender = beanGender.getGender();
        this.activity = beanActivity.getActivity();
        this.target = beanTarget.getTarget();
        Questionnaire questionnaire = new Questionnaire(gender, age, weight, height, activity);
    }

    public ApplicationControllerCalculateTdee() {
        // this second costructor is used to call requestTdeeList without passing bean
    }

    public double calculateTdee(Questionnaire questionnaire, String target){
        double kcal;
        TdeeCalculator tdeeCalculator = new TdeeCalculator();
        kcal = tdeeCalculator.calculateTdee(questionnaire, target);
        return kcal;
    }

    public List<Tdee> requestTdeeList() throws SQLException, IOException {
        // this method take all tdee that user has saved
        FactoryDao factoryDao = new FactoryDao();
        List<Tdee> tdeeList = factoryDao.useDao(TypeOfPersistence.JDBC, TypeOfEntity.TDEE).showData(UtilityAccess.getUsername());
        return tdeeList;
    }
}
