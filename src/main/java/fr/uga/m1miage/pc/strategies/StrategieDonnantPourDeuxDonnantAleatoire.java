package fr.uga.m1miage.pc.strategies;

import java.security.SecureRandom;

/**
 * Stratégie Donnant pour deux donnants et aléatoire :
 * Comme donnant pour deux donnants sauf que parfois, un coup aléatoire est joué.
 */
public class StrategieDonnantPourDeuxDonnantAleatoire implements Strategie {
    private char dernierCoupAdversaire = 'c'; // Coopération par défaut
    private char avantDernierCoupAdversaire = 'c'; // Coopération par défaut
    private final SecureRandom random = new SecureRandom();

    @Override
    public char decider(char dernierCoupAdversaire) {
        // Mise à jour des coups adverses
        this.avantDernierCoupAdversaire = this.dernierCoupAdversaire;
        this.dernierCoupAdversaire = dernierCoupAdversaire;

        // Génère un comportement aléatoire : 20% de chance de jouer un coup au hasard
        if (random.nextDouble() < 0.1) { // 10% de probabilité
            return random.nextBoolean() ? 'c' : 't';
        }

        // Si l'adversaire a répété le même coup deux fois, imiter ce coup
        if (this.dernierCoupAdversaire == this.avantDernierCoupAdversaire) {
            return this.dernierCoupAdversaire; // Réciprocité
        }

        // Sinon, coopérer par défaut
        return 'c';
    }
}
