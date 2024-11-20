package fr.uga.m1miage.pc.model;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {

    @Test
    void testConstructeurEtAccesseurs() {
        Joueur joueur = new Joueur("Alice", "DonnantDonnant", 10, 'c');

      
        assertEquals("Alice", joueur.getNom());
        assertEquals("DonnantDonnant", joueur.getStrategie());
        assertEquals(10, joueur.getScore());
        assertEquals('c', joueur.getDernierCoup());
    }

    @Test
    void testAjouterScore() {
        Joueur joueur = new Joueur("Bob", "ToujoursCooperer", 5, 't');
        joueur.ajouterScore(10);

       
        assertEquals(15, joueur.getScore());
    }

    @Test
    void testResetScore() {
        Joueur joueur = new Joueur("Charlie", "ToujoursTricher", 20, 'c');
        joueur.resetScore();

       
        assertEquals(0, joueur.getScore());
    }

    @Test
    void testJouerCoup() {
        Joueur joueur = new Joueur("David", "Graduel", 10, 'c');
        joueur.jouerCoup('t');

        
        assertEquals('t', joueur.getDernierCoup());
    }
}
