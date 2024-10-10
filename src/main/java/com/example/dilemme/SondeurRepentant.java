package com.example.dilemme;

public class SondeurRepentant implements Strategie {
    private boolean dernierCoupEtaitTest;
    private boolean trahiEnReponse;
    private int compteurTours; // Compteur de tours

    public SondeurRepentant() {
        this.dernierCoupEtaitTest = false;
        this.trahiEnReponse = false;
        this.compteurTours = 0; // Initialiser le compteur à 0
    }

    @Override
    public int choisirAction(Joueur adversaire) {
        compteurTours++; // Incrémenter le compteur à chaque tour

        // Si on a été trahi en réponse à un test, coopérer immédiatement
        if (trahiEnReponse) {
            trahiEnReponse = false;
            return 1;  // Coopérer pour montrer le repentir
        }

        // Tester l'adversaire tous les 4 tours par exemple
        if (!dernierCoupEtaitTest && compteurTours % 4 == 0) {  // Tous les 4 tours
            dernierCoupEtaitTest = true;
            return 2;  // Trahir pour tester
        }

        dernierCoupEtaitTest = false;
        return 1;  // Coopérer sinon
    }

    public void enregistrerCoupAdversaire(int coupAdversaire) {
        // Si le dernier coup était un test et que l'adversaire a trahi en réponse
        if (dernierCoupEtaitTest && coupAdversaire == 2) {
            trahiEnReponse = true;
        }
    }
}
