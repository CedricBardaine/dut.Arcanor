package arcanor;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

/**
* Modélise un object Controleur permettant de gérer une partie.
* @author Bardaine Cédric, Servant Andy-Loup
* @version 0.1
*/
public class Controleur implements Serializable {

	// Le tableau des pions du Joueur 1
	public ArrayList<Pion> listeJ1;
	// Le tableau des pions du Joueur 2
	public ArrayList<Pion> listeJ2;
	// La grille de jeu
	private Grille grille;
	// Le tableau contenant les 2 joueurs
	private Joueur j1;
	private Joueur j2;
	private Joueur joueurActuel;
	private LaGrilleFrame laFrame ;

	/**
	* Crée un objet de type <b>Controleur</b>. IL crée aussi tous les pions nécessaires au jeu.
	* @param liste1 la liste des pions du joueur 1.
	* @param liste2 la liste des pions du joueur 2.
	* @param grille la grille de jeu.
	* @param j1 le joueur 1.
	* @param j2 le joueur 2.
	*/
	public Controleur(ArrayList<Pion> liste1, ArrayList<Pion> liste2, Grille grille, Joueur j1, Joueur j2){

		if (grille != null) { this.grille = grille; }
		else {
			System.out.println("Erreur ! La grille n'est pas initialisée.");
			// this.grille = grille;
		}

		if (j1 != null && j2 != null) {
			this.j1 = j1;
			this.j2 = j2;
		}
		else {
			System.out.println("Erreur ! Les joueurs ne sont pas initialisés.");
			// this.j1 = null;
			// this.j2 = null;
		}

		//création des pions du joueur 1
		Pion j1p1t1 = new Pion(0, 0, 1, this.j1, "J1T1");
		j1p1t1.setDisp(true);
		Pion j1p2t1 = new Pion(3, 0, 1, this.j1, "J1T1");
		j1p2t1.setDisp(true);
		Pion j1p3t1 = new Pion(6, 0, 1, this.j1, "J1T1");
		j1p3t1.setDisp(true);
		Pion j1p4t2 = new Pion(0, 0, 2, this.j1, "J1T2");
		j1p4t2.setDisp(false);
		Pion j1p5t2 = new Pion(3, 0, 2, this.j1, "J1T2");
		j1p5t2.setDisp(false);
		Pion j1p6t2 = new Pion(6 , 0, 2, this.j1, "J1T2");
		j1p6t2.setDisp(false);
		Pion j1p7t3 = new Pion(1, 0, 3, this.j1, "J1T3");
		j1p7t3.setDisp(true);
		Pion j1p8t3 = new Pion(4, 0, 3, this.j1, "J1T3");
		j1p8t3.setDisp(true);
		Pion j1p9t3 = new Pion(7, 0, 3, this.j1, "J1T3");
		j1p9t3.setDisp(true);
		Pion j1p10t4 = new Pion(1, 0, 4, this.j1, "J1T4");
		j1p10t4.setDisp(false);
		Pion j1p11t4 = new Pion(4, 0, 4, this.j1, "J1T4");
		j1p11t4.setDisp(false);
		Pion j1p12t4 = new Pion(7, 0, 4, this.j1, "J1T4");
		j1p12t4.setDisp(false);

		//ajout des pions dans l'arrayliste listeJ1.
		this.listeJ1 = liste1;
		this.listeJ1.add(j1p1t1);
		this.listeJ1.add(j1p2t1);
		this.listeJ1.add(j1p3t1);
		this.listeJ1.add(j1p4t2);
		this.listeJ1.add(j1p5t2);
		this.listeJ1.add(j1p6t2);
		this.listeJ1.add(j1p7t3);
		this.listeJ1.add(j1p8t3);
		this.listeJ1.add(j1p9t3);
		this.listeJ1.add(j1p10t4);
		this.listeJ1.add(j1p11t4);
		this.listeJ1.add(j1p12t4);

		//création des pions du joueur 2
		Pion j2p1t1 = new Pion(7, 6, 1, this.j2, "J2T1");
		j2p1t1.setDisp(true);
		Pion j2p2t1 = new Pion(4, 6, 1, this.j2, "J2T1");
		j2p2t1.setDisp(true);
		Pion j2p3t1 = new Pion(1, 6, 1, this.j2, "J2T1");
		j2p3t1.setDisp(true);
		Pion j2p4t2 = new Pion(7, 6, 2, this.j2, "J2T2");
		j2p4t2.setDisp(false);
		Pion j2p5t2 = new Pion(4, 6, 2, this.j2, "J2T2");
		j2p5t2.setDisp(false);
		Pion j2p6t2 = new Pion(1, 6, 2, this.j2, "J2T2");
		j2p6t2.setDisp(false);
		Pion j2p7t3 = new Pion(6, 6, 3, this.j2, "J2T3");
		j2p7t3.setDisp(true);
		Pion j2p8t3 = new Pion(3, 6, 3, this.j2, "J2T3");
		j2p8t3.setDisp(true);
		Pion j2p9t3 = new Pion(0, 6, 3, this.j2, "J2T3");
		j2p9t3.setDisp(true);
		Pion j2p10t4 = new Pion(6, 6, 4, this.j2, "J2T4");
		j2p10t4.setDisp(false);
		Pion j2p11t4 = new Pion(3, 6, 4, this.j2, "J2T4");
		j2p11t4.setDisp(false);
		Pion j2p12t4 = new Pion(0, 6, 4, this.j2, "J2T4");
		j2p12t4 .setDisp(false);

		//ajout des pions dans l'arrayliste listeJ2.
		this.listeJ2 = liste2;
		this.listeJ2.add(j2p1t1);
		this.listeJ2.add(j2p2t1);
		this.listeJ2.add(j2p3t1);
		this.listeJ2.add(j2p4t2);
		this.listeJ2.add(j2p5t2);
		this.listeJ2.add(j2p6t2);
		this.listeJ2.add(j2p7t3);
		this.listeJ2.add(j2p8t3);
		this.listeJ2.add(j2p9t3);
		this.listeJ2.add(j2p10t4);
		this.listeJ2.add(j2p11t4);
		this.listeJ2.add(j2p12t4);

		this.grille.setArrayJ1(this.listeJ1) ;
		this.grille.setArrayJ2(this.listeJ2) ;
		this.laFrame = new LaGrilleFrame(this.grille ) ;

	}

