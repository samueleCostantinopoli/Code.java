package com.example.fitnesshelp.entities;

public class Account {

    private String username;
    private String password;
    private TypeOfUser role;
    private String email;
    private State state;

    public Account(String username, String password, TypeOfUser role, String email, State state) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

