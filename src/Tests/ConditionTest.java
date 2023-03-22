package Tests;

import Entities.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConditionTest {
    private int nbJour25;
    private int nbJour35;
    private String Livres;
    private String Jouets;
    private String Informatique;

    private boolean estMembre;

    private boolean estPasMembre;
    private String etat;

    private  int prix;

    @BeforeEach
    void setUp() {
        nbJour25=25;
        nbJour35=35;
    }

    @Test
    void valider() {
        //si NB jours superieur à 30
        boolean actual =Condition.Valider(nbJour35);
        boolean expected= false;
        assertEquals(expected,actual);

        //Si NB jours inferieur à 30
        actual= Condition.Valider(nbJour25);
        expected= true;
        assertEquals(actual,expected);
    }

    @Test
    void calculerLeMontantMaxCategorie() {
        //si Livre:
        Livres="Livres";
        int expected=30;
        int actual = Condition.calculerLeMontantMaxCategorie(Livres);
        assertEquals(expected,actual);

        //si Jouet :
        Jouets="Jouets";
        expected=50;
        actual=Condition.calculerLeMontantMaxCategorie(Jouets);
        assertEquals(actual,expected);

        //si Informatique
        Informatique="Informatique";
        expected=1000;
        actual=Condition.calculerLeMontantMaxCategorie(Informatique);
        assertEquals(expected,actual);
    }

    @Test
    void calculerMontantrembourse() {
        //si plus 30 jours :
        Livres=Livres;
        etat="abimé";
        double actual= Condition.calculerMontantrembourse(nbJour35,Livres,estMembre,etat,prix);
        double expected= 0;
        assertEquals(expected,actual);

    }

    @Test
    void calculerReductionMembre() {
        //si Membre:
        estMembre = true;
        double expected=20;
        double actual=Condition.calculerReductionMembre(estMembre);
        assertEquals(actual,expected);

        //si non Membre:
        estPasMembre = false;
        expected=0;
        actual=Condition.calculerReductionMembre(estPasMembre);
        assertEquals(actual,expected);


    }

    @Test
    void calculerReductionEtat() {

        //si abime:
        etat = "Abimé";
        double expected = 30;
        double actual = Condition.calculerReductionEtat(etat);
        assertEquals(expected,actual);

        //si tres abime:
        etat = "Très abimé";
        expected = 30;
        actual = Condition.calculerReductionEtat(etat);
        assertEquals(expected,actual);

        //si bon etat:
        etat="bon";
        expected=10;
        actual=Condition.calculerReductionEtat(etat);
        assertEquals(actual,expected);


    }
}