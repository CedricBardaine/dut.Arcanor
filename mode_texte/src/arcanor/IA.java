package arcanor;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;
import java.io.Serializable;

/**
 * Cette classe modélise un objet d'intelligence artificielle simulant le comportement d'un joueur. Elle hérite de la classe <b>Joueur</b>.
 * @version 0.1
 * @since 0.1
 * @author Bardaine Cédric, Servant Andy-Loup
 */
public class IA extends Joueur implements Serializable {

	//Le niveau de jeu de l'IA
	private int lvl;

	// /**
	//  * Créé une IA avec comme paramètre un <b>compte</b> prédéfinie et spécifique à l'IA.
	//  * @param leCompte le compte de l'IA.
	//  */
	// public IA(Compte leCompte) {
	// 	super(leCompte);
	// }

	//===============================================================================================================================================//

	/**
	 * Créé une IA avec comme paramètre un nom.
	 * @param nom le nom de l'IA.
	 */
	public IA(String nom) {
		super(nom);
	}

	//===============================================================================================================================================//

	/**
	 * Retourne le niveau de l'IA
	 * @return le niveau de l'IA
	 */
	public int getLvl(){return this.lvl;}

	//===============================================================================================================================================//

	/**
	 * Modifie le niveau de l'IA
	 * @param lvl le niveau de l'IA
	 */
	public void setLvl(int lvl){}

	//===============================================================================================================================================//

	/**
	 * Redéfinie la fonction jouer de sa classe mère Joueur avec des valeurs determinées par les méthodes <b>deplaAleaY</b>, <b>deplaAleaY</b> et <b>pionAlea</b>.
	 * @see arcanor.Joueur#jouer
	 * @see arcanor.IA#deplaAleaY
	 * @see arcanor.IA#deplaAleaX
	 * @see arcanor.IA#pionAlea
	 * @param controleur le <b>controleur</b> de la partie.
	 */
	public void jouer(Controleur controleur){

		boolean valide = false;
		//vrai quand les coordonnees aleatoire correspondent à un pion valide
		boolean saisie = false;
		boolean disp = false;
		Pion pionIA = null;

		while(!disp) {
			pionIA = controleur.getListeJ2().get(this.pionAlea());
			if(pionIA.getDisp()) {
				disp = true;
			}
		}

		valide = false;

		int nouvX = deplaAleaX();
		int nouvY = deplaAleaY();
		valide = controleur.deplacement(nouvX, nouvY, pionIA);

		while(!valide) {
			nouvX = deplaAleaX();
			nouvY = deplaAleaY();
			valide = controleur.deplacement(nouvX, nouvY, pionIA);
		}

	}

	//===============================================================================================================================================//

	/**
	 * Retourne un chiffre aleatoire correspondant a un identifiant de pion parmi les pions disponibles
	 * @return chiffre identifiant d'un pion
	 */
	public int pionAlea(){
		Random alea = new Random();
		int ret = alea.nextInt(12);
		return ret;
	}

	//===============================================================================================================================================//

	/**
	 * Retourne un entier parmi [0,8] correspondant à la nouvelle coordonnée x du pion.
	 * @return la coordonnée x
	 */
	public int deplaAleaX(){
		Random alea = new Random();
		int ret = ThreadLocalRandom.current().nextInt(0, 9);
		return ret;
	}

	//===============================================================================================================================================//

	/**
	 * Retourne un entier parmi [0,7] correspondant à la nouvelle coordonnée y du pion.
	 * @return la coordonnée y
	 */
	public int deplaAleaY(){
		Random alea = new Random();
		int ret = ThreadLocalRandom.current().nextInt(0, 8);
		return ret;
	}

}
