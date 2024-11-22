package fr.uga.m1miage.pc.strategies;

import java.security.SecureRandom;

/**
 * Stratégie Pavlov / Aléatoire :
 * - Si 5 ou 3 points ont été obtenus au tour précédent, répéter le dernier choix.
 * - Sinon, effectuer un choix aléatoire avec une probabilité donnée.
 * - Toujours inclure une part d'aléatoire dans les choix.
 */
public class StrategiePavlovAleatoire implements Strategie {
    private final SecureRandom secureRandom = new SecureRandom();
    private char dernierCoup = 'c'; // Coopérer par défaut

    @Override
    public char decider(char dernierCoupAdversaire) {
        // 10% de probabilité de jouer un coup aléatoire
        if (secureRandom.nextInt(100) < 10) {
            return choixAleatoire();
        }

        // Si 5 ou 3 points obtenus précédemment, répéter le dernier coup
        // (Imaginons que dernierCoup représente la décision précédente)
        return dernierCoup;
    }

    /**
     * Permet de définir le score obtenu au tour précédent pour ajuster la stratégie.
     * 
     * @param dernierScore Le score obtenu lors du dernier tour.
     */
    public void ajusterStrategie(int dernierScore) {
        if (dernierScore == 5 || dernierScore == 3) {
            // Si 5 ou 3 points ont été obtenus, conserver le dernier coup
            // Aucun changement n'est requis ici
        } else {
            // Sinon, préparer un coup aléatoire pour le prochain tour
            dernierCoup = choixAleatoire();
        }
    }

    /**
     * Génère un choix aléatoire ('c' ou 't').
     * 
     * @return Un coup aléatoire.
     */
    private char choixAleatoire() {
        return secureRandom.nextBoolean() ? 'c' : 't';
    }
}
