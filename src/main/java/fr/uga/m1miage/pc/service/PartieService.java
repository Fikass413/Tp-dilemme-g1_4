package fr.uga.m1miage.pc.service;

import fr.uga.m1miage.pc.model.Joueur;
import fr.uga.m1miage.pc.model.Partie;
import fr.uga.m1miage.pc.strategies.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Service pour gérer les parties entre deux joueurs.
 */
public class PartieService {

    /**
     * Initialise les stratégies disponibles.
     */
    public PartieService() {
        
    }

    public Partie creerPartie(Joueur joueur1, Joueur joueur2, int toursRestants) {
        if (toursRestants < 0) {
            throw new IllegalArgumentException("Le nombre de tours ne peut pas être négatif.");
        }
        return new Partie(joueur1, joueur2, toursRestants);
    }

    /**
     * Joue un tour entre les deux joueurs de la partie.
     *
     * @param partie La partie en cours.
     */
    public void jouerTour(Partie partie) {
        if (partie.getToursRestants() <= 0) {
            throw new IllegalStateException("La partie est terminée.");
        }

        Joueur joueur1 = partie.getJoueur1();
        Joueur joueur2 = partie.getJoueur2();

        Strategie strategie1 = FactorieStrategie.creerStrategies(CategorieStrategie.fromString(joueur1.getStrategie()));
        Strategie strategie2 = FactorieStrategie.creerStrategies(CategorieStrategie.fromString(joueur2.getStrategie()));

        if (strategie1 == null || strategie2 == null) {
            throw new RuntimeException("Une ou plusieurs stratégies sont invalides.");
        }

        // Calcul des coups des joueurs
        char choix1 = strategie1.decider(joueur1.getDernierCoup());
        char choix2 = strategie2.decider(joueur2.getDernierCoup());

        // Mise à jour des scores
        calculerScores(joueur1, choix1, joueur2, choix2);

        // Réduction du nombre de tours restants
        partie.setToursRestants(partie.getToursRestants() - 1);
    }

    /**
     * Calcule les scores pour un tour en fonction des choix des joueurs.
     *
     * @param joueur1 Le premier joueur.
     * @param choix1  Le choix du premier joueur ('c' ou 't').
     * @param joueur2 Le second joueur.
     * @param choix2  Le choix du second joueur ('c' ou 't').
     */
    private void calculerScores(Joueur joueur1, char choix1, Joueur joueur2, char choix2) {
        final int T = 5; // Trahir contre un coopérant
        final int C = 3; // Coopération mutuelle
        final int P = 1; // Trahison mutuelle
        final int D = 0; // Coopérer contre un traître

        if (choix1 == 't' && choix2 == 't') {
            joueur1.setScore(joueur1.getScore() + P);
            joueur2.setScore(joueur2.getScore() + P);
        } else if (choix1 == 'c' && choix2 == 'c') {
            joueur1.setScore(joueur1.getScore() + C);
            joueur2.setScore(joueur2.getScore() + C);
        } else if (choix1 == 't' && choix2 == 'c') {
            joueur1.setScore(joueur1.getScore() + T);
            joueur2.setScore(joueur2.getScore() + D);
        } else if (choix1 == 'c' && choix2 == 't'){
            joueur1.setScore(joueur1.getScore() + D);
            joueur2.setScore(joueur2.getScore() + T);
        }

        // Mise à jour des derniers coups
        joueur1.setDernierCoup(choix1);
        joueur2.setDernierCoup(choix2);
    }
}
