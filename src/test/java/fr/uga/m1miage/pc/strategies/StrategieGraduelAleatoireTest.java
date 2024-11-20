package fr.uga.m1miage.pc.strategies;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StrategieGraduelAleatoireTest {

    @Test
    void testDeciderAvecCooperation() {
        StrategieGraduelAleatoire strategie = new StrategieGraduelAleatoire();

        // L'adversaire coop�re, donc le choix peut �tre al�atoire
        char choix = strategie.decider('c');
        assertTrue(choix == 'c' || choix == 't', "Le choix doit �tre 'c' ou 't'");
    }

    @Test
    void testDeciderAvecTrahison() {
        StrategieGraduelAleatoire strategie = new StrategieGraduelAleatoire();

        // L'adversaire trahit une fois
        assertTrue(strategie.decider('t') == 't', "Le choix doit �tre 't' (d�but de la punition)");
        // Punit encore
        assertTrue(strategie.decider('c') == 't', "Le choix doit �tre 't' (punition active)");
    }

    @Test
    void testDeciderAvecPunitionTerminee() {
        StrategieGraduelAleatoire strategie = new StrategieGraduelAleatoire();

        // L'adversaire trahit plusieurs fois
        strategie.decider('t'); // Active la punition
        strategie.decider('c'); // Punit encore
        strategie.decider('c'); // Fin de la punition

        // Retour � un comportement al�atoire
        char choix = strategie.decider('c');
        assertTrue(choix == 'c' || choix == 't', "Le choix doit �tre 'c' ou 't'");
    }
}
