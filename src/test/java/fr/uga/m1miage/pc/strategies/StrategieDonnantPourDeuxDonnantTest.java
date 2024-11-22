package fr.uga.m1miage.pc.strategies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests pour la strat�gie Donnant pour deux donnants.
 */
public class StrategieDonnantPourDeuxDonnantTest {

    @Test
    public void testStrategieInitialeCooperation() {
        StrategieDonnantPourDeuxDonnant strategie = new StrategieDonnantPourDeuxDonnant();

        // Premier tour, coop�re par d�faut
        assertEquals('c', strategie.decider('c'));
    }

    @Test
    public void testR�ciprocit�ApresDeuxCoupIdentiques() {
        StrategieDonnantPourDeuxDonnant strategie = new StrategieDonnantPourDeuxDonnant();

        // Adversaire coop�re deux fois de suite
        assertEquals('c', strategie.decider('c')); // Premier tour
        assertEquals('c', strategie.decider('c')); // Deuxi�me tour : R�ciprocit�

        // Adversaire trahit deux fois de suite
        assertEquals('c', strategie.decider('t')); // Premier coup de trahison
        assertEquals('t', strategie.decider('t')); // Deuxi�me coup de trahison : R�ciprocit�
    }

    @Test
    public void testCooperationSiCoupsDifferents() {
        StrategieDonnantPourDeuxDonnant strategie = new StrategieDonnantPourDeuxDonnant();

        // Adversaire alterne entre coop�rer et trahir
        assertEquals('c', strategie.decider('c')); // Premier coup coop�rant
        assertEquals('c', strategie.decider('t')); // Coup trahissant
        assertEquals('c', strategie.decider('c')); // Retour � coop�ration
    }

    @Test
    public void testR�p�titionDansUnePartie() {
        StrategieDonnantPourDeuxDonnant strategie = new StrategieDonnantPourDeuxDonnant();

        // S�quence de coups : ['c', 't', 't', 'c', 'c', 't', 't']
        assertEquals('c', strategie.decider('c')); // Coop�ration
        assertEquals('c', strategie.decider('t')); // Trahison
        assertEquals('t', strategie.decider('t')); // R�ciprocit� apr�s deux trahisons
        assertEquals('c', strategie.decider('c')); // Coop�ration
        assertEquals('c', strategie.decider('c')); // R�ciprocit� apr�s deux coop�rations
        assertEquals('c', strategie.decider('t')); // Trahison unique
        assertEquals('t', strategie.decider('t')); // R�ciprocit� apr�s deux trahisons
    }

    @Test
    public void testParDefautPremiereCooperation() {
        StrategieDonnantPourDeuxDonnant strategie = new StrategieDonnantPourDeuxDonnant();

        // Premier coup inconnu, devrait coop�rer
        assertEquals('c', strategie.decider('t')); // Coop�ration par d�faut au premier coup
    }
}
