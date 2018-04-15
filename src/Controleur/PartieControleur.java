package Controleur;
import java.util.concurrent.TimeUnit;
import Modele.Joueur.*;
import Modele.Carte.*;
import Modele.Partie.*;
import Modele.Carte.*;
import Vue.Plateau;

/**
 * Controler la partie
 * @see PartieControleur
 *
 */
public class PartieControleur {

	private Partie partie;
	private int typeVariante;
	private int typeStrategie;
	private int nombreJoueurs;
	private Carte carte;
	
	
	public PartieControleur(Partie partie) {
		this.partie = partie;

	}
	
	public void setTypeVariante(int variante) {
		this.typeVariante=variante;
		
	}
	
	public void setTypeStrategie(int strategie) {
		this.typeStrategie=strategie;
		
	}
	
	public void setNombreJoueurs(int nombreJoueurs) {
		this.nombreJoueurs=nombreJoueurs;
		
	}
	
	public void initialiserPartie() {
		this.partie.initialisation(this.typeVariante,this.typeStrategie,this.nombreJoueurs);
		
	}
	
	public void jouerPartie(Carte carte) {
		this.partie.jouer();
		
	}
	
	public void choisirCouleur(int couleur) {
		partie.setCouleur8(couleur);
	}
	
	/**
	 * Choisir la carte a jouer apres les actions de souris
	 * @see PartieControleur#choisirCarte(Carte)
	 * @param carte la carte a jouer
	 * @return la position de la carte
	 */
	public int choisirCarte(Carte carte) {
		int numeroCarte= partie.joueurEnCours.getMain().indexOf(carte);
		numeroCarte= partie.joueurEnCours.choisirCarte(partie, numeroCarte);
		return numeroCarte;
	}
	
	/**
	 * Jouer une carte
	 * @see PartieControleur#jouerUneCarte(int)
	 * @param numeroCarte la position de la carte a jouer
	 */
	public void jouerUneCarte(int numeroCarte) {
		Carte carte = this.partie.jouerUneCarte(numeroCarte);
		carte.effet(this.partie);
		this.partie.tourSuivant();
		try        
		{
		    TimeUnit.SECONDS.sleep(1);
		} 
		catch(InterruptedException ex) 
		{
		
		}
		if(this.partie.finDePartie()==true) {
			this.partie.calculScores();
			this.partie.afficherScores();
		}
		
		while(!(this.partie.joueurEnCours instanceof JoueurReel) && this.partie.finDePartie()==false) {
			Carte carte2 = this.partie.jouerUneCarte();
			
			carte2.effet(this.partie);
			
			this.partie.tourSuivant();
			
			
			if (this.partie.paquet.getNombreCarte() < 2) {
				this.partie.redistribuer();
			}
			if(this.partie.finDePartie()==true) {
				this.partie.calculScores();
				this.partie.afficherScores();
			break;
			}
			
			try        
			{
				   TimeUnit.SECONDS.sleep(1);
			} 
			catch(InterruptedException ex) 
			{
				   
			}
		} 
	}
	

	

	
	
	
	
	
	
	
}
