package fr.uga.m1miage.pc.strategies;

import java.security.SecureRandom;

/**
 * Strat�gie Donnant pour deux donnants et al�atoire :
 * Comme donnant pour deux donnants sauf que parfois, un coup al�atoire est jou�.
 */
public class StrategieDonnantPourDeuxDonnantAleatoire implements Strategie {
    private char dernierCoupAdversaire = 'c'; // Coop�ration par d�faut
    private char avantDernierCoupAdversaire = 'c'; // Coop�ration par d�faut
    private final SecureRandom random = new SecureRandom();

    @Override
    public char decider(char dernierCoupAdversaire) {
        // Mise � jour des coups adverses
        this.avantDernierCoupAdversaire = this.dernierCoupAdversaire;
        this.dernierCoupAdversaire = dernierCoupAdversaire;

        // G�n�re un comportement al�atoire : 20% de chance de jouer un coup au hasard
        if (random.nextDouble() < 0.1) { // 10% de probabilit�
            return random.nextBoolean() ? 'c' : 't';
        }

        // Si l'adversaire a r�p�t� le m�me coup deux fois, imiter ce coup
        if (this.dernierCoupAdversaire == this.avantDernierCoupAdversaire) {
            return this.dernierCoupAdversaire; // R�ciprocit�
        }

        // Sinon, coop�rer par d�faut
        return 'c';
    }
}
