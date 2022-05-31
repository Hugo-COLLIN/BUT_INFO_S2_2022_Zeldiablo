package gameLaby.laby.modele;


/**
 * gere un personnage situe en x,y
 */
public class Position {

    /**
     * Position du personnage
     */
    int x, y;

    /**
     * Constructeur avec coordonnees
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Position(int dx, int dy) {
        this.x = dx;
        this.y = dy;
    }

    /**
     * Permet de savoir si le personnage est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si le personnage est bien en (dx,dy)
     */
    public boolean etrePresent(int dx, int dy) {

        return (this.x == dx && this.y == dy);
    }

    // ############################################
    // GETTER
    // ############################################

    /**
     * @return position x du personnage
     */
    public int getX() {
        // getter
        return this.x;
    }

    /**
     * @return position y du personnage
     */
    public int getY() {
        //getter
        return this.y;
    }

    public int distanceEntre(Position pos) {
        int distanceX = pos.getX() - x;
        int distanceY = pos.getY() - y;
        int sommeCarree = (int) (Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
        return (int) Math.round(Math.sqrt(sommeCarree));
    }
}
