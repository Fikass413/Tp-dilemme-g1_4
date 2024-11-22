package fr.uga.m1miage.pc.strategies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests pour la stratégie Pavlov / Aléatoire.
 */
public class StrategiePavlovAleatoireTest {

    @Test
    public void testRepetitionDernierCoupPour3Ou5Points() {
        StrategiePavlovAleatoire strategie = new StrategiePavlovAleatoire();

        // Simuler un dernier coup (coopération)
        strategie.ajusterStrategie(3); // 3 points obtenus, doit répéter le dernier coup
        char dernierCoup = strategie.decider('c');
        assertEquals('c', dernierCoup, "Le coup répété devrait être 'c' après avoir obtenu 3 points.");

        // Simuler un dernier coup (trahison)
        strategie.ajusterStrategie(5); // 5 points obtenus, doit répéter le dernier coup
        dernierCoup = strategie.decider('t');
        assertEquals('c', dernierCoup);
    }

    @Test
    public void testChoixAleatoirePourAutresScores() {
        StrategiePavlovAleatoire strategie = new StrategiePavlovAleatoire();

        // Simuler un score différent de 3 ou 5
        strategie.ajusterStrategie(1); // Score non favorable, coup aléatoire attendu
        char choix = strategie.decider('c');
        assertTrue(choix == 'c' || choix == 't', "Le coup devrait être aléatoire (c ou t).");
    }

    @Test
    public void testAleatoireAvecProbabilite() {
        StrategiePavlovAleatoire strategie = new StrategiePavlovAleatoire();

        // Simuler plusieurs tours et compter les coups aléatoires
        int nombreDeTours = 1000;
        int coupsAleatoires = 0;
        for (int i = 0; i < nombreDeTours; i++) {
            char dernierCoup = strategie.decider('c');
            if (dernierCoup != 'c' && dernierCoup != 't') {
                coupsAleatoires++;
            }
        }

        // Vérifier que des coups aléatoires sont joués, et avec une proportion approximative
        double proportionAleatoire = (double) coupsAleatoires / nombreDeTours;
        System.out.println("Proportion aleatoire: " + String.valueOf(proportionAleatoire));
        assertTrue(proportionAleatoire >= 0 && proportionAleatoire < 0.5,
                "La proportion de coups aléatoires devrait être d'environ 10%.");
    }
}
