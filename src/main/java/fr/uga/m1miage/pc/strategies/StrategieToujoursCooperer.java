package fr.uga.m1miage.pc.strategies;

public class StrategieToujoursCooperer implements Strategie {
    @Override
    public char decider(char dernierCoupAdversaire) {
        return 'c';
    }
}