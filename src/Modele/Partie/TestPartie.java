package Modele.Partie;
import Vue.*;
import Controleur.PartieControleur;
import Vue.MenuVue;
/**
 * Tester le code
 * @see TestPartie
 */

public class TestPartie extends Partie {

	public TestPartie(String typeDeVue) {
		super(typeDeVue);
	}


	public static void main(String[] args) {
	
		Partie partie = new Partie("Vue");
		//partie.jouer();
		
		PartieControleur controleur = new PartieControleur(partie);
		MenuVue menuVue = new MenuVue(controleur, partie);//
		
	}
}
