package com.example.fitnesshelp.entities;

public class Account {

    private String username;
    private String password;
    private int userId;
    private TypeOfUser role;
    private String email;

    public Account(String username, String password, int userId, TypeOfUser role, String email) {
        this.username = username;
        this.password = password;
        this.userId = userId;
        this.role = role;
        this.email = email;
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
}

enum TypeOfUser {
    NORMAL,
    PERSONAL_TRAINER
}
