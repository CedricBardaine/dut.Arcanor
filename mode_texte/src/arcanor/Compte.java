package arcanor ;
import arcanor.* ;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream ;
import java.io.DataOutputStream ;
import java.io.IOException;

import java.io.BufferedReader ; //BufferedReader
import java.io.FileReader ;

import java.io.Serializable ;

/**
* Permet de garder un historique du nombre de victoire.
* @author Bardaine Cédric, Servant Andy-Loup
* @version 0.1
*/
public class Compte implements Serializable {

    private String pseudo;
    private String mdp;
    private int nbVictoire;

    /**
    * Constructeur de la classe <b>Compte</b>. Créé un nouveau compte en prenant en paramètre deux chaînes de caractères, un <b>mot de passe</b> et un <b>pseudo</b>.
    * Fait appel à <b>VerifCompteExistant</b> pour vérifie que le pseudo est correct.
    * @see arcanor.Compte#VerifCompteExistant
    * @param pseudo le pseudonyme
    * @param mdp le mot de passe
    */
    public Compte(String pseudo, String mdp) {
        FileOutputStream fosP ;
        DataOutputStream ossP ;
        //
        FileOutputStream fosC ;
        ObjectOutputStream oosC ;

        try {
                fosP = new FileOutputStream(new File("../data/pseudos")) ; //sert à ajouter le pseudo cree au fichier de pseudos existants
                ossP = new DataOutputStream(fosP) ;
                //
                fosC = new FileOutputStream(new File("../data/Comptes")) ; //sert à ajouter le Compte cree au fichier
                oosC = new ObjectOutputStream(fosC) ;

                if (pseudo != null  &&  mdp != null) {

                    if ( VerifCompteExistant(pseudo) ) {
                        this.pseudo = pseudo ;
                        this.mdp = mdp ;


                        this.writeObject(oosC) ; // sauvegarde l'objet

                        ossP.writeUTF(this.pseudo) ; // sauvegarde l'attribut pseudo
                        ossP.close() ;



                    }
                    else { System.out.println("le pseudo est deja utilise par une autre personne, c'est pas grave, un manque d'originalite ca arrive a tout le monde"); }

                }
                else { System.out.println("Le pseudo ou le mot de passe n'est pas valide, ils doivent contenir au moins un caractère");}
        }
        catch(FileNotFoundException e) { System.out.println(e.getMessage());}
        catch(IOException ex) { System.out.println(ex.getMessage());}
    }

    public void writeObject(ObjectOutputStream sortie) throws IOException {
        sortie.writeObject(this.pseudo) ;
        sortie.writeObject(this.mdp) ;
        sortie.writeObject(this.nbVictoire) ;
        sortie.close() ;
    }


    /**
    * Vérifie que le pseudonyme passé en paramètres est correct.
    * C'est à dire qu'ils n'existent pas déjà.
    * @param pseudoCherche le pseudonyme à vérifier
    * @return vrai s'il n'y a pas de compte avec ce pseudo
    */
    public boolean VerifCompteExistant(String pseudoCherche){
        // String line = null, recherche = null, path = null;
        // // le chemin du fichier et le mot recherche doivent etre definis
        boolean ret = true ;
        String line ;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("../data/pseudos"));
            int i = 1 ; //initialisation du numero de ligne

            while ((line = reader.readLine()) != null) {
                if ( line.indexOf(pseudoCherche) != -1) {
                    ret = false ;
                }
            }
            reader.close();
        }
        catch(FileNotFoundException e) { System.out.println("Ne fichier n'a pas ete trouve" );  }
        catch(IOException e) { System.out.println( e.getMessage() ); }

        return ret ;

    }

    /**
    * Retourne le nombre de partie gagner avec un compte.
    * @return le nombre de victoire.
    */
    public int getNbVictoire() { return this.nbVictoire; }

    /**
    * Retourne le pseudonyme du compte.
    * @return le pseudonyme.
    */
    public String getPseudo() { return this.pseudo; }

    /**
    * Renvoie le compte courant.
    * @return le compte courant.
    */
    public Compte getCompte() { return this; }

    /**
     * Renvoie le mot de passe du compte.
     * @return le mot de passe.
    */
    public String getMdp() {return this.mdp; }


}
