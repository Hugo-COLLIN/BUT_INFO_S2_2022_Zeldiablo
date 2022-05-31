package gameLaby.laby.controller;

import gameLaby.laby.modele.Labyrinthe;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Methode de test de la methode LabyJeu
 */
class LabyJeuTest
{
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

    /**
     * Teste le deplacement d'un monstre qui est contre un mur.
     */
    @Test
    public void test_Monstre_Collision() throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple/laby1.txt");


        // Fait assez de deplacement pour rencontrer un obstacle (mur, monstre)
        for(int i=0; i<10; i++)
            laby.deplacerPosition(Labyrinthe.HAUT);
        for(int i=0; i<10; i++)
            laby.deplacerPosition(Labyrinthe.GAUCHE);
        for(int i=0; i<10; i++)
            laby.deplacerPosition(Labyrinthe.BAS);
        for(int i=0; i<10; i++)
            laby.deplacerPosition(Labyrinthe.DROITE);
        for(int i=0; i<10; i++)
            laby.deplacerPosition(Labyrinthe.HAUT);
        for(int i=0; i<10; i++)
            laby.deplacerPosition(Labyrinthe.DROITE);

        // Recuperation des valeurs
        int Px=laby.getPj().getX();
        int Py=laby.getPj().getY();
        //le personnage vient par la gauche
        //On a un soucis avec le modele :il faut un while dans deplacer position
        //pour le soucis nest pas sur la view

        //Hypoyhese principale(70%): quelquun a modifié le view au lieu dagir sur le modèle
        //Hypothese2:(30%):autre chose

        // Test sur la position
        assertEquals(3, Px);
        assertEquals(3,Py);
    }
}