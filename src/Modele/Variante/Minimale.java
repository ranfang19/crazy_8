package Modele.Variante;
import Modele.Effet.*;

import java.util.*;

import Modele.Carte.*;
import Modele.Effet.Carte8;
import Modele.Effet.Rejouer;
/**
 * La variante de type Minimale
 * @see Minimale
 */
public class Minimale extends Variante {
	/**
	 * Creation de Minimale en donnant le nom, numero, regle
	 * @see Minimale#Minimale()
	 */
	public Minimale() {
		super();

		this.setNom("Version Minimale");
		this.setNumero("1");
		this.setRegle("10:oblige à rejouer \n 8:permet de changer la couleur, se pose sur n'importe quelle carte");
		this.getRegle();
	}
	
	/**
	 * Set l'effet de type Minimale:
	 * l'effet 'rejouer' pour les cartes 10
	 * l'effet 'Changer de couleur'pour les carte 8
	 * @see Minimale#setEffet(PaquetDeCarte)
	 * @param paquet le paquet de carte non effets
	 * @return le paquet de carte avec effets
	 */
	public PaquetDeCarte setEffet(PaquetDeCarte paquet) {

		int index=0;
		/**
		 * set effet 'rejouer'
		 * set effet 'Changer de couleur'
		 */
		System.out.println("Entrée minimale");
		Iterator<Carte> i1 = paquet.getListPaquet().iterator();
		while (i1.hasNext()) {
			Carte carte = i1.next();
			if (carte.getValeur() == 9) {
				Effet rejouer = new Rejouer();
				paquet.getCartePaquet(index).setEffet(rejouer);
			}
			if (carte.getValeur() == 7) {
				Effet carte8 = new Carte8();
				paquet.getCartePaquet(index).setEffet(carte8);
			}
			index++;

		}
		
		return paquet;

	}

}
