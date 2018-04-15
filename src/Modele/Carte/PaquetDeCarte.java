package Modele.Carte;

import java.util.*;

import Modele.Joueur.Joueur;

/**
 * @see PaquetDeCarte
 * le paquet de carte nous permet de poser les cartes non distribu�es
 * 
 */
public class PaquetDeCarte {



	private ArrayList<Carte> paquetDeCarte = new ArrayList<Carte>();

	/**
	 * Creation du paquet de carte
	 * @see PaquetDeCarte#PaquetDeCarte()
	 */
	public PaquetDeCarte() {
		for (int i = 0; i < 4; i++) {
			for (int y = 0; y < 13; y++) {
				Carte carte = new Carte(y, i);
				this.paquetDeCarte.add(carte);
			}
		}
	}

	/**
	 * Melanger le paquet
	 * @see PaquetDeCarte #melanger()
	 * 
	 */
	
	public void melanger() {
		Collections.shuffle(this.paquetDeCarte);
		Collections.shuffle(this.paquetDeCarte);
	}
	
	/**
	 * Ajouter une carte dans le paquet
	 * @see PaquetDeCarte 
	 * 
	 */

	public void ajouterCarte(Carte carte) {
		this.paquetDeCarte.add(carte);
	}

	/**
	 * Enlever la premiere carte dans le paquet
	 * @see PaquetDeCarte
	 * 
	 */
	public void enleverCarte() {
		this.paquetDeCarte.remove(0);
	}
	
	/**
	 * Distribuer les cartes aux joueurs et au talon
	 * @see PaquetDeCarte #distribuer(int, List, Talon)
	 * @param nombreDeCartesChacun le nombre de cartes pour chaque personne
	 * @paramles listeJoueurs joueurs
	 * @paramle talon talon
	 */

	public void distribuer(int nombreDeCartesChacun, List<Joueur> listeJoueurs, Talon talon) {

		for (int i = 0; i < listeJoueurs.size(); i++) {
			for (int y = 0; y < nombreDeCartesChacun; y++) {

				listeJoueurs.get(i).ajouterCarte(this.paquetDeCarte.get(0));
				this.paquetDeCarte.remove(0);
			}

		}

		talon.ajouterCarte(this.paquetDeCarte.get(0));
		this.paquetDeCarte.remove(0);

	}
	
	/**
	 * Afficher tous les cartes dans le paquet
	 * @see PaquetDeCarte #afficherCartes()
	 * 
	 */

	public void afficherCartes() {
		for (int i = 0; i < this.getNombreCarte(); i++) {
			System.out.println(this.paquetDeCarte.get(i).toString());
		}
	}

	/**
	 * Get le nombre de cartes dans le paquet
	 * @see PaquetDeCarte #getNombreCarte()
	 * @return le nombre de cartes
	 * 
	 */
	public int getNombreCarte() {
		return this.paquetDeCarte.size();
	}
	/**
	 * Get une carte du paquet
	 * @see PaquetDeCarte #getCartePaquet(int)
	 * @param position la position de la carte
	 * @return la carte du la position choisie
	 * 
	 */

	public Carte getCartePaquet(int position) {
		return this.paquetDeCarte.get(position);
	}
	/**
	 * Get tous les cartes du paquet
	 * @see PaquetDeCarte #getListPaquet()
	 * @return Une liste de cartes
	 * 
	 */
	public ArrayList<Carte> getListPaquet() {
		return this.paquetDeCarte;
	}

}

