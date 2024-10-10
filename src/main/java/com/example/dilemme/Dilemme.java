package com.example.dilemme;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dilemme {
    private static final Logger logger = Logger.getLogger(Dilemme.class.getName());

    private Joueur joueur1;
    private Joueur joueur2;
    private Scanner scanner;
    private int nombreDeTours;
    private boolean continuerJoueur1 = true;
    private boolean continuerJoueur2 = true;

    public Dilemme(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.scanner = new Scanner(System.in);
    }

    public void jouer() {
        // Demander le nombre de tours
        logger.log(Level.INFO, "Combien de tours souhaitez-vous jouer ?");
        nombreDeTours = scanner.nextInt();

        // Boucle de jeu
        for (int tour = 1; tour <= nombreDeTours; tour++) {
            logger.log(Level.INFO, "Tour " + tour + ":");

            int choix1 = -1;
            int choix2 = -1;

            if (continuerJoueur1) {
                choix1 = demanderChoix(joueur1);
            }
            if (continuerJoueur2) {
                choix2 = demanderChoix(joueur2);
            }

            // Logique du dilemme
            calculerScores(choix1, choix2);

            // Affichage des scores
            logger.log(Level.INFO, joueur1.toString());
            logger.log(Level.INFO, joueur2.toString());

            // Demander si les joueurs veulent continuer
            if (continuerJoueur1) {
                continuerJoueur1 = demanderContinuer(joueur1);
                if (!continuerJoueur1) {
                    choisirStrategie(joueur1);
                    joueur1.setAI(true);
                }
            }

            if (continuerJoueur2) {
                continuerJoueur2 = demanderContinuer(joueur2);
                if (!continuerJoueur2) {
                    choisirStrategie(joueur2);
                    joueur2.setAI(true);
                }
            }

            if (!continuerJoueur1 && !continuerJoueur2) {
                jouerAvecIA();
                break;
            }
        }

        logger.log(Level.INFO, "Merci d'avoir joué !");
        scanner.close();
    }

    private void jouerAvecIA() {
        logger.log(Level.INFO, "Les deux joueurs sont des IA, le jeu continue automatiquement !");
        for (int tour = 1; tour <= nombreDeTours; tour++) {
            int choixIA1 = joueur1.choisirAction(joueur2);
            int choixIA2 = joueur2.choisirAction(joueur1);

            // Logique du dilemme entre IA
            calculerScores(choixIA1, choixIA2);

            // Affichage des scores
            logger.log(Level.INFO, joueur1.toString());
            logger.log(Level.INFO, joueur2.toString());
        }
    }

    private int demanderChoix(Joueur joueur) {
        logger.log(Level.INFO, joueur.getNom() + ", choisissez votre action : (1) Coopérer (2) Trahir");
        return scanner.nextInt();
    }

    private void calculerScores(int choix1, int choix2) {
        if (choix1 == -1 || choix2 == -1) {
            return;
        }
        if (choix1 == 1 && choix2 == 1) {
            logger.log(Level.INFO, "Les deux joueurs coopèrent !");
            joueur1.ajouterScore(3);
            joueur2.ajouterScore(3);
        } else if (choix1 == 2 && choix2 == 2) {
            logger.log(Level.INFO, "Les deux joueurs trahissent !");
            joueur1.ajouterScore(0);
            joueur2.ajouterScore(0);
        } else {
            logger.log(Level.INFO, "Un joueur coopère et l'autre trahit !");
            if (choix1 == 1) {
                joueur1.ajouterScore(0);
                joueur2.ajouterScore(5);
            } else {
                joueur1.ajouterScore(5);
                joueur2.ajouterScore(0);
            }
        }
    }

    private boolean demanderContinuer(Joueur joueur) {
        logger.log(Level.INFO, "Voulez-vous continuer à jouer, " + joueur.getNom() + "? (oui/non) : ");
        String reponse = scanner.next();
        return reponse.equalsIgnoreCase("oui");
    }

    private void choisirStrategie(Joueur joueur) {
        logger.log(Level.INFO, "Choisissez une stratégie pour " + joueur.getNom() + ":");
        logger.log(Level.INFO, "1. Toujours Coopérer");
        logger.log(Level.INFO, "2. Toujours Trahir");
        logger.log(Level.INFO, "3. Donnant Donnant");
        logger.log(Level.INFO, "4. Pacificateur");
        logger.log(Level.INFO, "5. Sondeur Repentant");
        int choixStrategie = scanner.nextInt();

        switch (choixStrategie) {
            case 1:
                joueur.setStrategie(new ToujoursCooperer());
                break;
            case 2:
                joueur.setStrategie(new ToujoursTrahir());
                break;
            case 3:
                joueur.setStrategie(new DonnantDonnant());
                break;
            case 4:
                joueur.setStrategie(new Pacificateur());
                break;
            case 5:
                joueur.setStrategie(new SondeurRepentant());
                break;
            default:
                logger.log(Level.INFO, "Stratégie non valide, la stratégie par défaut est choisie.");
                joueur.setStrategie(new ToujoursCooperer());
        }
    }

	
	public Joueur getJoueur1() {
        return joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }
}
