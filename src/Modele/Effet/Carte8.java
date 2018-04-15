package Modele.Effet;
import Modele.Joueur.*;
import java.util.Scanner;

import Modele.Carte.*;
import Modele.Partie.Partie;
/**
 * Carte 8 c'est l'effet pour changer la couleur
 * @see Carte8
 * 
 */
public class Carte8 extends Effet {


	Scanner sc = new Scanner(System.in);

	/**
	 * Set l'effet de la carte8
	 * @see Carte8#Carte8()
	 */
	public Carte8() {
		super();
		effet="Change la couleur";
	}
	
	/**
	 *Faire l'effet de la carte8
	 * @see Carte8#faireEffet(Partie)
	 * @param partie la partie en cours
	 */
	public void faireEffet(Partie partie) {
		
		int couleur8;
		
		
		if(partie.getTypeDeVue()== "Vue" && partie.joueurEnCours instanceof JoueurReel) {
			JoueurReel joueurReel = (JoueurReel) partie.joueurEnCours;
			joueurReel.choisirCarte8Vue();
		}else {
			couleur8=partie.joueurEnCours.choisirCarte8();
			String couleurDemandee = "La couleur demandée est " + Carte.COULEURS[couleur8] + "\n";
			System.out.println(couleurDemandee);
			partie.setCouleur8(couleur8);
		}
		
		
		
		
	}

}
