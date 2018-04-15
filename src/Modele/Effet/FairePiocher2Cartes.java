package Modele.Effet;

import Modele.Partie.Partie;
/**
 * FairePiocher2Cartes c'est l'effet pour faire le joueur suivant piocher 2 cartes
 * @see FairePiocher2Cartes
 */
public class FairePiocher2Cartes extends Effet {

/**
 * Set l'effet pour piocher 2 cartes
 * @see FairePiocher2Cartes#FairePiocher2Cartes()
 */

	public FairePiocher2Cartes() {
		super();
		effet="Faire passer son tour et piocher deux cartes au joueur suivant";
	}
	
/**
 * Utiliser l'effet de faire piocher 2 cartes
 * @see FairePiocher2Cartes#faireEffet(Partie)
 * @param partie la partie en cours	
 */
	
	public void faireEffet(Partie partie) {
		
		partie.tourSuivant();
		System.out.println(partie.joueurEnCours.getNom() + " pioche deux cartes et passe son tour. \n");
		partie.joueurEnCours.piocher(partie.paquet);
		partie.joueurEnCours.piocher(partie.paquet);
		
		
	}

}