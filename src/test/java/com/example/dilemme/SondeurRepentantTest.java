package com.example.dilemme;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SondeurRepentantTest {

    private SondeurRepentant sondeurRepentant;
    private Joueur adversaire;

    @BeforeEach
    public void setUp() {
        // Initialisation du SondeurRepentant et d'un adversaire fictif
        sondeurRepentant = new SondeurRepentant();
        adversaire = new Joueur("Adversaire", new ToujoursTrahir());
    }

    @Test
    public void testChoisirActionCoopereInitialement() {
        // Vérifie que SondeurRepentant coopère au début
        assertEquals(1, sondeurRepentant.choisirAction(adversaire),
                "Le SondeurRepentant doit coopérer au début");
    }

    @Test
    public void testChoisirActionTesteTousLesQuatreTours() {
        // Le SondeurRepentant doit coopérer lors des 3 premiers tours
        assertEquals(1, sondeurRepentant.choisirAction(adversaire)); // 1er tour
        assertEquals(1, sondeurRepentant.choisirAction(adversaire)); // 2e tour
        assertEquals(1, sondeurRepentant.choisirAction(adversaire)); // 3e tour

        // Il doit tester l'adversaire au 4e tour
        assertEquals(2, sondeurRepentant.choisirAction(adversaire),
                "Le SondeurRepentant doit trahir au 4e tour pour tester l'adversaire");
    }

    @Test
    public void testChoisirActionApresTrahisonEnReponse() {
        // Simuler un test au 4e tour et une trahison en réponse
        sondeurRepentant.choisirAction(adversaire); // 1er tour
        sondeurRepentant.choisirAction(adversaire); // 2e tour
        sondeurRepentant.choisirAction(adversaire); // 3e tour
        sondeurRepentant.choisirAction(adversaire); // 4e tour (test)

        // Enregistrer la trahison de l'adversaire en réponse au test
        sondeurRepentant.enregistrerCoupAdversaire(2);  // L'adversaire a trahi

        // Le SondeurRepentant doit coopérer au tour suivant pour montrer le repentir
        assertEquals(1, sondeurRepentant.choisirAction(adversaire),
                "Le SondeurRepentant doit coopérer après avoir été trahi en réponse à un test");
    }

    @Test
    public void testNePasTesterAvantQuatreTours() {
        // Vérifier qu'il ne teste pas avant le 4e tour
        assertEquals(1, sondeurRepentant.choisirAction(adversaire)); // 1er tour
        assertEquals(1, sondeurRepentant.choisirAction(adversaire)); // 2e tour
        assertEquals(1, sondeurRepentant.choisirAction(adversaire)); // 3e tour
    }

    @Test
    public void testEnregistrerCoupAdversaire() {
        // Simuler un test et enregistrer la trahison de l'adversaire
        sondeurRepentant.choisirAction(adversaire); // 1er tour
        sondeurRepentant.choisirAction(adversaire); // 2e tour
        sondeurRepentant.choisirAction(adversaire); // 3e tour
        sondeurRepentant.choisirAction(adversaire); // 4e tour (test)
        
        // Adversaire trahit au 4e tour, on enregistre la trahison
        sondeurRepentant.enregistrerCoupAdversaire(2);
        
        // Le SondeurRepentant doit coopérer après avoir été trahi
        assertEquals(1, sondeurRepentant.choisirAction(adversaire),
                "Le SondeurRepentant doit coopérer après la trahison de l'adversaire lors du test");
    }

    @Test
    public void testResetApresCooperation() {
        // Simuler un test et une trahison, puis une coopération de l'adversaire
        sondeurRepentant.choisirAction(adversaire); // 1er tour
        sondeurRepentant.choisirAction(adversaire); // 2e tour
        sondeurRepentant.choisirAction(adversaire); // 3e tour
        sondeurRepentant.choisirAction(adversaire); // 4e tour (test)

        // Adversaire trahit au 4e tour
        sondeurRepentant.enregistrerCoupAdversaire(2);

        // SondeurRepentant coopère au tour suivant
        assertEquals(1, sondeurRepentant.choisirAction(adversaire));

        // Vérifier qu'il retourne à coopérer après la trahison
        assertEquals(1, sondeurRepentant.choisirAction(adversaire)); // Le tour suivant doit être coopération
    }
}
