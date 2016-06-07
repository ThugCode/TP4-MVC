package src.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import src.modele.*;

/**
 * @author GERLAND - LETOURNEUR
 */
public class FeuilleDessinVue extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<TortueVue> tortues;
	private FormeVue formeCourante;
	private FeuilleDessin dessin;

	/**
	 * Constructeur
	 */
	public FeuilleDessinVue(FeuilleDessin dessin) {
		tortues = new ArrayList<TortueVue>();
		formeCourante = new FormeHexaVue();
		this.dessin = dessin;
		this.dessin.addObserver(this);
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

		dessinerTortues(g);
	}
	
	/**
	 * Ajouter une tortue sur la feuille de dessin
	 * @param o
	 */
	public void ajouterTortue(Tortue tortue) {
		TortueVue tortueVue = new TortueVue(tortue, formeCourante);
		tortue.addObserver(this);
		tortues.add(tortueVue);
		dessin.ajouterTortue(tortue);
	}
	
	/**
	 * Supprimer la dernière tortue de la liste
	 */
	public void retirerDerniereTortue() {
		
		if(tortues.size() > 0)
			tortues.remove(tortues.size()-1);
	}
	
	/**
	 * Appel de chaque tortue pour l'afficher
	 * @param g
	 */
	private void dessinerTortues(Graphics g) {
		
		//Copie de la liste pour éviter les erreurs "check for comodification"
		ArrayList<TortueVue> tortuesAffichages = new ArrayList<TortueVue>(tortues);
		
		for(TortueVue tortueVue : tortuesAffichages) {
			tortueVue.dessinerTortue(g);
		}
	}
	
	/**
	 * Changer la forme des tortues
	 * @param forme
	 */
	public void changerFormeTortues(FormeVue forme) {
		formeCourante = forme;
		for(TortueVue tortueVue : tortues) {
			tortueVue.setForme(forme);
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