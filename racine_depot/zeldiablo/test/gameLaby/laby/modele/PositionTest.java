package gameLaby.laby.modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PositionTest {
    Position pos;
    int x, y;

    @BeforeEach
    void beforeEach()
    {
        x = 2;
        y = 1;
        pos = new Position(x,y);
    }

    @Test
    void test_getters_XY ()
    {
        //Appel methodes
        int resX = pos.getX();
        int resY = pos.getY();

        //Test
        assertEquals(resX, 2, "doivent etre egaux");
        assertEquals(resY, 1, "doivent etre egaux");
    }

    @Test
    void test_etrePresent_present()
    {
        //Appel methode
        boolean res = pos.etrePresent(2, 1);

        //Test
        assertTrue(res, "doit etre vrai");
    }

    @Test
    void test_etrePresent_pasPresent1Att()
    {
        //Appel methode
        boolean res = pos.etrePresent(2, 3);

        //Test
        assertFalse(res, "doit etre faux");
    }

    @Test
    void test_etrePresent_pasPresent2Att()
    {
        //Appel methode
        boolean res = pos.etrePresent(8, 5);

        //Test
        assertFalse(res, "doit etre faux");
    }

    @Test
    void distance_entre(){
        // construction position
        Position p1=new Position(4, 3);
        Position p2= new Position(0, 0);
        // appel methode
        int dist=p2.distanceEntre(p1);
        // test
        assertEquals(5, dist, "La distance doit etre egale a 5");
    }
}