package com.example.fitnesshelp.utils;

public class Printer {
    private Printer(){}
    public static void print(String messaggio){
        System.out.println(messaggio);
    }
    public static void error(String errore){
        System.out.println(errore);
    }
}

