package Modele.Carte;

import Modele.Effet.*;


import Modele.Partie.*;
/**
 * @see Carte
 * Definir les cartes
 * 
 */
public class Carte {



	public final static int PIC = 0;
	public final static int COEUR = 1;
	public final static int CARREAU = 2;
	public final static int TREFLE = 3;

	public final static int AS = 0;
	public final static int DEUX = 1;
	public final static int TROIS = 2;
	public final static int QUATRE = 3;
	public final static int CINQ = 4;
	public final static int SIX = 5;
	public final static int SEPT = 6;
	public final static int HUIT = 7;
	public final static int NEUF = 8;
	public final static int DIX = 9;
	public final static int VALET = 10;
	public final static int DAME = 11;
	public final static int ROI = 12;

	public final static String[] COULEURS = { "Pic", "Coeur", "Carreau", "Trefle" };
	public final static String[] VALEURS = { "AS", "DEUX", "TROIS", "QUATRE", "CINQ", "SIX", "SEPT", "HUIT", "NEUF",
			"DIX", "VALET", "DAME", "ROI" };

	private int couleur;
	private int valeur;
	private Effet effet;

	/**
	 * Deux constructeurs pour definir la carte(integer et String)
	 * @see Carte#Carte(int, int)
	 * @see Carte#Carte(String, String)
	 */
	public Carte(int valeur, int couleur) {
		this.setCouleur(couleur);
		this.setValeur(valeur);
	}

	public Carte(String valeur, String couleur) {
		int i = 0;
		int c = 0, v = 0;
		boolean trouve = false;
		while (i < Carte.COULEURS.length && trouve == false) {
			if (couleur.equals(Carte.COULEURS[i])) {
				trouve = true;
				c = i;
			} else {
				i++;
			}
		}
		i = 0;
		trouve = false;
		while (i < Carte.VALEURS.length && trouve == false) {
			if (valeur.equals(Carte.VALEURS[i])) {
				trouve = true;
				v = i;
			} else {
				i++;
			}
		}
		this.setCouleur(c);
		this.setValeur(v);
	}

	/**
	 * Get la coleur de la carte
	 * 
	 * @see Carte#getCouleur()
	 * @return couleur le numero de la couleur
	 */

	public int getCouleur() {
		return couleur;
	}

	/**
	 * Set la coueur de la carte
	 * 
	 * @see Carte#setCouleur(int)
	 * @param couleur le numero de la couleur
	 */

	public void setCouleur(int couleur) {
		if (couleur >= Carte.PIC && couleur <= Carte.TREFLE) {
			this.couleur = couleur;
		}
	}

	/**
	 * Get le numero de la valeur
	 * 
	 * @see Carte#getValeur()
	 * @return le numero de la valeur
	 */

	public int getValeur() {
		return valeur;
	}

	/**
	 * Set la valeur de la carte
	 * 
	 * @see Carte#setVouleur(int)
	 * @param valeur le numero de la valeur
	 * 
	 */
	public void setValeur(int valeur) {
		if (valeur >= Carte.AS && valeur <= Carte.ROI) {
			this.valeur = valeur;
		}
	}

	/**
	 * Obtenir le nom de la carte
	 * 
	 * @see Carte #toString()
	 * @return le nom de la carte en chaine de caracteres
	 */

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(Carte.VALEURS[this.valeur]);
		sb.append(" de ");
		sb.append(Carte.COULEURS[this.couleur]);
		return sb.toString();
	}

	/**
	 * Obtenir effet de la carte
	 * 
	 * @see Carte#getEffet()
	 * @return Effet de la carte, si elle n'a pas, return "null"
	 * 
	 */

	public String getEffet() {
		if (this.effet != null) {
			return this.effet.getEffet();
		} else {
			return "Aucun effet";
		}

	}

	/**
	 * Definir l'effet de la carte, si elle n'a pas, on set "null"
	 * 
	 * @see Carte#setEffet(Effet)
	 * @param effet le type "Effet"
	 */

	public void setEffet(Effet effet) {
		this.effet = effet;
	}

	/**
	 * Utiliser l'effet de la carte, si elle n'a pas l'effet, on ne fait rien
	 * 
	 * @see Carte#effet
	 * @param partie le type "Partie"
	 */
	public void effet(Partie partie) {
		if (this.effet != null) {
			this.effet.faireEffet(partie);
		} else {

		}
	}

}

