
package Modele.Partie;

import java.util.*;

import Modele.Effet.*;
import Modele.Carte.Carte;
import Modele.Carte.PaquetDeCarte;
import Modele.Carte.Talon;
import Modele.Joueur.*;
import Modele.Strategie.*;
import Modele.Variante.Alexis;
import Modele.Variante.Minimale;
import Modele.Variante.Ran;
import Vue.FinVue;

/**
 * Commencer une partie du jeu
 * @see Partie
 */
@SuppressWarnings("deprecation")
public class Partie extends Observable {

	private List<Joueur> listeJoueurs = new ArrayList<Joueur>();
	private List<Integer> listeScores = new ArrayList<Integer>();
	Scanner sc = new Scanner(System.in);
	public PaquetDeCarte paquet;
	public Talon talon;
	public Joueur joueurEnCours;
	private Joueur joueurPrecedant;
	private boolean sensHoraire = true;
	private static int tourDeJeu = 0;
	private int couleur8 = -1;
	int numeroCarte;

	private String typeDeVue;
	

	private ArrayList<Observer> listObserver = new ArrayList<Observer>();

	public Partie(String typeDeVue) {
		
		this.typeDeVue = typeDeVue;
		
		if(typeDeVue == "Console") {
			
			 int nombreDeJoueurs;
			 System.out.println("Combien de joueurs voulez-vous?");
			 nombreDeJoueurs = sc.nextInt();

			 
			 System.out.println("Quelle strategie voulez-vous choisir?");
			 System.out.println("Taper 1 pour Strategie simple \nTaper 2 pour Strategie moyenne");
			 int typeStrategie = sc.nextInt();
			 
			 System.out.println("Quelle variante voulez-vous choisir?");
		     System.out.println("Taper 1 pour la variante Minimale");
		     System.out.println("Taper 2 pour la variante Ran");
		 	 System.out.println("Taper 3 pour la variante Alexis"); 
		 	 int typeVariante =sc.nextInt();
		 	 
		 	initialisation(typeStrategie, typeVariante, nombreDeJoueurs);
		}
		
	}
	
   /**
    * Initialisation d'une partie
    * @param typeStrategie le type de strategie
    * @param typeVariante le type de variante
    * @param nombreDeJoueurs le nombre de joueurs
    */
	public void initialisation(int typeStrategie, int typeVariante, int nombreDeJoueurs) {

		/**
		 * Initialisation de strategie
		 */
		Strategie strategie;
		if (typeStrategie == 2) {
			strategie = new StrategieMoyenne();
		} else {
			strategie = new StrategieSimple();
		}
		
		/**
		 * On creer une liste de joueurs
		 */

		Joueur joueur = new JoueurReel("JoueurRéel", this);
		this.listeJoueurs.add(joueur);
		for (int i = 1; i < nombreDeJoueurs; i++) {
			String nomOrdi = "Ordinateur " + i;
			Joueur joueurOrdi = new JoueurVirtuel(nomOrdi, strategie);
			this.listeJoueurs.add(joueurOrdi);
		}

		this.talon = new Talon();
		this.paquet = new PaquetDeCarte();

		/**
		 * Initialisation de variante
		 */

		if (typeVariante == 1) {
			Minimale minimale = new Minimale();
			this.paquet = minimale.setEffet(this.paquet);
		}
		if (typeVariante == 2) {
			Ran ran = new Ran();
			this.paquet = ran.setEffet(this.paquet);
		}
		if (typeVariante == 3) {
			Alexis alexis = new Alexis();
			this.paquet = alexis.setEffet(this.paquet);
		}

		this.paquet.melanger();
		this.paquet.distribuer(5, listeJoueurs, talon);
		this.joueurEnCours = this.listeJoueurs.get(0);
		this.joueurPrecedant = this.listeJoueurs.get(0);

	}

   /**
    * Changer le sens de la partie
    * @see Partie#changerSens() 
    */
	
	public void changerSens() {
		this.sensHoraire = !this.sensHoraire;
	}
	
   /**
    * Get le nombre de joueurs
    * @see Partie#getNombreJoueurs()
    * @return le nombre de joueurs
    */
	
	public int getNombreJoueurs() {
		return this.listeJoueurs.size();
	}
	
