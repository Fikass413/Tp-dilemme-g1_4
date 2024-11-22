package fr.uga.m1miage.pc.strategies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests pour la stratégie Donnant donnant soupconneux.
 */
public class StrategieDonnantDonnantSoupconneuxTest {

    @Test
    public void testPremierTourTrahison() {
        StrategieDonnantDonnantSoupconneux strategie = new StrategieDonnantDonnantSoupconneux();

        // Premier tour : toujours trahir
        assertEquals('t', strategie.decider('c'), "Au premier tour, la stratégie devrait toujours trahir.");
        assertEquals('t', strategie.decider('t'), "Au premier tour, la stratégie devrait toujours trahir.");
    }

    @Test
    public void testImitationApresPremierTour() {
        StrategieDonnantDonnantSoupconneux strategie = new StrategieDonnantDonnantSoupconneux();

        // Premier tour
        strategie.decider('c'); // Ignoré pour ce test, vérifie juste qu'il passe

        // Tours suivants : imiter le dernier coup de l'adversaire
        assertEquals('c', strategie.decider('c'), "La stratégie devrait imiter une coopération après le premier tour.");
        assertEquals('t', strategie.decider('t'), "La stratégie devrait imiter une trahison après le premier tour.");
    }

    @Test
    public void testComportementPlusieursTours() {
        StrategieDonnantDonnantSoupconneux strategie = new StrategieDonnantDonnantSoupconneux();

        // Premier tour : trahir
        assertEquals('t', strategie.decider('c'), "Au premier tour, la stratégie devrait toujours trahir.");

        // Deuxième tour : imiter le dernier coup
        assertEquals('c', strategie.decider('c'), "La stratégie devrait imiter une coopération.");
        assertEquals('t', strategie.decider('t'), "La stratégie devrait imiter une trahison.");
    }
}
