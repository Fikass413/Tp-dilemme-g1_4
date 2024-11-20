package fr.uga.m1miage.pc.strategies;

public class StrategieRancunierDoux implements Strategie {

    private boolean rancune = false; 
    private int toursDePunition = 0; 
    private final int MAX_PUNITION = 3; 

    
    @Override
    public char decider(char dernierCoupAdversaire) {
        if (dernierCoupAdversaire == 't') {
           
            rancune = true;
            toursDePunition = MAX_PUNITION;
        }

        if (rancune) {
            
            toursDePunition--;
            if (toursDePunition <= 0) {
                rancune = false; 
            }
            return 't'; 
        }

     
        return 'c';
    }
}

