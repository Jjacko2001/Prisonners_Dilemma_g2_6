package com.example.dilemme;

public interface Strategie {
    // Méthode pour définir le choix : 1 = Coopérer, 2 = Trahir
    int choisirAction(Joueur adversaire);
}
