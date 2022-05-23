package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

public class LabyJeu implements Jeu
{
    Labyrinthe laby;

    public LabyJeu (Labyrinthe labyP)
    {
        this.laby = labyP;
    }

    /**
     * met a jour l'etat du jeu
     */
    public void update(double secondes, Clavier clavier) {
        
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
}
