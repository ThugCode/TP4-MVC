package modele;

import java.util.ArrayList;
import java.util.Observable;

public class FeuilleDessin extends Observable{

	private ArrayList<Tortue> tortues;

	/**
	 * Constructeur
	 */
	public FeuilleDessin() {
		tortues = new ArrayList<Tortue>();
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
	 * Changer la couleur de toutes les tortues
	 */
	public void changerCouleursTortues(int couleur) {
		for (Tortue tortue : tortues) {
			tortue.setCouleur(couleur);
		}
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
	 * Réinitialiser la feuille de dessin
	 */
	public void reset() {
		for (Tortue tortue : tortues) {
			tortue.reset();
		}
	}
	
	/**
	 * Faire avancer toutes les tortues autonomes
	 */
	public void faireAvancerTortuesAutonomes() {
		for (Tortue tortue : tortues) {
			((TortueAutonome) tortue).avancer(tortues);
		}
	}
	
	/**
	 * Notifier la vue
	 */
	private void notifier() {
		setChanged();
		notifyObservers();
	}
	
	/**
	 * GETTER - SETTER
	 */
	public ArrayList<Tortue> getTortues() { return tortues; }
	
	public void setTortues(ArrayList<Tortue> tortues) {
		this.tortues = tortues;
	}
}
