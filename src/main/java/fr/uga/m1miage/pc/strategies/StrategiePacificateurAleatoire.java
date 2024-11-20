package fr.uga.m1miage.pc.strategies;

import java.security.SecureRandom;



public class StrategiePacificateurAleatoire implements Strategie {

    private final SecureRandom random = new SecureRandom();

    
    @Override
    public char decider(char dernierCoupAdversaire) {
      
        return random.nextInt(100) < 80 ? 'c' : 't';
    }
}