	//===============================================================================================================================================//

	/**
	* S'assure que les regles du jeu sont respectées lors d'une action et modifie la disponibilité d'une pièce lorsque c'est nécessaire.
	* @param pion le pion sur lequel vérifier les règles du jeu.
	* @return vrai ssi les regles sont respectées
	*/
	public boolean regleDeplacement(Pion pion){

		//le retour de la methode, true si le deplacement est possible
		boolean ret = false;
		//true si les coordonnees sont valides
		boolean verifCoord = false;
		//true si un pion est déjà présent sur la case
		boolean presenceJ1 = false;
		boolean presenceJ2 = false;
		//true si aucun pion est sur la case
		boolean nonPresent = false;
		//true si le pion qui est déjà sur la case appartient aussi au joueur
		boolean joueur = false;
		//true si le deplacement sur la case occupée est possible --> le pion à la bonne taille pour manger le pion déjà présent sur la case
		boolean deplacement = false;
		//true si le pion que le joueur veut déplacer est disponible
		boolean dispo = false;
		//le pion déjà présent sur la case.
		Pion p = null;
		//la taille du pion à déplacer
		int taille = 0;
		//la taille du pion déjà présent sur la case
		int taille2 = 0;

		//vérification des coordonnées
		if ( (pion.getPosX() <= 7) && (pion.getPosX() >= 0) && (pion.getPosY() <= 6) && (pion.getPosY() >= 0) ) {
			verifCoord = true;
		}
		else {
			if(!pion.getJoueur().getPseudo().equals("IA")) {
				System.out.println("coordonnees incorrectes");
			}
		}


		//vérification de la disponibilité de la pièce à déplacer.
		if( pion.getDisp()) {
			dispo = true;
		}
		else {
			System.out.println("Pion indisponible");
		}



		if(verifCoord && dispo) {


			// vérifie la présence d'une pièce sur la case.
			int i = 0;
			while(i < this.listeJ1.size() && !presenceJ1) {
				if( pion.getPosX() == this.listeJ1.get(i).getPosX() && pion.getPosY() == this.listeJ1.get(i).getPosY()) {
					p = this.listeJ1.get(i);
					if(!p.equals(pion)) {
						presenceJ1 = true;
					}
				}
				i++;
			}
			int j = 0;
			while(j < this.listeJ2.size() && !presenceJ2) {
				if( pion.getPosX() == this.listeJ2.get(j).getPosX() && pion.getPosY() == this.listeJ2.get(j).getPosY()) {
					p = this.listeJ2.get(j);
					if(!p.equals(pion)) {
						presenceJ2 = true;
					}
				}
				j++;
			}

			//Vérifie à qui appartient le Pion
			if(presenceJ1 || presenceJ2) {
				//un joueur ne peut pas manger ses propres pièces
				if(p.getJoueur().equals(pion.getJoueur())) {
					joueur = true;
				}
				//donc si la pièce ne lui appartient pas, on vérifie la correspondance des tailles
				//pour savoir s'il peut manger le pion qui se triuve déjà sur la case.
				if(!joueur){
					taille = pion.getTaille();
					taille2 = p.getTaille();
					//vérification de la correspondance des tailles
					if (taille == 1 && taille2 == 2 ) { deplacement = true;}
					else if (taille == 2 && taille2 == 3) { deplacement = true; }
					else if (taille == 3 && taille2 == 4) { deplacement = true; }
					else {deplacement = false;}
					//si le deplacement est possible, modification de la disponibilité de la pièce qui va être mangée
					if(deplacement) {
						p.setDisp(false);
					}
				}
			}
			else {
				nonPresent = true;
			}

			//Si aucune pièce n'est présente sur la case ou si le deplacement est conforme au règlement, le déplacement est autorisé
			if(nonPresent || deplacement) {
				ret = true;
			}
		}

		return ret;
	}

