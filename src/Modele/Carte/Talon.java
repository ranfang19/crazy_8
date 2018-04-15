package Modele.Carte;

import java.util.*;
/**
 * Le talon nous permet de poser les cartes jouees
 * @see Talon
 * 
 */
public class Talon {



	private ArrayList<Carte> talon;
	
	/**
	 * Creation du talon
	 * @see Talon#Talon()
	 */
	public Talon() {
		this.talon = new ArrayList<Carte>();
	}
	
	/**
	 * Get le nombre de cartes
	 * @see Talon #getNombreCartes()
	 * @return le nombre de cartes
	 * 
	 */

	public int getNombreCartes() {
		return this.talon.size();
	}
	/**
	 * Get la premiere dans le talon
	 * @see Talon#getCarte()
	 * @return la premiere carte dans le talon
	 * 
	 */

	public Carte getCarte() {
		return this.talon.get(0);
	}
	
	/**
	 * Afficher la carte jouee
	 * @see Talon#afficherLaPremiereCarte()
	 * 
	 */

	public void afficherLaPremiereCarte() {
		System.out.println(this.talon.get(this.talon.size() - 1).toString() + "\n");
	}

	/**
	 * Get la carte jouee
	 * @see Talon#getCarteJouee()
	 * @return la carte jouee
	 * 
	 */

	public Carte getCarteJouee() {
		return this.talon.get(this.talon.size() - 1);
	}
	
	/**
	 * Afficher la carte jouee
	 * @see Talon#afficherCarteJouee()
	 * 
	 */

	public void afficherCarteJouee() {
		System.out.println(this.talon.get(this.talon.size() - 1).toString() + "\n");
	}
	
	/**
	 * Vider le talon
	 * @see Talon#vider()
	 * 
	 */

	public void vider() {
		this.talon.clear();
	}
	
	/**
	 * Ajouter une carte dans le talon
	 * @see Talon#ajouterCarte(Carte)
	 * @param carte la carte a ajouter
	 * 
	 */

	public void ajouterCarte(Carte carte) {
		this.talon.add(carte);
	}
	
	/**
	 * Enlever une carte choisie
	 * @see Talon#enleverCarte(int)
	 * @param position la position de la carte enlevee
	 * 
	 */

	public void enleverCarte(int position) {
		this.talon.remove(position);
	}
	
	/**
	 * Afficher tous les cartes du talon
	 * @see Talon#afficherCartes()
	 * 
	 */

	public void afficherCartes() {
		for (int i = 0; i < this.getNombreCartes(); i++) {
			System.out.println(this.talon.get(i).toString());
		}
		System.out.println("\n");
	}

}