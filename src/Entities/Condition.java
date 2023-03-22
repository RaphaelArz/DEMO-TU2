package Entities;

import java.util.prefs.PreferenceChangeListener;

public class Condition {

    private static int  montantMax;
    static final int nbJours = 30;

    public static boolean Valider(int unNbDejours) {
        boolean bool = true;
        if (unNbDejours > 30) {
            bool = false;
        }
        return bool;
    }




    public static int  calculerLeMontantMaxCategorie(String uneCategorie) {
        if (uneCategorie.compareTo("Livres")==0){
            montantMax=30;
        } else if (uneCategorie.equals("Jouets")) {
            montantMax=50;

        }
        else if (uneCategorie.compareTo("Informatique")==0) {
            montantMax=1000;
        }
        return montantMax;
    }


    public  static double calculerMontantrembourse(int unNbDejours, String uneCategorie,boolean estMembre,String unEtat,int unPrix){
        double montantRembourser = montantMax;
        if(unNbDejours<=30){
            if(estMembre== false){
                montantRembourser = unPrix*0.8;}
            if(unEtat.compareTo("Abimé")==0|| unEtat.compareTo("Très abimé")==0){
                    montantRembourser=montantRembourser-(unPrix-unPrix*0.7);
                }
            else{
                    montantRembourser=montantRembourser-(unPrix-unPrix*0.9);
                }
            }
        else montantRembourser=0;


        return montantRembourser;
    }

    public static double calculerReductionMembre(boolean estMembre) {
        double reductionMembre= 0;
        if (estMembre){
            reductionMembre = 20;
        }
        return reductionMembre;
}
    public static double calculerReductionEtat(String unEtat){
        double remiseEtat = 10;
        if(unEtat.compareTo("Abimé")==0 || unEtat.compareTo("Très abimé")==0){
            remiseEtat=30;

        }
        return remiseEtat;
    }
}
