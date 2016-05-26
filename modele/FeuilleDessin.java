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
		for (Tortue tortue : tortues) {
			for (Tortue autreTortue : tortues) {
				
				if(tortue.equals(autreTortue)) continue;
				
				if(((TortueIntelligente) tortue).getChampVision().estDansLePolygone(new Point(autreTortue.getX(), autreTortue.getY()))) {
					
				}
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
