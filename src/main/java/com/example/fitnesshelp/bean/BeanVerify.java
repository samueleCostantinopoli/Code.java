package com.example.fitnesshelp.bean;


public class BeanVerify {
    //questo bean è un utility per gli altri bean, sarà qui che metterò i metodi per gestire la sintassi degli input passati
    private BeanVerify(){}
    public static void verificaSintassiEmail(String email) throws DoppiaChiocciolaException, DoppiaVirgolaException, TerminatoreEmailException {
        int contatore = 0;
        int contatore2 = 0;
        contatore = email.indexOf('@');
        contatore2 = email.indexOf('@', contatore + 1);
        if (contatore2 != -1) {
            //bisogna lanciare un eccezione
            throw new DoppiaChiocciolaException("l'email inserita deve\ncontenere una sola '@' ");
        }
        if (email.indexOf(',') != -1) {
            throw new DoppiaVirgolaException("spiacente l'email non può\ncontente un carattere ','");
        }
        if(!(email.endsWith(".com") || email.endsWith(".it") || email.endsWith(".live"))){
            throw new TerminatoreEmailException("l'email deve terminare con\n.com o .it o .live");
        }
    }
}
