package com.example.fitnesshelp.utils;

public class Printer {
    private Printer(){}
    public static void print(String messagge){
        System.out.println(messagge);
    }
    public static void error(String error){
        Printer.print(error);
    }
}

