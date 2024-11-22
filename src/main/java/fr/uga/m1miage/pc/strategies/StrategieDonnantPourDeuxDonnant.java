package fr.uga.m1miage.pc.strategies;

/**
 * Strat�gie Donnant pour deux donnants :
 * L'adversaire doit faire le m�me choix deux fois de suite avant que cette strat�gie ne le r�ciproque.
 */
public class StrategieDonnantPourDeuxDonnant implements Strategie {
    private char dernierCoupAdversaire = 'c'; // Coop�ration par d�faut
    private char avantDernierCoupAdversaire = 'c'; // Coop�ration par d�faut

    @Override
    public char decider(char dernierCoupAdversaire) {
        // Mise � jour des coups adverses
        this.avantDernierCoupAdversaire = this.dernierCoupAdversaire;
        this.dernierCoupAdversaire = dernierCoupAdversaire;

        // V�rification : l'adversaire a-t-il r�p�t� le m�me coup deux fois ?
        if (this.dernierCoupAdversaire == this.avantDernierCoupAdversaire) {
            return this.dernierCoupAdversaire; // R�ciprocit�
        }

        // Par d�faut, coop�rer si les coups adverses sont diff�rents
        return 'c';
    }
}
