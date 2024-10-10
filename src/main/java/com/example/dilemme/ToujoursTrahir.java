package com.example.dilemme;

public class ToujoursTrahir implements Strategie {
    @Override
    public int choisirAction(Joueur adversaire) {
        return 2; // Trahir toujours
    }
}
