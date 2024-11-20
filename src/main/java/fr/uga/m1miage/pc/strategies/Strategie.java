package fr.uga.m1miage.pc.strategies;

/**
 * Interface pour toutes les stratégies du jeu.
 */
public interface Strategie {
    char decider(char dernierCoupAdversaire);
}