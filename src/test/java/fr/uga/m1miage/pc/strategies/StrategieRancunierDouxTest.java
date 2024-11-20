package fr.uga.m1miage.pc.strategies;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StrategieRancunierDouxTest {

    @Test
    void testDecider() {
        StrategieRancunierDoux strategie = new StrategieRancunierDoux();

       
        assertEquals('c', strategie.decider('c'));

     
        strategie.decider('t');
        assertEquals('t', strategie.decider('c'));

        
        for (int i = 0; i < 3; i++) {
            strategie.decider('c'); 
        }
        assertEquals('c', strategie.decider('c')); 
    }
}
