package fr.uga.m1miage.pc.strategies;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StrategieToujoursCoopererTest {

    @Test
    void testDecider() {
        StrategieToujoursCooperer strategie = new StrategieToujoursCooperer();

        // Coopère toujours
        assertEquals('c', strategie.decider('c'));
        assertEquals('c', strategie.decider('t'));
    }
}
