package com.example.dilemme;

public class Pacificateur implements Strategie {
    private int nombreTrahisonsAdversaire;

    public Pacificateur() {
        this.nombreTrahisonsAdversaire = 0;
    }

    @Override
    public int choisirAction(Joueur adversaire) {
        // Si l'adversaire a trahi deux fois de suite, on trahit
        if (nombreTrahisonsAdversaire >= 2) {
            return 2;  // Trahir
        }
        return 1;  // Coopérer
    }

    // Méthode pour mettre à jour le comportement de l'adversaire
    public void enregistrerCoupAdversaire(int coupAdversaire) {
        if (coupAdversaire == 2) {
            nombreTrahisonsAdversaire++;
        } else {
            nombreTrahisonsAdversaire = 0;  // Réinitialiser si l'adversaire coopère
        }
    }
}
