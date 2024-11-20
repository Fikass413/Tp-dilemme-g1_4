package fr.uga.m1miage.pc.strategies;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StrategieVraiPacificateurTest {

    @Test
    void testDecider() {
        StrategieVraiPacificateur strategie = new StrategieVraiPacificateur();

        
        assertEquals('c', strategie.decider('c'));
        assertEquals('c', strategie.decider('t'));
        assertEquals('c', strategie.decider((char) 0)); 
    }
}
