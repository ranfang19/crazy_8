package Vue;
import Controleur.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

import Modele.Carte.*;

/**
 * Vue pour la carte 8
 * @see Carte8
 *
 */
public class Carte8Vue {

	public JFrame frame;
	private PartieControleur controleur;
	public Carte8Vue(PartieControleur controleur) {
		initialize();
		this.controleur = controleur;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);//
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("Vous pouvez changer la couleur");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));

		JButton btnNewButtonPic = new JButton("");
		btnNewButtonPic.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButtonPic.setIcon(new ImageIcon(Carte8Vue.class.getResource("/resources/Pic.jpg")));
		btnNewButtonPic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controleur.choisirCouleur(0);//
				frame.setVisible(false);//
 
			}
		});

		JButton btnNewButtonCoeur = new JButton("");
		btnNewButtonCoeur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controleur.choisirCouleur(1);//
				frame.setVisible(false);//

			}
		});
		btnNewButtonCoeur.setIcon(new ImageIcon(Carte8Vue.class.getResource("/resources/Coeur.jpg")));

		JButton btnNewButtonCarreau = new JButton("");
		btnNewButtonCarreau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controleur.choisirCouleur(2);//
				frame.setVisible(false);//

			}
		});
		btnNewButtonCarreau.setIcon(new ImageIcon(Carte8Vue.class.getResource("/resources/Carreau.jpg")));

		JButton btnNewButtonTrefle = new JButton("");
		btnNewButtonTrefle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controleur.choisirCouleur(3);//
				frame.setVisible(false);//

			}
		});
		btnNewButtonTrefle.setIcon(new ImageIcon(Carte8Vue.class.getResource("/resources/Trefle.jpg")));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(89)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButtonCarreau, 0, 0, Short.MAX_VALUE).addComponent(btnNewButtonPic,
										GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGap(53)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButtonTrefle, 0, 0, Short.MAX_VALUE).addComponent(btnNewButtonCoeur,
										GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
						.addGap(87))
				.addGroup(Alignment.TRAILING,
						groupLayout.createSequentialGroup().addContainerGap(106, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
								.addGap(100)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(18).addComponent(lblNewLabel).addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButtonCoeur, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButtonPic, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButtonCarreau, 0, 0, Short.MAX_VALUE)
						.addComponent(btnNewButtonTrefle, GroupLayout.PREFERRED_SIZE, 106, Short.MAX_VALUE))
				.addContainerGap(15, Short.MAX_VALUE)));
		frame.getContentPane().setLayout(groupLayout);
		

		frame.setVisible(true);//
	}

}
