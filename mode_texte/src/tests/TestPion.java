package test;
import org.junit.*;
import junit.framework.*;
import static org.junit.Assert.*;
import arcanor.*;

/**
 * Classe de tests de la classe Pion.
 * @see Pion
 * @author Bardaine Cédric, Servant Andy-Loup
 */
public class TestPion extends TestCase {

        private Pion p;
        private int x,y,t;
        private boolean disp;
        private Joueur j;

        @BeforeClass
        protected void setUp() throws Exception {
                this.x = 2;
                this.y = 1;
                this.t = 3;
                this.disp = true;
                Compte compte = new Compte("c", "c");
                this.j = new Joueur(compte);
                this.p = new Pion(this.x, this.y, this.t, this.j);
        }

        // @Test()
        //constructeur
        public void testPion() {
                int xTest = 4;
                int yTest = 1;
                int tTest = 2;
                Pion pTest = new Pion(xTest, yTest, tTest, this.j);
                assertNotNull(pTest);
                assertEquals(pTest.getPosX(), xTest);
                assertEquals(pTest.getPosY(), yTest);
                assertEquals(pTest.getTaille(), tTest);
        }

        // @Test()
        public void testGetPosX() {
                //résultat attendu
                int res = this.x;
                //résultat obtenu
                int test = this.p.getPosX();
                //test égalité
                assertEquals(res,test);
        }

        // @Test()
        public void testSetPosX() {
                //nouvelle posX
                int newX = 3;
                p.setPosX(newX);
                //résultat attendu
                int res = p.getPosX();
                //test égalité
                assertEquals(newX,res);
        }

        // @Test()
        public void testGetPosY() {
                //résultat attendu
                int res = this.y;
                //résultat obtenu
                int test = p.getPosY();
                //test égalité
                assertEquals(res,test);
        }

        // @Test()
        public void testSetPosY() {
                //nouvell posY
                int newY = 4;
                p.setPosY(newY);
                //résultat attendu
                int res = p.getPosY();
                assertEquals(newY,res);
        }

        // @Test()
        public void testGetTaille() {
                //résultat attendu
                int res = this.t;
                //résultat obtenu
                int test = p.getTaille();
                assertEquals(res,test);
        }

        // @Test()
        public void testGetDisp() {
                //résultat attendu
                boolean res = this.disp;
                //résultat obtenu
                boolean test = p.getDisp();
                assertEquals(test, res);
        }

        // @Test()
        public void testSetDisp() {

                Pion pTest = new Pion(3,1,2, this.j);
                boolean testDisp =false;
                pTest.setDisp(testDisp);
                assertEquals(pTest.getDisp(), testDisp);

        }

        public void testGetJoueur() {
                assertEquals(p.getJoueur(), this.j);
        }

}
