package gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

public class LabyDessin implements DessinJeu {

    private static final int TAILLE_CASE = 50;

    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        LabyJeu labyJeu = (LabyJeu) jeu;

        final GraphicsContext gc = canvas.getGraphicsContext2D();

        Labyrinthe labyrinthe = labyJeu.getLaby();

        for (int i = 0; i < labyrinthe.getLengthX(); i++) {
            // column = i = x

            for (int j = 0; j < labyrinthe.getLengthY(); j++) {
                // line = j = y
                if (labyrinthe.getMur(i, j)) {
                    gc.setFill(Color.BLACK);
                    gc.fillRect(i * TAILLE_CASE, j * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
                } else if (labyrinthe.pj.getX() == i && labyrinthe.pj.getY() == j) {
                    gc.setFill(Color.RED);
                    gc.fillOval(i * TAILLE_CASE, j * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
                } else {
                    gc.setFill(Color.WHITE);
                    gc.fillRect(i * TAILLE_CASE, j * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
                }
            }
        }
    }
}
