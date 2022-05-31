package gameLaby.laby.modele;

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

    public void etreAttire(Personnage p, String action) {
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
        int distanceApresDeplacement = this.distanceEntre(new Position(prochainX, prochainY));

        if(distanceInitiale > distanceApresDeplacement) {
            this.x = futurPos.x;
            this.y = futurPos.y;
        } else {
            if (this.x - futurPos.getX() == 1) this.x++;
            else if (this.x - futurPos.getX() == -1) this.x--;
            else if (this.y - futurPos.getY() == 1) this.y++;
            else if (this.y - futurPos.getY() == -1) this.y--;
        }
    }


}