	///===============================================================================================================================================//

	/**
	* Déplace le pion selon les paramètres x et y (qui sont les coordonnées de la case où le joueur veut déplacer son pion) et fait appel à la méthode <b>regleDeplacement</b> pour vérifier que le déplacement est conforme.
	* Vérifie aussi qu'il n'y a pas un autre pion en dessous du pion à déplacer. Si c'est le cas, déplace aussi ce pion à la case souhaitée.
	* @see arcanor.Controleur#regleDeplacement
	* @param x la coordonnée x de la case où déplacer le pion.
	* @param y la coordonnée y de la case où déplacer le pion.
	* @param pion le pion sélectionné
	* @return vrai ssi le déplacement est conforme aux règles.
	*/
	public boolean deplacement(int x, int y, Pion pion){

		boolean ret = false;


		//doublon du pion qui sert à vérifier que le déplacement est conforme aux règles.
		Pion doublon = new Pion(pion.getPosX(), pion.getPosY(), pion.getTaille(), pion.getJoueur(), "doublon");
		Pion doublon2 = null;
		//true si les règles sont respectées
		boolean regle = false;
		//true si le deplacement est correct, càd que le pion ne se déplace que d'une seule case.
		boolean valide = false;
		// if( (x<=1) && (x>=-1) && (y<=1) && (y>=-1)) {valide = true;}
		if ( (x == pion.getPosX() + 1) && (y == pion.getPosY()) ) {valide = true;}
		else if ( (x == pion.getPosX() - 1) && (y == pion.getPosY()) ) {valide = true;}
		else if ( (y == pion.getPosY() + 1) && (x == pion.getPosX()) ) {valide = true;}
		else if ( (y == pion.getPosY() - 1) && (x == pion.getPosX()) ) {valide = true;}
		else if ( (x == pion.getPosX() + 1) && (y == pion.getPosY() + 1) ) {valide = true;}
		else if ( (x == pion.getPosX() + 1) && (y == pion.getPosY() - 1) ) {valide = true;}
		else if ( (x == pion.getPosX() - 1) && (y == pion.getPosY() - 1) ) {valide = true;}
		else if ( (x == pion.getPosX() - 1) && (y == pion.getPosY() + 1) ) {valide = true;}
		else {
			if(!pion.getJoueur().getPseudo().equals("IA")) {
				System.out.println("Attention ! le pion  peut se deplacer que d'une seule case dans toutes les directions");}
			}


			//vérifie qu'il n'y a pas un pion en dessous du pion à deplacer.S'il y en a un, le deplace avec.
			boolean dessous = false;
			for (int i = 0 ; i < this.listeJ1.size() ; i++ ) {
				if ( (this.listeJ1.get(i).getPosX() == pion.getPosX()) && (this.listeJ1.get(i).getPosY() == pion.getPosY()) ) {
					if(this.listeJ1.get(i) != pion) {
						dessous = true;
						doublon2 = this.listeJ1.get(i);
					}
					else {dessous = false; }
				}
			}
			for (int j = 0 ; j < this.listeJ2.size() ; j++ ) {
				if ( (this.listeJ2.get(j).getPosX() == pion.getPosX()) && (this.listeJ2.get(j).getPosY() == pion.getPosY()) ) {
					if(this.listeJ2.get(j) != pion) {
						dessous = true;
						doublon2 = this.listeJ2.get(j);
					}
					else {dessous = false;}
				}
			}

			/*vérifie que la case du déplacement n'est pas déja occupée
			si c'est le cas, le pion qui est en-dessous du pion à déplacer ne pourra pas être déplacé, il sera donc libéré.
			On fait donc appel à la méthode libererPion*/
			// boolean occupee = false;
			// boolean liberer = false;
			// if(dessous) {
			// 	int k = 0;
			// 	while(k < this.listeJ1.size() && !occupee) {
			// 		if(this.listeJ1.get(k).getPosX() == (pion.getPosX() + x) && this.listeJ1.get(k).getPosY() == (pion.getPosY() + y)) {
			// 			occupee = true;
			// 			// liberer = libererPion(x, y, pion);
			// 		}
			// 		k++;
			// 	}
			// 	int l = 0;
			// 	while(l < this.listeJ2.size() && !occupee) {
			// 		if(this.listeJ2.get(l).getPosX() == (pion.getPosX() + x) && this.listeJ2.get(l).getPosY() == (pion.getPosY() + y)) {
			// 			occupee = true;
			// 			// liberer = libererPion(x,y,pion);
			// 		}
			// 		l++;
			// 	}
			// }
			//
			// if(!occupee) {
			if (valide) {
				doublon.setPosX(x);
				doublon.setPosY(y);
				regle = regleDeplacement(doublon);
				if (regle) {
					pion.setPosX(x);
					pion.setPosY(y);
					ret = true;
					if(dessous /*&& !occupee*/) {
						doublon2.setPosX(x);
						doublon2.setPosY(y);
					}
				}
				else {
					if(!pion.getJoueur().getPseudo().equals("IA")) {
						System.out.println("Attention ! Le deplacement n'est pas conforme aux regles du jeu");}
					}

				}
				// }
				// else {
				// 	System.out.println("Vous ne pouvez pas deplacer ce pion sur cette case.");
				// 	System.out.println("Raison : il y a deja un pion sur la case et vous ne pouvez pas le manger car il y a deja un pion sous votre pion.");
				// 	System.out.println("Le pion va donc etre libere.");
				// 	liberer = libererPion(x,y,pion);
				// }

				this.grille.setArrayJ1(this.listeJ1) ;
				this.grille.setArrayJ2(this.listeJ2) ;

				return ret;

			}

