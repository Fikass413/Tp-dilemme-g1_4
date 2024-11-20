package fr.uga.m1miage.pc.strategies;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StrategieToujoursTricherTest {

    @Test
    void testDecider() {
        StrategieToujoursTricher strategie = new StrategieToujoursTricher();

        // Trahit toujours
        assertEquals('t', strategie.decider('c'));
        assertEquals('t', strategie.decider('t'));
    }
}
