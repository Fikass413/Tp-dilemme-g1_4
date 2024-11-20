package fr.uga.m1miage.pc.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Partie {
    private Joueur joueur1;
    private Joueur joueur2;
    private int toursRestants; 
}
