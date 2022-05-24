package gameLaby.laby.controller;

import gameLaby.laby.modele.Labyrinthe;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LabyJeuTest {
@Test
    public void test_Monstre_posInit() throws IOException {
    Labyrinthe laby = new Labyrinthe("labySimple/laby1.txt");
    System.out.println(laby.toString());
}
}