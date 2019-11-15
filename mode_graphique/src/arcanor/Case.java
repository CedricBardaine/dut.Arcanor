package arcanor ;

import arcanor.* ;

/**
* Cette classe modélise des objets <b>Case</b> qui représentent une case de la Grille du jeu Arcanor,
* Un objet <b>Case</b> est represente par des coordonees x et y ainsi que la presence ou non d'un Pion.
* @author Bardaine Cédric, Servant Andy-Loup
* @version 0.1
*/
public class Case {
        private int x , y ;
        private Pion lePion ;


        /**
        * Construit un objet <b>Case</b>.
        * @param unX la coordonnée x de la case.
        * @param unY la coordonnée y de la case.
        */
        public Case(int unX , int unY) {
                this.x = unX ;
                this.y = unY ;
                this.lePion = null ;
        }


        /**
        * Permet de savoir si la case est libre ou non.
        * @return vrai si la case ne contient aucun Pion
        */
        public boolean libre() {
                if (getPion() == null ) return true ;
                else return false ;
        }

        /**
        * Reourne le nom du pion qui est sur la case.
        * @return un String représentant le pion par sa taille et son appartenance à un joueur.
        */
        public String toString() {
                if (this.lePion == null) return "    " ;
                else return this.lePion.getNom();
        }



        //les getters ______________________________________________________________________
        /**
        * Retourne le <b>Pion</b> qui est sur la case.
        * @return le Pion de la Case.
        */
        public Pion getPion() { return this.lePion ; }

        /**
        * Retourne la coordonnée x de la case.
        * @return la coordonnée x
        */
        public int getCoordonneeX() {return this.x ;}

        /**
        * Retourne la coordonnée y de la case.
        * @return la coordonnée y
        */
        public int getCoordonneeY() {return this.y ;}

        //les setters ______________________________________________________________________
        /**
        * Permet d'ajouter un <b>Pion</b> à la Case.
        * @param unPion à ajouter à la Case.
        */
        public void setPion(Pion unPion) { this.lePion = unPion ; }



}
