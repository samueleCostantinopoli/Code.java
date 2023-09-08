package com.example.fitnesshelp.entities;

public class Tdee extends Macro {
    private int kcal;
    private String username;
    private String target;
    private String quantity;

    public Tdee(int kcal, String username, float pro, float fat, float carb, String target, String quantity) {
        super(pro, fat, carb);
        this.kcal = kcal;
        this.username = username;
        this.target = target;
        this.quantity = quantity;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
