package gameLaby.laby.modele;

import javafx.geometry.Pos;

public class Monstre extends Position {
    /**
     * Constructeur avec coordonnees
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Monstre(int dx, int dy) {
        super(dx, dy);
    }

    public Position etreAttire(Personnage p, String action) {
        int distanceInitiale = this.distanceEntre(p);
        int prochainX = this.x;
        int prochainY = this.y;
        switch (action) {
            case Labyrinthe.HAUT:
                // on monte une ligne
                prochainY--;
                break;
            case Labyrinthe.BAS:
                // on descend une ligne
                prochainY++;
                break;
            case Labyrinthe.DROITE:
                // on augmente colonne
                prochainX++;
                break;
            case Labyrinthe.GAUCHE:
                // on augmente colonne
                prochainX--;
                break;
        }
        Position futurPos = new Position(prochainX, prochainY);
        int distanceApresDeplacement = futurPos.distanceEntre(p);
        System.out.println("Distance initiale: " + distanceInitiale);
        System.out.println("Prochaine distance: "  +distanceApresDeplacement);

        if (distanceInitiale < distanceApresDeplacement) {
            if (this.x - futurPos.getX() == 1) futurPos.x += 2;
            else if (this.x - futurPos.getX() == -1) futurPos.x -= 2;
            else if (this.y - futurPos.getY() == 1) futurPos.y += 2;
            else if (this.y - futurPos.getY() == -1) futurPos.y -= 2;
        }

        return futurPos;
    }
}
