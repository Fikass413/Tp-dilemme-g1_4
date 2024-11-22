package fr.uga.m1miage.pc.strategies;

public class FactorieStrategie {
	
	private FactorieStrategie() {}
	
    public static Strategie creerStrategies(CategorieStrategie categorie) {
    	if (categorie == null)
    		throw new IllegalArgumentException("Mauvaise categorie de strategie : " + categorie);
    	
        switch (categorie) {
            case DONNANT_DONNANT:
                return new StrategieDonnantDonnant();
            case DONNANT_DONNANT_ALEATOIRE:
                return new StrategieDonnantDonnantAleatoire();
            case DONNANT_DEUX_DONNANT_ALEATOIRE:
                return new StrategieDonnantPourDeuxDonnantAleatoire();
            case DONNANT_DEUX_DONNANT:
                return new StrategieDonnantPourDeuxDonnant();
            case SONDEUR_NAIF:
                return new StrategieSondeurNaif();
            case SONDEUR_REPENTANT:
                return new StrategieSondeurRepentant();
            case PACIFICATEUR_NAIF:
                return new StrategiePacificateurNaif();
            case VRAI_PACIFICATEUR:
                return new StrategieVraiPacificateur();
            case ALEATOIRE:
                return new StrategieAleatoire();
            case TOUJOURS_TRAHIR:
                return new StrategieToujoursTricher();
            case TOUJOURS_COOPERER:
                return new StrategieToujoursCooperer();
            case RANCUNIER:
                return new StrategieRancunier();
            case PAVLOV:
                return new StrategiePavlov();
            case PAVLOV_ALEATOIRE:
                return new StrategiePavlovAleatoire();
            case ADAPTATIF:
                return new StrategieAdaptative();
            case GRADUEL:
                return new StrategieGraduelAleatoire();
            case DONNANT_DONNANT_SOUPCONNEUX:
                return new StrategieDonnantDonnantSoupconneux();
            case RANCUNIER_DOUX:
                return new StrategieRancunierDoux();
            default:
                throw new IllegalArgumentException("Mauvaise categorie de strategie : " + categorie);
        }
    }
}