package com.example.fitnesshelp.utils;

import com.example.fitnesshelp.entities.Account;
import com.example.fitnesshelp.entities.State;

public class UtilityAccess {
    /*questa classe contiene 2 attributi statici che sono settati inizialmente a null
     * se l'utente effettua l' accesso con successo gli attributi di questa classe vengono settati
     * con i giusti valori presenti nel database per quell'utente, e tutte le altre classi potranno vedere queste
     * informazioni contenute nella seguente classe, e le useranno per capire se l'utete ha i permessi per entrare
     * in alcune schermate  */
    private static String usernameNelDatabase=null;
    private static String codiceUtente=null;
    private UtilityAccess(){
        //NON FA NULLA PERCHE E' UNA CLASSE UTILITY E FORNISCE METODI STATICI PER SETTARE IL VALORE DELLE VARIABILI PRIVATE
    }

    public static String getUsernameNelDatabase() {
        return usernameNelDatabase;
    }

    public static void setNomeUtenteNelDatabase(String nomeUtenteNelDatabase) {
        UtilityAccess.usernameNelDatabase = nomeUtenteNelDatabase;
    }

    public static String getCodiceUtente() {
        return codiceUtente;
    }

    public static void setCodiceUtente(String codiceUtente) {
        UtilityAccess.codiceUtente = codiceUtente;
    }

    //nuova aggiunta account
    private static Account account;

    public static Account getAccount() {
        return account;
    }

    public static void setAccount(Account account) {
        UtilityAccess.account = account;
    }

    private static State state;
    public static State getState() {
        return state;
    }

    public static void setState(State state){
        UtilityAccess.state = state;
    }
}
