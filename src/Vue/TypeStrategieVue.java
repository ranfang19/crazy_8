package Vue;
import Controleur.PartieControleur;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Controleur.PartieControleur;
import Modele.Partie.Partie;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Vue pour choisir le type de strategie
 * @see TypeStrategieVue
 */
public class TypeStrategieVue {

	private JFrame frame;
	private PartieControleur controleur;
	private Partie partie;

	/**
	 * Create the application.
	 */
	
	public TypeStrategieVue(PartieControleur controleur, Partie partie) {
		initialize();
		this.controleur = controleur;
		this.partie = partie;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblChoisissezLeNiveau = new JLabel("Choisissez le niveau de difficult\u00E9 :");
		lblChoisissezLeNiveau.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblChoisissezLeNiveau.setBounds(31, 45, 387, 49);
		frame.getContentPane().add(lblChoisissezLeNiveau);
		
		JButton btnFacile = new JButton("Facile");
		btnFacile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				controleur.setTypeStrategie(1);
				controleur.initialiserPartie();
				Plateau plateau = new Plateau(controleur, partie);
			}
		});
		btnFacile.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnFacile.setBounds(93, 131, 91, 35);
		frame.getContentPane().add(btnFacile);
		
		JButton btnMoyen = new JButton("Moyen");
		btnMoyen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				controleur.setTypeStrategie(2);
				controleur.initialiserPartie();
				Plateau plateau = new Plateau(controleur, partie);
			}
		});
		btnMoyen.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnMoyen.setBounds(246, 131, 91, 35);
		frame.getContentPane().add(btnMoyen);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TypeVarianteVue window = new TypeVarianteVue(controleur,partie);
				frame.setVisible(false);
			}
		});
		btnRetour.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnRetour.setBounds(173, 202, 89, 23);
		frame.getContentPane().add(btnRetour);
		
		frame.setVisible(true);
	}

}
