package fr.uga.m1miage.pc.strategies;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StrategieRancunierTest {

    @Test
    void testDecider() {
        StrategieRancunier strategie = new StrategieRancunier();

      
        assertEquals('c', strategie.decider('c'));

       
        assertEquals('t', strategie.decider('t'));
        assertEquals('t', strategie.decider('c')); 
    }
}
