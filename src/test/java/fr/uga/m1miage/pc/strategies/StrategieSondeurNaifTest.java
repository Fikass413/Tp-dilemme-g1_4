package fr.uga.m1miage.pc.strategies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests pour la stratégie Sondeur naïf.
 */
public class StrategieSondeurNaifTest {

    @Test
    public void testImitationDernierCoup() {
        StrategieSondeurNaif strategie = new StrategieSondeurNaif();

        // Imitation simple du dernier coup de l'adversaire
        assertEquals('c', strategie.decider('c')); // Coopérer
        assertEquals('t', strategie.decider('t')); // Trahir
    }

    @Test
    public void testTrahisonAleatoireLorsDeCooperation() {
        StrategieSondeurNaif strategie = new StrategieSondeurNaif();

        // Simuler plusieurs tours pour détecter des trahisons aléatoires
        boolean trahisonDetectee = false;
        for (int i = 0; i < 100; i++) {
            char resultat = strategie.decider('c');
            if (resultat == 't') { // Une trahison inattendue est détectée
                trahisonDetectee = true;
                break;
            }
        }

        assertTrue(trahisonDetectee, "Une trahison aurait dû être détectée après plusieurs itérations.");
    }

    @Test
    public void testAleatoireAvecProbabilite() {
        StrategieSondeurNaif strategie = new StrategieSondeurNaif();

        // Simuler plusieurs tours et compter les trahisons aléatoires
        int nombreDeTours = 1000;
        int trahisonsAleatoires = 0;
        for (int i = 0; i < nombreDeTours; i++) {
            char resultat = strategie.decider('c');
            if (resultat == 't') {
                trahisonsAleatoires++;
            }
        }

        // Vérifier qu'environ 20% des coups sont des trahisons aléatoires (avec une marge d'erreur)
        double proportion = (double) trahisonsAleatoires / nombreDeTours;
        assertTrue(proportion >= 0.15 && proportion <= 0.25, 
            "La proportion de trahisons aléatoires devrait être d'environ 20%.");
    }

    @Test
    public void testAucuneTrahisonLorsDeTrahisonAdverse() {
        StrategieSondeurNaif strategie = new StrategieSondeurNaif();

        // Si l'adversaire trahit, la stratégie doit simplement imiter sans jouer aléatoirement
        for (int i = 0; i < 100; i++) {
            assertEquals('t', strategie.decider('t'));
        }
    }
}
