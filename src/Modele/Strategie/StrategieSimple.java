package Modele.Strategie;
import Modele.Partie.*;



/**
 *La strategie simple
 * @see  StrategieSimple
 */

public class StrategieSimple extends Strategie {

	/**
	 *Creation d'une strategieMoyenne
	 * @see  StrategieSimple
	 */	
	public StrategieSimple() {
		super();
	}
	/**
	 *Trouver la carte a jouer:
	 *Il joue n'importe quelle carte jouable
	 * @see  StrategieSimple#ordiChoisirUneCarte(Partie)
	 * @param partie la partie en cours
	 * @return la position de la carte a jouer
	 */
	public int ordiChoisirUneCarte(Partie partie) {

		int numeroCarte=0;
		
		while (numeroCarte < partie.joueurEnCours.getNombreCarte() && partie.choixValide(numeroCarte) == false) {
			numeroCarte++;
		}
		
		return numeroCarte;
	}

}
