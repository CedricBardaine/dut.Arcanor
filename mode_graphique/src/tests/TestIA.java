package test;
import org.junit.*;
import junit.framework.*;
import static org.junit.Assert.*;
import arcanor.*;


/**
* Classe de tests de la classe IA.
* @see IA
* @author Bardaine Cédric, Servant Andy-Loup
*/
public class TestIA extends TestCase{

        private IA ia;

        @BeforeClass
        protected void setUp() throws Exception {
                Compte c = new Compte("c","c");
                this.ia = new IA(c);
        }

        // // @Test()
        // public void testGetAndSetLvl() {
        //
        //         this.ia.setLvl(1) ;
        //
        //         assertEquals(this.ia.getLvl(), 1) ;
        // }

        public void testDeplaAleaX() {
                int test = this.ia.deplaAleaX();
                boolean t = false;
                // System.out.println(test);
                if( (test >= -1) && (test <= 1)) {t = true;}
                assertTrue(t);

        }

        public void testPionAlea() {
                int test = this.ia.pionAlea();
                // System.out.println(test);
                boolean t = false;
                if ( (test >= 0) && (test < 13 )) {t = true;}
                assertTrue(t);
        }

        public void testDeplaAleaY() {
                int test = this.ia.deplaAleaY();
                // System.out.println(test);
                boolean t = false;
                if( (test >= -1) && (test <= 1)) {t = true;}
                assertTrue(t);
        }
}
