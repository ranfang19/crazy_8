package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import Controleur.PartieControleur;
import Modele.Partie.Partie;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;

/**
 * Vue pour choisir le nombre des joueurs
 * @see NombreJoueurVue
 */
public class NombreJoueurVue{

	private JFrame frame2;
	private PartieControleur controleur;
	private Partie partie;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NombreJoueurVue window = new NombreJoueurVue();
					window.frame2.setVisible(true);
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
	public NombreJoueurVue(PartieControleur controleur, Partie partie) {
		this.controleur = controleur;
		this.partie = partie;
		initialize();
	}

	/**
	 * Initialize the contents of the frame2.
	 */
	private void initialize() {
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 550, 335);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JLabel lblChoisissezLeNombre = new JLabel("Choisissez le nombre de joueurs :");
		lblChoisissezLeNombre.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblChoisissezLeNombre.setBounds(65, 48, 421, 36);
		frame2.getContentPane().add(lblChoisissezLeNombre);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(4, 2, 6, 1));
		spinner.setFont(new Font("Calibri", Font.PLAIN, 28));
		spinner.setBounds(242, 149, 54, 45);
		frame2.getContentPane().add(spinner);
		
		JButton btnSuivant = new JButton("Suivant");
		btnSuivant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int value = (Integer) spinner.getValue();
				controleur.setNombreJoueurs(value);
				TypeVarianteVue window = new TypeVarianteVue(controleur, partie);
				frame2.setVisible(false);
				
			}
		});
		btnSuivant.setForeground(new Color(100, 149, 237));
		btnSuivant.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSuivant.setBounds(206, 221, 123, 35);
		frame2.getContentPane().add(btnSuivant);
		
		frame2.setVisible(true);
	}

}
