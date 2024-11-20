package fr.uga.m1miage.pc.strategies;

public class StrategieGraduelAleatoire {
    private boolean punitionActive = false;  // Variable d'�tat pour suivre si la punition est active

    public char decider(char dernierChoixAdversaire) {
        if (dernierChoixAdversaire == 't') {
            punitionActive = true;  // D�marrer la punition apr�s une trahison
        }

        if (punitionActive) {
            return 't';  // Continuer � punir tant que la phase de punition est active
        }

        if (dernierChoixAdversaire == 'c') {
            // Logique pour choisir al�atoirement entre coop�ration et punition
            return Math.random() > 0.5 ? 'c' : 't';
        }

        return 'c';  // Par d�faut, choisir la coop�ration si pas de punition active
    }

    // R�initialiser la punition apr�s un certain nombre de tours ou une autre condition
    public void resetPunition() {
        punitionActive = false;
    }
}
