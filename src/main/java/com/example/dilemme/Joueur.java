package com.example.dilemme;

public class Joueur {
    private String nom;
    private int score;
    private Strategie strategie;  // Ajout de la stratégie
    private boolean isAI; // Indique si le joueur est contrôlé par l'IA

    public Joueur(String nom, Strategie strategie) {
        this.nom = nom;
        this.strategie = strategie;
        this.score = 0;
        this.isAI = false; // Par défaut, le joueur n'est pas IA
    }

    public int choisirAction(Joueur adversaire) {
        return strategie.choisirAction(adversaire);  // Utilisation de la stratégie
    }

    public String getNom() {
        return nom;
    }

    public int getScore() {
        return score;
    }

    public void ajouterScore(int points) {
        this.score += points;
    }

    public Strategie getStrategie() {
        return strategie;
    }

    public void setStrategie(Strategie strategie) {
        this.strategie = strategie;
    }

    public boolean isAI() {
        return isAI;
    }

    public void setAI(boolean isAI) {
        this.isAI = isAI;
    }

    @Override
    public String toString() {
        return "Joueur: " + nom + ", Score: " + score;
    }
}
