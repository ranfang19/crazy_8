package Vue;
import javax.swing.JButton;
import java.util.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Modele.Carte.Carte;;

/**
 * Vue pour la carte avec des images
 * @see CarteVue
 *
 */
public class CarteVue extends JPanel implements Observer{

	private Image image;
	private JPanel carteMe;
	private static Carte uneCarte;


	public CarteVue(Carte carte) {
		this.uneCarte=carte;
		try{

            this.image = ImageIO.read(new File(("src/resources/"+carte.getCouleur()+"-"+carte.getValeur()+".gif")));
        } catch (IOException ex) {
            Logger.getLogger(CarteVue.class.getName()).log(Level.SEVERE, null, ex);
        }
		this.carteMe = this;
		this.setPreferredSize(new Dimension(79, 116));
		
		
	}

	
	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }


	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}