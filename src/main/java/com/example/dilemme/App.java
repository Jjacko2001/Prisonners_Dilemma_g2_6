package com.example.dilemme;

public class App {
    public static void main(String[] args) {
        // Création des joueurs avec leurs stratégies
        Joueur joueur1 = new Joueur("Alice", new DonnantDonnant());
        Joueur joueur2 = new Joueur("Bob", new Pacificateur());

        // Initialisation du dilemme avec les joueurs
        Dilemme dilemme = new Dilemme(joueur1, joueur2);
        dilemme.jouer(); // Commence le jeu
    }
}
