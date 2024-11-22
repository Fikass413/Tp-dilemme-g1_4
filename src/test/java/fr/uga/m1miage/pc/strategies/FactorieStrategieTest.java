package fr.uga.m1miage.pc.strategies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests pour la classe FactorieStrategie et la m�thode creerStrategies.
 */
public class FactorieStrategieTest {

    @Test
    public void testCreerStrategies_ValidCategorie() {
        // V�rification que la m�thode cr�e la bonne strat�gie pour chaque cat�gorie

        assertTrue(FactorieStrategie.creerStrategies(CategorieStrategie.DONNANT_DONNANT) instanceof StrategieDonnantDonnant);
        assertTrue(FactorieStrategie.creerStrategies(CategorieStrategie.DONNANT_DONNANT_ALEATOIRE) instanceof StrategieDonnantDonnantAleatoire);
        assertTrue(FactorieStrategie.creerStrategies(CategorieStrategie.DONNANT_DEUX_DONNANT_ALEATOIRE) instanceof StrategieDonnantPourDeuxDonnantAleatoire);
        assertTrue(FactorieStrategie.creerStrategies(CategorieStrategie.DONNANT_DEUX_DONNANT) instanceof StrategieDonnantPourDeuxDonnant);
        assertTrue(FactorieStrategie.creerStrategies(CategorieStrategie.SONDEUR_NAIF) instanceof StrategieSondeurNaif);
        assertTrue(FactorieStrategie.creerStrategies(CategorieStrategie.SONDEUR_REPENTANT) instanceof StrategieSondeurRepentant);
        assertTrue(FactorieStrategie.creerStrategies(CategorieStrategie.PACIFICATEUR_NAIF) instanceof StrategiePacificateurNaif);
        assertTrue(FactorieStrategie.creerStrategies(CategorieStrategie.VRAI_PACIFICATEUR) instanceof StrategieVraiPacificateur);
        assertTrue(FactorieStrategie.creerStrategies(CategorieStrategie.ALEATOIRE) instanceof StrategieAleatoire);
        assertTrue(FactorieStrategie.creerStrategies(CategorieStrategie.TOUJOURS_TRAHIR) instanceof StrategieToujoursTricher);
        assertTrue(FactorieStrategie.creerStrategies(CategorieStrategie.TOUJOURS_COOPERER) instanceof StrategieToujoursCooperer);
        assertTrue(FactorieStrategie.creerStrategies(CategorieStrategie.RANCUNIER) instanceof StrategieRancunier);
        assertTrue(FactorieStrategie.creerStrategies(CategorieStrategie.PAVLOV) instanceof StrategiePavlov);
        assertTrue(FactorieStrategie.creerStrategies(CategorieStrategie.PAVLOV_ALEATOIRE) instanceof StrategiePavlovAleatoire);
        assertTrue(FactorieStrategie.creerStrategies(CategorieStrategie.ADAPTATIF) instanceof StrategieAdaptative);
        assertTrue(FactorieStrategie.creerStrategies(CategorieStrategie.GRADUEL) instanceof StrategieGraduelAleatoire);
        assertTrue(FactorieStrategie.creerStrategies(CategorieStrategie.DONNANT_DONNANT_SOUPCONNEUX) instanceof StrategieDonnantDonnantSoupconneux);
        assertTrue(FactorieStrategie.creerStrategies(CategorieStrategie.RANCUNIER_DOUX) instanceof StrategieRancunierDoux);
    }

    @Test
    public void testCreerStrategies_InvalidCategorie() {
        // V�rification qu'une exception est lanc�e pour une cat�gorie invalide
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            FactorieStrategie.creerStrategies(null);
        });
        assertEquals("Mauvaise categorie de strategie : null", exception.getMessage());
    }
}
