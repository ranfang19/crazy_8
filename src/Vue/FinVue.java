package Vue;
import Modele.Joueur.*;
import java.util.*;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * Vue pour la fin
 * @see FinVue
 *
 */
public class FinVue {

	private JFrame frame;
	private JLabel txtMessage1;

	

	/**
	 * Create the application.
	 */
	public FinVue(ArrayList<Joueur> listeJoueurs, ArrayList<Integer> listeDesScores)  {
		initialize(listeJoueurs, listeDesScores);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Joueur> listeJoueurs, ArrayList<Integer> listeDesScores) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 558, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);///
		ArrayList<String> listeMessage = new ArrayList<String>();
		for (int i = 0; i < 6 ; i++) {
			String message = "";
			listeMessage.add(message);
		}
		
		for (int i = 0; i < listeJoueurs.size(); i++) {
			String message = "";
			String ligne = listeJoueurs.get(i).getNom() + " a un score de " + listeDesScores.get(i);
			listeMessage.remove(i);
			listeMessage.add(i,ligne);
		}
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FinVue.class.getResource("/resources/congratulations.png")));
		
		txtMessage1 = new JLabel();
		txtMessage1.setText(listeMessage.get(0));
		

		

		
		JLabel txtMessage2 = new JLabel(listeMessage.get(1));
		
		JLabel txtMessage3 = new JLabel(listeMessage.get(2));
		
		JLabel txtMessage4 = new JLabel(listeMessage.get(3));
		
		JLabel lblNewLabel_1 = new JLabel(listeMessage.get(5));
		
		JLabel txtMessage5 = new JLabel(listeMessage.get(4));

		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(104)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 128, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(159)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtMessage2, GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
								.addComponent(txtMessage1, GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
								.addComponent(txtMessage3, GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
								.addComponent(txtMessage4, GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMessage5, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtMessage1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(txtMessage2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtMessage3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtMessage4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtMessage5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);

	}
}
