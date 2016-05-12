package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import modele.Tortue;

/**
 * @author GERLAND - LETOURNEUR
 */
public class FeuilleDessinVue extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<TortueVue> tortues;

	/**
	 * Constructeur
	 */
	public FeuilleDessinVue() {
		tortues = new ArrayList<TortueVue>();
	}
	
	/**
	 * Affichage de la feuille de dessin avec les tortues
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Color c = g.getColor();
		
		Dimension dim = getSize();
		g.setColor(Color.white);
		g.fillRect(0,0,dim.width, dim.height);
		g.setColor(c);

		showTurtles(g);
	}
	
	/**
	 * Ajouter une tortue sur la feuille de dessin
	 * @param o
	 */
	public void addTortue(Tortue o) {
		TortueCercleVue tortueVue = new TortueCercleVue(o);
		tortues.add(tortueVue);
		o.addObserver(this);
		
		this.repaint();
	}
	
	/**
	 * Appel de chaque tortue pour l'afficher
	 * @param g
	 */
	public void showTurtles(Graphics g) {
		for(TortueVue tortueVue : tortues) {
			tortueVue.drawTurtle(g);
		}
	}

	/**
	 * Réinitialisation des tortues
	 */
	public void reset() {
		for (TortueVue tortueVue : tortues) {
			tortueVue.getTortue().reset();
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.repaint();
	}
	
	public ArrayList<TortueVue> getTortues() {
		return tortues;
	}
}
