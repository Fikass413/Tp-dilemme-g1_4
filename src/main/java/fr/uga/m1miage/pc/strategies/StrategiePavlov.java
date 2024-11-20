package fr.uga.m1miage.pc.strategies;

public class StrategiePavlov implements Strategie {
    private char dernierChoix = 'c';

    @Override
    public char decider(char dernierCoupAdversaire) {
        if (dernierCoupAdversaire == 'c') {
            return dernierChoix; 
        }
        dernierChoix = (dernierChoix == 'c') ? 't' : 'c'; 
        return dernierChoix;
    }
}