			///===============================================================================================================================================//

			/**
			* Cette méthode permet de libérer un pion. Quand un joueur fait appel à cette méthode au lieu de la méthode <b>deplacement</b> c'est pour ne pas déplacer le pion
			* qui est en-dessous du pion à déplacer.
			* Attention, cette méthode n'indique pas s'il y a un pion en dessous d'un autre.
			* S'il n'y a pas de pion à libérer cette méthode agit comme un simple déplacement.
			* Elle fait aussi appel à la méthode <b>regleDeplacement</b> pour vérifier que le déplacement est conforme aux règles du jeu.
			* @see arcanor.Controleur#regleDeplacement
			* @param x correspond au déplacement horizontal
			* @param y correspond au déplacement vertical
			* @param pion le pion sélectionné
			* @return vrai ssi l'action est possible, qu'elle est conforme aux règles.
			*/
			public boolean libererPion(int x, int y, Pion pion) {

				boolean ret = false;
				//doublon du pion qui sert à vérifier que le déplacement est conforme aux règles.
				Pion doublon = new Pion(pion.getPosX(), pion.getPosY(), pion.getTaille(), pion.getJoueur(), "doublon");
				Pion doublon2 = null;
				//true si les règles sont respectées
				boolean regle = false;
				//true si le deplacement est correct, càd que le pion ne se déplace que d'une seule case.
				boolean valide = false;

				//set la disponiblité du pion qui va être libéré à true.
				int i = 0;
				while(i < this.listeJ1.size()) {
					if( (this.listeJ1.get(i).getPosX() == doublon.getPosX()) && (this.listeJ1.get(i).getPosY() == doublon.getPosY()) ) {
						if(!this.listeJ1.get(i).getDisp()){
							this.listeJ1.get(i).setDisp(true);
							doublon2 = this.listeJ1.get(i);
						}
					}
					i++;
				}
				int j = 0;
				while(j < this.listeJ2.size()) {
					if( (this.listeJ2.get(j).getPosX() == doublon.getPosX()) && (this.listeJ2.get(j).getPosY() == doublon.getPosY()) ) {
						if(!this.listeJ2.get(j).getDisp()) {
							this.listeJ2.get(j).setDisp(true);
							doublon2 = this.listeJ2.get(j);
						}
					}
					j++;
				}




				// if( (x<=1) && (x>=-1) && (y<=1) && (y>=-1)) {valide = true;}
				if ( (x == pion.getPosX() + 1) && (y == pion.getPosY()) ) {valide = true;}
				else if ( (x == pion.getPosX() - 1) && (y == pion.getPosY()) ) {valide = true;}
				else if ( (y == pion.getPosY() + 1) && (x == pion.getPosX()) ) {valide = true;}
				else if ( (y == pion.getPosY() - 1) && (x == pion.getPosX()) ) {valide = true;}
				else if ( (x == pion.getPosX() + 1) && (y == pion.getPosY() + 1) ) {valide = true;}
				else if ( (x == pion.getPosX() + 1) && (y == pion.getPosY() - 1) ) {valide = true;}
				else if ( (x == pion.getPosX() - 1) && (y == pion.getPosY() - 1) ) {valide = true;}
				else if ( (x == pion.getPosX() - 1) && (y == pion.getPosY() + 1) ) {valide = true;}
				else {System.out.println("Attention ! le pion  peut se deplacer que d'une seule case dans toutes les directions");}
				if (valide) {
					doublon.setPosX(x);
					doublon.setPosY(y);
					regle = regleDeplacement(doublon);
					if (regle) {
						pion.setPosX(x);
						pion.setPosY(y);
						ret = true;
					}
					else {
						System.out.println("Attention ! Le deplacement n'est pas conforme aux regles du jeu");
					}
				}

				// boolean disp = false;
				// //vérifie si un pion du joueur 1 était en dessous du pion déplacé, si c'est le cas, le pion devient disponible.
				// int i = 0;
				// while (i < this.listeJ1.size() && !disp) {
				// 	if(doublon2.getPosX() == this.listeJ1.get(i).getPosX() && doublon2.getPosY() == this.listeJ1.get(i).getPosY()) {
				// 		disp = true;
				// 		this.listeJ1.get(i).setDisp(true);
				// 		System.out.println("boucle 1");
				// 	}
				// 	i++;
				// }
				// // cherche dans la liste des pions du joueur 2, uniquement s'il n'y avait pas un pion du joueur 1 sur la case.
				// // if(!disp) {
				// 	int j = 0;
				// 	while(j < this.listeJ2.size() && !disp) {
				// 		if(doublon2.getPosX() == this.listeJ2.get(j).getPosX() && doublon2.getPosY() == this.listeJ2.get(j).getPosY()) {
				// 			disp = true;
				// 			this.listeJ2.get(j).setDisp(true);
				// 			System.out.println("boucle 2");
				// 		}
				// 		j++;
				// 	}
				// }

				return ret;

			}

