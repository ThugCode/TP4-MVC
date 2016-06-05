package modele;

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
	 * Réinitialiser la feuille de dessin
	 */
	public void reset() {
		for (Tortue tortue : tortues) {
			tortue.reset();
		}
	}
	
	/**
	 * Faire avancer toutes les tortues aléatoires
	 */
	public void faireAvancerTortuesAleatoires() {
		for (Tortue tortue : tortues) {
			((TortueAleatoire) tortue).avancer();
		}
	}
	
	/**
	 * Faire avancer toutes les tortues intelligentes
	 */
	public void faireAvancerTortuesIntelligentes() {
		for (Tortue tortue : tortues) {
			((TortueIntelligente) tortue).avancerIntelligement(tortues);
		}
	}
	
	public ArrayList<Tortue> getTortues() {
		return tortues;
	}

	public void setTortues(ArrayList<Tortue> tortues) {
		this.tortues = tortues;
	}
}
