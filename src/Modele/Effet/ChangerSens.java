package Modele.Effet;

import Modele.Partie.*;

/**
 * ChangerSens c'est l'effet pour changer le sens
 * @see ChangerSens
 * 
 */
public class ChangerSens extends Effet {


	
	/**
	 * Set l'effet de "changer sens"
	 * @see ChangerSens#ChangerSens()
	 */

	public ChangerSens() {
		super();
		effet="changer le sens";
	}
	
	/**
	 * Changer le sens
	 * @see ChangerSens#faireEffet(Partie)
	 * @param partie la partie en cours
	 */
	
	public void faireEffet(Partie partie) {
		
		partie.changerSens();
		System.out.println(partie.joueurEnCours.getNom() + " inverse le sens du jeu.\n");
		
	}

}
