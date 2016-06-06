package modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import commun.Commun;

public class TortueIntelligente extends TortueAleatoire {
	
	private Polygone champVision;

	/**
	 * Constructeur
	 */
	public TortueIntelligente() {
		super();
		
		this.deployerLeChampsDeVision();
	}
	
	/**
	 * Calcul de la distance avec une autre tortue
	 * @param autreTortue
	 * @return
	 */
	public float distanceAutreTortue(Tortue autreTortue) {
		
		return (float) Math.sqrt(Math.pow(autreTortue.getX()-this.getX(), 2) + Math.pow(autreTortue.getY()-this.getY(),2));
	}
	
	/**
	 * Verifie si la tortue autreTortue est dans le champs de vision
	 * @param x
	 * @return
	 */
	public boolean estDansMonChampsDeVision(Tortue autreTortue) {
		
		Point t = new Point(autreTortue.getX(), autreTortue.getY());
		
		return this.getChampVision().verifierDroiteAB(t) 
				&& this.getChampVision().verifierDroiteAD(t)
				&& distanceAutreTortue(autreTortue) <= Commun.LONGUEUR_VUE;
	}

	/**
	 * Avancer seul et en ayant un champ de vision
	 */
	public void avancerIntelligement(ArrayList<Tortue> autresTortues) {
		
		ArrayList<Tortue> listeTortuesVisibles = new ArrayList<Tortue>();
		
		for (Tortue autreTortue : autresTortues) {
			if(this.equals(autreTortue)) continue;
			if(this.estDansMonChampsDeVision(autreTortue)) {
				listeTortuesVisibles.add(autreTortue);
			}
		}
		listeTortuesVisibles.add(this);
		
		float temp = 0;
		float distancePlusProche = Float.MAX_VALUE;
		
		//Prendre la direction et vitesse moyenne des tortues visibles
		if(listeTortuesVisibles.size() > 0) {
			int cpt = 0;
			int directionAutre = 0;
			int vitesseAutre = 0;
			for(Tortue tortueASuivre : listeTortuesVisibles) {
				cpt++;
				directionAutre += tortueASuivre.getDirection();
				vitesseAutre += tortueASuivre.getVitesse();
				
				if(this.equals(tortueASuivre)) continue;
				temp = this.distanceAutreTortue(tortueASuivre);
				if(temp<distancePlusProche) {
					distancePlusProche = temp;
				}
			}
			directionAutre /= cpt;
			vitesseAutre /= cpt;
			
			if(distancePlusProche < Commun.DISTANCE_MINIMUM) {
				vitesseAutre = 0;
			}
			
			this.setDirection(directionAutre);
			this.setVitesse(vitesseAutre);
		}
		
		//Si la tortue ne voit aucune autre tortue
		if(listeTortuesVisibles.size() == 1) {
			Random rand = new Random();
			vitesse += rand.nextInt(5)-2;
			if(vitesse > Commun.VITESSE_MAXIMUM) vitesse = Commun.VITESSE_MAXIMUM;
			if(vitesse <= 0) vitesse = 1;
			direction += rand.nextInt(10)-5;
		}
		
		this.avancer();
		
		this.deployerLeChampsDeVision();
	}
	
	/**
	 * Calcul du champs de vision
	 */
	public void deployerLeChampsDeVision() {
		//Coordonnée de la tortue
		Point a = new Point(this.x, this.y);
		
		//Coordonnée du point haut gauche
		int bX = (int) (this.getX() + Commun.LONGUEUR_VUE*Math.cos(Commun.RATIO_DEG_RAD*(this.getDirection()-Commun.ANGLE_VUE/2)));
		int bY = (int) (this.getY() + Commun.LONGUEUR_VUE*Math.sin(Commun.RATIO_DEG_RAD*(this.getDirection()-Commun.ANGLE_VUE/2)));
		Point b = new Point(bX, bY);
		
		//Coordonnée du point haut centre
		int cX = (int) Math.round(x+Commun.LONGUEUR_VUE*Math.cos(Commun.RATIO_DEG_RAD*direction));
		int cY = (int) Math.round(y+Commun.LONGUEUR_VUE*Math.sin(Commun.RATIO_DEG_RAD*direction));
		Point c = new Point(cX, cY);
		
		//Coordonnée du point haut droite
		int dX = (int) (this.getX() + Commun.LONGUEUR_VUE*Math.cos(Commun.RATIO_DEG_RAD*(this.getDirection()+Commun.ANGLE_VUE/2)));
		int dY = (int) (this.getY() + Commun.LONGUEUR_VUE*Math.sin(Commun.RATIO_DEG_RAD*(this.getDirection()+Commun.ANGLE_VUE/2)));
		Point d = new Point(dX, dY);
		
		champVision = new Polygone(a, b, c, d);
	}

	/************
	 * GETTER
	 ************/
	
	public Polygone getChampVision() { return champVision; }
	
	/************
	 * SETTER
	 ************/

	public void setChampVision(Polygone champVision) {
		this.champVision = champVision;
	}
}
