package fr.uga.m1miage.pc.strategies;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StrategiePavlovTest {

    @Test
    void testDecider() {
        StrategiePavlov strategie = new StrategiePavlov();

        // Coopère initialement
        assertEquals('c', strategie.decider('c'));

        // Alterne après une trahison
        assertEquals('t', strategie.decider('t'));
        assertEquals('c', strategie.decider('t'));
    }
}
