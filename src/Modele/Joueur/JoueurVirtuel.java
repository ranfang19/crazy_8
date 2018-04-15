package Modele.Joueur;
import Modele.Strategie.*;
import Modele.Partie.*;
/**
 * Joueur virtuel
 * @see JoueurVirtuel
 */
public class JoueurVirtuel extends Joueur {

	private Strategie strategie;
	
	/**
	 *Creation du joueur virtuel
	 * @see JoueurVirtuel#JoueurVirtuel(String, Strategie)
	 * @param nom son nom 
	 * @param strategie son type
	 */	
	
	public JoueurVirtuel(String nom, Strategie strategie) {
		super();
		this.nom = nom;
		this.strategie = strategie;
	}
	
	/**
	 *Choisir la couleur a changer apres de jouer la carte 8
	 * @see JoueurVirtuel#choisirCarte8()
	 * @return la couleur a changer
	 */	
	public int choisirCarte8() {	
		return 1;	
	}
	
	/**
	 *Choisir la carte a jouer(dans le console)
	 * @see JoueurVirtuel#choisirCarte(Partie)
	 * @param partie la partie en cours
	 * @return la position de la carte a jouer
	 */		
	
	public int choisirCarte(Partie partie) {
		
		return this.strategie.ordiChoisirUneCarte(partie);
		
	}
	/**
	 *Choisir la carte a jouer(dans le GUI)
	 * @see JoueurVirtuel#choisirCarte(Partie, int)
	 * @param partie la partie en cours
	 * @return la position de la carte a jouer
	 */	
	
	public int choisirCarte(Partie partie, int numeroCarte) {
		return choisirCarte(partie);
	}
	

}
