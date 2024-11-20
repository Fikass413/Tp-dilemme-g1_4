package fr.uga.m1miage.pc.strategies;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StrategieDonnantDonnantTest {

    @Test
    void testDecider() {
        StrategieDonnantDonnant strategie = new StrategieDonnantDonnant();

       
        assertEquals('c', strategie.decider((char) 0));

        
        assertEquals('c', strategie.decider('c'));

      
        assertEquals('t', strategie.decider('t'));
    }
}
