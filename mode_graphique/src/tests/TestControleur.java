package test;
import org.junit.*;
import junit.framework.*;
import static org.junit.Assert.*;
import arcanor.*;
import java.util.ArrayList;

/**
 * Classe de tests de la classe <b>Controleur</b>.
 * @see Controleur
 * @author Bardaine Cédric, Servant Andy-Loup
 */
public class TestControleur extends TestCase {

        private ArrayList<Pion> listeJ1;
        private ArrayList<Pion> listeJ2;
        private Grille grille;
        private Joueur j1;
        private Joueur j2;
        private Joueur joueurActuel;
        private Controleur controle;

        @BeforeClass
        protected void setUp() throws Exception {

                //création des joueurs
                Compte c1 = new Compte("c1","c1");
                this.j1 = new Joueur(c1);
                Compte c2 = new Compte("c2","c2");
                this.j2 = new Joueur(c2);

                //création de la grille
                this.grille = new Grille();

                //initialisation des arrayliste
                this.listeJ1 = new ArrayList<Pion>();
                this.listeJ2 = new ArrayList<Pion>();

                //création du Controleur
                this.controle = new Controleur(this.listeJ1, this.listeJ2, this.grille, this.j1, this.j2);
        }

        public void testControleur() {

                System.out.println('\n' + "==================== Test du constructeur ====================" + '\n');

                //vérifie que le Controleur a bien été créé
                assertNotNull(this.controle);

                //vérifié que les ArrayList ont bien été initialisée
                assertNotNull(this.listeJ1);
                assertNotNull(this.listeJ2);

                /*
                 * Pour tester si les pions ont été correctement créé et placé dans les ArrayList,
                 * on fait l'hypothèse que, si le premier et le dernier pion de chaque liste est correct, ils le sont tous.
                */

                //p1 à les mêmes paramètres que le pion normalement créé et placé dans la listeJ1 à l'indice 0
                //on test donc si c'est bien le cas.
                Pion p1 = new Pion(0, 0, 1, this.j1, "p1"); //création de p1
                //x, y, t et j sont les paramètres du pion à l'indice 0 de listeJ1.
                int x = this.listeJ1.get(0).getPosX();
                int y = this.listeJ1.get(0).getPosY();
                int t = this.listeJ1.get(0).getTaille();
                Joueur j = this.listeJ1.get(0).getJoueur();
                //tests du premier pion de listeJ1
                assertEquals(x, p1.getPosX());
                assertEquals(y, p1.getPosY());
                assertEquals(t, p1.getTaille());
                assertEquals(j, p1.getJoueur());

                Pion p2 = new Pion(7, 0, 4, this.j1, "p2");
                x = this.listeJ1.get(11).getPosX();
                y = this.listeJ1.get(11).getPosY();
                t = this.listeJ1.get(11).getTaille();
                j = this.listeJ1.get(11).getJoueur();
                //tests du dernier pion de listeJ1
                assertEquals(x, p2.getPosX());
                assertEquals(y, p2.getPosY());
                assertEquals(t, p2.getTaille());
                assertEquals(j, p2.getJoueur());


                //idem que les tests précédents mais cette fois avec les pions de listeJ2
                Pion p3 = new Pion(7, 6, 1, this.j2, "p3");
                x = this.listeJ2.get(0).getPosX();
                y = this.listeJ2.get(0).getPosY();
                t = this.listeJ2.get(0).getTaille();
                j = this.listeJ2.get(0).getJoueur();
                //tests du premer pion de listeJ2
                assertEquals(x, p3.getPosX());
                assertEquals(y, p3.getPosY());
                assertEquals(t, p3.getTaille());
                assertEquals(j, p3.getJoueur());

                Pion p4 = new Pion(0, 6, 4, this.j2, "p4");
                x = this.listeJ2.get(11).getPosX();
                y = this.listeJ2.get(11).getPosY();
                t = this.listeJ2.get(11).getTaille();
                j = this.listeJ2.get(11).getJoueur();
                //tests du dernier pion de listeJ2
                assertEquals(x, p4.getPosX());
                assertEquals(y, p4.getPosY());
                assertEquals(t, p4.getTaille());
                assertEquals(j, p4.getJoueur());
        }


