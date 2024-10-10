package com.example.dilemme;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

public class DilemmeTest {

    private Dilemme dilemme;
    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueur;

    @BeforeEach
    public void setUp() {
        // Initialisation des joueurs avec des stratégies concrètes
        joueur1 = new Joueur("Alice", new DonnantDonnant());
        joueur2 = new Joueur("Bob", new ToujoursTrahir());

        // Simuler une entrée utilisateur avec 3 tours, choix coopérer/trahir et non pour continuer
        String data = "3\n1\n2\nnon\nnon\n";
        InputStream input = new ByteArrayInputStream(data.getBytes());
        System.setIn(input);  // Remplace l'entrée standard par cet InputStream

        // Initialiser le dilemme avec ces joueurs
        dilemme = new Dilemme(joueur1, joueur2);

        // Initialisation d'un autre joueur pour tester la méthode choisirStrategie
        joueur = new Joueur("Alice", new ToujoursCooperer());
    }

    @Test
    public void testChoixStrategieJoueur() {
        // Vérifie que les stratégies des joueurs sont bien initialisées
        assertTrue(joueur1.getStrategie() instanceof DonnantDonnant);
        assertTrue(joueur2.getStrategie() instanceof ToujoursTrahir);
    }

    @Test
    public void testChoisirStrategieToujoursCooperer() {
        // Simuler l'entrée de l'utilisateur avec la valeur 1 (Toujours Coopérer)
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Appel de la méthode choisirStrategie
        dilemme.choisirStrategie(joueur);

        // Vérifier que la stratégie a été mise à jour pour "Toujours Coopérer"
        }

    @Test
    public void testChoisirStrategieToujoursTrahir() {
        // Simuler l'entrée de l'utilisateur avec la valeur 2 (Toujours Trahir)
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Appel de la méthode choisirStrategie
        dilemme.choisirStrategie(joueur);

        // Vérifier que la stratégie a été mise à jour pour "Toujours Trahir"
        }

    @Test
    public void testChoisirStrategieDonnantDonnant() {
        // Simuler l'entrée de l'utilisateur avec la valeur 3 (Donnant Donnant)
        String input = "3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Appel de la méthode choisirStrategie
        dilemme.choisirStrategie(joueur);

        // Vérifier que la stratégie a été mise à jour pour "Donnant Donnant"
        assertTrue(joueur.getStrategie() instanceof DonnantDonnant, "La stratégie doit être Donnant Donnant");
    }

    @Test
    public void testChoisirStrategiePacificateur() {
        // Simuler l'entrée de l'utilisateur avec la valeur 4 (Pacificateur)
        String input = "4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Appel de la méthode choisirStrategie
        dilemme.choisirStrategie(joueur);

        }

    @Test
    public void testChoisirStrategieSondeurRepentant() {
        // Simuler l'entrée de l'utilisateur avec la valeur 5 (Sondeur Repentant)
        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Appel de la méthode choisirStrategie
        dilemme.choisirStrategie(joueur);

       }

    @Test
    public void testChoisirStrategieInvalide() {
        // Simuler l'entrée de l'utilisateur avec une valeur invalide
        String input = "99\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Appel de la méthode choisirStrategie
        dilemme.choisirStrategie(joueur);

        }
}
