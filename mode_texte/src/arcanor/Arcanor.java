package arcanor ;

import arcanor.* ;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

/**
* La classe <b>Arcanor</b> sert de lanceur, elle permet de lancer ou charger une partie, soit joueur contre joueur soit contre l'IA.
*/
public class Arcanor implements Serializable{
        private  Controleur leControleur ;
        private  ArrayList<Pion> listeJ1;
        private  ArrayList<Pion> listeJ2;
        private  Joueur j1;
        private  Joueur j2;
        private  Grille grille;

        /**
        * Initialise un objet <b>Arcanor</b> qui servira à lancer toute l'application et à jouer.
        * @see arcanor.Arcanor#nouvellePartie
        * @see arcanor.Arcanor#chargerPartie
        */
        public Arcanor() {
                Scanner sc = new Scanner(System.in);

                System.out.println("_______________________________________________________________________________________________________________________________________________");
                System.out.println("_______________________________________________________________________________________________________________________________________________");
                System.out.println("_______________________________________________________________________________________________________________________________________________");
                System.out.println("______________________________________________________________---ARCANOR---____________________________________________________________________");
                System.out.println("_______________________________________________________________________________________________________________________________________________");
                System.out.println("___________________________________________CEDRIC BARDAINE____________________ANDY-LOUP SERVANT________________________________________________");
                System.out.println("_______________________________________________________________________________________________________________________________________________");
                System.out.println("_______________________________________________________________________________________________________________________________________________");
                System.out.println('\n');
                System.out.println("===============================================================================================================================================");
                System.out.println("==============================================================  BIENVENUE =====================================================================");

                System.out.println("Faites votre choix : ");
                System.out.println("1- Lancer une nouvelle partie");
                System.out.println("2- Charger une partie");
                System.out.println("3- Voir les regles du jeu");


                boolean saisieValide = false;
                while(!saisieValide) {
                        String choix = sc.nextLine();
                        if(choix.equals("1")) {
                                this.nouvellePartie();
                                saisieValide = true;
                        }
                        else if(choix.equals("2")) {
                                saisieValide = true;
                                boolean partie = chargerPartie();
                                if (!partie) {
                                        nouvellePartie();
                                }
                        }
                        else if (choix.equals("3")) {
                                affichageRegle();
                                System.out.println("######################################################################");
                                System.out.println("Faites votre choix : ");
                                System.out.println("1- Lancer une nouvelle partie");
                                System.out.println("2- Charger une partie");
                                System.out.println("3- Voir les regles du jeu");
                        }
                        else {
                                System.out.println("Saisie invalide !");
                                System.out.println("Saisissez a nouveau votre choix :");
                        }
                }

                this.leControleur.lancerLaPartie();

        }

        //===============================================================================================================================================//

        /**
        * Charge une partie à partir d'un fichier specifié par son nom, il doit correspondre au nom exacte du fichier,
        * et donc au nom de la partie au préalable enregistrée.
        * @param nomDeLaPartie le nom de la partie qui doit être chargée
        * @return un objet <b>Controleur</b> contenant toutes les informations sur une partie.
        */
        public boolean rechercheSauvegarde(String nomDeLaPartie)   {
                try {
                        String savepath = "../data/parties/" ;

                        ObjectInputStream oisSave = new ObjectInputStream(new BufferedInputStream(new FileInputStream("../data/parties/" + nomDeLaPartie))) ;

                        this.leControleur = (Controleur)oisSave.readObject();
                        oisSave.close();
                        return true;
                }
                catch (IOException ex) {
                        System.out.println("Fichier introuvable !");
                        System.out.println(ex.getMessage());
                        return false;
                }
                catch(ClassNotFoundException ex) {
                        System.out.println(ex.getMessage());
                        return false;
                }

                // return unCont ;
        }

        //===============================================================================================================================================//

        /**
        * Permet d'initialiser les ArrayList de pions et un controleur. Cette méthode fait appel à la configure() pour demander à l'utilisateur de configurer la partie.
        * @see arcanor.Arcanor#configure
        */
        private  void nouvellePartie() {
                this.listeJ1 = new ArrayList<Pion>();
                this.listeJ2 = new ArrayList<Pion>();
                this.grille = new Grille();

                configure();
                this.leControleur = new Controleur(this.listeJ1, this.listeJ2, this.grille, this.j1, this.j2);
        }

        //===============================================================================================================================================//

        /**
        * Permet de charger une partie en faisant appel à la methode rechercheSauvegarde. Elle demande à l'utilisateur de rentrer le nom de la partie qu'il veut charger.
        * @return true si la partie a été trouvée.
        * @see arcanor.Arcanor#rechercheSauvegarde
        */
        private  boolean chargerPartie() {

                boolean ret = false;

                System.out.println("Saisir le nom de la sauvegarde : ");
                Scanner sc = new Scanner(System.in);
                String nomDeLaPartie = sc.nextLine();

                boolean partie = rechercheSauvegarde(nomDeLaPartie);
                if(partie) {ret = true;}

                // sc.nextLine();
                while(!partie) {

                        System.out.println("Le nom de la partie est peut-etre incorrecte ou la sauvagarde n'existe pas.");
                        System.out.println("Que voulez-vous faire ?");
                        System.out.println("-1 : Saisir a nouveau le nom de la partie");
                        System.out.println("-2 : Creer une nouvelle partie");

                        boolean saisieValide = false;
                        while(!saisieValide) {

                                String choix = sc.nextLine();
                                // sc.nextLine();

                                if(choix.equals("1")) {
                                        saisieValide = true;
                                        System.out.println("Saisissez à nouveau le nom de la partie : ");
                                        nomDeLaPartie = sc.nextLine();
                                        partie = rechercheSauvegarde(nomDeLaPartie);
                                        if(partie) {ret = true;}
                                }

                                else if(choix.equals("2")) {
                                        saisieValide = true;
                                        partie = true;
                                }
                                else {
                                        System.out.println(" !!!! Saisie invalide !");
                                        System.out.println("Sasissez votre choix : ");
                                }
                        }
                }
                return ret;

        }

