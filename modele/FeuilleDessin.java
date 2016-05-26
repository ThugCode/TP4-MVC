package modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;

public class FeuilleDessin extends Observable{

	private ArrayList<Tortue> tortues;

	public FeuilleDessin() {
		tortues = new ArrayList<Tortue>();
	}
	
	/**
	 * Notifier la vue
	 */
	private void notifier() {
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Changer la couleur de toutes les tortues
	 */
	public void changerCouleursTortues(int couleur) {
		for (Tortue tortue : tortues) {
			tortue.setCouleur(couleur);
		}
	}
	
	/**
	 * Ajouter une tortue sur la feuille de dessin
	 * @param o
	 */
	public void ajouterTortue(Tortue tortue) {
		tortues.add(tortue);
		notifier();
	}
	
	/**
	 * Supprimer la dernière tortue de la liste
	 */
	public void retirerDerniereTortue() {
		
		if(tortues.size() > 0)
			tortues.remove(tortues.size()-1);
		notifier();
	}
	
	/**
	 * 
	 */
	public void reset() {
		for (Tortue tortue : tortues) {
			tortue.reset();
		}
	}
	
	/**
	 * 
	 */
	public void faireAvancerTortues() {
		for (Tortue tortue : tortues) {
			((TortueAleatoire) tortue).avancerSeul();
		}
	}
	
	/**
	 * 
	 */
	public void faireAvancerTortuesIntelligentes() {
		
		ArrayList<Tortue> listesTortue = new ArrayList<Tortue>();
		for (Tortue tortue : tortues) {
			
			listesTortue.clear();
			
			for (Tortue autreTortue : tortues) {
				
				if(tortue.equals(autreTortue)) continue;
				
				if(((TortueIntelligente) tortue).getChampVision().estDansLePolygone(new Point(autreTortue.getX(), autreTortue.getY()))) {
					listesTortue.add(autreTortue);
				}
			}
			
			if(listesTortue.size() > 0) {
				int cpt = 0;
				int directionAutre = 0;
				int vitesseAutre = 0;
				for(Tortue tortueASuivre : listesTortue) {
					cpt++;
					directionAutre += tortueASuivre.getDirection();
					vitesseAutre += tortueASuivre.getVitesse();
				}
				directionAutre /= cpt;
				vitesseAutre /= cpt;
				
				tortue.setDirection(directionAutre);
				tortue.setVitesse(vitesseAutre);
			}
			
			((TortueIntelligente) tortue).avancerIntelligement();
		}
	}
	
	public ArrayList<Tortue> getTortues() {
		return tortues;
	}

	public void setTortues(ArrayList<Tortue> tortues) {
		this.tortues = tortues;
	}
}
