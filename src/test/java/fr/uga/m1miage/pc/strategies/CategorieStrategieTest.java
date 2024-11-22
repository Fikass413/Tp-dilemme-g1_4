package fr.uga.m1miage.pc.strategies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests pour l'énumération CategorieStrategie et la méthode fromString.
 */
public class CategorieStrategieTest {

    @Test
    public void testFromString_ValidValues() {
        // Vérification que la méthode fromString retourne la bonne stratégie pour des valeurs valides.
        assertEquals(CategorieStrategie.DONNANT_DONNANT, CategorieStrategie.fromString("DonnantDonnant"));
        assertEquals(CategorieStrategie.DONNANT_DONNANT_ALEATOIRE, CategorieStrategie.fromString("DonnantDonnantAleatoire"));
        assertEquals(CategorieStrategie.DONNANT_DEUX_DONNANT_ALEATOIRE, CategorieStrategie.fromString("DonnantDeuxDonnantAleatoire"));
        assertEquals(CategorieStrategie.DONNANT_DEUX_DONNANT, CategorieStrategie.fromString("DonnantDeuxDonnant"));
        assertEquals(CategorieStrategie.SONDEUR_NAIF, CategorieStrategie.fromString("SondeurNaif"));
        assertEquals(CategorieStrategie.SONDEUR_REPENTANT, CategorieStrategie.fromString("SondeurRepentant"));
        assertEquals(CategorieStrategie.PACIFICATEUR_NAIF, CategorieStrategie.fromString("PacificateurNaif"));
        assertEquals(CategorieStrategie.VRAI_PACIFICATEUR, CategorieStrategie.fromString("VraiPacificateur"));
        assertEquals(CategorieStrategie.ALEATOIRE, CategorieStrategie.fromString("Aleatoire"));
        assertEquals(CategorieStrategie.TOUJOURS_TRAHIR, CategorieStrategie.fromString("ToujoursTrahir"));
        assertEquals(CategorieStrategie.TOUJOURS_COOPERER, CategorieStrategie.fromString("ToujoursCooperer"));
        assertEquals(CategorieStrategie.RANCUNIER, CategorieStrategie.fromString("Rancunier"));
        assertEquals(CategorieStrategie.PAVLOV, CategorieStrategie.fromString("Pavlov"));
        assertEquals(CategorieStrategie.PAVLOV_ALEATOIRE, CategorieStrategie.fromString("PavlovAleatoire"));
        assertEquals(CategorieStrategie.ADAPTATIF, CategorieStrategie.fromString("Adaptatif"));
        assertEquals(CategorieStrategie.GRADUEL, CategorieStrategie.fromString("Graduel"));
        assertEquals(CategorieStrategie.DONNANT_DONNANT_SOUPCONNEUX, CategorieStrategie.fromString("DonnantDonnantSoupconneux"));
        assertEquals(CategorieStrategie.RANCUNIER_DOUX, CategorieStrategie.fromString("RancunierDoux"));
    }

    @Test
    public void testFromString_InvalidValue() {
        // Vérification qu'une exception est levée pour une valeur invalide
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CategorieStrategie.fromString("MauvaiseValeur");
        });
        assertEquals("Mauvaise categorie de strategie : MauvaiseValeur", exception.getMessage());
    }
}
