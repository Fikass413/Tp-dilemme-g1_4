package fr.uga.m1miage.pc.strategies;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StrategieAleatoireTest {

    @Test
    void testDecider() {
        StrategieAleatoire strategie = new StrategieAleatoire();

        
        for (int i = 0; i < 100; i++) {
            char choix = strategie.decider('c');
            assertTrue(choix == 'c' || choix == 't');
        }
    }
}
