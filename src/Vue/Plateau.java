package Vue;
import Controleur.PartieControleur;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import Controleur.CarteControleur;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

import Modele.Carte.Carte;
import Modele.Joueur.Joueur;
import Modele.Joueur.JoueurReel;
import Modele.Partie.*;

/**
 * Vue pour le plateau du jeu
 * @author ranfang
 *
 */
public class Plateau implements Observer {

	public JPanel south;
	public JPanel center;
	public JLabel talon;
	private JFrame frame;
	private boolean update=false;
	private JPanel carteMainPanel;
	public static Carte carteChoisie;
	private Partie partie;
	private PartieControleur controleur;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Plateau window = new Plateau(p);
					// window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 */
	public Plateau(PartieControleur controleur, Partie partie) {
		this.controleur = controleur;
		this.partie = partie;
		this.partie.addObserver(this);
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {

		frame = new JFrame();
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setResizable(false);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		/**
		 * diviser la fenetre
		 */

		JPanel north = new JPanel();
		frame.getContentPane().add(north, BorderLayout.NORTH);
		north.setPreferredSize(new Dimension(800, 200));
		north.setOpaque(false);

		this.south = new JPanel();
		frame.getContentPane().add(this.south, BorderLayout.SOUTH);
		this.south.setPreferredSize(new Dimension(800, 200));
		this.south.setOpaque(false);
		this.south.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel east = new JPanel();
		frame.getContentPane().add(east, BorderLayout.EAST);
		east.setPreferredSize(new Dimension(200, 200));
		east.setOpaque(false);

		JPanel center = new JPanel();
		frame.getContentPane().add(center, BorderLayout.CENTER);
		center.setPreferredSize(new Dimension(400, 200));
		center.setOpaque(false);

		JPanel west = new JPanel();
		frame.getContentPane().add(west, BorderLayout.WEST);
		west.setPreferredSize(new Dimension(200, 200));
		center.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel paquet = new JLabel("");
		paquet.setIcon(new ImageIcon(Plateau.class.getResource("/resources/smallback.jpg")));
		paquet.setBounds(154, 474, 158, 218);
		center.add(paquet);
		
		this.talon = new JLabel("");
		this.talon.setIcon(new ImageIcon(Plateau.class.getResource(
				"/resources/" + partie.talon.getCarte().getCouleur() + "-" + partie.talon.getCarte().getValeur() + ".gif")));
		this.talon.setBounds(154, 474, 158, 218);
		center.add(this.talon);

	

		ArrayList<Carte> cartes = (ArrayList<Carte>) partie.joueurEnCours.getMain();
		int nbCarte = cartes.size();
		this.south.setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(new FlowLayout());

		
		JButton piocher = new JButton("Piocher");
		piocher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("JoueurReel pioche une carte et passe son tour\n");
				controleur.jouerUneCarte(partie.joueurEnCours.getNombreCarte());
			}
		});
		piocher.setVisible(true);
		buttonPanel.add(piocher);
		buttonPanel.setPreferredSize(new Dimension(800, 30));

	
		
		this.carteMainPanel = this.afficherCarteMain(partie);
		this.carteMainPanel.setPreferredSize(new Dimension(800, 160));
		
		this.south.add(buttonPanel, BorderLayout.NORTH);
		this.south.add(this.carteMainPanel, BorderLayout.SOUTH);

		if (partie.getNombreJoueurs() == 2) {
			JLabel joueur1 = new JLabel("");
			joueur1.setIcon(new ImageIcon(Plateau.class.getResource("/resources/smallback.jpg")));
			joueur1.setBounds(154, 474, 158, 218);
			north.add(joueur1);
		}

		else if (partie.getNombreJoueurs() == 3) {
			JLabel joueur2 = new JLabel("");
			joueur2.setIcon(new ImageIcon(Plateau.class.getResource("/resources/smallback.jpg")));
			paquet.setBounds(154, 474, 158, 218);
			west.add(joueur2);

			JLabel joueur3 = new JLabel("");
			joueur3.setIcon(new ImageIcon(Plateau.class.getResource("/resources/smallback.jpg")));
			paquet.setBounds(154, 474, 158, 218);
			east.add(joueur3);

		}

		else if (partie.getNombreJoueurs() == 4) {
			JLabel joueur1 = new JLabel("");
			joueur1.setIcon(new ImageIcon(Plateau.class.getResource("/resources/smallback.jpg")));
			joueur1.setBounds(154, 474, 158, 218);
			north.add(joueur1);

			JLabel joueur2 = new JLabel("");
			joueur2.setIcon(new ImageIcon(Plateau.class.getResource("/resources/smallback.jpg")));
			paquet.setBounds(154, 474, 158, 218);
			west.add(joueur2);

			JLabel joueur3 = new JLabel("");
			joueur3.setIcon(new ImageIcon(Plateau.class.getResource("/resources/smallback.jpg")));
			paquet.setBounds(154, 474, 158, 218);
			east.add(joueur3);
		}

		else if (partie.getNombreJoueurs() == 5) {
			JLabel joueur1 = new JLabel("");
			joueur1.setIcon(new ImageIcon(Plateau.class.getResource("/resources/smallback.jpg")));
			joueur1.setBounds(154, 474, 158, 218);
			north.add(joueur1);

			JLabel joueur2 = new JLabel("");
			joueur2.setIcon(new ImageIcon(Plateau.class.getResource("/resources/smallback.jpg")));
			paquet.setBounds(154, 474, 158, 218);
			west.add(joueur2);

			JLabel joueur3 = new JLabel("");
			joueur3.setIcon(new ImageIcon(Plateau.class.getResource("/resources/smallback.jpg")));
			paquet.setBounds(154, 474, 158, 218);
			east.add(joueur3);

			JLabel joueur4 = new JLabel("");
			joueur4.setIcon(new ImageIcon(Plateau.class.getResource("/resources/smallback.jpg")));
			joueur4.setBounds(154, 474, 158, 218);
			north.add(joueur4);

		}

		else if (partie.getNombreJoueurs() == 6) {
			JLabel joueur1 = new JLabel("");
			joueur1.setIcon(new ImageIcon(Plateau.class.getResource("/resources/smallback.jpg")));
			joueur1.setBounds(154, 474, 158, 218);
			north.add(joueur1);

			JLabel joueur2 = new JLabel("");
			joueur2.setIcon(new ImageIcon(Plateau.class.getResource("/resources/smallback.jpg")));
			paquet.setBounds(154, 474, 158, 218);
			west.add(joueur2);

			JLabel joueur3 = new JLabel("");
			joueur3.setIcon(new ImageIcon(Plateau.class.getResource("/resources/smallback.jpg")));
			paquet.setBounds(154, 474, 158, 218);
			east.add(joueur3);

			JLabel joueur4 = new JLabel("");
			joueur4.setIcon(new ImageIcon(Plateau.class.getResource("/resources/smallback.jpg")));
			joueur4.setBounds(154, 474, 158, 218);
			north.add(joueur4);

			JLabel joueur5 = new JLabel("");
			joueur5.setIcon(new ImageIcon(Plateau.class.getResource("/resources/smallback.jpg")));
			joueur5.setBounds(154, 474, 158, 218);
			north.add(joueur5);

		}

	}


	@SuppressWarnings("deprecation")
	@Override
	public void update(Observable o, Object arg) {
		
		if(o instanceof Partie) {
		if(arg instanceof JoueurReel) {
			this.south.remove(this.carteMainPanel);
			this.carteMainPanel.removeAll();
			this.carteMainPanel = this.afficherCarteMain(partie);
			this.south.add(this.carteMainPanel, BorderLayout.SOUTH);	
			this.carteMainPanel.updateUI();
			this.south.updateUI();
		}
		this.talon.setIcon(new ImageIcon(Plateau.class.getResource(
				"/resources/" + this.partie.talon.getCarteJouee().getCouleur() + "-" + this.partie.talon.getCarteJouee().getValeur() + ".gif")));
		this.talon.updateUI();
		}
	
	}

	/**
	 * "afficherCarteMain" nous permet de afficher les cartes du joueur physique
	 * 
	 */

	public JPanel afficherCarteMain(Partie p) {
		JPanel carteMain = new JPanel();
		carteMain.setOpaque(false);
		carteMain.setLayout(new FlowLayout());
		ArrayList<Carte> cartes = (ArrayList<Carte>) partie.joueurEnCours.getMain();
		Iterator<Carte> it = cartes.iterator();
		while (it.hasNext()) {
			Carte c = it.next();
			CarteVue carteVue = new CarteVue(c);
			CarteControleur carteControleur=new CarteControleur(c,carteVue,controleur);
			carteMain.add(carteVue);
		}
		carteMain.setPreferredSize(new Dimension(800, 160));
		return carteMain;

	}
	
	
	

}
