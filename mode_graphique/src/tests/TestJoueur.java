package test ;
import arcanor.* ;
import org.junit.* ;
import junit.framework.*;
import static org.junit.Assert.* ;
import java.util.ArrayList;

/**
* Classe de tests de la classe Joueur.
* @see Joueur
* @author Bardaine Cédric, Servant Andy-Loup
*/
public class TestJoueur extends TestCase {

        private Joueur j;
        private String pseudo;

        @BeforeClass
        protected void setUp() throws Exception {
                this.pseudo = "pseudo";
                Compte compte = new Compte(pseudo, "c");
                this.j = new Joueur(compte);
        }

        public void testJoueur() {
                assertNotNull(this.j);
        }
        // @Test()
        // public void testGetPseudo() {
        //         //résultat attendu
        //         String s = this.pseudo;
        //         //résultat obtenu
        //         String test = this.j.getPseudo();
        //         assertEquals(s, test);
        // }

        public void testJouer() {

                //création du Controleur
                Compte c1 = new Compte("c1","c1");
                Joueur j1 = new Joueur(c1);
                Compte c2 = new Compte("c2","c2");
                Joueur j2 = new Joueur(c2);
                Grille grille = new Grille();
                ArrayList<Pion> listeJ1 = new ArrayList<Pion>();
                ArrayList<Pion> listeJ2 = new ArrayList<Pion>();
                Controleur controle = new Controleur(listeJ1, listeJ2, grille, j1, j2);

                j1.jouer(controle);
        }
}
