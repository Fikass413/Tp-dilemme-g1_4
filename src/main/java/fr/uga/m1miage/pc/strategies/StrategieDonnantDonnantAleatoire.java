package fr.uga.m1miage.pc.strategies;

import java.security.SecureRandom;



public class StrategieDonnantDonnantAleatoire implements Strategie {

    private final SecureRandom random = new SecureRandom();

    
    @Override
    public char decider(char dernierCoupAdversaire) {
        
        return random.nextBoolean() ? 'c' : 't';
    }
}
