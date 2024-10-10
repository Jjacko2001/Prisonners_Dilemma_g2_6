package com.example.dilemme;

public class ToujoursCooperer implements Strategie {
    @Override
    public int choisirAction(Joueur adversaire) {
        return 1; // Coopérer toujours
    }
}