        public void testRegleDeplacement() {

                System.out.println('\n' + "==================== Test de regleDeplacement ====================" + '\n');

                this.joueurActuel = this.j1;
                //test : personne n'est sur la case où on veut déplacer le pion
                //création d'un doublon.
                Pion pTest = new Pion(this.listeJ1.get(0).getPosX(), this.listeJ1.get(0).getPosY(), this.listeJ1.get(0).getTaille(), this.listeJ1.get(0).getJoueur(), this.listeJ1.get(0).getNom());
                pTest.setPosY(1); //on déplace le pion d'une case vers l'avant
                boolean test = this.controle.regleDeplacement(pTest);
                assertTrue(test);

                //test : il y a déjà un pion nous appartenant sur la case où on veut déplacer le pion
                Pion pTest2 = this.listeJ1.get(1);
                pTest2.setPosX(4);
                test = this.controle.regleDeplacement(pTest2);
                assertFalse(test);

                //test : il y a un pion adverse sur la case, les tailles correspondent, on peut manger le pion
                Pion pTest3 = this.listeJ2.get(11);
                pTest3.setPosY(4);
                pTest3.setDisp(true);
                Pion pTest4 = this.listeJ1.get(7);
                pTest4.setPosX(pTest3.getPosX());
                pTest4.setPosY(pTest3.getPosY());
                test = this.controle.regleDeplacement(pTest4);
                assertTrue(test);

                //test : il y a un pion adverse sur la case, les tailes ne correspondent pas.
                Pion pTest5 = this.listeJ2.get(3);
                Pion pTest6 = this.listeJ1.get(3);
                pTest6.setPosX(pTest5.getPosX());
                pTest6.setPosY(pTest5.getPosY());
                test = this.controle.regleDeplacement(pTest6);
                assertFalse(test);

                //test : déplacer un pion indisponible
                Pion pTest7 = this.listeJ2.get(10);
                pTest7.setPosY(1);
                test = this.controle.regleDeplacement(pTest7);
                assertFalse(test);

                //test : déplacer un pion avec des coordonnees incorrectes
                //ce test doit renvoyer 2 messages d'erreur dans la console
                System.out.println("  ##Un message d'errreur doit s'afficher :");
                Pion pTest8 = this.listeJ1.get(8);
                pTest8.setPosX(10);
                pTest8.setPosY(-3);
                test = this.controle.regleDeplacement(pTest8);
                assertFalse(test);
        }

        public void testDeplacement() {

                System.out.println('\n' + "==================== Test de deplacement ====================" + '\n');


                //creation d'un doublon du pion 1 du joueur 1
                Pion pTest = new Pion(this.listeJ1.get(0).getPosX(), this.listeJ1.get(0).getPosY(), this.listeJ1.get(0).getTaille(), this.listeJ1.get(0).getJoueur(), this.listeJ1.get(0).getNom());
                //test : déplacment d'une case vers l'avant
                boolean test = this.controle.deplacement(0,1, pTest);
                assertTrue(test);
                //vérifie que le déplacement à bien eu lieu
                assertEquals(pTest.getPosX(),0);
                assertEquals(pTest.getPosY(),1);
                //vérifie que le pion en-dessous à bien été déplacé.
                assertEquals(this.listeJ1.get(3).getPosX(), pTest.getPosX());
                assertEquals(this.listeJ1.get(3).getPosY(), pTest.getPosY());


                //test : deplacement d'une case sur le côté (le déplcement ne doit pas être possible car il y a déjà un autre pion)
                //un message d'erreur doit être renvoyer sur la console.
                System.out.println("  ##Un message d'errreur doit s'afficher :");
                Pion pTest2 = new Pion(this.listeJ1.get(0).getPosX(), this.listeJ1.get(0).getPosY(), this.listeJ1.get(0).getTaille(), this.listeJ1.get(0).getJoueur(), this.listeJ1.get(0).getNom());

                test = this.controle.deplacement(1,0,pTest2);
                assertFalse(test);
                //vérifie que le déplacement n'a pas eu lieu
                assertEquals(pTest2.getPosX(),0);
                assertEquals(pTest2.getPosY(),0);


                //test : déplacement d'une case en diagonale vers la droite.
                Pion pTest3 = new Pion(this.listeJ1.get(0).getPosX(), this.listeJ1.get(0).getPosY(), this.listeJ1.get(0).getTaille(), this.listeJ1.get(0).getJoueur(), this.listeJ1.get(0).getNom());
                test = this.controle.deplacement(1,1,pTest3);
                assertTrue(test);
                //vérifie qu e le déplacement a bien eu lieu
                assertEquals(pTest3.getPosX(),1);
                assertEquals(pTest3.getPosY(),1);


                //test : déplacement d'une case vers la gauche (en dehors du plateau)
                //un message d'erreur doit d'afficher dans la console car les coordonnees sont invalides
                System.out.println("  ##Un message d'errreur doit s'afficher :");
                Pion pTest4 = new Pion(this.listeJ1.get(0).getPosX(), this.listeJ1.get(0).getPosY(), this.listeJ1.get(0).getTaille(), this.listeJ1.get(0).getJoueur(), this.listeJ1.get(0).getNom());
                // assertEquals(pTest4, pTest3);
                pTest4.setPosX(0);
                pTest4.setPosY(0);
                // Boolean test2 = this.controle.deplacement(-1,-1,pTest4);
                // assertTrue(test2);
                // //vérifie que le deplacement n'a pas eu lieu
                // assertEquals(pTest4.getPosX(),0);
                // assertEquals(pTest4.getPosY(),0);

                //test : cas d'un déplacement d'un pion contenant un autre pion sur une case déjà occupée par un pion adverse.
                // Pion pTest5 = this.listeJ1.get(0);
                // pTest5.setPosX(0);
                // pTest5.setPosY(0);
                // System.out.println(pTest5.getPosX());
                // System.out.println(pTest5.getPosY());
                // //création d'un pion de taille 2
                // Pion pTest6 = new Pion(0,1,2,this.j2);
                // pTest6.setDisp(true);
                // //place le pTest6 sur la case devant pTest5
                // pTest6.setPosX(1);
                // pTest6.setPosY(1);
                // System.out.println(this.listeJ1.get(3).getDisp());
                // System.out.println(pTest5.getDisp());
                // test = this.controle.deplacement(1,1,pTest5);
                // //vérifie que le pion en dessous de pTest5 n'a pas été deplacé et est bien disponible
                // assertEquals(this.listeJ1.get(3).getPosX(), 0);
                // // System.out.println(pTest6.getPosY());
                // System.out.println(pTest5.getPosY());
                // System.out.println(this.listeJ1.get(3).getPosY());
                // System.out.println(this.listeJ1.get(3).getDisp());
                // // assertEquals(this.listeJ1.get(3).getPosY(), 0);
                // assertTrue(this.listeJ1.get(3).getDisp());

        }


