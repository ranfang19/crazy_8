package Modele.Effet;

import Modele.Partie.Partie;
/**
 * Rejouer c'est l'effet pour laisser le joueur rejouer une carte
 * @see Rejouer
 */
public class Rejouer extends Effet {

/**
 * Set l'effet de "rejouer"
 * @see Rejouer#Rejouer()
 */

	public Rejouer() {
		super();
		effet="Rejouer";
	}
	/**
	 * Utiliser l'effet de rejouer
	 * @see Rejouer#faireEffet(Partie)
	 * @param partie la partie en cours
	 */
	public void faireEffet(Partie partie) {
		
		System.out.println(partie.joueurEnCours.getNom() + " rejoue !\n");
		
		for(int i=0; i<(partie.getNombreJoueurs()-1);i++) {
			partie.tourSuivant();
		}
		
	}

}
