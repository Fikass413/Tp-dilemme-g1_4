package fr.uga.m1miage.pc.strategies;


public class StrategieAdaptative implements Strategie {
    private int scorePourCooperer = 0;
    private int scorePourTrahir = 0;

    @Override
    public char decider(char dernierCoupAdversaire) {
        return scorePourCooperer >= scorePourTrahir ? 'c' : 't';
    }

    public void ajouterPoints(char action, int points) {
        if (action == 'c') {
            scorePourCooperer += points;
        } else {
            scorePourTrahir += points;
        }
    }
}
