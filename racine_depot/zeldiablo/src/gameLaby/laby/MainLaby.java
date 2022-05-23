package gameLaby.laby;

import moteurJeu.MoteurJeu;

/**
 * lance un jeu de type labyrinthe
 */

public class MainLaby {

    public static void main(String[] args) {

        /**
         * A voir si besoin de parametrage
         *         //int width = 800;
         *         //int height = 600;
         *         //int pFPS = 100;
         *
         *         // creation des objets
         *         ...
         *
         *         // parametrage du moteur de jeu
         *         //MoteurJeu.setTaille(width,height);
         *         //MoteurJeu.setFPS(pFPS);
         *
         *         ...
         */

        // creation des objets
        LabyJeu jeu = new LabyJeu();
        LabyDessin dessin = new LabyDessin();

        // lancement du jeu
        MoteurJeu.launch(jeu, dessin);
    }
}

