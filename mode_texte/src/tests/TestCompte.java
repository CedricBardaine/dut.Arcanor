package test ;
import arcanor.* ;

import org.junit.*;
import static org.junit.Assert.*;
import junit.framework.*; //.TestCase ;

/**
 * Classe de test de la classe <b>Compte</b>.
 * @see Compte
 * @author Bardaine Cédric, Servant Andy-Loup
 *
*/
public class TestCompte extends TestCase {

    private String lePseudoDeTest;
    private String leMdpDeTest;
    // private int leNbVictoireDeTest;
    private Compte leCompteDeTest;


    @BeforeClass
    protected void setUp() throws Exception {
            this.lePseudoDeTest = "Test" ;
            this.leMdpDeTest = "TestMdp" ;

            // this.leNbVictoireDeTest = 10 ;
            this.leCompteDeTest = new Compte(this.lePseudoDeTest, this.leMdpDeTest) ;
    }

    //@Test()
    public void testCompte() {
            assertNotNull(leCompteDeTest) ;
    }


    //@Test()
    public void testGetPseudo() {
            //résultat attendu
            String res = this.lePseudoDeTest;
            //résultat obtenu
            String test = leCompteDeTest.getPseudo();
            assertTrue(test.equals(res));
    }

    public void testGetMdp() {

        String res = this.leMdpDeTest;

        String test = leCompteDeTest.getMdp();
        assertTrue(test.equals(res));
    }
}
