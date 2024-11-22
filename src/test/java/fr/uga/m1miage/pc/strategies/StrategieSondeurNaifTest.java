package fr.uga.m1miage.pc.strategies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests pour la strat�gie Sondeur na�f.
 */
public class StrategieSondeurNaifTest {

    @Test
    public void testImitationDernierCoup() {
        StrategieSondeurNaif strategie = new StrategieSondeurNaif();

        // Imitation simple du dernier coup de l'adversaire
        assertEquals('c', strategie.decider('c')); // Coop�rer
        assertEquals('t', strategie.decider('t')); // Trahir
    }

    @Test
    public void testTrahisonAleatoireLorsDeCooperation() {
        StrategieSondeurNaif strategie = new StrategieSondeurNaif();

        // Simuler plusieurs tours pour d�tecter des trahisons al�atoires
        boolean trahisonDetectee = false;
        for (int i = 0; i < 100; i++) {
            char resultat = strategie.decider('c');
            if (resultat == 't') { // Une trahison inattendue est d�tect�e
                trahisonDetectee = true;
                break;
            }
        }

        assertTrue(trahisonDetectee, "Une trahison aurait d� �tre d�tect�e apr�s plusieurs it�rations.");
    }

    @Test
    public void testAleatoireAvecProbabilite() {
        StrategieSondeurNaif strategie = new StrategieSondeurNaif();

        // Simuler plusieurs tours et compter les trahisons al�atoires
        int nombreDeTours = 1000;
        int trahisonsAleatoires = 0;
        for (int i = 0; i < nombreDeTours; i++) {
            char resultat = strategie.decider('c');
            if (resultat == 't') {
                trahisonsAleatoires++;
            }
        }

        // V�rifier qu'environ 20% des coups sont des trahisons al�atoires (avec une marge d'erreur)
        double proportion = (double) trahisonsAleatoires / nombreDeTours;
        assertTrue(proportion >= 0.15 && proportion <= 0.25, 
            "La proportion de trahisons al�atoires devrait �tre d'environ 20%.");
    }

    @Test
    public void testAucuneTrahisonLorsDeTrahisonAdverse() {
        StrategieSondeurNaif strategie = new StrategieSondeurNaif();

        // Si l'adversaire trahit, la strat�gie doit simplement imiter sans jouer al�atoirement
        for (int i = 0; i < 100; i++) {
            assertEquals('t', strategie.decider('t'));
        }
    }
}
