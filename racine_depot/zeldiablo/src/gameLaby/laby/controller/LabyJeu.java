package gameLaby.laby.controller;

import gameLaby.laby.modele.Labyrinthe;
import moteurJeu.Clavier;
import moteurJeu.Jeu;

/**
 * Implémentation du moteur de jeu pour notre jeu labyrinthe
 */
public class LabyJeu implements Jeu
{
    /**
     * Objet labyrinthe
     */
    Labyrinthe laby;

    /**
     * Constructeur par defaut
     */
    public LabyJeu (Labyrinthe labyP)
    {
        this.laby = labyP;
    }

    /**
     * Met a jour l'etat du jeu
     */
    public void update(double secondes, Clavier clavier) {
        // deplace le personnage en fonction des touches
        if (clavier.espace) {
            laby.getPj().attaquer(laby.getMonstre());
            return;
        }

        if (clavier.haut)
            this.laby.deplacerPosition(Labyrinthe.HAUT);
        else if (clavier.bas)
            this.laby.deplacerPosition(Labyrinthe.BAS);
        else if (clavier.gauche)
            this.laby.deplacerPosition(Labyrinthe.GAUCHE);
        else if (clavier.droite)
            this.laby.deplacerPosition(Labyrinthe.DROITE);


        
    }

    /**
     * Methode heritee du moteur de jeu, aucune initialisation particuliere
     */
    @Override
    public void init() {
        // pas d'initialisation particuliere
    }

    /**
     * Methode heritee du moteur de jeu, le jeu ne finit jamais
     * @return faux car le jeu ne s'arrete jamais
     */
    @Override
    public boolean etreFini() {
        // le jeu ne s'arrete jamais
        return false;
    }

    // >Getter
    /**
     * Getter de laby
     * @return this.laby de type Labyrinthe
     */
    public Labyrinthe getLaby() {
        return this.laby;
    }
}
