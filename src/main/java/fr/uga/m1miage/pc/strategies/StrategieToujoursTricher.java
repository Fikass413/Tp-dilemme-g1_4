package fr.uga.m1miage.pc.strategies;

public class StrategieToujoursTricher implements Strategie {
    @Override
    public char decider(char dernierCoupAdversaire) {
        return 't';
    }
}
