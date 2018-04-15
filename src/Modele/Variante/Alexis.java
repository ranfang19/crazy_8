package Modele.Variante;
import Modele.Effet.*;
import java.util.Iterator;

import Modele.Carte.*;
/**
 * La variante de type Alexis
 * @see Alexis
 */

public class Alexis extends Variante {
	/**
	 * Creation de Alexis en donnant le nom, numero, regle
	 * @see Alexis#Alexis()
	 */
	public Alexis() {
		super();

		this.setNom("Version Alexis");
		this.setNumero("3");
		this.setRegle(
				"0:oblige de rejouer \n 8:permet de changer la couleur, se pose sur n'importe quelle carte \n 7:le joueur suivant passe son tour \n valet:changement de sens \n 2: le joueur suivant pioche 2 cartes");

	}
	
	/**
	 * Set l'effet de type Alexis:
	 * l'effet 'sanuer joueur suivant' pour les cares 7
	 * l'effet 'rejouer' pour les cartes 10
	 * l'effet 'changer le sens'pour les cartes valet
	 * l'effet 'faire piocher 2 cartes pour les cartes 2
	 * l'effet 'Changer de couleur'pour les carte 8
	 * @see Alexis#setEffet(PaquetDeCarte)(PaquetDeCarte)
	 * @param paquet le paquet de carte non effets
	 * @return le paquet de carte avec effets
	 */
	
	public PaquetDeCarte setEffet(PaquetDeCarte paquet) {

		int index = 0;

		/**
		 * set effet 'rejouer'
		 * set effet 'carte8'
		 * set effet 'sauter le joueur suivant'
		 * set effet 'changer le sens'
		 * set effet 'faire piocher 2 cartes'
		 */

		Iterator<Carte> i1 = paquet.getListPaquet().iterator();
		while (i1.hasNext()) {
			Carte carte = i1.next();
			if (carte.getValeur() == 1) {
				Effet fairePiocher2Cartes = new FairePiocher2Cartes();
				paquet.getCartePaquet(index).setEffet(fairePiocher2Cartes);
			}
			if (carte.getValeur() == 6) {
				Effet sauterJoueurSuivant = new SauterJoueurSuivant();
				paquet.getCartePaquet(index).setEffet(sauterJoueurSuivant);
			}
			if (carte.getValeur() == 7) {
				Effet carte8 = new Carte8();
				paquet.getCartePaquet(index).setEffet(carte8);
			}
			if (carte.getValeur() == 9) {
				Effet rejouer = new Rejouer();
				paquet.getCartePaquet(index).setEffet(rejouer);
			}
			if (carte.getValeur() == 10) {
				Effet changerSens = new ChangerSens();
				paquet.getCartePaquet(index).setEffet(changerSens);
			}
			index++;
		}

		return paquet;

	}
}
