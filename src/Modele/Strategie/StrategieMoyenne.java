package Modele.Strategie;

import Modele.Partie.*;
import java.util.ArrayList;

import Modele.Carte.*;
/**
 *La strategie moyenne
 * @see  StrategieMoyenne
 */
public class StrategieMoyenne extends Strategie {

	/**
	 *Creation d'une strategieMoyenne
	 * @see  StrategieMoyenne
	 */
	public StrategieMoyenne() {
		super();
	}
	/**
	 *Trouver la carte a jouer:
	 *Il trouve d'abord les cartes normales, puis les cartes speciales sauf le 10 et le 8,
	 *ensuite il trouve le 8 et a la fin le 10
	 * @see  StrategieSimple#ordiChoisirUneCarte(Partie)
	 * @param partie la partie en cours
	 * @return la position de la carte a jouer
	 */
	public int ordiChoisirUneCarte(Partie partie) {

		int ib = 0;
		boolean carteValide = false;

		/**
		 * si la carte est normale
		 */
		while (ib < partie.joueurEnCours.getNombreCarte() && carteValide == false
				&& partie.joueurEnCours.getNom() != "joueurRéel") {

			if (((partie.getCouleur8() != -1 && partie.joueurEnCours.getCarte(ib).getCouleur() == partie.getCouleur8())
					|| (partie.getCouleur8() == -1 && partie.joueurEnCours.getCarte(ib).getValeur() == partie.talon
							.getCarteJouee().getValeur())
					|| (partie.getCouleur8() == -1 && partie.joueurEnCours.getCarte(ib).getCouleur() == partie.talon
							.getCarteJouee().getCouleur()))
					&& partie.joueurEnCours.getCarte(ib).getEffet() == null) {

				if (partie.getCouleur8() != -1) {
					partie.setCouleur8(-1);
				}

				carteValide = true;
				return ib;

			}

			else {
				ib++;
			}
		}

		/**
		 * si la carte est sp�ciale mais pas le 8 & 10
		 */

		ib = 0;
		while (ib < partie.joueurEnCours.getNombreCarte() && carteValide == false
				&& partie.joueurEnCours.getNom() != "joueurRéel") {

			if (((partie.getCouleur8() != -1 && partie.joueurEnCours.getCarte(ib).getCouleur() == partie.getCouleur8())
					|| (partie.getCouleur8() == -1 && partie.joueurEnCours.getCarte(ib).getValeur() == partie.talon
							.getCarteJouee().getValeur())
					|| (partie.getCouleur8() == -1 && partie.joueurEnCours.getCarte(ib).getCouleur() == partie.talon
							.getCarteJouee().getCouleur()))
					&& partie.joueurEnCours.getCarte(ib).getEffet() != null
					&& partie.joueurEnCours.getCarte(ib).getEffet() != "Changer la couleur"
					&& partie.joueurEnCours.getCarte(ib).getEffet() != "Rejouer") {

				if (partie.getCouleur8() != -1) {
					partie.setCouleur8(-1);
				}

				carteValide = true;
				return ib;

			}

			else {
				ib++;
			}
		}

		/**
		 * si la carte est le 8
		 */
		ib = 0;
		while (ib < partie.joueurEnCours.getNombreCarte() && carteValide == false
				&& partie.joueurEnCours.getNom() !="joueurRéel") {
			if (partie.joueurEnCours.getCarte(ib).getEffet() == "Changer la couleur") {

				if (partie.getCouleur8() != -1) {
					partie.setCouleur8(-1);
				}
				carteValide = true;
				return ib;

			}

			else {
				ib++;
			}
		}

		/**
		 * si la carte est le 10
		 */
		ib = 0;
		while (ib < partie.joueurEnCours.getNombreCarte() && carteValide == false
				&& partie.joueurEnCours.getNom() != "joueurRéel") {
			if (((partie.getCouleur8() != -1 && partie.joueurEnCours.getCarte(ib).getCouleur() == partie.getCouleur8())
					|| (partie.getCouleur8() == -1 && partie.joueurEnCours.getCarte(ib).getValeur() == partie.talon
							.getCarteJouee().getValeur())
					|| (partie.getCouleur8() == -1 && partie.joueurEnCours.getCarte(ib).getCouleur() == partie.talon
							.getCarteJouee().getCouleur()))
					&& partie.joueurEnCours.getCarte(ib).getEffet() != null
					&& partie.joueurEnCours.getCarte(ib).getEffet() == "Rejouer") {

				if (partie.getCouleur8() != -1) {
					partie.setCouleur8(-1);
				}
				carteValide = true;
				return ib;

			}

			else {
				ib++;
			}
		}

		/**
		 * si on peut pas jouer la carte de la position 'ib'
		 */

		if (ib == partie.joueurEnCours.getNombreCarte() && carteValide == false) {
			carteValide = true;
		}

		return ib;
	}

}
