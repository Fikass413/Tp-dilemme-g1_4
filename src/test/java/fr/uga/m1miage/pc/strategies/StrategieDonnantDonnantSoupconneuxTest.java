package fr.uga.m1miage.pc.strategies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests pour la strat�gie Donnant donnant soupconneux.
 */
public class StrategieDonnantDonnantSoupconneuxTest {

    @Test
    public void testPremierTourTrahison() {
        StrategieDonnantDonnantSoupconneux strategie = new StrategieDonnantDonnantSoupconneux();

        // Premier tour : toujours trahir
        assertEquals('t', strategie.decider('c'), "Au premier tour, la strat�gie devrait toujours trahir.");
        assertEquals('t', strategie.decider('t'), "Au premier tour, la strat�gie devrait toujours trahir.");
    }

    @Test
    public void testImitationApresPremierTour() {
        StrategieDonnantDonnantSoupconneux strategie = new StrategieDonnantDonnantSoupconneux();

        // Premier tour
        strategie.decider('c'); // Ignor� pour ce test, v�rifie juste qu'il passe

        // Tours suivants : imiter le dernier coup de l'adversaire
        assertEquals('c', strategie.decider('c'), "La strat�gie devrait imiter une coop�ration apr�s le premier tour.");
        assertEquals('t', strategie.decider('t'), "La strat�gie devrait imiter une trahison apr�s le premier tour.");
    }

    @Test
    public void testComportementPlusieursTours() {
        StrategieDonnantDonnantSoupconneux strategie = new StrategieDonnantDonnantSoupconneux();

        // Premier tour : trahir
        assertEquals('t', strategie.decider('c'), "Au premier tour, la strat�gie devrait toujours trahir.");

        // Deuxi�me tour : imiter le dernier coup
        assertEquals('c', strategie.decider('c'), "La strat�gie devrait imiter une coop�ration.");
        assertEquals('t', strategie.decider('t'), "La strat�gie devrait imiter une trahison.");
    }
}