   /**
    * Set couleur8 apres le changement de couleur	
    * @see Partie#setCouleur8(int)
    * @param couleur le numero de couleur
    */

	public void setCouleur8(int couleur) {
		couleur8 = couleur;
	}
	
	/**
	 * Get couleur8
	 * @see Partie#getCouleur8(int)
	 * @return la valeur de couleur8
	 */

	public int getCouleur8() {
		return this.couleur8;
	}
	
	/**
	 * Determiner le joueur suivant
	 * @see Partie#tourSuivant()
	 */
	
	public void tourSuivant() {

		if (this.sensHoraire) {
			this.tourDeJeu = (this.tourDeJeu + 1) % (this.getNombreJoueurs());

		} else {
			this.tourDeJeu = (this.tourDeJeu - 1 + this.getNombreJoueurs()) % (this.getNombreJoueurs());
		}
		this.joueurPrecedant = this.joueurEnCours;
		this.joueurEnCours = this.listeJoueurs.get(this.tourDeJeu);
		this.notifyObserver(this, this.joueurEnCours);
	}
	
	/**
	 * Get le joueur en cours
	 * @see Partie#getJoueurEnCours()
	 * @return le joueur en cours
	 */

	public Joueur getJoueurEnCours() {
		return this.joueurEnCours;
	}
	
	/**
	 * Afficher le talon
	 * @see Partie#afficherTalon()
	 */

	public void afficherTalon() {
		this.talon.afficherCartes();
	}
	
	/**
	 * Afficher le paquet de carte
	 * @see Partie#afficherPaquetDeCarte()
	 */

	public void afficherPaquetDeCarte() {
		this.paquet.afficherCartes();
	}

	/**
	 * Afficher les cartes de joueur
	 * @see Partie#afficherCartesJoueur(int)
	 * @param numeroJoueur le numero du joueur
	 */
	
	public void afficherCartesJoueur(int numeroJoueur) {

		System.out.println(this.listeJoueurs.get(numeroJoueur).getNom());
		this.listeJoueurs.get(numeroJoueur).afficherCartes();
	}
	
	/**
	 * Afficher les cartes de joueur
	 * @see Partie#afficherCartesJoueur(Joueur)
	 * @param joueur le joueur
	 */

	public void afficherCartesJoueur(Joueur joueur) {

		System.out.println(joueur.getNom());
		joueur.afficherCartes();
	}

	/**
	 * Afficher les cartes de tous les joueurs
	 * @see Partie#afficherCartesTousJoueurs()
	 */
	
	public void afficherCartesTousJoueurs() {

		for (int i = 0; i < this.getNombreJoueurs(); i++) {
			this.afficherCartesJoueur(i);
			System.out.println("\n");
		}
	}

	/**
	 * Calculer les scores
	 * @see Partie#calculScores()
	 */
	
	public void calculScores() {

		System.out.println(this.joueurPrecedant.getNom() + " a gagné !");
		Iterator<Joueur> it = this.listeJoueurs.iterator();
		while (it.hasNext()) {
			int score = 0;
			Joueur j = (Joueur) it.next();
			Iterator<Carte> it2 = j.getMain().iterator();
			while (it2.hasNext()) {
				Carte carte = (Carte) it2.next();
				if (carte.getValeur() == 7) {
					score += 50;
				} else if (carte.getValeur() == 10 || carte.getValeur() == 6 || carte.getValeur() == 1) {
					score += 20;
				} else if (carte.getValeur() == 12 || carte.getValeur() == 11) {
					score += 10;
				} else {
					score += carte.getValeur() + 1;
				}
			}
			this.listeScores.add(score);
		}
	}

	/**
	 * Afficher les scores
	 * @see Partie#afficherScores()
	 */
	
	public void afficherScores() {

		ArrayList<Joueur> liste = new ArrayList<Joueur>();
		ArrayList<Integer> listeDesScores = new ArrayList<Integer>();
		for (int i = 0; i < getNombreJoueurs(); i++) {
			liste.add(this.listeJoueurs.get(i));
			listeDesScores.add(this.listeScores.get(i));
			System.out.println(this.listeJoueurs.get(i).getNom() + " a un score de " + this.listeScores.get(i));
		}
		FinVue fin=new FinVue(liste, listeDesScores);/////////////////
	}

	/**
	 * Verifier si la partie est terminee
	 * @see Partie#finDePartie()
	 * @return boolean
	 */
	
