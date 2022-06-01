package gameLaby.laby.modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonnageTest {
    Labyrinthe laby;

    /*
    Creation d une position afin de pouvoir l utiliser dans les tests ci dessous
     */
    @BeforeEach
    void beforeEach() throws IOException {
        laby = new Labyrinthe("labySimple/laby1.txt");
    }

    /*
   Test de la methode attaquer de la classe Personnage (si l'attaque a eu lieu)
    */
    @Test
    void test_attaquer_aEuLieu()
    {

        // Stockage des points de vie initiaux du monstre
        int pvInit=laby.getMonstre().getPv();

        // creation d un boolean pour le test
        boolean aEuLieu=false;

        // appel de la methode
        aEuLieu=laby.getPj().attaquer(laby.getMonstre());

        // Test que l attaque a eu lieu et que le monstre a subi des degats
        boolean subirDegats=(pvInit>laby.getMonstre().getPv());
        assertTrue(aEuLieu, "L attaque doit avoir eu lieu");
        assertTrue(subirDegats, "Le monstre doit avoir subit des degats");
    }

}
