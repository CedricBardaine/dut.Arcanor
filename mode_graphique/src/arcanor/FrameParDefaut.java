package arcanor;

import javax.swing.JFrame;

/**
* Créer une fenêtre JFrame avec des paramêtres basiques.
* @author Bardaine Cédric, Servant Andy-Loup
* @version 0.1
*/
public class FrameParDefaut extends JFrame {

    public FrameParDefaut() {
        this.setSize(2500 , 3000);
        this.setLocation(50 , 50);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true) ;
        this.setVisible(true) ;

    }
}
