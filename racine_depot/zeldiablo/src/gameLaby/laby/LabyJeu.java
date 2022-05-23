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
        if (clavier.droite || clavier.gauche || clavier.haut || clavier.bas)
            this.laby.deplacerPerso(clavier.toString());
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
