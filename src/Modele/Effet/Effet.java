package Modele.Effet;

import Modele.Carte.Talon;
import Modele.Partie.Partie;
/**
 * l'effet de la carte
 * @see Effet
 */
public abstract class Effet { 
	


	
	protected String effet;
	
	public Effet() {
		}
		
	/**
	 * Get l'effet de la carte
	 * @see Effet#getEffet()
	 * @return l'effet de carte, si elle n'a pas, on obtient "null"
	 */
	public String getEffet() {
		return this.effet;
	}
	
	/**
	 * Faire l'effet si il y en a
	 * @see Effet#faireEffet(Partie)
	 * @param partie la partie en cours
	 */
	
    public abstract void faireEffet(Partie partie);
			

}