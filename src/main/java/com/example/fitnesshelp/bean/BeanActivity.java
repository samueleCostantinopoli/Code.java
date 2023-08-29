package com.example.fitnesshelp.bean;

import com.example.fitnesshelp.entities.Activity;

public class BeanActivity {
    Activity activity;
    public BeanActivity(Activity activity){
        this.activity = activity;
    }

    public Activity getActivity() {
        return activity;
    }
}