			///===============================================================================================================================================//

			/**
			* Permet de soulever un pion pour voir ce qu'il y a en-desous. La méthode affiche les pions qui sont sur la case du pion sélectionné.
			* @param pion le pion selectionné
			* @param joueur le joueur qui souhaite soulever son pion.
			* @return vrai ssi le pion sélectionné appartient bien au joueur. (On ne peut pas soulever un pion adverse)
			*/
			public boolean voirPion(Joueur joueur, Pion pion){

				//vrai si on peut soulever le pion
				boolean ret = false;
				boolean presentJ1 = false;
				boolean presentJ2 = false;
				Pion dessous = null;

				if (pion.getJoueur() != joueur) {
					System.out.println("Attention ! La piece selectionnee ne vous appartient pas.");
				}
				else {
					for (int i = 0 ; i < this.listeJ1.size() ; i++ ) {
						if ( (this.listeJ1.get(i).getPosX() == pion.getPosX()) && (this.listeJ1.get(i).getPosY() == pion.getPosY()) ) {
							if(!this.listeJ1.get(i).equals(pion)) {
								dessous = this.listeJ1.get(i);
								presentJ1 = true;
							}
						}
						// else { presentJ1 = false; }
					}
					if(!presentJ1) {
						for (int j = 0 ; j < this.listeJ2.size() ; j++ ) {
							if ( (this.listeJ2.get(j).getPosX() == pion.getPosX()) && (this.listeJ2.get(j).getPosY() == pion.getPosY()) ) {
								if(!this.listeJ2.get(j).equals(pion)){
									dessous = this.listeJ2.get(j);
									presentJ2 = true;
								}
							}
							// else { presentJ2 = false; }
						}

					}
					ret = true;
					System.out.println("Pion(s) sur la case de coordonnees (" + pion.getPosX() + "," + pion.getPosY() + ") : ");
					System.out.println("Pion de " + pion.getJoueur().getPseudo() + " de taille " + pion.getTaille() );
					if (presentJ1 || presentJ2) { System.out.println("Pion de " + dessous.getJoueur().getPseudo() + " de taille " + dessous.getTaille() );}

				}
				return ret;
			}

