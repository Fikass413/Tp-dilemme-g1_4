package fr.uga.m1miage.pc.strategies;

import java.security.SecureRandom;

/**
 * Strat�gie Sondeur na�f :
 * - Joue comme le dernier coup de l'adversaire.
 * - Avec une probabilit� de 20%, trahit au lieu de coop�rer.
 */
public class StrategieSondeurNaif implements Strategie {
    private final SecureRandom secureRandom = new SecureRandom();

    @Override
    public char decider(char dernierCoupAdversaire) {
        // Si le dernier coup de l'adversaire est de coop�rer, trahir avec une probabilit� de 20%
        if (dernierCoupAdversaire == 'c' && secureRandom.nextInt(100) < 20) {
            return 't'; // Trahir au lieu de coop�rer
        }
        // Sinon, imiter le dernier coup de l'adversaire
        return dernierCoupAdversaire;
    }
}
