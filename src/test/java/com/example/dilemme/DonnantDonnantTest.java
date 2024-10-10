package com.example.dilemme;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DonnantDonnantTest {

    private DonnantDonnant donnantDonnant;
    private Joueur adversaire;

    @BeforeEach
    public void setUp() {
        // Initialisation de la stratégie DonnantDonnant et d'un adversaire fictif
        donnantDonnant = new DonnantDonnant();
        adversaire = new Joueur("Adversaire", new ToujoursTrahir());  // Stratégie d'exemple pour l'adversaire
    }

    @Test
    public void testDonnantDonnantCommenceParCooperer() {
        // Le DonnantDonnant doit commencer par coopérer
        assertEquals(1, donnantDonnant.choisirAction(adversaire), 
                     "Le DonnantDonnant doit commencer par coopérer");
    }

    @Test
    public void testDonnantDonnantImiteCoupAdversaire() {
        // Simuler que l'adversaire coopère (1) au premier tour
        donnantDonnant.setDernierCoupAdversaire(1);  // Adversaire a coopéré
        assertEquals(1, donnantDonnant.choisirAction(adversaire), 
                     "Le DonnantDonnant doit coopérer si l'adversaire a coopéré au tour précédent");

        // Simuler que l'adversaire trahit (2) au tour suivant
        donnantDonnant.setDernierCoupAdversaire(2);  // Adversaire a trahi
        assertEquals(2, donnantDonnant.choisirAction(adversaire), 
                     "Le DonnantDonnant doit trahir si l'adversaire a trahi au tour précédent");
    }

    @Test
    public void testDonnantDonnantReagitApresPlusieursTours() {
        // Simuler que l'adversaire coopère deux tours de suite
        donnantDonnant.setDernierCoupAdversaire(1);
        assertEquals(1, donnantDonnant.choisirAction(adversaire), 
                     "Le DonnantDonnant doit coopérer après la première coopération de l'adversaire");

        // Simuler que l'adversaire trahit au tour suivant
        donnantDonnant.setDernierCoupAdversaire(2);
        assertEquals(2, donnantDonnant.choisirAction(adversaire), 
                     "Le DonnantDonnant doit trahir après que l'adversaire a trahi");
        
        // Simuler que l'adversaire coopère de nouveau
        donnantDonnant.setDernierCoupAdversaire(1);
        assertEquals(1, donnantDonnant.choisirAction(adversaire), 
                     "Le DonnantDonnant doit coopérer après que l'adversaire a coopéré");
    }
}