			///===============================================================================================================================================//

			/**
			* Méthode qui permet d'afficher la grille de jeu avec les pions actualisée à chaque tour.
			*/
			public void afficherGrille() {

				this.laFrame.repaint() ;

				// System.out.println("affichage du plateau");
				Pion pion = null;
				int k = 0;
				System.out.println("  (0)   (1)   (2)   (3)   (4)   (5)   (6)   (7)    ");
				for (int axeY = 0  ;  axeY < this.grille.getColumnCount()  ;  axeY++) {

					for (int axeX = 0  ;  axeX < this.grille.getRowCount()  ;  axeX++ ) {

						String[][] plateau = new String[this.grille.getRowCount()+1][this.grille.getColumnCount()+1];
						int i = 0;
						boolean present1 = false;
						boolean present2 = false;

						while(i < this.listeJ1.size() && !present1) {
							if(this.listeJ1.get(i).getPosX() == axeX && this.listeJ1.get(i).getPosY() == axeY) {
								// if(this.listeJ1.get(i).getDisp()) {
								present1 = true;
								pion = this.listeJ1.get(i);
								// }
							}
							i++;
						}
						int j = 0;
						while(j < this.listeJ2.size() && !present2) {
							if(this.listeJ2.get(j).getPosX() == axeX && this.listeJ2.get(j).getPosY() == axeY) {
								// if(this.listeJ2.get(j).getDisp()) {
								present2 = true;
								pion = this.listeJ2.get(j);
								// }
							}
							j++;
						}
						if(present1 || present2) {
							plateau[axeX][axeY] = "[" + pion.getNom() + "]";
							System.out.print(plateau[axeX][axeY]);
							// System.out.print("[" + pion.getNom() + "]" ) ;
						}
						else {
							plateau[axeX][axeY] = "[    ]";
							System.out.print(plateau[axeX][axeY]);
							// System.out.println("[    ]");
						}
						present1 = false;
						present2 = false;

					}
					System.out.println(" " + "(" + String.valueOf(k) + ")");
					System.out.println();

					k++;
				}
			}

			///===============================================================================================================================================//

			/**
			* Méthode permettant de changer de joueur à chaque fin de tour.
			*/
			public void changerJouer(){

				if (this.joueurActuel == j1) {this.joueurActuel = j2;}
				else {this.joueurActuel = j1;}
			}

			///===============================================================================================================================================//

