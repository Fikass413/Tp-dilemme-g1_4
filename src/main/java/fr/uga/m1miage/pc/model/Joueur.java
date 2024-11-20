package fr.uga.m1miage.pc.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Joueur {

    
    private String nom;

    
    private String strategie;

    
    private int score = 0;

    
    private char dernierCoup = 'c'; // Coopération par défaut

    
    public void resetScore() {
        this.score = 0;
    }

    
    public void jouerCoup(char coup) {
        this.dernierCoup = coup;
    }

    
    public void ajouterScore(int score) {
        this.score += score;
    }
}
