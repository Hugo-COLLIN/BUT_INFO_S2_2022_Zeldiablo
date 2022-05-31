package gameLaby.laby.controller;

import gameLaby.laby.modele.Labyrinthe;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LabyJeuTest {
    /*
    Test si la position initiale du monstre
     */
    @Test
    public void test_Monstre_posInit() throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple/laby1.txt");
        assertEquals(laby.getMonstre().etrePresent(4, 3), true);
    }

    /*
    Test labsence du monstre(il est nulle)
     */
    @Test
    public void test_Monstre_posInit_Absent() throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple/laby0.txt");
        assertNull(laby.getMonstre());
    }

    @Test
    public void test_Monstre_sur_Perso() {
        //TODO quand le personnage va pouvoir se deplacer ...bref à voir plus tard
        throw (new Error());
    }

    @Test
    public void test_Monstre_toString() throws IOException {
        String laby0="XXXXXXX\n" +
                "X.....X\n" +
                "X..P..X\n" +
                "X.....X\n" +
                "XXXXXXX";
        Labyrinthe laby = new Labyrinthe("labySimple/laby0.txt");
        for (int i = 0; i < laby.getLengthY() * laby.getLengthX(); i++) {
            assertEquals(laby.toString().charAt(i),laby0.charAt(i));
        }
    }

    @Test
    public void test_Monstre_Collision() throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple/laby1.txt");
        laby.deplacerPosition(Labyrinthe.HAUT);
        laby.deplacerPosition(Labyrinthe.GAUCHE);
        laby.deplacerPosition(Labyrinthe.BAS);
        laby.deplacerPosition(Labyrinthe.DROITE);
        laby.deplacerPosition(Labyrinthe.HAUT);
        laby.deplacerPosition(Labyrinthe.DROITE);
        int Px=laby.getPj().getX();
        int Py=laby.getPj().getY();
        int Mx=laby.getMonstre().getX();
        int My=laby.getMonstre().getY();
        //le personnage vient par la gauche
        //On a un soucis avec le modele :il faut un while dans deplacer position
        //pour le soucis nest pas sur la view

        //Hypoyhese principale(70%): quelquun a modifié le view au lieu dagir sur le modèle
        //Hypothese2:(30%):autre chose

        assertEquals(Px+1,Mx);
        assertEquals(Py,My);
    }
}