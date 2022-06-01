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

    public double distanceEntre(Role pos) {
        double distanceX = pos.getX() - x;
        double distanceY = pos.getY() - y;
        double sommeCarree = Math.pow(distanceX, 2) + Math.pow(distanceY, 2);
        return Math.sqrt(sommeCarree);
    }

    public void subirDegat(int Degat){
        this.pv--;
    }

    public abstract boolean attaquer(Role role);

    public void subirDegats (int degats)
    {
        this.setPv(this.getPv()-degats);
    }
    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }
}
