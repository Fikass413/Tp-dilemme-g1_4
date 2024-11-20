package fr.uga.m1miage.pc.strategies;


public class StrategieDonnantDonnant implements Strategie {
    @Override
    public char decider(char dernierCoupAdversaire) {
        return dernierCoupAdversaire == 0 ? 'c' : dernierCoupAdversaire;
    }
}