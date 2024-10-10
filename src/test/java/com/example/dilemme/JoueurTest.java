package com.example.dilemme;import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JoueurTest {

    private Joueur joueur;
    private Strategie strategieMock;

    @BeforeEach
    public void setUp() {
        // Création d'une stratégie fictive pour les tests
        strategieMock = new Strategie() {
            @Override
            public int choisirAction(Joueur adversaire) {
                return 1; // Simule une action de coopération
            }
        };
        
        // Initialisation d'un joueur avec un nom et une stratégie
        joueur = new Joueur("Alice", strategieMock);
    }

    @Test
    public void testGetNom() {
        // Vérification que le nom est correctement retourné
        assertEquals("Alice", joueur.getNom(), "Le nom du joueur doit être 'Alice'");
    }

    @Test
    public void testGetScore() {
        // Vérification que le score initial est bien à 0
        assertEquals(0, joueur.getScore(), "Le score initial doit être 0");
    }

    @Test
    public void testAjouterScore() {
        // Ajoute des points au score
        joueur.ajouterScore(10);
        // Vérification que le score est bien mis à jour
        assertEquals(10, joueur.getScore(), "Le score après ajout doit être 10");

        joueur.ajouterScore(5);
        assertEquals(15, joueur.getScore(), "Le score après ajout de 5 doit être 15");
    }

    @Test
    public void testChoisirAction() {
        // Simule un choix d'action avec l'adversaire
        Joueur adversaire = new Joueur("Bob", strategieMock);
        int action = joueur.choisirAction(adversaire);

        // Vérifie que l'action choisie est bien celle définie dans la stratégie
        assertEquals(1, action, "L'action choisie doit être 1 (coopérer)");
    }

    @Test
    public void testGetStrategie() {
        // Vérifie que la stratégie est correctement retournée
        assertEquals(strategieMock, joueur.getStrategie(), "La stratégie doit être celle définie lors de l'initialisation");
    }

    @Test
    public void testSetStrategie() {
        // Change la stratégie du joueur
        Strategie nouvelleStrategie = new Strategie() {
            @Override
            public int choisirAction(Joueur adversaire) {
                return 2; // Simule une action de trahison
            }
        };
        joueur.setStrategie(nouvelleStrategie);

        // Vérifie que la stratégie a bien été mise à jour
        assertEquals(nouvelleStrategie, joueur.getStrategie(), "La nouvelle stratégie doit être mise à jour correctement");
        
        // Vérifie que le comportement change avec la nouvelle stratégie
        Joueur adversaire = new Joueur("Bob", strategieMock);
        assertEquals(2, joueur.choisirAction(adversaire), "L'action choisie doit maintenant être 2 (trahir)");
    }

    @Test
    public void testIsAI() {
        // Par défaut, le joueur ne doit pas être IA
        assertFalse(joueur.isAI(), "Par défaut, le joueur ne doit pas être contrôlé par l'IA");
    }

    @Test
    public void testSetAI() {
        // Met à jour l'état IA du joueur
        joueur.setAI(true);
        assertTrue(joueur.isAI(), "Le joueur doit maintenant être contrôlé par l'IA");

        // Désactive l'IA
        joueur.setAI(false);
        assertFalse(joueur.isAI(), "Le joueur ne doit plus être contrôlé par l'IA");
    }

    @Test
    public void testToString() {
        // Vérifie la représentation en chaîne du joueur
        String expected = "Joueur: Alice, Score: 0";
        assertEquals(expected, joueur.toString(), "La méthode toString doit retourner 'Joueur: Alice, Score: 0'");

        // Met à jour le score
        joueur.ajouterScore(10);
        expected = "Joueur: Alice, Score: 10";
        assertEquals(expected, joueur.toString(), "La méthode toString doit retourner 'Joueur: Alice, Score: 10' après mise à jour du score");
    }
}
