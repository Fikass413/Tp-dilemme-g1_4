package fr.uga.m1miage.pc.strategies;

import java.security.SecureRandom;

/**
 * Strat�gie Sondeur repentant :
 * - Joue comme le dernier coup de l'adversaire.
 * - Peut trahir al�atoirement avec une probabilit� de 20%.
 * - Si l'adversaire trahit en r�ponse, coop�re imm�diatement au tour suivant (repentance).
 */
public class StrategieSondeurRepentant implements Strategie {
    private final SecureRandom secureRandom = new SecureRandom();
    private boolean repentant = false;

    @Override
    public char decider(char dernierCoupAdversaire) {
        // Si la strat�gie est en mode repentance, coop�rer imm�diatement
        if (repentant) {
            repentant = false; // La repentance ne dure qu'un tour
            return 'c';
        }

        // Si l'adversaire coop�re, possibilit� de trahir al�atoirement
        if (dernierCoupAdversaire == 'c' && secureRandom.nextInt(100) < 20) {
            return 't'; // Test de trahison
        }

        // Si l'adversaire trahit en r�ponse, activer le mode repentance
        if (dernierCoupAdversaire == 't') {
            repentant = true; // Mode repentance activ� pour le prochain tour
        }

        // Sinon, imiter le dernier coup de l'adversaire
        return dernierCoupAdversaire;
    }
}
