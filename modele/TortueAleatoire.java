package modele;

import java.util.Random;

import commun.Commun;

/**
 * @author GERLAND - LETOURNEUR
 */
public class TortueAleatoire extends Tortue {

	protected int vitesse;

	/**
	 * Constructeur
	 */
	public TortueAleatoire() { 
		super();
	}

	/**
	 * Réinitialiser la tortue
	 */
	public void reset() {
		
		super.reset();
		
		Random rand = new Random();
		x = rand.nextInt(Commun.LARGEUR_FEUILLE);
		y = rand.nextInt(Commun.HAUTEUR_FEUILLE);
		vitesse = rand.nextInt(60);
		direction = rand.nextInt(360)+1;
		
		notifier();
  	}
	
	/**
	 * Avancer la tortue grâce à sa vitesse
	 */
	public void avancerSeul() {
		
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
