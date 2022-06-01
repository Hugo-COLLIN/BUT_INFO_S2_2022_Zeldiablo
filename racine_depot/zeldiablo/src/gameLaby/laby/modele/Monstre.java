package gameLaby.laby.modele;

public class Monstre extends Role {
    /**
     * Constructeur avec coordonnees
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Monstre(int dx, int dy, int pv) {
        super(dx, dy, pv);
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
        Monstre futurPos = new Monstre(prochainX, prochainY,0);
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

    public boolean attaquer (Role role)
    {
        boolean res = false;
        if (this.distanceEntre(role) == 1)
        {
            role.subirDegats(role.DEGAT);
            res = true;
        }
        return res;
    }

    public void subirDegats (int degats)
    {
        this.setPv(this.getPv()-degats);
    }
}
