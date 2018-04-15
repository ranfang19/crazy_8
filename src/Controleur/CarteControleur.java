package Controleur;
import Modele.Carte.*;
import Vue.*;

import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import java.awt.event.MouseListener;

/**
 * Controler les actions des cartes
 * @see CarteControleur
 *
 */
public class CarteControleur {
	
	private Carte carte;
	private JPanel jpanel;
	private PartieControleur controleur;
	
	/**
	 * Creation de la carte
	 * @see CarteControleur#CarteControleur(Carte, JPanel, PartieControleur)
	 * @param carte la carte
	 * @param jpanel le panel pour afficher l'image
	 * @param controleur
	 */
	public CarteControleur(Carte carte,JPanel jpanel, PartieControleur controleur) {
		this.carte=carte;
		this.jpanel=jpanel;
		this.controleur=controleur;
		
		jpanel.addMouseListener(new MouseListener(){
			
			public void mouseClicked(MouseEvent arg0) {

				System.out.println(carte.toString());
				Plateau.carteChoisie=carte;
				int numeroCarte = controleur.choisirCarte(carte);
				if(numeroCarte != -1 ) {
					controleur.jouerUneCarte(numeroCarte);
				}
				
			}
			

			public void mouseEntered(MouseEvent arg0) {
				jpanel.setBounds(jpanel.getX(), jpanel.getY() - 10, jpanel.getWidth(), jpanel.getHeight());
			}

			public void mouseExited(MouseEvent arg0) {
				jpanel.setBounds(jpanel.getX(), jpanel.getY() + 10, jpanel.getWidth(), jpanel.getHeight());
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}


		});
			
		}
		
		
	}
	
	
	
