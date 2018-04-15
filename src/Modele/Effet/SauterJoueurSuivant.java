package Modele.Effet;

import Modele.Partie.Partie;

/**
 *  * l'effet pour faire le joueur suivant passer son tour
 * @see SauterJoueurSuivant
 */

public class SauterJoueurSuivant extends Effet {

	/**
	 * Set l'effet de "sauter le joueur suivant"
	 * @see SauterJoueurSuivant#SauterJoueurSuivant()
	 */
	public SauterJoueurSuivant() {
		super();
		effet="Saute le joueur suivant";
	}
	
	/**
	 * Utiliser l'effet pour sauter le joueur suivant
	 * @see SauterJoueurSuivant#faireEffet(Partie)
	 * @param partie la partie en cours
	 */
	public void faireEffet(Partie partie) {
		
		partie.tourSuivant();
		System.out.println(partie.joueurEnCours.getNom() + " est sauté ! \n");
		
		
		
	}

}