			/**
			* Cette méthode permet de lancer une partie. La grille est affichée et actualisée à chaque tour de jeu.
			* Fait appel à la méthode <b>finPartie</b> pour savoir si un joueur à gagné.
			* @see arcanor.Controleur#finPartie
			*/
			public void lancerLaPartie(){

				boolean fin = false;
				this.joueurActuel = this.j1;
				System.out.println("********************************************************************************************************************************************");
				System.out.println("************************************************************ DEBUT DE LA PARTIE ************************************************************");
				System.out.println("********************************************************************************************************************************************");
				System.out.println("C'est a " + this.joueurActuel.getPseudo() + " de jouer !");
				int i = 1;
				while(!fin) {
					System.out.println("Tour " + String.valueOf(i));
					afficherGrille();
					this.joueurActuel.jouer(this);
					System.out.println("====================================================================================================================================");
					if(finPartie(this.joueurActuel)) {
						fin = true;
					}
					else {
						changerJouer();
						System.out.println("C'est a " + this.joueurActuel.getPseudo() + " de jouer !");
					}
					i++;
				}

				afficherGrille();
				this.laFrame.repaint() ;
				if(this.joueurActuel.equals(this.j1)) {System.out.println("_____________________________________________________!!! " +this.j1.getPseudo() +  " a gagne !!! _______________________________________________________");}
				else {
					System.out.println("____________________________________________________!!! " + this.j2.getPseudo() + " a gagne !!! _______________________________________________________");
				}

				System.out.println("************************************************************** FIN DE LA PARTIE ************************************************************");
				System.out.println("********************************************************************************************************************************************");
				System.out.println();



			}

			///===============================================================================================================================================//

			/**
			* Retourne la liste des pions du joueur 1.
			* @return la liste des pions
			*/
			public ArrayList<Pion> getListeJ1() { return this.listeJ1;}

			/**
			* Retourne la liste des pions du joueur 2.
			* @return la liste des pions.
			*/
			public ArrayList<Pion> getListeJ2() { return this.listeJ2;}

			/**
			* Retourne vrai si un joueur a gagné, c'est à dire si tous ces pions sont sur la ligne opposée de sa ligne de départ et qu'il réalise un minimum de 12 points.
			* @param joueur le joueur à qui on vérifie s'il a a gagné.
			* @return ret vrai si le joueur a gagné.
			*/
			public boolean finPartie(Joueur joueur) {

				int sommeJ1 = 0;
				int sommeJ2 = 0;
				boolean fin = false;

				if(joueur.equals(this.j1)) {
					for(int i = 0 ; i < this.listeJ1.size() ; i++) {
						if(this.listeJ1.get(i).getPosY() == 6) {
							sommeJ1 = sommeJ1 + this.listeJ1.get(i).getTaille();
						}
					}
				}
				else {
					for(int j = 0 ; j < this.listeJ2.size() ; j++) {
						if(this.listeJ2.get(j).getPosY() == 0) {
							sommeJ2 = sommeJ2 + this.listeJ2.get(j).getTaille();
						}
					}
				}

				if (sommeJ1 >= 12) { fin = true;}
				else if (sommeJ2 >= 12) { fin = true;}
				else {fin = false;}

				return fin;
			}

			//===============================================================================================================================================//

			/**
			* Retourne le joueur j1.
			* @return j1
			*/
			public Joueur getJ1() {return this.j1;}

			//===============================================================================================================================================//

			/**
			* Retourne le joueur j2.
			* @return j2
			*/
			public Joueur getJ2() {return this.j2;}

			/**
			* Retourne le joueurActuel.
			* @return joueurActuel.
			*/
			public Joueur getJoueurActuel() {return this.joueurActuel;}

			//===============================================================================================================================================//

			/**
			* enregistre dans un fichier la partie en cours :
			* sauvegarde les positions de pions  et  le joueur actuel
			* @param nomDeLaPartie correspond au nom de partie sous lequel la partie est enregistree
			*/
			public void sauvegarde(String nomDeLaPartie) {
				String savepath = "../data/parties/" ;

				System.out.println("- - -");
				System.out.println("Retenez le nom de la partie si vous souhaitez un jour pouvoir la continuer");
				System.out.println("Le nom de la partie est : "+ nomDeLaPartie) ;
				System.out.println("- - - ");

				// ObjectOutputStream oosSave = null ;

				try {
					ObjectOutputStream oosSave = new ObjectOutputStream( new FileOutputStream(savepath + nomDeLaPartie) ) ;
					oosSave.writeObject(this) ;
					oosSave.close() ;
				}
				catch(java.io.IOException e) {e.getMessage() ; }
				// catch(java.lang.ClassNotFoundException e) {e.getMessage() ; }
				// finally { 	try { oosSave.close() ; }
				// catch(IOException e) { e.getMessage() ; }
			}



		}
