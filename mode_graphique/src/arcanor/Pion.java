package arcanor;
import arcanor.*;
import java.io.Serializable;

/**
* Génère un pion
* @author Bardaine Cédric, Servant Andy-Loup
* @version 0.1
*/

public class Pion implements Serializable {

        private int posX;
        private int posY;
        private int taille;
        private boolean disp;
        private Joueur joueur;
        private String nom;

        /**
        * Permet de construire un objet de type pion. Le constructeur vérifie la validité des paramètres.
        * S'ils sont incorrects, affecte -1 à tous les attributs. Le pion est disponible lors de sa création, sa dispo sera modifiée en fonction de sa taille lors de l'initialisation du <b>Controleur</b>.
        * @param x la position sur l'axe X de départ du pion
        * @param y la position sur l'axe Y de départ du Pion
        * @param t la taille de départ du pion
        * @param joueur le joueur qui possède ce pion
        * @param nom le nom du pion
        * @see arcanor.Joueur
        */
        public Pion(int x, int y, int t, Joueur joueur, String nom){

                //vérification du joueur
                if (joueur != null) {

                        //vérification des coordonnées
                        if ( ((x >= 0) && (x <= 7))  && ((y >= 0) && (y <= 6)) ) {

                                //vérification de la taille
                                if ( (t >= 1) && (t <= 4) ) {
                                        this.posX = x;
                                        this.posY = y;
                                        this.taille = t;
                                        this.disp = true;
                                        this.joueur = joueur;
                                        this.nom = nom;

                                }
                                else {
                                        System.out.println("Erreur ! La taille du pion n'est pas correcte (rappel : 1 <= taille <= 4).");
                                        this.posX = -1;
                                        this.posY = -1;
                                        this.taille = -1;
                                        this.disp = false;
                                        this.joueur = null;
                                        this.nom = null;
                                }
                        }
                        else {
                                System.out.println("Erreur ! Les coordonnées du pion ne sont pas correctes (rappel : )");
                                this.posX = -1;
                                this.posY = -1;
                                this.taille = -1;
                                this.disp = false;
                                this.joueur = null;
                                this.nom = null;
                        }
                }
                else {
                        System.out.println("Erreur ! Le joueur n'est pas initialisé");
                        this.posX = -1;
                        this.posY = -1;
                        this.taille = -1;
                        this.disp = false;
                        this.joueur = null;
                        this.nom = null;
                }

        }

        //===============================================================================================================================================//
        //================================================accesseurs et modificateurs====================================================================//


        /**
        * Retourne la coordonnée x du pion
        * @return la valeur de x
        */
        public int getPosX(){ return this.posX; }

        //===============================================================================================================================================//

        /**
        * Défini une nouvelle position sur l'axe X pour le pion en question
        * @param posX la nouvelle position sur l'axe X
        */
        public void setPosX(int posX){

                if ( (posX >= 0) || (posX <= 7)) {
                        this.posX = posX;
                }
                else {
                        System.out.println("Erreur ! La nouvelle position doit etre comprise entre 0 et 7.");
                }
        }

        //===============================================================================================================================================//

        /**
        * Retourne la coordonnée y du pion.
        * @return la valeur de y
        */
        public int getPosY(){ return this.posY; }

        //===============================================================================================================================================//

        /**
        * Défini une nouvelle position sur l'axe Y pour le pion en question
        * @param posY la nouvelle position sur l'axe Y
        */
        public void setPosY(int posY){

                if ( (posY >= 0) || (posY <= 6)) {
                        this.posY = posY;
                }
                else {
                        System.out.println("Erreur ! La nouvelle position doit etre comprise entre 0 et 6.");
                }
        }

        //===============================================================================================================================================//

        /**
        * Retourne la taille du pion.
        * @return la taille du Pion
        */
        public int getTaille(){ return this.taille; }

        //===============================================================================================================================================//

        /**
        * Permet de vérifier si le pion est disponible (qu'il n'a pas été mangé)
        * @return vrai si le pion est disponible
        */
        public boolean getDisp(){ return this.disp; }

        //===============================================================================================================================================//

        /**
        * Permet de changer la disponibilité d'un pion (s'il est mangé ou libéré)
        * @param disp la nouvelle disponibilité du pion
        */
        public void setDisp(boolean disp){ this.disp = disp; }

        //===============================================================================================================================================//

        /**
        * Permet d'obtenir le joueur propriétaire du pion.
        * @return le joueur
        */
        public Joueur getJoueur() {return this.joueur; }

        //===============================================================================================================================================//

        /**
         * Retourn le nom du pion.
         * @return le nom du pion.
        */
        public String getNom() {return this.nom;}

}
