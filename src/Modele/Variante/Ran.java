package Modele.Variante;
import Modele.Effet.*;
import java.util.*;

import Modele.Carte.*;

/**
 * La variante de type Ran
 * @see Ran
 */
public class Ran extends Variante {

	public Ran() {
		super();

		this.setNom("Version Ran");
		this.setNumero("2");
		this.setRegle(
				"0:oblige de rejouer \n 8:permet de changer la couleur, se pose sur n'importe quelle carte \n 7:le joueur suivant passe son tour \n valet:changement de sens");
		this.getRegle();
	}
	/**
	 * Set l'effet de type Ran:
	 * l'effet 'sanuer joueur suivant' pour les cares 7
	 * l'effet 'rejouer' pour les cartes 10
	 * l'effet 'changer le sens'pour les cartes valet
	 * l'effet 'Changer de couleur'pour les carte 8
	 * @see Ran#setEffet(PaquetDeCarte)
	 * @param paquet le paquet de carte non effets
	 * @return le paquet de carte avec effets
	 */
	public PaquetDeCarte setEffet(PaquetDeCarte paquet) {

		int index = 0;


		Iterator<Carte> i1 = paquet.getListPaquet().iterator();
		while (i1.hasNext()) {
			Carte carte = i1.next();
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
