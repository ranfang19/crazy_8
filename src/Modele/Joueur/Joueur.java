
package Modele.Joueur;


import java.util.ArrayList;
import java.util.List;
import Modele.Partie.*;

import Modele.Carte.*;

/**
 * Definir les actions et les attributs du joueur
 *@see Joueur
 */

public abstract class Joueur{

	protected String nom;
	protected List<Carte> main = new ArrayList<Carte>();

	/**
	 * Creation d'un joueur
	 * @see Joueur#Joueur()
	 */
	public Joueur() {
	}

	/**
	 * Get le nombre de cartes du joueur
	 * @see Joueur#getNombreCarte()
	 * @return le nombre de cartes
	 */
	public int getNombreCarte() {
		return this.main.size();
	}
	
	/**
	 * Get la cartie de la position choisie du joueur
	 * @see Joueur#getCarte(int)
	 * @param position la position de la carte
	 * @return la carte choisie du joeur
	 */

	public Carte getCarte(int position) {
		return this.main.get(position);
	}
	
	/**
	 * Get la liste de cartes du joueur
	 * @see Joueur#getMain()
	 * @return la liste de cartes du joueur
	 */

	public List<Carte> getMain() {
		return this.main;
	}
	
	/**
	 * Afficher le nombre de cartes du joueur
	 * @see Joueur#afficherNombreCarte()
	 */

	public void afficherNombreCarte() {
		System.out.println("Nombre de cartes restantes : " + this.main.size());
	}
	
	/**
	 * Enlever une carte de la position choise du joueur
	 * @see Joueur#enleverCarte(int)
	 * @param position la position de la carte enlevee
	 */

	public void enleverCarte(int position) {
		this.main.remove(position);
	}
	
	/**
	 * Enlever une carte du joueur
	 * @see Joueur#enleverCarte(Carte)
	 * @param carte la carte a enlever
	 */

	public void enleverCarte(Carte carte) {
		this.main.remove(carte);
	}
	
	/**
	 * Ajouter une carte dans la main du joueur
	 * @see Joueur#ajouterCarte(Carte)
	 * @param carte la carte a ajouter
	 */

	public void ajouterCarte(Carte carte) {
		this.main.add(carte);
	}
	
	/**
	 * Le joueur pioche une carte dans le paquet de carte
	 * @see Joueur#piocher(PaquetDeCarte)
	 * @param paquetDeCarte le paquet de carte
	 */

	public void piocher(PaquetDeCarte paquetDeCarte) {
		this.main.add(paquetDeCarte.getCartePaquet(0));
		paquetDeCarte.enleverCarte();
	}
	
	/**
	 * Afficher les cartes du joueur avec le numero
	 * @see Joueur#afficherCartes()
	 */

	public void afficherCartes() {
		for (int i = 0; i < this.getNombreCarte(); i++) {
			String numeroCarte = i + ". ";
			System.out.println(numeroCarte + this.main.get(i).toString());
		}
	}

	/**
	 * Le joueur joue une carte1
	 * @see Joueur#jouerCarte(int, Talon)
	 * @param position la position de la carte a jouer 
	 * @param talon le talon
	 */
	public void jouerCarte(int position, Talon talon) {

		talon.ajouterCarte(this.main.get(position));
		this.enleverCarte(position);
	}

	/**
	 * Le joueur joue une carte2
	 * @see Joueur#jouerCarte(Carte, Talon)
	 * @param carte la carte a jouer
	 * @param talon le talon
	 */
	public void jouerCarte(Carte carte, Talon talon) {
		talon.ajouterCarte(carte);
		this.enleverCarte(carte);
	}
	
	/**
	 * Get la liste de tous les cartes du joueur
	 * @see Joueur#getListMain()
	 */

	public List<Carte> getListMain() {
		return this.main;
	}
	
	/**
	 * Get le nom du joueur
	 * @see Joueur#getNom()
	 * @return le nom
	 */

	public String getNom() {

		return this.nom;
	}
	
	public abstract int choisirCarte8();
	
	public abstract int choisirCarte(Partie partie);
	public abstract int choisirCarte(Partie partie, int numeroCarte);

}