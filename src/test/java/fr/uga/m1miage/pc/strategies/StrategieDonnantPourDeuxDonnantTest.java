package fr.uga.m1miage.pc.strategies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests pour la stratégie Donnant pour deux donnants.
 */
public class StrategieDonnantPourDeuxDonnantTest {

    @Test
    public void testStrategieInitialeCooperation() {
        StrategieDonnantPourDeuxDonnant strategie = new StrategieDonnantPourDeuxDonnant();

        // Premier tour, coopère par défaut
        assertEquals('c', strategie.decider('c'));
    }

    @Test
    public void testRéciprocitéApresDeuxCoupIdentiques() {
        StrategieDonnantPourDeuxDonnant strategie = new StrategieDonnantPourDeuxDonnant();

        // Adversaire coopère deux fois de suite
        assertEquals('c', strategie.decider('c')); // Premier tour
        assertEquals('c', strategie.decider('c')); // Deuxième tour : Réciprocité

        // Adversaire trahit deux fois de suite
        assertEquals('c', strategie.decider('t')); // Premier coup de trahison
        assertEquals('t', strategie.decider('t')); // Deuxième coup de trahison : Réciprocité
    }

    @Test
    public void testCooperationSiCoupsDifferents() {
        StrategieDonnantPourDeuxDonnant strategie = new StrategieDonnantPourDeuxDonnant();

        // Adversaire alterne entre coopérer et trahir
        assertEquals('c', strategie.decider('c')); // Premier coup coopérant
        assertEquals('c', strategie.decider('t')); // Coup trahissant
        assertEquals('c', strategie.decider('c')); // Retour à coopération
    }

    @Test
    public void testRépétitionDansUnePartie() {
        StrategieDonnantPourDeuxDonnant strategie = new StrategieDonnantPourDeuxDonnant();

        // Séquence de coups : ['c', 't', 't', 'c', 'c', 't', 't']
        assertEquals('c', strategie.decider('c')); // Coopération
        assertEquals('c', strategie.decider('t')); // Trahison
        assertEquals('t', strategie.decider('t')); // Réciprocité après deux trahisons
        assertEquals('c', strategie.decider('c')); // Coopération
        assertEquals('c', strategie.decider('c')); // Réciprocité après deux coopérations
        assertEquals('c', strategie.decider('t')); // Trahison unique
        assertEquals('t', strategie.decider('t')); // Réciprocité après deux trahisons
    }

    @Test
    public void testParDefautPremiereCooperation() {
        StrategieDonnantPourDeuxDonnant strategie = new StrategieDonnantPourDeuxDonnant();

        // Premier coup inconnu, devrait coopérer
        assertEquals('c', strategie.decider('t')); // Coopération par défaut au premier coup
    }
}
