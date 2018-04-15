package Modele.Strategie;
import Modele.Partie.*;
/**
 * Strategie(le type d'ordinateur)
 * @see Strategie
 */
public abstract class Strategie {

	/**
	 * Trouver la carte a jouer
	 * @see Strategie#ordiChoisirUneCarte(Partie)
	 * @return la position de la carte
	 */
	
	public abstract int ordiChoisirUneCarte(Partie partie);
	
	
}
