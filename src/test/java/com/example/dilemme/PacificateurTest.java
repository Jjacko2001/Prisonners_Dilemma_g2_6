package com.example.dilemme;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PacificateurTest {

    private Pacificateur pacificateur;
    private Joueur adversaire;

    @BeforeEach
    public void setUp() {
        // Initialisation du Pacificateur et d'un adversaire fictif
        pacificateur = new Pacificateur();
        adversaire = new Joueur("Adversaire", new ToujoursTrahir());  // Stratégie d'exemple pour l'adversaire
    }

    @Test
    public void testPacificateurCoopereAuDebut() {
        // Le pacificateur doit coopérer au début
        assertEquals(1, pacificateur.choisirAction(adversaire), 
                     "Le Pacificateur doit coopérer au début");
    }

    @Test
    public void testPacificateurTrahirApresDeuxTrahisons() {
        // Simuler deux trahisons de l'adversaire
        pacificateur.enregistrerCoupAdversaire(2);  // Adversaire trahit une première fois
        pacificateur.enregistrerCoupAdversaire(2);  // Adversaire trahit une deuxième fois

        // Le pacificateur doit trahir après deux trahisons de l'adversaire
        assertEquals(2, pacificateur.choisirAction(adversaire), 
                     "Le Pacificateur doit trahir après deux trahisons consécutives de l'adversaire");
    }

    @Test
    public void testPacificateurResetApresCooperation() {
        // Simuler une trahison suivie d'une coopération
        pacificateur.enregistrerCoupAdversaire(2);  // Adversaire trahit une fois
        pacificateur.enregistrerCoupAdversaire(1);  // Adversaire coopère

        // Le pacificateur doit coopérer à nouveau après une coopération
        assertEquals(1, pacificateur.choisirAction(adversaire), 
                     "Le Pacificateur doit coopérer après une coopération de l'adversaire");
    }

    @Test
    public void testPacificateurCoopereApresUneSeuleTrahison() {
        // Simuler une seule trahison de l'adversaire
        pacificateur.enregistrerCoupAdversaire(2);  // Adversaire trahit une fois

        // Le pacificateur doit coopérer après une seule trahison
        assertEquals(1, pacificateur.choisirAction(adversaire), 
                     "Le Pacificateur doit coopérer après une seule trahison");
    }
}
