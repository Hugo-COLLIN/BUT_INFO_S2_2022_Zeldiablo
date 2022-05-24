package gameLaby.laby.modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe labyrinthe. Represente un labyrinthe avec
 * <ul> des murs </ul>
 * <ul> un personnage (x,y) </ul>
 */
public class Labyrinthe {

    /**
     * Constantes char
     */
    public static final char MUR = 'X';
    public static final char PJ = 'P';
    public static final char MONSTRE = 'M';
    public static final char VIDE = '.';

    /**
     * Constantes actions possibles
     */
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";

    /**
     * Attribut du personnage
     */
    private Personnage pj;


    /**
     * Attribut du monstre
     */
    private Monstre monstre;

    /**
     * Les murs du labyrinthe
     */
    public boolean[][] murs;

    /**
     * Retourne la case suivante selon une actions
     *
     * @param x      case depart
     * @param y      case depart
     * @param action action effectuee
     * @return case suivante
     */
    static int[] getSuivant(int x, int y, String action) {
        switch (action) {
            case HAUT:
                // on monte une ligne
                y--;
                break;
            case BAS:
                // on descend une ligne
                y++;
                break;
            case DROITE:
                // on augmente colonne
                x++;
                break;
            case GAUCHE:
                // on augmente colonne
                x--;
                break;
            default:
                throw new Error("action inconnue");
        }
        int[] res = {x, y};
        return res;
    }

    /**
     * Charge le labyrinthe
     *
     * @param nom nom du fichier de labyrinthe
     * @return labyrinthe cree
     * @throws IOException probleme a la lecture / ouverture
     */
    public Labyrinthe(String nom) throws IOException {
        // ouvrir fichier
        FileReader fichier = new FileReader(nom);
        BufferedReader bfRead = new BufferedReader(fichier);

        int nbLignes, nbColonnes;
        // lecture nblignes
        nbLignes = Integer.parseInt(bfRead.readLine());
        // lecture nbcolonnes
        nbColonnes = Integer.parseInt(bfRead.readLine());

        // creation labyrinthe vide
        this.murs = new boolean[nbColonnes][nbLignes];
        this.pj = null;

        // lecture des cases
        String ligne = bfRead.readLine();

        // stocke les indices courants
        int numeroLigne = 0;

        // parcours le fichier
        while (ligne != null) {

            // parcours de la ligne
            for (int colonne = 0; colonne < ligne.length(); colonne++) {
                char c = ligne.charAt(colonne);
                switch (c) {
                    case MUR:
                        this.murs[colonne][numeroLigne] = true;
                        break;
                    case VIDE:
                        this.murs[colonne][numeroLigne] = false;
                        break;
                    case PJ:
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        // ajoute PJ
                        this.pj = new Personnage(colonne, numeroLigne);
                        break;
                    case MONSTRE:
                        this.murs[colonne][numeroLigne] = false;
                        this.monstre = new Monstre(colonne, numeroLigne);
                        break;

                    default:
                        throw new Error("caractere inconnu " + c);
                }
            }

            // lecture
            ligne = bfRead.readLine();
            numeroLigne++;
        }

        // ferme fichier
        bfRead.close();
    }


    /**
     * Deplace le personnage en fonction de l'action.
     * Gere la collision avec les murs
     *
     * @param action une des actions possibles
     */
    public void deplacerPosition(String action) {
        // case courante
        int[] courante = {this.pj.x, this.pj.y};

        // calcule case suivante
        int[] suivante = getSuivant(courante[0], courante[1], action);

        // si c'est pas un mur, on effectue le deplacement
        if (!this.murs[suivante[0]][suivante[1]]) {
            // on met a jour personnage
            this.pj.x = suivante[0];
            this.pj.y = suivante[1];
        }
    }


    /**
     * Le jeu n'est jamais fini
     *
     * @return fin du jeu
     */
    public boolean etreFini() {
        return false;
    }

    // ##################################
    // GETTER
    // ##################################

    /**
     * Getter de Y
     * @return taille selon Y
     */
    public int getLengthY() {
        return murs[0].length;
    }

    /**
     * Getter de X
     * @return taille selon X
     */
    public int getLengthX() {
        return murs.length;
    }

    /**
     * Retourne l'etat d'un mur
     * return mur en (i,j)
     * @param x
     * @param y
     * @return mur en (i,j)
     */
    public boolean getMur(int x, int y) {
        // utilise le tableau de boolean
        return this.murs[x][y];
    }

    public Monstre getMonstre() {
            return this.monstre;
    }

    public Personnage getPj(){
        return this.pj;
    }

    public String toString() {
        String S = "";
        for (int y = 0; y < this.getLengthY(); y++) {
            // affiche la ligne
            for (int x = 0; x < this.getLengthX(); x++) {
                if (this.getMur(x, y))
                    S += MUR;
                else if (this.monstre != null && this.monstre.etrePresent(x,y)) {
                    S +=MONSTRE;
                } else if (this.pj.etrePresent(x, y)) {
                    S += PJ;
                } else {
                    S += VIDE;
                }
            }
            S+='\n';
        }
        return S;
    }
}