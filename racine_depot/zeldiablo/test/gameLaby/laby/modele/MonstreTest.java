package gameLaby.laby.modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class MonstreTest {
    Labyrinthe laby;

    /*
    Creation d une position afin de pouvoir l utiliser dans les tests ci dessous
     */
    @BeforeEach
    void beforeEach() throws IOException {
       laby = new Labyrinthe("labySimple/laby1.txt");
    }

    /*
    Test de la methode etreAttire de la classe Monstre
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

    @Test
    void subirDegats_pertePVpos ()
    {
        Monstre m = new Monstre(2, 3, 5);
        Personnage p = new Personnage(2,2, 5);
    }

    @Test
    void deplacementSiNonAttaque() {
        Monstre m = laby.getMonstre();
        Personnage p = laby.getPj();

        Monstre positionInit =new Monstre(m.getX(), m.getY(), m.getPv());
        laby.deplacerPosition(Labyrinthe.HAUT);

        boolean deplacer = positionInit.getX() != m.getX() || positionInit.getY() != m.getY();

        assertTrue(deplacer, "Le monstre ne s'est pas deplacer");
        assertEquals(5, p.getPv(), "Le hero a perdu des points de vie donc a ete attaque");

    }
}