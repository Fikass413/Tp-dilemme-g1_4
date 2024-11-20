package fr.uga.m1miage.pc.strategies;

public class StrategieDonnantPourDeuxDonnants implements Strategie {

    private int compteurTrahisons = 0;

    
    @Override
    public char decider(char dernierCoupAdversaire) {
        if (dernierCoupAdversaire == 't') {
            compteurTrahisons++;
        } else {
            compteurTrahisons = 0; // R�initialise le compteur si l'adversaire coop�re
        }

        return compteurTrahisons >= 2 ? 't' : 'c';
    }
}
