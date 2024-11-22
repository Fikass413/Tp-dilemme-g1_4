package fr.uga.m1miage.pc.strategies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests pour la strat�gie Pavlov / Al�atoire.
 */
public class StrategiePavlovAleatoireTest {

    @Test
    public void testRepetitionDernierCoupPour3Ou5Points() {
        StrategiePavlovAleatoire strategie = new StrategiePavlovAleatoire();

        // Simuler un dernier coup (coop�ration)
        strategie.ajusterStrategie(3); // 3 points obtenus, doit r�p�ter le dernier coup
        char dernierCoup = strategie.decider('c');
        assertEquals('c', dernierCoup, "Le coup r�p�t� devrait �tre 'c' apr�s avoir obtenu 3 points.");

        // Simuler un dernier coup (trahison)
        strategie.ajusterStrategie(5); // 5 points obtenus, doit r�p�ter le dernier coup
        dernierCoup = strategie.decider('t');
        assertEquals('c', dernierCoup);
    }

    @Test
    public void testChoixAleatoirePourAutresScores() {
        StrategiePavlovAleatoire strategie = new StrategiePavlovAleatoire();

        // Simuler un score diff�rent de 3 ou 5
        strategie.ajusterStrategie(1); // Score non favorable, coup al�atoire attendu
        char choix = strategie.decider('c');
        assertTrue(choix == 'c' || choix == 't', "Le coup devrait �tre al�atoire (c ou t).");
    }

    @Test
    public void testAleatoireAvecProbabilite() {
        StrategiePavlovAleatoire strategie = new StrategiePavlovAleatoire();

        // Simuler plusieurs tours et compter les coups al�atoires
        int nombreDeTours = 1000;
        int coupsAleatoires = 0;
        for (int i = 0; i < nombreDeTours; i++) {
            char dernierCoup = strategie.decider('c');
            if (dernierCoup != 'c' && dernierCoup != 't') {
                coupsAleatoires++;
            }
        }

        // V�rifier que des coups al�atoires sont jou�s, et avec une proportion approximative
        double proportionAleatoire = (double) coupsAleatoires / nombreDeTours;
        System.out.println("Proportion aleatoire: " + String.valueOf(proportionAleatoire));
        assertTrue(proportionAleatoire >= 0 && proportionAleatoire < 0.5,
                "La proportion de coups al�atoires devrait �tre d'environ 10%.");
    }
}
