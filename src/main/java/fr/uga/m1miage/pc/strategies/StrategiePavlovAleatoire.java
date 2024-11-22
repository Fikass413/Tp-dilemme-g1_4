package fr.uga.m1miage.pc.strategies;

import java.security.SecureRandom;

/**
 * Strat�gie Pavlov / Al�atoire :
 * - Si 5 ou 3 points ont �t� obtenus au tour pr�c�dent, r�p�ter le dernier choix.
 * - Sinon, effectuer un choix al�atoire avec une probabilit� donn�e.
 * - Toujours inclure une part d'al�atoire dans les choix.
 */
public class StrategiePavlovAleatoire implements Strategie {
    private final SecureRandom secureRandom = new SecureRandom();
    private char dernierCoup = 'c'; // Coop�rer par d�faut

    @Override
    public char decider(char dernierCoupAdversaire) {
        // 10% de probabilit� de jouer un coup al�atoire
        if (secureRandom.nextInt(100) < 10) {
            return choixAleatoire();
        }

        // Si 5 ou 3 points obtenus pr�c�demment, r�p�ter le dernier coup
        // (Imaginons que dernierCoup repr�sente la d�cision pr�c�dente)
        return dernierCoup;
    }

    /**
     * Permet de d�finir le score obtenu au tour pr�c�dent pour ajuster la strat�gie.
     * 
     * @param dernierScore Le score obtenu lors du dernier tour.
     */
    public void ajusterStrategie(int dernierScore) {
        if (dernierScore == 5 || dernierScore == 3) {
            // Si 5 ou 3 points ont �t� obtenus, conserver le dernier coup
            // Aucun changement n'est requis ici
        } else {
            // Sinon, pr�parer un coup al�atoire pour le prochain tour
            dernierCoup = choixAleatoire();
        }
    }

    /**
     * G�n�re un choix al�atoire ('c' ou 't').
     * 
     * @return Un coup al�atoire.
     */
    private char choixAleatoire() {
        return secureRandom.nextBoolean() ? 'c' : 't';
    }
}
