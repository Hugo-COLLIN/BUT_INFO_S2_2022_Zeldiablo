package gameLaby.laby.modele;

public class Personnage extends Role {
    /**
     * Constructeur avec coordonnees
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Personnage(int dx, int dy,int pv) {
        super(dx, dy,pv);
    }

    @Override
    public boolean attaquer(Role m) {
        if (this.distanceEntre(m) == 1) {
            m.subirDegats(Role.DEGAT);
        }
        return true;
    }

}
