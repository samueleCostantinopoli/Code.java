package com.example.fitnesshelp.entities;

public class Account {

    private String name;
    private String password;
    private int userId;
    private TypeOfUser role;
    private String email;
    private State state;

    public Account(String name, String surname, String password, int userId, TypeOfUser role, String email, State state) {
        this.name = name;
        this.password = password;
        this.userId = userId;
        this.role = role;
        this.email = email;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public TypeOfUser getRole() {
        return role;
    }

    public void setRole(TypeOfUser role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}

