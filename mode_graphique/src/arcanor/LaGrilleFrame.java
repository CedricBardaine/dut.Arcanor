package arcanor;

import arcanor.*;
//
import javax.swing.JFrame ;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.lang.ArrayIndexOutOfBoundsException ;


/**
* Créer la fenetre ou le jeu se deroule.
* @author Bardaine Cédric, Servant Andy-Loup
* @version 0.1
*/
public class LaGrilleFrame extends FrameParDefaut {
    private final int TAILLE_CELLULE = 70;

    /**
    * Constructeur de LaGrilleFrame
    * @param laGrille la grille qui sera utilisée pour le tableau
    */
    public LaGrilleFrame(Grille laGrille) {
        try {
            this.setSize(TAILLE_CELLULE*laGrille.getGrille().length , TAILLE_CELLULE*laGrille.getGrille()[0].length);
            // Grille laGrille = new Grille(uneGrille);
            JTable leTab = new JTable(laGrille);

            leTab.setShowGrid(true);

            leTab.setGridColor(Color.BLACK);
            leTab.setRowHeight(TAILLE_CELLULE);

            JScrollPane jSP = new JScrollPane(leTab);
            this.getContentPane().add(jSP);

        }
        catch(java.lang.ArrayIndexOutOfBoundsException e) {System.out.println("oups, impossible de créer la grille, il se peut que le nombre de lignes et/ou de colonnes est mauvais");}
    }
}
