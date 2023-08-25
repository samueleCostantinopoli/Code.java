package com.example.fitnesshelp.bean;

public class BeanUsername {

    private String username;

    public BeanUsername(String username) {
        setUsername(username);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username.length() <= 12) {
            this.username = username;
        } else {
            throw new IllegalArgumentException("Username must be less than or equal to 12 characters.");
        }
    }
}
