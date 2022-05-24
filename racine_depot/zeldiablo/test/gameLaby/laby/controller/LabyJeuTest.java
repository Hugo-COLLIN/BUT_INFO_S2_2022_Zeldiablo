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
}