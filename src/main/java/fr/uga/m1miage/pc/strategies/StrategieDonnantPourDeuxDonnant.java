package fr.uga.m1miage.pc.strategies;

/**
 * Stratégie Donnant pour deux donnants :
 * L'adversaire doit faire le même choix deux fois de suite avant que cette stratégie ne le réciproque.
 */
public class StrategieDonnantPourDeuxDonnant implements Strategie {
    private char dernierCoupAdversaire = 'c'; // Coopération par défaut
    private char avantDernierCoupAdversaire = 'c'; // Coopération par défaut

    @Override
    public char decider(char dernierCoupAdversaire) {
        // Mise à jour des coups adverses
        this.avantDernierCoupAdversaire = this.dernierCoupAdversaire;
        this.dernierCoupAdversaire = dernierCoupAdversaire;

        // Vérification : l'adversaire a-t-il répété le même coup deux fois ?
        if (this.dernierCoupAdversaire == this.avantDernierCoupAdversaire) {
            return this.dernierCoupAdversaire; // Réciprocité
        }

        // Par défaut, coopérer si les coups adverses sont différents
        return 'c';
    }
}
