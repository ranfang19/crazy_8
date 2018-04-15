package Modele.Joueur;
import Controleur.*;
import Vue.*;
import java.util.Scanner;

import Modele.Partie.Partie;
/**
 * Joueur reel
 * @see JoueurReel
 */
public class JoueurReel extends Joueur{

	Scanner sc = new Scanner(System.in);
	private Partie partie;
	
	/**
	 * Creation un joueur reel
	 * @see JoueurReel#JoueurReel(String)
	 * @param nom le nom du joueur reel
	 * @param partie
	 */
	public JoueurReel(String nom, Partie partie) {
		super();
		this.nom = nom;
		this.partie = partie;
		
	}
	
	/**
	 * Joueur reel choisit la couleur apres il joue la carte 8 (dans la console)
	 * @see JoueurReel#choisirCarte8()
	 * @return le numero de la couleur
	 */
	public int choisirCarte8() {
		
		int couleur8;
		System.out.println("Taper 0 pour le PIC");
		System.out.println("Taper 1 pour le COEUR");
		System.out.println("Taper 2 pour le CARREAU");
		System.out.println("Taper 3 pour le TREFLE");
		couleur8 = Math.abs(sc.nextInt());
		while (couleur8 != 0 & couleur8 != 1 & couleur8 != 2 & couleur8 != 3) {
			System.out.println("\nMerci de choisir parmis les choix proposées : \n");
			couleur8 = sc.nextInt();
		}
		
		return couleur8;
	}
	
	/**
	 * Joueur reel choisit la couleur apres il joue la carte 8(dans le GUI)
	 * @see JoueurReel#choisirCarte8Vue()
	 */
	public void choisirCarte8Vue() {
		
		PartieControleur controleur = new PartieControleur(partie);
		Carte8Vue carte8vue = new Carte8Vue(controleur);
		
		
	}
	
	/**
	 * Joueur reel choisit une carte a jouer (dans le console)
	 * @see JoueurReel#choisirCarte(Partie)
	 * @param partie la partie en cours
	 * @return la position de la carte choisie
	 */
	
	public int choisirCarte(Partie partie) {	
		int choixOK=0;
		int numeroCarte=0;
		
		while (choixOK != 1) {
			
			if(choixOK==-1) {
				System.out.println("\nVous ne pouvez pas jouer cette carte.\n");
			}
			this.afficherCartes();
			String piocher = this.getNombreCarte() + ". Piocher";
			System.out.println(piocher);
			System.out.println("\nChoisissez la carte à jouer : \n");
			numeroCarte = sc.nextInt();
			if(partie.choixValide(numeroCarte)==true) {
				choixOK=1;
			}else {
				choixOK=-1;
			}
			
		}
		return numeroCarte;
		
	}
	/**
	 * Joueur reel choisit une carte a jouer(dans le GUI)
	 * @see JoueurReel#choisirCarte(Partie, int)
	 * @param partie la partie en cours
	 * @param numeroCarte la position de carte
	 * @return la position de la carte choisie
	 */
	public int choisirCarte(Partie partie, int numeroCarte) {	
		
		
		if(partie.choixValide(numeroCarte)==true) {
				return numeroCarte;
		}else {
				return -1;
		}
	
		
	}
	
	
	
}
