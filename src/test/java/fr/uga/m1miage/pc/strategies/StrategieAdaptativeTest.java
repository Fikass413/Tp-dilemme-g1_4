package fr.uga.m1miage.pc.strategies;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StrategieAdaptativeTest {

    @Test
    void testDecider() {
        StrategieAdaptative strategie = new StrategieAdaptative();

      
        assertEquals('c', strategie.decider('c'));

       
        strategie.ajouterPoints('c', 5);
        strategie.ajouterPoints('t', 3);

        
        assertEquals('c', strategie.decider('t'));
    }
}
