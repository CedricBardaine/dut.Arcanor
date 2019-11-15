import org.junit.*;
import static org.junit.Assert.*;

/**
 * Classe de tests de la classe Grille.
 * @see Grille
 * @author Bardaine Cédric, Servant Andy-Loup
 */
public class TestGrille {

        private int[][] grille;
        private static final int LIGNEX = 8;
        private static final int LIGNEY = 7;

        @Before()
        protected void setUp() {
                this.grille = new Grille();
        }


        public TestGrille() {
                //test que l'objet testGrille n'est pas null.
                Grille testGrille = new Grille();
                assertNotNull(testGrille);
        }

        @Test()
        public void testGetLigneX() {
                int res = this.LIGNEX;
                int test = grille.getLigneX();
                assertEquals(test, res);
        }

         @Test()
         public void testGetLigneY() {
                 int res = this.LIGNEY;
                 int test = grille.getLigneY();
                 assertEquals(test, res);
         }

         @Test()
         public void testGetGrille() {
                 Grille testGrille = grille.getGrille();
                 assertNotNull(testGrille);
         }
}
