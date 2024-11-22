package fr.uga.m1miage.pc.strategies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests pour la stratégie Sondeur repentant.
 */
public class StrategieSondeurRepentantTest {

    @Test
    public void testImitationDernierCoup() {
        StrategieSondeurRepentant strategie = new StrategieSondeurRepentant();

        // Imitation simple du dernier coup de l'adversaire
        assertEquals('c', strategie.decider('c')); // Coopérer
        assertEquals('t', strategie.decider('t')); // Trahir
    }

    @Test
    public void testTrahisonAleatoireLorsDeCooperation() {
        StrategieSondeurRepentant strategie = new StrategieSondeurRepentant();

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
    public void testRepentanceApresTrahisonDeLAdversaire() {
        StrategieSondeurRepentant strategie = new StrategieSondeurRepentant();

        // Trahir aléatoirement, puis l'adversaire répond par une trahison
        strategie.decider('c'); // Premier coup (possiblement aléatoire)
        char resultat = strategie.decider('t'); // Adversaire trahit
        assertEquals('t', resultat);

        // Vérifier qu'après la repentance, la stratégie reprend son comportement habituel
        assertEquals('c', strategie.decider('t')); // Trahir si l'adversaire trahit
    }

    @Test
    public void testAleatoireAvecProbabilite() {
        StrategieSondeurRepentant strategie = new StrategieSondeurRepentant();

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
}
