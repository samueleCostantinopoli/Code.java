package com.example.fitnesshelp.utils;

import com.example.fitnesshelp.entities.Account;
import com.example.fitnesshelp.entities.State;

public class UtilityAccess {
    // this is only used to set this static parameter for another class, so this can see the status of user
    private static String username = null;
    private static State state = State.NOT_LOGGED_IN;
    private UtilityAccess(){
        // is empty because this class provides only methods to set and get user status
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UtilityAccess.username = username;
    }

    public static State getState() {
        return state;
    }

    public static void setState(State state){
        UtilityAccess.state = state;
    }

    // new account added
    private static Account account;

    public static Account getAccount() {
        return account;
    }

    public static void setAccount(Account account) {
        UtilityAccess.account = account;
    }


}
