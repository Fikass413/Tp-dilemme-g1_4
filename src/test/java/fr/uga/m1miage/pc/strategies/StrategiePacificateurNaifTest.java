package fr.uga.m1miage.pc.strategies;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StrategiePacificateurNaifTest {

    @Test
    void testDecider() {
        StrategiePacificateurNaif strategie = new StrategiePacificateurNaif();

        
        assertEquals('c', strategie.decider('t'));
        assertEquals('c', strategie.decider('c'));
    }
}

