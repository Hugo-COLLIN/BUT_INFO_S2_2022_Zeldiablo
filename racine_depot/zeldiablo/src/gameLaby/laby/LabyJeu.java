package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

public class LabyJeu implements Jeu
{
    Labyrinthe laby;

    /**
     * constructeur par defaut
     */
    public LabyJeu (Labyrinthe labyP)
    {
        this.laby = labyP;
    }

    /**
     * met a jour l'etat du jeu
     */
    public void update(double secondes, Clavier clavier) {
        // deplace le personnage en fonction des touches
        if (clavier.haut)
            this.laby.deplacerPosition(Labyrinthe.HAUT);
        else if (clavier.bas)
            this.laby.deplacerPosition(Labyrinthe.BAS);
        else if (clavier.gauche)
            this.laby.deplacerPosition(Labyrinthe.GAUCHE);
        else if (clavier.droite)
            this.laby.deplacerPosition(Labyrinthe.DROITE);
        
    }

    @Override
    public void init() {
        // pas d'initialisation particuliere
    }

    @Override
    public boolean etreFini() {
        // le jeu ne s'arrete jamais
        return false;
    }

    // >Getter

    public Labyrinthe getLaby() {
        return this.laby;
    }
}
