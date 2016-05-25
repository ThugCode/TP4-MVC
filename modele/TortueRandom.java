package modele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import commun.Commun;

/**
 * @author GERLAND - LETOURNEUR
 */
public class TortueRandom extends Tortue {

	protected int vitesse;

	/**
	 * Constructeur
	 */
	public TortueRandom() { 
		listSegments = new ArrayList<Segment>();
		coul = 0;
		reset();
	}

	/**
	 * Réinitialiser la tortue
	 */
	public void reset() {
		
		super.reset();
		
		Random rand = new Random();
		x = rand.nextInt(Commun.LARGEURFEUILLE);
		y = rand.nextInt(Commun.HAUTEURFEUILLE);
		vitesse = rand.nextInt(60);
		dir = rand.nextInt(360)+1;
		
		notifier();
  	}
	
	public void avancerSeul() {
		
		this.avancer(this.vitesse);
		
		this.setPosition(
				Math.floorMod(this.getX(), Commun.LARGEURFEUILLE),
				Math.floorMod(this.getY(), Commun.HAUTEURFEUILLE));
		
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
