package gameLaby.laby.view;

import gameLaby.laby.controller.LabyJeu;
import gameLaby.laby.modele.Labyrinthe;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

/**
 * Vue graphique permettant de créer l'IHM a partir du modele
 */
public class LabyDessin implements DessinJeu {

    /**
     * Taille d'une case
     */
    private static final int TAILLE_CASE = 50;

    /**
     * Cree l'interface graphique a partir du modele
     * @param jeu jeu a afficher
     * @param canvas canvas dans lequel dessiner l'etat du jeu
     */
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
                } else if (labyrinthe.getPj().etrePresent(i,j)) {
                    gc.setFill(Color.RED);
                    gc.fillOval(i * TAILLE_CASE, j * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
                } else if (labyrinthe.getMonstre() != null && labyrinthe.getMonstre().etrePresent(i,j)) {
                    gc.setFill(Color.VIOLET);
                    gc.fillOval(i * TAILLE_CASE, j * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
                } else {
                    gc.setFill(Color.WHITE);
                    gc.fillRect(i * TAILLE_CASE, j * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
                }
            }
        }
    }
}
