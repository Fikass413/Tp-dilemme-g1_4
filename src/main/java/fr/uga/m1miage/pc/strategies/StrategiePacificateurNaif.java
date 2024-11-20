package fr.uga.m1miage.pc.strategies;

public class StrategiePacificateurNaif implements Strategie {

    
    @Override
    public char decider(char dernierCoupAdversaire) {
        return 'c'; 
    }
}

