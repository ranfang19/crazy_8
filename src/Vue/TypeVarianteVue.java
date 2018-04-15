package Vue;
import Controleur.PartieControleur;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Modele.Partie.Partie;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
/**
 * Vue pour choisir la variante
 * @see TypeVarianteVue
 */
public class TypeVarianteVue {

	private JFrame frame;
	private PartieControleur controleur;
	private Partie partie;


	/**
	 * Create the application.
	 */
	public TypeVarianteVue(PartieControleur controleur, Partie partie) {
		
		this.controleur=controleur;
		this.partie = partie;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblChoisissezUneVariante = new JLabel("Choisissez une Variante :");
		lblChoisissezUneVariante.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblChoisissezUneVariante.setBounds(59, 33, 326, 36);
		frame.getContentPane().add(lblChoisissezUneVariante);

		JButton btnMinimale = new JButton("Minimale");
		btnMinimale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMinimale.setToolTipText(
						"<html>" + "10 : Oblige à rejouer" + "<br>8 : Permet de changer la couleur" + "<html>"); //
			}
		});
		btnMinimale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				controleur.setTypeVariante(1);
				TypeStrategieVue typeStrategieVue=new TypeStrategieVue(controleur, partie);

			}
		});
		btnMinimale.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnMinimale.setBounds(45, 125, 111, 35);
		frame.getContentPane().add(btnMinimale);

		JButton btnRan = new JButton("Ran");
		btnRan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRan.setToolTipText("<html>" + "10 : Oblige à rejouer" + "<br>8 : Permet de changer la couleur"
						+ "<br>7 : Le joueur suivant passe son tour" + "<br>Valet : Changement de sens" + "<html>");
			}
		});
		btnRan.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnRan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				controleur.setTypeVariante(2);
				TypeStrategieVue typeStrategieVue=new TypeStrategieVue(controleur, partie);
			}
		});
		btnRan.setBounds(166, 125, 110, 35);
		frame.getContentPane().add(btnRan);

		JButton btnAlexis = new JButton("Alexis");
		btnAlexis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAlexis.setToolTipText("<html>" + "10 : Oblige à rejouer" + "<br>8 : Permet de changer la couleur"
						+ "<br>7 : Le joueur suivant passe son tour" + "<br>Valet : Changement de sens"
						+ "<br>2 : Le joueur suivant pioche 2 cartes" + "<html>"); //
			}
		});
		btnAlexis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				controleur.setTypeVariante(3);
				TypeStrategieVue typeStrategieVue=new TypeStrategieVue(controleur,partie);

			}
		});
		btnAlexis.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnAlexis.setBounds(286, 125, 111, 35);
		frame.getContentPane().add(btnAlexis);

		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NombreJoueurVue window = new NombreJoueurVue(controleur, partie);//
				frame.setVisible(false);
			}
		});
		btnRetour.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnRetour.setBounds(179, 207, 89, 23);
		frame.getContentPane().add(btnRetour);

		frame.setVisible(true);
	}

}
