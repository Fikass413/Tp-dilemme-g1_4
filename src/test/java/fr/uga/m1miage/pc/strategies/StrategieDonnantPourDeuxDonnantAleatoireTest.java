package fr.uga.m1miage.pc.strategies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests pour la strat�gie Donnant pour deux donnants et al�atoire.
 */
public class StrategieDonnantPourDeuxDonnantAleatoireTest {

    @Test
    public void testStrategieInitialeCooperation() {
        StrategieDonnantPourDeuxDonnantAleatoire strategie = new StrategieDonnantPourDeuxDonnantAleatoire();

        // Premier tour, coop�re par d�faut
        assertEquals('c', strategie.decider('c'));
    }

    @Test
    public void testR�ciprocit�ApresDeuxCoupsIdentiques() {
        StrategieDonnantPourDeuxDonnantAleatoire strategie = new StrategieDonnantPourDeuxDonnantAleatoire();

        // Adversaire coop�re deux fois de suite
        assertEquals('c', strategie.decider('c')); // Premier tour
        assertEquals('c', strategie.decider('c')); // Deuxi�me tour : R�ciprocit�

        // Adversaire trahit deux fois de suite
        assertEquals('c', strategie.decider('t')); // Premier coup de trahison
        assertEquals('t', strategie.decider('t')); // Deuxi�me coup de trahison : R�ciprocit�
    }

    @Test
    public void testCooperationSiCoupsDifferents() {
        StrategieDonnantPourDeuxDonnantAleatoire strategie = new StrategieDonnantPourDeuxDonnantAleatoire();

        // Adversaire alterne entre coop�rer et trahir
        assertEquals('c', strategie.decider('c')); // Premier coup coop�rant
        assertEquals('c', strategie.decider('t')); // Coup trahissant
        assertEquals('c', strategie.decider('c')); // Retour � coop�ration
    }

    @Test
    public void testPresenceDeCoupAleatoire() {
        StrategieDonnantPourDeuxDonnantAleatoire strategie = new StrategieDonnantPourDeuxDonnantAleatoire();

        // Simuler plusieurs tours pour d�tecter des coups al�atoires
        boolean aleatoireDetecte = false;
        for (int i = 0; i < 100; i++) {
            char resultat = strategie.decider('c');
            if (resultat == 't') { // Un coup al�atoire (trahison inattendue) est d�tect�
                aleatoireDetecte = true;
                break;
            }
        }

        assertTrue(aleatoireDetecte, "Un coup al�atoire aurait d� �tre d�tect� apr�s plusieurs it�rations.");
    }
}
