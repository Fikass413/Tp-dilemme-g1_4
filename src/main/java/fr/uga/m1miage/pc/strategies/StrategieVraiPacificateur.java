package fr.uga.m1miage.pc.strategies;
public class StrategieVraiPacificateur implements Strategie {

    
    @Override
    public char decider(char dernierCoupAdversaire) {
        return 'c';
    }
}
