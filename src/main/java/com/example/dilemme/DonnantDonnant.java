package com.example.dilemme;

public class DonnantDonnant implements Strategie {
    private int dernierCoupAdversaire;

    public DonnantDonnant() {
        // On commence par coopérer (1 = Coopérer)
        this.dernierCoupAdversaire = 1;
    }

    @Override
    public int choisirAction(Joueur adversaire) {
        // Copier le dernier coup de l'adversaire
        return dernierCoupAdversaire;
    }

    // Cette méthode permet de mettre à jour le dernier coup de l'adversaire après chaque tour
    public void setDernierCoupAdversaire(int coup) {
        this.dernierCoupAdversaire = coup;
    }
}
