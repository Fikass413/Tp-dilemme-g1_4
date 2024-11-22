package fr.uga.m1miage.pc.strategies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests pour la stratégie Donnant pour deux donnants et aléatoire.
 */
public class StrategieDonnantPourDeuxDonnantAleatoireTest {

    @Test
    public void testStrategieInitialeCooperation() {
        StrategieDonnantPourDeuxDonnantAleatoire strategie = new StrategieDonnantPourDeuxDonnantAleatoire();

        // Premier tour, coopère par défaut
        assertEquals('c', strategie.decider('c'));
    }

    @Test
    public void testRéciprocitéApresDeuxCoupsIdentiques() {
        StrategieDonnantPourDeuxDonnantAleatoire strategie = new StrategieDonnantPourDeuxDonnantAleatoire();

        // Adversaire coopère deux fois de suite
        assertEquals('c', strategie.decider('c')); // Premier tour
        assertEquals('c', strategie.decider('c')); // Deuxième tour : Réciprocité

        // Adversaire trahit deux fois de suite
        assertEquals('c', strategie.decider('t')); // Premier coup de trahison
        assertEquals('t', strategie.decider('t')); // Deuxième coup de trahison : Réciprocité
    }

    @Test
    public void testCooperationSiCoupsDifferents() {
        StrategieDonnantPourDeuxDonnantAleatoire strategie = new StrategieDonnantPourDeuxDonnantAleatoire();

        // Adversaire alterne entre coopérer et trahir
        assertEquals('c', strategie.decider('c')); // Premier coup coopérant
        assertEquals('c', strategie.decider('t')); // Coup trahissant
        assertEquals('c', strategie.decider('c')); // Retour à coopération
    }

    @Test
    public void testPresenceDeCoupAleatoire() {
        StrategieDonnantPourDeuxDonnantAleatoire strategie = new StrategieDonnantPourDeuxDonnantAleatoire();

        // Simuler plusieurs tours pour détecter des coups aléatoires
        boolean aleatoireDetecte = false;
        for (int i = 0; i < 100; i++) {
            char resultat = strategie.decider('c');
            if (resultat == 't') { // Un coup aléatoire (trahison inattendue) est détecté
                aleatoireDetecte = true;
                break;
            }
        }

        assertTrue(aleatoireDetecte, "Un coup aléatoire aurait dû être détecté après plusieurs itérations.");
    }
}
