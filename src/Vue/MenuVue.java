package Vue;
import Controleur.PartieControleur;
import Modele.Partie.Partie;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Vue du menu
 * @see MenuVue
 */
public class MenuVue{

	private JFrame frame;
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
					MenuVue window = new MenuVue();
					window.frame.setVisible(true);
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
	public MenuVue(PartieControleur controleur, Partie partie) {
		initialize();
		this.controleur = controleur;
		this.partie = partie;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 335);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblBienvenueSurLe = new JLabel("Bienvenue sur le jeu du Américain !");
		lblBienvenueSurLe.setBounds(33, 45, 461, 66);
		lblBienvenueSurLe.setFont(new Font("Dialog", Font.PLAIN, 25));
		frame.getContentPane().add(lblBienvenueSurLe);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NombreJoueurVue nombreJoueurVue = new NombreJoueurVue(controleur,partie);//
				frame.setVisible(false);
			}
		});

		btnStart.setForeground(new Color(100, 149, 237));
		btnStart.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnStart.setBounds(184, 165, 101, 36);
		frame.getContentPane().add(btnStart);

		frame.setVisible(true);
	}
}