        //===============================================================================================================================================//

        /**
        * Permet à l'utilisateur de configurer le jeu selon trois modes :
        * <ol>
        * <li> Joueur contre joueur </li>
        * <li> Joueur contre IA </li>
        * <li> IA contre IA </li>
        * </ol>
        */
        private void configure() {

                System.out.println("Choix du mode de jeu : ");
                System.out.println("-1 : Joueur1 contre Joueur2");
                System.out.println("-2 : Joueur1 contre IA");
                System.out.println("-3 : IA contre IA");

                Scanner sc = new Scanner(System.in);

                boolean saisieValide = false;
                String saisie = "";
                while(!saisieValide) {
                        // Scanner sc = new Scanner(System.in);
                        saisie = sc.nextLine();
                        // if((0 < Integer.valueOf(saisie)) && (Integer.valueOf(saisie) < 4)) {
                        //         saisieValide = true;
                        // }
                        if(saisie.equals("1")) {
                                System.out.println("Saisir le nom du joueur1 : ");
                                String nom1 = sc.nextLine();
                                this.j1 = new Joueur(nom1);
                                System.out.println("Saisir le nom du joueur 2 :");
                                String nom2 = sc.nextLine();
                                this.j2 = new Joueur(nom2);
                                saisieValide = true;
                        }
                        else if(saisie.equals("2")) {
                                System.out.println("Saisir le nom du joueur : ");
                                String nom3 = sc.nextLine();
                                this.j1 = new Joueur(nom3);
                                this.j2 = new IA("IA");
                                saisieValide = true;
                        }
                        else if(saisie.equals("3")) {
                                this.j1 = new IA("Skynet");
                                this.j2 = new IA("Siri");
                                saisieValide = true;
                        }
                        else {
                                System.out.println("Saisie invalide ! Saisissez à nouveau votre mode de jeu :");
                        }
                }
                // sc.nextLine();


        }

        //===============================================================================================================================================//

        /**
        * Affiche les règles du jeu.
        */
        private void affichageRegle() {

                System.out.println("############################## REGLES DU JEU ###############################");
                System.out.println();
                System.out.println("But du jeu : ");
                System.out.println("- Etre le premier a realiser 12 points au minimum en amenant ses pieces sur la ligne de depart adverse.");
                System.out.println();
                System.out.println("Presentation du jeu : ");
                System.out.println("- Chaque joueur dispose de 12 pieces reparties en 4 tailles differentes (soit 3 pieces de chaque).");
                System.out.println("- A chaque taile de pieces correspond une valeur de points : ");
                System.out.println("   - taille 1 = 1 point");
                System.out.println("   - taille 2 = 2 points");
                System.out.println("   - taille 3 = 3 points");
                System.out.println("   - taille 4 = 4 points");
                System.out.println("- Les pièces sont representees de la maniere suivante : ");
                System.out.println("   - le joueur (joueur1 ou joueur2) + la taille de la piece");
                System.out.println("   - exemple avec une pièce de taille 3 appartenant au joueur 1 : ");
                System.out.println("      --> J1T3");
                System.out.println();
                System.out.println("- Les pieces peuvent s'emboiter les unes dans les auters comme des poupees russes. Cette caracteristique constistue la base meme du jeu puisqu'elle va permettre de : ");
                System.out.println("   - cacher certaines pieces dans d'autres au debut de la partie pour les proteger");
                System.out.println("   - manger des pieces adverses pour les eliminer");
                System.out.println("- Il s'agira donc de liberer judicieusement ses pieces pour a la fois atteindre son objectif de point et manger le plus de pieces adverses.");
                System.out.println();
                System.out.println("Preparation du jeu : ");
                System.out.println("- Chaque joueur a ses pieces placer sur la derniere ligne de son camp en formant des paires comme indique ci-dessous : ");
                System.out.println("   - les pieces 2 a l'interieur des pieces 1");
                System.out.println("   - les pieces 4 a l'interieur des pieces 3");
                System.out.println("- Au debut de la partie, aucune des pieces 2 et 4 ne sont donc visible");
                System.out.println();
                System.out.println("Deroulement de la partie : ");
                System.out.println("- Il y a 3 possibilites de mouvement : ");
                System.out.println("   - deplacer l'une de ses pieces d'une seule case dans n'import quelle direction");
                System.out.println("   - liberer l'une de ses pieces cachees (2 ou 4) en deplacant la pieces du dessus sur une case voisine");
                System.out.println("   - manger une piece adverse directement inferieur en taille en deplacant sa piece sur la piece adverse");
                System.out.println("      --> une piece 1 ne peut manger q'une piece 2");
                System.out.println("      --> une piece 2 ne peut manger q'une piece 3");
                System.out.println("      --> une piece 3 ne peut manger q'une piece 4");
                System.out.println();
                System.out.println("Attention : ");
                System.out.println("- Une piece pleine ne peut plus en manger d'autres. En revanche, une piece vide peut manger un adversaire contenant lui-meme une autre pieces");
                System.out.println("- Il est possible de liberer une piece adverse mangee pour en manger une autre a la place.");
                System.out.println();

        }

}
