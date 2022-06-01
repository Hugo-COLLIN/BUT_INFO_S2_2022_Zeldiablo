package gameLaby.laby._main;

import gameLaby.laby.controller.LabyJeu;
import gameLaby.laby.modele.Labyrinthe;
import gameLaby.laby.view.LabyDessin;
import moteurJeu.MoteurJeu;

import java.io.IOException;

/**
 * Lance un jeu de type Labyrinthe
 */

public class MainLaby {

    public static void main(String[] args) throws IOException
    {
        // creation des objets
        Labyrinthe laby = new Labyrinthe("labySimple/laby1.txt");
        LabyJeu jeu = new LabyJeu(laby);
        LabyDessin dessin = new LabyDessin();

        MoteurJeu.setFPS(10);

        // lancement du jeu
        MoteurJeu.launch(jeu, dessin);
    }
}

