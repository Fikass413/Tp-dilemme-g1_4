package fr.uga.m1miage.pc.strategies;

import java.security.SecureRandom;

/**
 * Stratégie Sondeur naïf :
 * - Joue comme le dernier coup de l'adversaire.
 * - Avec une probabilité de 20%, trahit au lieu de coopérer.
 */
public class StrategieSondeurNaif implements Strategie {
    private final SecureRandom secureRandom = new SecureRandom();

    @Override
    public char decider(char dernierCoupAdversaire) {
        // Si le dernier coup de l'adversaire est de coopérer, trahir avec une probabilité de 20%
        if (dernierCoupAdversaire == 'c' && secureRandom.nextInt(100) < 20) {
            return 't'; // Trahir au lieu de coopérer
        }
        // Sinon, imiter le dernier coup de l'adversaire
        return dernierCoupAdversaire;
    }
}
