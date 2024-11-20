package fr.uga.m1miage.pc.strategies;

public class StrategieGraduelAleatoire {
    private boolean punitionActive = false;  // Variable d'état pour suivre si la punition est active

    public char decider(char dernierChoixAdversaire) {
        if (dernierChoixAdversaire == 't') {
            punitionActive = true;  // Démarrer la punition après une trahison
        }

        if (punitionActive) {
            return 't';  // Continuer à punir tant que la phase de punition est active
        }

        if (dernierChoixAdversaire == 'c') {
            // Logique pour choisir aléatoirement entre coopération et punition
            return Math.random() > 0.5 ? 'c' : 't';
        }

        return 'c';  // Par défaut, choisir la coopération si pas de punition active
    }

    // Réinitialiser la punition après un certain nombre de tours ou une autre condition
    public void resetPunition() {
        punitionActive = false;
    }
}
