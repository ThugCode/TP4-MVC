package modele;

import java.util.ArrayList;
import java.util.Random;

import commun.Commun;

/**
 * @author GERLAND - LETOURNEUR
 */
public class TortueAleatoire extends Tortue implements TortueAutonome {

	protected int vitesse;

	/**
	 * Constructeur
	 */
	public TortueAleatoire() { 
		super();
	}

	/**
	 * Réinitialiser la tortue
	 * et affecter une vitesse et une direction aléatoire 
	 */
	public void reset() {
		
		super.reset();
		
		Random rand = new Random();
		x = rand.nextInt(Commun.LARGEUR_FEUILLE);
		y = rand.nextInt(Commun.HAUTEUR_FEUILLE);
		vitesse = rand.nextInt(Commun.VITESSE_MAXIMUM);
		direction = rand.nextInt(360)+1;
		
		notifier();
  	}
	
	/**
	 * Avancer la tortue grâce à sa vitesse
	 */
	public void avancer(ArrayList<Tortue> autresTortues) {
		
		this.avancer(this.vitesse);
		
		//La position reste dans l'écran
		this.setPosition(
				Math.floorMod(this.getX(), Commun.LARGEUR_FEUILLE),
				Math.floorMod(this.getY(), Commun.HAUTEUR_FEUILLE));
		
		notifier();
	}
	
	/************
	 * GETTER
	 ************/
	
	public int getVitesse() { return vitesse; }
	
	/************
	 * SETTER
	 ************/
	
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
}
