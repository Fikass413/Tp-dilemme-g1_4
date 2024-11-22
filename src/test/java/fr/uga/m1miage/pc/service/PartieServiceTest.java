package fr.uga.m1miage.pc.service;

import fr.uga.m1miage.pc.model.Joueur;
import fr.uga.m1miage.pc.model.Partie;
import fr.uga.m1miage.pc.service.PartieService;
import fr.uga.m1miage.pc.strategies.Strategie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartieServiceTest {

    private PartieService partieService;
    private Joueur joueur1;
    private Joueur joueur2;

    @BeforeEach
    void setUp() {
        partieService = new PartieService();
        joueur1 = new Joueur();
        joueur1.setStrategie("DonnantDonnant");
        joueur2 = new Joueur();
        joueur2.setStrategie("DonnantDonnant");
    }

    @Test
    void testCreerPartieAvecToursValides() {
        Partie partie = partieService.creerPartie(joueur1, joueur2, 5);
        assertNotNull(partie);
        assertEquals(5, partie.getToursRestants());
        assertEquals(joueur1, partie.getJoueur1());
        assertEquals(joueur2, partie.getJoueur2());
    }

    @Test
    void testCreerPartieAvecToursNegatifs() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            partieService.creerPartie(joueur1, joueur2, -1);
        });
        assertEquals("Le nombre de tours ne peut pas être négatif.", exception.getMessage());
    }

    @Test
    void testJouerTourAvecStrategiesValides() {
        Partie partie = partieService.creerPartie(joueur1, joueur2, 5);
        partieService.jouerTour(partie);
        assertEquals(3, joueur1.getScore());
        assertEquals(3, joueur2.getScore());
        assertEquals('c', joueur1.getDernierCoup());
        assertEquals('c', joueur2.getDernierCoup());
        assertEquals(4, partie.getToursRestants());
    }

    @Test
    void testJouerTourQuandPartieTerminee() {
        Partie partie = partieService.creerPartie(joueur1, joueur2, 0);
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            partieService.jouerTour(partie);
        });
        assertEquals("La partie est terminée.", exception.getMessage());
    }

    @Test
    void testCalculerScores() {
        // Test de coopération mutuelle
        Partie partie = partieService.creerPartie(joueur1, joueur2, 5);
        partieService.jouerTour(partie);
        assertEquals(3, joueur1.getScore());
        assertEquals(3, joueur2.getScore());

        // Test de trahison contre coopération
        joueur1.jouerCoup('c'); // Joueur 1 coopère
        joueur2.jouerCoup('t'); // Joueur 2 trahit
        partieService.jouerTour(partie);
        assertEquals(3, partie.getJoueur1().getScore());
        assertEquals(8, partie.getJoueur2().getScore()); // 3 + 5

        // Test de trahison mutuelle
        joueur1.jouerCoup('t'); // Joueur 1 trahit
        joueur2.jouerCoup('t'); // Joueur 2 trahit
        partieService.jouerTour(partie);
        assertEquals(4, partie.getJoueur1().getScore()); // 8 + 1
        assertEquals(9, partie.getJoueur2().getScore()); // 8 + 1

        // Test de coopération contre trahison
        joueur1.jouerCoup('t'); // Joueur 1 trahit
        joueur2.jouerCoup('c'); // Joueur 2 coopère
        partieService.jouerTour(partie);
        assertEquals(9, partie.getJoueur1().getScore()); // 9 + 5
        assertEquals(9, partie.getJoueur2().getScore()); // 9 + 0
    }
}