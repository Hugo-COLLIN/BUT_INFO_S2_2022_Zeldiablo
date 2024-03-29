package gameLaby.laby.modele;


/**
 * gere un personnage situe en x,y
 */
public abstract class Role {

    /**
     * Position du personnage
     */
    int x, y;

    private int pv;
    public static final int DEGAT = 1;

    /**
     * Constructeur avec coordonnees
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Role(int dx, int dy, int pv) {
        this.x = dx;
        this.y = dy;
        this.pv = pv;
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

    /**
     * methode distance entre deux roles
     * @param pos
     * @return
     */
    public double distanceEntre(Role pos) {
        double distanceX = pos.getX() - x;
        double distanceY = pos.getY() - y;
        double sommeCarree = Math.pow(distanceX, 2) + Math.pow(distanceY, 2);
        return Math.sqrt(sommeCarree);
    }

    /**
     * attaquer en abstrait
     * @param role
     * @return
     */
    public abstract boolean attaquer(Role role);

    /**
     * methode pour subir les degats
     * @param degats
     */
    public void subirDegats (int degats)
    {
        this.setPv(this.getPv()-degats);
        // Permet de mettre la vie a zero si elle descend en dessous
        this.setPv(Math.max(this.getPv(), 0));
    }

    /**
     * methode retournant le nombre de pv
     * @return
     */
    public int getPv() {
        return pv;
    }

    /**
     * methode modifiant le nombre de pv
     * @param pv
     */
    public void setPv(int pv) {
        this.pv = pv;
    }
}