	public boolean finDePartie() {

		if (this.joueurPrecedant.getNombreCarte() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Restribuer les cartes quand il y en a plus
	 * @see Partie#redistribuer()
	 */
	
	public void redistribuer() {

		int nombreCartes = this.talon.getNombreCartes() - 1;
		for (int i = 0; i < nombreCartes; i++) {
			this.paquet.ajouterCarte(this.talon.getCarte());
			this.talon.enleverCarte(0);
		}
		this.paquet.melanger();

	}

	/**
	 * Verifier si la carte choisie est valide
	 * @see Partie#choixValide(int)
	 * @param numeroCarte la position de carte a la main
	 * @return
	 */
	
	public boolean choixValide(int numeroCarte) {

		if (numeroCarte == this.joueurEnCours.getNombreCarte()
				|| (couleur8 != -1 && this.joueurEnCours.getCarte(numeroCarte).getCouleur() == couleur8)
				|| (couleur8 == -1 && this.joueurEnCours.getCarte(numeroCarte).getValeur() == this.talon.getCarteJouee()
						.getValeur())
				|| (couleur8 == -1 && this.joueurEnCours.getCarte(numeroCarte).getCouleur() == this.talon
						.getCarteJouee().getCouleur())
				|| this.joueurEnCours.getCarte(numeroCarte).getEffet() == "Change la couleur") {

			if (couleur8 != -1) {
				couleur8 = -1;
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Jouer ou piocher une carte
	 * @see Partie#jouerUneCarte()
	 * @return la carte jouee ou la carte nulle
	 */
	
	public Carte jouerUneCarte() {

		numeroCarte = this.joueurEnCours.choisirCarte(this);

		if (numeroCarte == this.joueurEnCours.getNombreCarte()) {
			this.joueurEnCours.piocher(this.paquet);
			System.out.println(this.joueurEnCours.getNom() + " a pioché une carte et passe son tour \n");
			Carte carteNulle = new Carte(1, 1);
			carteNulle.setEffet(null);
			
			return carteNulle;
		} else {
			Carte carte = this.joueurEnCours.getCarte(numeroCarte);
			this.joueurEnCours.jouerCarte(this.joueurEnCours.getCarte(numeroCarte), this.talon);
			System.out
					.println(this.joueurEnCours.getNom() + " a joué  " + this.talon.getCarteJouee().toString() + ".\n");
			
			return carte;
		}

	}
	
	/**
	 * Jouer ou piocher une carte
	 * @param numeroCarte la position de la carte
	 * @return la carte jouee ou la carte nulle
	 */
	
	public Carte jouerUneCarte(int numeroCarte) {

		if (numeroCarte == this.joueurEnCours.getNombreCarte()) {
			this.joueurEnCours.piocher(this.paquet);
			Carte carteNulle = new Carte(1, 1);
			carteNulle.setEffet(null);
			
			return carteNulle;
		} else {
			Carte carte = this.joueurEnCours.getCarte(numeroCarte);
			this.joueurEnCours.jouerCarte(this.joueurEnCours.getCarte(numeroCarte), this.talon);
			
			return carte;
		}
		

	}

	/**
	 * Commencer une partie
	 * @see Partie#jouer()
	 */
	
	public void jouer() {


		while (this.finDePartie() == false) {

			if (this.joueurEnCours instanceof JoueurReel) {
					if(this.couleur8 == -1) {
						this.talon.afficherLaPremiereCarte();
					}else {
						String couleurDemandee = "La couleur demandée est " + Carte.COULEURS[this.couleur8] + "\n";
						System.out.println(couleurDemandee);
					}
			}

			Carte carte = this.jouerUneCarte();
			carte.effet(this);
			this.tourSuivant();
			if (this.paquet.getNombreCarte() < 2) {
				this.redistribuer();
			 }
		}
		this.calculScores();
		this.afficherScores();
	}


	public void addObserver(Observer obs) {
		this.listObserver.add(obs);
	}
	
	public void notifyObserver(Observable o, Object arg) {
		for(Observer obs : listObserver) {
			obs.update(o, arg);
			}
		}

	/**
	 * Get le type de vue
	 * @return le type de vue
	 */
	public String getTypeDeVue() {
		return this.typeDeVue;
		}


}