        public void testVoirPion() {

                System.out.println('\n' + "==================== Test de voirPion ====================" + '\n');

                // ! indique le pion appartient à "null" !

                //test : le pion sélectionné ne nous appartient pas;
                System.out.println("  ##Un message d'errreur doit s'afficher :");
                this.joueurActuel = this.j1;
                boolean test = this.controle.voirPion(this.joueurActuel, this.listeJ2.get(0));
                assertFalse(test);

                //test : le pion sélectionné nous appartient (avec j1)
                test = this.controle.voirPion(this.joueurActuel, this.listeJ1.get(0));
                assertTrue(test);

                //test : le pion sélectionné nous appartient (avec j2)
                test = this.controle.voirPion(this.j2, this.listeJ2.get(2));
                assertTrue(test);
        }


        // public void testAfficheGrille() {
        //
        //         System.out.println('\n' + "==================== Test de afficheGrille ====================" + '\n');
        //
        //         this.controle.afficheGrille();
        // }

        // // public void testChangerJoueur() {
        //         System.out.println("==================== Test de changerJouer ====================");
        // //         this.joueurActuel = this.j1;
        // //         this.controle.changerJouer();
        // //         assertEquals(this.j1.getPseudo(), "c1");
        // //         // assertEquals(this.joueurActuel, this.j2);
        // // }


        public void testLancerLaPartie() {

                this.controle.lancerLaPartie();
        }

        public void testFinPartie() {

                System.out.println('\n' + "==================== Test de finPartie ====================" + '\n');

                //test : le j2 gagne
                //il faut tout d'abord mettre ses pions sur la ligne de départ de J1
                for(int i = 0 ; i < this.listeJ2.size() ; i++) {
                        this.listeJ2.get(i).setPosY(0);
                }
                boolean test = this.controle.finPartie(this.j2);
                assertTrue(test);

                //test si j1 a gagné (ses pions sont toujours en position de départ il ne peut donc pas gagner);
                test = this.controle.finPartie(this.j1);
                assertFalse(test);

        }

        // public void testJouer() {
        //
        //         System.out.println('\n' + "==================== Test de jouer ====================" + '\n');
        //
        //         this.joueurActuel = this.j1;
        //         this.controle.jouer();
        // }

        public void testLibererPion() {

                System.out.println('\n' + "==================== Test de libererPion ====================" + '\n');
                //creation d'un doublon du pion 1 du joueur 1
                Pion pTest = new Pion(this.listeJ1.get(0).getPosX(), this.listeJ1.get(0).getPosY(), this.listeJ1.get(0).getTaille(), this.listeJ1.get(0).getJoueur(), this.listeJ1.get(0).getNom());
                //test : déplacment d'une case vers l'avant
                boolean test = this.controle.libererPion(0,1, pTest);
                assertTrue(test);
                //vérifie que le déplacement à bien eu lieu
                assertEquals(pTest.getPosX(),0);
                assertEquals(pTest.getPosY(),1);
                //vérifie que le pion en-dessous n'a pas été déplacé.
                assertEquals(this.listeJ1.get(3).getPosX(), 0);
                assertEquals(this.listeJ1.get(3).getPosY(), 0);
                //vérifie que le pion est maintenant disponible
                assertTrue(this.listeJ1.get(3).getDisp());
        }
}
