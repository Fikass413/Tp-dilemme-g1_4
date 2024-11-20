package fr.uga.m1miage.pc.strategies;

public class StrategieRancunier implements Strategie {
    private boolean rancune = false;

    @Override
    public char decider(char dernierCoupAdversaire) {
        if (dernierCoupAdversaire == 't') {
            rancune = true;
        }
        return rancune ? 't' : 'c';
    }
}
