package modele;

import java.awt.Point;

import commun.Commun;

public class TortueIntelligente extends TortueAleatoire {
	
	private Polygone champVision;

	public TortueIntelligente() {
		super();
		
		this.deployerLeChampsDeVision();
	}
	
	/**
	 * Avancer seul et en ayant un champ de vision
	 */
	public void avancerIntelligement() {
		
		this.avancerSeul();
		
		this.deployerLeChampsDeVision();
	}
	
	/**
	 * Calcul du champs de vision
	 */
	public void deployerLeChampsDeVision() {
		//Coordonnée de la tortue
		Point a = new Point(this.x, this.y);
		
		//Coordonnée du point haut gauche
		int bX = (int) (this.getX() + Commun.LONGUEUR_VUE/2*Math.cos(Commun.RATIO_DEG_RAD*(this.getDirection()-Commun.ANGLE_VUE/2)));
		int bY = (int) (this.getY() + Commun.LONGUEUR_VUE/2*Math.sin(Commun.RATIO_DEG_RAD*(this.getDirection()-Commun.ANGLE_VUE/2)));
		Point b = new Point(bX, bY);
		
		//Coordonnée du point haut centre
		int cX = (int) Math.round(x+Commun.LONGUEUR_VUE/2*Math.cos(Commun.RATIO_DEG_RAD*direction));
		int cY = (int) Math.round(y+Commun.LONGUEUR_VUE/2*Math.sin(Commun.RATIO_DEG_RAD*direction));
		Point c = new Point(cX, cY);
		
		//Coordonnée du point haut droite
		int dX = (int) (this.getX() + Commun.LONGUEUR_VUE/2*Math.cos(Commun.RATIO_DEG_RAD*(this.getDirection()+Commun.ANGLE_VUE/2)));
		int dY = (int) (this.getY() + Commun.LONGUEUR_VUE/2*Math.sin(Commun.RATIO_DEG_RAD*(this.getDirection()+Commun.ANGLE_VUE/2)));
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
