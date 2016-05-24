package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.JPanel;

import commun.Commun;
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
	 * Supprimer la dernière tortue de la liste
	 */
	public void removeLastTortue() {
		tortues.remove(tortues.size()-1);
		
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
	
	/**
	 * Changer la couleur de toutes les tortues
	 */
	public void changerCouleursTortues(int couleur) {
		for (TortueVue tortueVue : tortues) {
			tortueVue.getTortue().setColor(couleur);
		}
	}
	
	/**
	 * 
	 */
	public void actionsAleatoires() {
		Random rand = new Random();
		for (TortueVue tortueVue : tortues) {
			int action = rand.nextInt(3);
			int angle = rand.nextInt(45);
			
			if(action == 0) {
				int newX = (int) Math.round(tortueVue.getTortue().getX()+angle*Math.cos(Commun.ratioDegRad*tortueVue.getTortue().getDir()));
				int newY = (int) Math.round(tortueVue.getTortue().getY()+angle*Math.sin(Commun.ratioDegRad*tortueVue.getTortue().getDir()));
				if(newX < Commun.LARGEURFEUILLE && newY < Commun.HAUTEURFEUILLE
				&& newX > 0 && newY > 0)
					tortueVue.getTortue().avancer(angle);
				else {
					tortueVue.getTortue().droite(180);
					tortueVue.getTortue().avancer(angle);
				}
			} else if(action == 1)
				tortueVue.getTortue().droite(angle);
			else
				tortueVue.getTortue().gauche(angle);
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
