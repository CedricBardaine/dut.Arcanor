package arcanor;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.Serializable;

/** Cette classe permet d'initialiser un joueur. Elle permet aussi au joueur de jouer.
* @author Bardaine Cédric, Servant Andy-Loup
* @version 0.1
*/
public class Joueur implements Serializable {

        // private Compte leCompte;
        private String pseudo;
        //
        // /**
        // * Initialise le joueur grâce à un <b>compte</b>.
        // * @see Compte
        // * @param  leCompte le compte du joueur, il contient toutes ses informations.
        // */
        // public Joueur(Compte leCompte){
        //
        //         if(leCompte != null) {
        //                 this.leCompte = leCompte;
        //                 this.pseudo = this.leCompte.getPseudo();
        //         }
        //         else {System.out.println("");}
        // }


        /**
         * Initialise un joueur en prenant un nom en paramètre.
         * @param nom le nom du joueur.
         */
        public Joueur(String nom) {
                if(nom != null) {
                        this.pseudo = nom;
                }
                else {
                        this.pseudo = "joueur";
                }
        }

        //===============================================================================================================================================//

        /**
        * Cette méthode permet au joueur de choisir parmis 3 actions :
        * <ol>
        * <li> <b>déplacer</b> un pion </li>
        * <li> <b>libérer</b> un pion </li>
        * <li> <b>voir</b> un pion </li>
        * </ol>
        * Le joueur choisit d'abord le pion avec lequel il veut jouer en entrant ses coordonnées.
        * Il choisit ensuite l'action qu'il veut réaliser en tapant 1, 2 ou 3.
        * @see arcanor.Controleur#deplacement
        * @see arcanor.Controleur#libererPion
        * @see arcanor.Controleur#voirPion
        * @param controleur le <b>controleur</b> de la partie.
        */
        public void jouer(Controleur controleur) {

		Pion pion = null;

		Scanner sc = new Scanner(System.in);

                //false uniquement si on souhaite continuer la partie après avoir sauvegardé.
                boolean arreter = false;

                while(!arreter) {
                        System.out.println("Saisissez les coordonnees du pion avec lequel vous voulez jouer : ");
                        System.out.println("x = ");
                        int pionX = sc.nextInt();
                        System.out.println("y = ");
                        int pionY = sc.nextInt();

                        boolean valide = false;


                        while(!valide) {
                                if(controleur.getJoueurActuel() == controleur.getJ1()) {
                                        int i = 0;
                                        while(i < controleur.getListeJ1().size() && !valide) {
                                                //vérifie que le pion sélectionné appartient bien au joueur actuel (cas où joueurActuel = joueur1)
                                                if( pionX == controleur.getListeJ1().get(i).getPosX() && pionY == controleur.getListeJ1().get(i).getPosY() ) {
                                                        //vérifie si le pion est disponible
                                                        if(controleur.getListeJ1().get(i).getDisp()) {
                                                                valide = true;
                                                                pion = controleur.getListeJ1().get(i);
                                                        }
                                                }
                                                i++;
                                        }
                                }
                                else {
                                        int j = 0;
                                        while(j < controleur.getListeJ2().size() && !valide) {
                                                //vérifie que le pion sélectionné appartient au joueur actuel (cas où joueurActuel = joueur2)
                                                if( pionX == controleur.getListeJ2().get(j).getPosX() && pionY == controleur.getListeJ2().get(j).getPosY() ) {
                                                        //vérifie si le pion est disponible
                                                        if(controleur.getListeJ2().get(j).getDisp() ) {
                                                                valide = true;
                                                                pion = controleur.getListeJ2().get(j);
                                                        }
                                                }
                                                j++;
                                        }
                                }
                                if(!valide) {
                                        System.out.println("Vous ne pouvez choisir ce pion !" + '\n' + "Raisons possibles : ");
                                        System.out.println("- les coordonnes sont incorrectes" + '\n' + "- le pion est indisponible" + '\n' + "- ce pion ne vous appartient pas");
                                        System.out.println("Saisissez a nouveau les coordonnes du pion :");
                                        System.out.println("x = ");
                                        pionX = sc.nextInt();
                                        System.out.println("y = ");
                                        pionY = sc.nextInt();
                                }
                        }

                        System.out.println("Quelle action souhaitez-vous faire ?");
                        System.out.println("-1 : deplacer un pion");
                        System.out.println("-2 : liberer un pion");
                        System.out.println("-3 : voir un pion");
                        System.out.println("-4 : sauvegarder la partie et quitter");

                        boolean saisieValide = false;
                        int saisie = 0;

                        while(!saisieValide){
                                // Scanner sc = new Scanner(System.in);
                                saisie = sc.nextInt();
                                if((0 < saisie) && (saisie < 5)){
                                        saisieValide = true;
                                }
                                else{ System.out.println("!!! Saisie invalide !!!"); }
                        }

                        if(saisie == 1) {
                                valide = false;

                                System.out.println("Ou voulez-vous deplacer votre pion ? Saisissez les nouvelles coordonnees : ");
                                System.out.println("x = ");
                                int nouvX = sc.nextInt();
                                System.out.println("y = ");
                                int nouvY = sc.nextInt();
                                valide = controleur.deplacement(nouvX, nouvY, pion);
                                arreter = true;

                                while(!valide) {
                                        System.out.println("Saisie non valide ! Saisissez a nouveau le deplacement du votre pion : ");
                                        System.out.println("x = ");
                                        nouvX = sc.nextInt();
                                        System.out.println("y = ");
                                        nouvY = sc.nextInt();
                                        valide = controleur.deplacement(nouvX, nouvY, pion);
                                        arreter = true;
                                }
                        }
                        else if (saisie == 2) {
                                valide = false;

                                System.out.println("Ou voulez-vous deplacer votre pion ? Saisissez les nouvelles coordonnees : ");
                                System.out.println("x = ");
                                int nouvX = sc.nextInt();
                                System.out.println("y = ");
                                int nouvY = sc.nextInt();
                                valide = controleur.libererPion(nouvX, nouvY, pion);
                                arreter = true;

                                while(!valide) {
                                        System.out.println("Saisie non valide ! Saisissez a nouveau le deplacement du votre pion : ");
                                        System.out.println("x = ");
                                        nouvX = sc.nextInt();
                                        System.out.println("y = ");
                                        nouvY = sc.nextInt();
                                        valide = controleur.libererPion(nouvX, nouvY, pion);
                                        arreter = true;
                                }
                        }
                        else if (saisie == 3) {
                                valide = false;
                                valide = controleur.voirPion(this, pion);
                                arreter = true;
                        }
                        else if (saisie == 4) {
                                System.out.println("Saisissez le nom de la sauvegarde : ");
                                Scanner sauvegarde = new Scanner(System.in);
                                String nomDeLaPartie = sauvegarde.nextLine();
                                controleur.sauvegarde(nomDeLaPartie);

                                // boolean saisieSauv = false;
                                // while(!saisieSauv) {
                                //         System.out.println("Souhaitez-vous continuer la partie ?");
                                //         System.out.println("1- oui");
                                //         System.out.println("2- non");
                                //         saisie = sc.nextInt();
                                //         if(saisie == 1) {
                                //                 // this.jouer(controleur);
                                //                 arreter = false;
                                //
                                //         }
                                        // else if(saisie == 2) {
                                                System.out.println("La partie a ete sauvegardee, vous pouvez quitter l'application et reprendre votre partie la prochaine fois que vous lance Arcanor.");
                                                System.out.println("Au revoir !");
                                                sc.nextInt();
                                        // }
                                }
                        }
                // }



	}



        //===============================================================================================================================================//

        /**
         * Retourne le pseudo du joueur.
         * @return le pseudo.
        */
        public String getPseudo() {return this.pseudo;}


        // public Joueur getJoueur() {return this.leCompte;}

}
