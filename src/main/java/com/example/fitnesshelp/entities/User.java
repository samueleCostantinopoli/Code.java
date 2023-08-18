package com.example.fitnesshelp.entities;

public class User {

    private int id;
    private String name;
    private String surname;
    private State state;

    public User(int id, String name, String surname, State state) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

