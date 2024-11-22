package fr.uga.m1miage.pc.strategies;

/**
 * Stratégie Donnant donnant soupçonneux :
 * - Commence toujours par trahir au premier tour.
 * - Ensuite, joue comme le dernier coup de l'adversaire.
 */
public class StrategieDonnantDonnantSoupconneux implements Strategie {
    private boolean premierTour = true;

    @Override
    public char decider(char dernierCoupAdversaire) {
        if (premierTour) {
            premierTour = false;
            return 't'; // Trahir au premier tour
        }

        // Imiter le dernier coup de l'adversaire
        return dernierCoupAdversaire == 0 ? 'c' : dernierCoupAdversaire;
    }
}
