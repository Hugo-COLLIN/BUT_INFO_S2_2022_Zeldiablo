package gameLaby.laby.modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test de la classe Position
 */
class PositionTest {
    Position pos;
    int x, y;

    /**
    * Creation d une position afin de pouvoir l utiliser dans les tests ci dessous
     */
    @BeforeEach
    void beforeEach()
    {
        x = 2;
        y = 1;
        pos = new Position(x,y);
    }

    /**
    * Test des methodes getX et getY de la classe Position
     */
    @Test
    void test_getters_XY ()
    {
        // Appel des methodes
        int resX = pos.getX();
        int resY = pos.getY();

        // Test si les valeurs obtenues par les methodes correspondent a celles attendues
        assertEquals(resX, 2, "Les valeurs doivent etre egales");
        assertEquals(resY, 1, "Les valeurs doivent etre egales");
    }

    /**
     * Test de la methode etrePresent de la classe Position (cas Present)
     */
    @Test
    void test_etrePresent_present()
    {
        // Appel de la methode
        boolean res = pos.etrePresent(2, 1);

        // Test si la position est bien presente a ces coordonnees donnees en parametre
        assertTrue(res, "Le resultat doit etre vrai");
    }

    /**
     * Test de la methode etrePresent de la classe Position (cas non present)
    */
    @Test
    void test_etrePresent_pasPresent1Att()
    {
        // Appel de la methode
        boolean res = pos.etrePresent(2, 3);

        // Test si la position n'est bien pas presente aux coordonnes donnees en parametre
        assertFalse(res, "Le resultat doit etre faux");
    }

    /**
     * Test de la methode etrePresent de la classe Position (cas non present avec d autres valeurs)
    */
    @Test
    void test_etrePresent_pasPresent2Att()
    {
        // Appel de la methode
        boolean res = pos.etrePresent(8, 5);

        // Test si la position n'est bien pas presente aux coordonnes donnees en parametre
        assertFalse(res, "Le resultat doit etre faux");
    }

    /**
     * Test de la methode distance_entre de la classe Position
     */
    @Test
    void distance_entre(){
        // construction position
        Position p1=new Position(4, 3);
        Position p2= new Position(0, 0);
        // appel methode
        double dist=p2.distanceEntre(p1);
        // test
        assertEquals(5, dist, "La distance doit etre egale a 5");
    }
}