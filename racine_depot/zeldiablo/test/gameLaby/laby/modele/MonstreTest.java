package gameLaby.laby.modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class MonstreTest {
    Labyrinthe laby;

    /**
     *Creation d une position afin de pouvoir l utiliser dans les tests ci dessous
     */
    @BeforeEach
    void beforeEach() throws IOException {
       laby = new Labyrinthe("labySimple/laby1.txt");
    }

    /**
     *Test de la methode etreAttire de la classe Monstre
     */
    @Test
    void test_etreAttire()
    {
        // Calcul de la distance initiale entre le Monstre et le Personnage du Labyrinthe
        double distInit=laby.getMonstre().distanceEntre(laby.getPj());

        // Deplacement du Heros
        laby.deplacerPosition(Labyrinthe.GAUCHE);
        double distApresDeplacement = laby.getMonstre().distanceEntre(laby.getPj());

        // Test si les valeurs obtenues par les methodes correspondent a celles attendues
        boolean distReduite=(distInit>distApresDeplacement);
        assertTrue(distReduite, "La distance entre le monstre et le personnage doit etre soit reduite, soit egale a " +
                "celle initialle");
    }

    /**
     *     Tests Attaque des monstres :
     */
    @Test
    void attaquer_pertePVpos ()
    {
        //Init
        Monstre m = new Monstre(2, 3, 5);
        Personnage p = new Personnage(2,2, 5);

        //Appel methode
        m.attaquer(p);

        //Test
        assertEquals(4, p.getPv(),  "doit etre diminue de 1");
    }

    /**
     * test pertePv negatif
     */
    @Test
    void attaquer_pertePVneg ()
    {
        //Init
        Monstre m = new Monstre(2, 3, 5);
        Personnage p = new Personnage(2,2, 0);

        //Appel methode
        m.attaquer(p);

        //Test
        assertEquals(0, p.getPv(),  "doit valoir 0");
    }

    /**
     * test deplacement du monstre lors de son attaque
     */
    @Test
    void nonDeplacementDuMonstre() {
        Monstre m = laby.getMonstre();
        Personnage p = laby.getPj();


        laby.deplacerPosition(Labyrinthe.HAUT);
        Monstre positionInit =new Monstre(m.getX(), m.getY(), m.getPv());
        laby.deplacerPosition(Labyrinthe.HAUT);

        boolean deplacer = positionInit.getX() == m.getX() && positionInit.getY() == m.getY();

        assertTrue(deplacer, "Le monstre s'est deplace");
        assertEquals(4, p.getPv(), "Le hero n'a pas perdu des points de vie donc n'a pas ete attaque");

    }

    /**
     * deplacement du monstre si non attaque
     */
    @Test
    void deplacementSiNonAttaque() {
        Monstre m = laby.getMonstre();
        Personnage p = laby.getPj();

        Monstre positionInit =new Monstre(m.getX(), m.getY(), m.getPv());
        laby.deplacerPosition(Labyrinthe.HAUT);

        boolean deplacer = positionInit.getX() != m.getX() || positionInit.getY() != m.getY();

        assertTrue(deplacer, "Le monstre ne s'est pas deplace");
        assertEquals(5, p.getPv(), "Le hero a perdu des points de vie donc a ete attaque");

    }
}