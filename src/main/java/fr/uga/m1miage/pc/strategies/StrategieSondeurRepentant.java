package fr.uga.m1miage.pc.strategies;

import java.security.SecureRandom;

/**
 * Stratégie Sondeur repentant :
 * - Joue comme le dernier coup de l'adversaire.
 * - Peut trahir aléatoirement avec une probabilité de 20%.
 * - Si l'adversaire trahit en réponse, coopère immédiatement au tour suivant (repentance).
 */
public class StrategieSondeurRepentant implements Strategie {
    private final SecureRandom secureRandom = new SecureRandom();
    private boolean repentant = false;

    @Override
    public char decider(char dernierCoupAdversaire) {
        // Si la stratégie est en mode repentance, coopérer immédiatement
        if (repentant) {
            repentant = false; // La repentance ne dure qu'un tour
            return 'c';
        }

        // Si l'adversaire coopère, possibilité de trahir aléatoirement
        if (dernierCoupAdversaire == 'c' && secureRandom.nextInt(100) < 20) {
            return 't'; // Test de trahison
        }

        // Si l'adversaire trahit en réponse, activer le mode repentance
        if (dernierCoupAdversaire == 't') {
            repentant = true; // Mode repentance activé pour le prochain tour
        }

        // Sinon, imiter le dernier coup de l'adversaire
        return dernierCoupAdversaire;
    }
}
