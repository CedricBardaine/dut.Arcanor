//package __________________________________
package arcanor ;
//__________________________________________


//imports __________________________________
import arcanor.* ;
//
import javax.swing.table.AbstractTableModel;
import java.awt.image.BufferedImage ;
import javax.imageio.ImageIO ;
import java.io.File ;
import javax.swing.ImageIcon ;
import java.util.ArrayList ;
//__________________________________________

/**
* Cette classe représente la Grille par un tableau à double entree.
* @author Bardaine Cédric, Servant Andy-Loup
* @version 0.1
*/
public class Grille extends AbstractTableModel {

    private int nbLignes , nbColones ;
    //
    private Case[][] laGrille ;
    //
    private ArrayList<Pion> alPJ1 ;
    private ArrayList<Pion> alPJ2 ;



    /**
    * Un constructeur, il prend en parametre un double tableau d'objets Case afin de créer une Grille.
    * @param uneGrille est le double tableau en question.
    */
    public Grille(Case[][] uneGrille) {
        this.laGrille = uneGrille ;
        this.nbLignes   = this.laGrille.length ;
        this.nbColones  = this.laGrille[0].length ;
    }

    /**
    * Un constructeur, il ne prend rien en parametre et initialise une grille normale du jeu Arcanor.
    */
    public Grille() {
        this.laGrille = new Case[7][8] ;
        for(int i = 0 ; i < this.nbLignes; i++) {
            for (int j = 0 ; j < this.nbColones ; j++ ) {
                this.laGrille[i][j] = new Case(i,j);
            }
        }
        this.nbLignes = 8;
        this.nbColones = 7 ;
    }




    //_______________ methodes heritees de AbstractTableModel _______________
    /**
    * @return le nombre de ligne de la la Grille
    */
    public int getRowCount() { return this.nbLignes ; }
    /**
    * @return le nombre de colonnes de la la Grille
    */
    public int getColumnCount() { return this.nbColones ; }
    /**
    * @return le nom de la colonnne
    */
    public String getColumnName(int colonne){
        return (new Integer(colonne).toString());

    }
    /**
    * @return la classe de l'object à la colonne spécifié
    */
    public Class getColumnClass(int colonne) {
        return this.getValueAt(0, colonne).getClass();
    }
    /**
    * Renvoie un objet correspondant aux coordonnees passees en parametre.
    * @param row la ligne recherchée pour l'objet a renvoyer
    * @param column la colonne recherchée pour l'objet a renvoyer
    * @return l'object correspondant aux coordonnees, ou null si il n'y a rien à l'emplacement
    */
    public Object getValueAt(int row, int column) throws java.lang.NullPointerException {
        // String path = "../modeles/DV.png" ;
        Object ret = new Object() ;
        ret = new ImageIcon("../data/modeles/DV.png")  ;
        // Case caseRet = laGrille[row][column] ;
        //
        // if (caseRet.getPion() == null )                         ret = new ImageIcon("../data/modeles/DV.jpg");
        // else {
        //     if (caseRet.getPion().getNom() == "J1T1") ret = new ImageIcon("../data/modeles/pionJ1T1.jgp") ;
        //     if (caseRet.getPion().getNom() == "J1T2") ret = new ImageIcon("../data/modeles/pionJ1T2.jgp") ;
        //     if (caseRet.getPion().getNom() == "J1T3") ret = new ImageIcon("../data/modeles/pionJ1T3.jgp") ;
        //     if (caseRet.getPion().getNom() == "J1T4") ret = new ImageIcon("../data/modeles/pionJ1T4.jgp") ;
        //     if (caseRet.getPion().getNom() == "J2T1") ret = new ImageIcon("../data/modeles/pionJ2T1.jgp") ;
        //     if (caseRet.getPion().getNom() == "J2T2") ret = new ImageIcon("../data/modeles/pionJ2T2.jgp") ;
        //     if (caseRet.getPion().getNom() == "J2T3") ret = new ImageIcon("../data/modeles/pionJ2T3.jgp") ;
        //     if (caseRet.getPion().getNom() == "J2T4") ret = new ImageIcon("../data/modeles/pionJ2T4.jgp") ;
        // }
        // return ret ;

        for (int i = 0  ;  i< this.alPJ1.size()  ;  i++) {
            Pion lepetitpion = this.alPJ1.get(i) ;
            if (lepetitpion.getDisp() ) {
                if(lepetitpion.getPosX() == row  &&  lepetitpion.getPosY() == column) {
                    if(lepetitpion.getTaille() == 1) { ret = new ImageIcon("../data/modeles/pionJ1T1.png") ; }
                    if(lepetitpion.getTaille() == 2) { ret = new ImageIcon("../data/modeles/pionJ1T2.png") ; }
                    if(lepetitpion.getTaille() == 3) { ret = new ImageIcon("../data/modeles/pionJ1T3.png") ; }
                    if(lepetitpion.getTaille() == 4) { ret = new ImageIcon("../data/modeles/pionJ1T4.png") ; }
                }
            }
        }
        for (int i = 0  ;  i< this.alPJ2.size()  ;  i++) {
            Pion lepetitpion = this.alPJ2.get(i) ;
            if (lepetitpion.getDisp() ) {
                if(lepetitpion.getPosX() == row  &&  lepetitpion.getPosY() == column) {
                    if(lepetitpion.getTaille() == 1) { ret = new ImageIcon("../data/modeles/pionJ2T1.png") ; }
                    if(lepetitpion.getTaille() == 2) { ret = new ImageIcon("../data/modeles/pionJ2T2.png") ; }
                    if(lepetitpion.getTaille() == 3) { ret = new ImageIcon("../data/modeles/pionJ2T3.png") ; }
                    if(lepetitpion.getTaille() == 4) { ret = new ImageIcon("../data/modeles/pionJ2T4.png") ; }
                }
            }
        }


        return ret ;

        //disponibilité avec disp()


    }


    //______________________________________________________________________


    /**
    * @return l'attribut LaGrilleFrame
    */
    public Case[][] getGrille() {return this.laGrille ; }


    /**
    * Permet d'afficher la grille sous forme de texte
    */
    public void afficherGrille() {
        System.out.println("affichage du plateau");
        for (int axeY = this.nbColones - 1  ;  axeY >= 0  ;  axeY--) {
            for (int axeX = 0  ;  axeX < this.nbLignes  ;  axeX++ ) {
                System.out.print("[" + this.laGrille[axeX][axeY].toString() + "]" ) ;
            }
            System.out.println();
        }
    }

    /**
    * Permet d'initialiser l'ArrayList contenant les pions du joueur 1.
    */
    public void setArrayJ1(ArrayList<Pion> larray) {this.alPJ1 = larray ; }
    /**
    * Permet d'initialiser l'ArrayList contenant les pions du joueur 2.
    */
    public void setArrayJ2(ArrayList<Pion> larray) {this.alPJ2 = larray ; }


}
