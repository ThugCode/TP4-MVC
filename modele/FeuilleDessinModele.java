package modele;

import java.util.ArrayList;
import java.util.Observable;

public class FeuilleDessinModele extends Observable{

	private ArrayList<Tortue> tortues;

	public FeuilleDessinModele() {
		tortues = new ArrayList<Tortue>();
	}
	
	/**
	 * Changer la couleur de toutes les tortues
	 */
	public void changerCouleursTortues(int couleur) {
		for (Tortue tortue : tortues) {
			tortue.setColor(couleur);
		}
	}
	
	/**
	 * Ajouter une tortue sur la feuille de dessin
	 * @param o
	 */
	public void addTortue(Tortue o) {
		tortues.add(o);
		
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Supprimer la dernière tortue de la liste
	 */
	public void removeLastTortue() {
		tortues.remove(tortues.size()-1);	
		
		setChanged();
		notifyObservers();
	}
	
	/**
	 * 
	 */
	public void faireAvancerTortues() {
		for (Tortue tortue : tortues) {
			((TortueRandom) tortue).avancerSeul();
		}
	}
	
	public void faireAvancerTortuesSmart() {
		for (Tortue tortue : tortues) {
			((TortueSmart) tortue).avancerSmart(this.tortues);
		}
	}
	
	public ArrayList<Tortue> getTortues() {
		return tortues;
	}

	public void setTortues(ArrayList<Tortue> tortues) {
		this.tortues = tortues;
	}
}
