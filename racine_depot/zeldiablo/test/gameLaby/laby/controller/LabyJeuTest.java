package gameLaby.laby.controller;

import gameLaby.laby.modele.Labyrinthe;
import gameLaby.laby.modele.Monstre;
import gameLaby.laby.modele.Personnage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import moteurJeu.Clavier;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test de la classe LabyJeu
 */
class LabyJeuTest {
    /**
     * Teste si la position initiale du monstre
     */
    @Test
    public void test_Monstre_posInit() throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple/laby1.txt");
        assertTrue(laby.getMonstre().etrePresent(4, 3), "le personnage doit etre present dans le labyrinthe");
    }

    /**
     * Test l'absence du monstre (il vaut null)
     */
    @Test
    public void test_Monstre_posInit_Absent() throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple/laby0.txt");
        assertNull(laby.getMonstre());
    }


    /**
     * Teste que la méthode toString de Monstre fonctionne correctement
     */
    @Test
    public void test_Monstre_toString() throws IOException {
        String laby0 = "XXXXXXX\n" +
                "X.....X\n" +
                "X..P..X\n" +
                "X.....X\n" +
                "XXXXXXX";
        Labyrinthe laby = new Labyrinthe("labySimple/laby0.txt");
        for (int i = 0; i < laby.getLengthY() * laby.getLengthX(); i++) {
            assertEquals(laby.toString().charAt(i), laby0.charAt(i));
        }
    }

    /**
     * Teste le deplacement d'un monstre qui est contre un mur.
     */
    @Test
    public void test_Monstre_Collision() throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple/laby1.txt");


        // Fait assez de deplacement pour rencontrer un obstacle (mur, monstre)
        for (int i = 0; i < 10; i++)
            laby.deplacerPosition(Labyrinthe.HAUT);
        for (int i = 0; i < 10; i++)
            laby.deplacerPosition(Labyrinthe.GAUCHE);

        // Recuperation des valeurs
        int Px = laby.getPj().getX();
        int Py = laby.getPj().getY();
        //le personnage vient par la gauche
        //On a un soucis avec le modele :il faut un while dans deplacer position
        //pour le soucis nest pas sur la view

        //Hypoyhese principale(70%): quelquun a modifié le view au lieu dagir sur le modèle
        //Hypothese2:(30%):autre chose

        // Test sur la position
        assertEquals(5, Px);
        assertEquals(1, Py);
    }

    @Test
    public void test_laby_culdecasc() throws IOException {

        Labyrinthe laby = new Labyrinthe("labySimple/laby_test_culdesac.txt");

        laby.deplacerPosition(Labyrinthe.DROITE);
        assertEquals(laby.getMonstre().etrePresent(laby.getMonstre().getX(), laby.getMonstre().getY()), true);
        laby.deplacerPosition(Labyrinthe.GAUCHE);
        assertEquals(laby.getMonstre().etrePresent(laby.getMonstre().getX(), laby.getMonstre().getY()), true);
        laby.deplacerPosition(Labyrinthe.BAS);
        assertEquals(laby.getMonstre().etrePresent(laby.getMonstre().getX(), laby.getMonstre().getY()), true);
        laby.deplacerPosition(Labyrinthe.HAUT);
        assertEquals(laby.getMonstre().etrePresent(laby.getMonstre().getX(), laby.getMonstre().getY()), true);
    }

    /**
     * On test les pv du monstre avant et après lattaque
     * le monstre est éloigné de au moins une case
     * @throws IOException
     */
    @Test
    public void test_attaqueMonstre_eloigne() throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple/laby1.txt");
        assertEquals(5, laby.getMonstre().getPv());
        assertTrue(laby.getPj().attaquer(laby.getMonstre()));
        assertEquals(5, laby.getMonstre().getPv());

    }

    /**
     * Test du deplacement du personnage lors de lattaque
     * on simule lappui sur le clavier
     * @throws IOException
     */
    @Test
    public void test_attaqueMonstre_eloigne_deplacementjoueur() throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple/laby1.txt");
        Personnage p = laby.getPj();
        Monstre m = laby.getMonstre();
        int initPV = m.getPv();
        int InitX = p.getX();
        int InitY = p.getY();

        Clavier clavier = new Clavier();
        clavier.espace = true;
        clavier.haut = true;
        LabyJeu labyJeu = new LabyJeu(laby);
        labyJeu.update(0, clavier);

        assertEquals(InitX, p.getX(), "Le personnage s'est deplace en X");
        assertEquals(InitY, p.getY(), "Le personnage s'est deplace en Y");
        assertEquals(initPV, m.getPv(), "Le monstre a ete attaque !");

    }
}