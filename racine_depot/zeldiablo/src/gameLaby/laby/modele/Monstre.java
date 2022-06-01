package gameLaby.laby.modele;

public class Monstre extends Role {
    /**
     * Constructeur avec coordonnees
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Monstre(int dx, int dy) {
        super(dx, dy);
    }

    public Role etreAttire(Personnage p, String action) {
        double distanceInitiale = this.distanceEntre(p);
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
        Monstre futurPos = new Monstre(prochainX, prochainY);
        double distanceApresDeplacement = futurPos.distanceEntre(p);
//        System.out.println("Distance initiale: " + distanceInitiale);
//        System.out.println("Prochaine distance: "  +distanceApresDeplacement);
//
        if (distanceInitiale < distanceApresDeplacement) {
            if (this.x - futurPos.getX() == 1) futurPos.x += 2;
            else if (this.x - futurPos.getX() == -1) futurPos.x -= 2;
            else if (this.y - futurPos.getY() == 1) futurPos.y += 2;
            else if (this.y - futurPos.getY() == -1) futurPos.y -= 2;

            distanceApresDeplacement = futurPos.distanceEntre(p);
            if (distanceInitiale < distanceApresDeplacement) {
                futurPos.x = this.x;
                futurPos.y = this.y;
            }
        }
        return futurPos;
    }

    public void attaquer (Role role)
    {

    }
}
