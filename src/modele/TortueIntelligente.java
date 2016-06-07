package src.modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import src.commun.Commun;

public class TortueIntelligente extends TortueAleatoire {
	
	private TriangleVision champVision;

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
		
		return this.getChampVision().verifierDroiteAB(t)					//Verifie la droite AB
				&& this.getChampVision().verifierDroiteAD(t)				//Vérifie la droite AC
				&& distanceAutreTortue(autreTortue) <= Commun.LONGUEUR_VUE;	//Vérifie l'arc de cercle BC
	}

	/**
	 * Avancer seul et en ayant un champ de vision
	 */
	public void avancer(ArrayList<Tortue> autresTortues) {
		
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
			
			//Si la distance d'une autre tortue est trop faible,
			//La tortue s'arrete
			if(distancePlusProche < Commun.DISTANCE_MINIMUM) {
				vitesseAutre = 0;
			}
			
			this.setDirection(directionAutre);
			this.setVitesse(vitesseAutre);
		}
		
		//Si la tortue ne voit aucune autre tortue
		//elle peut faire varier légerement sa vitesse et sa direction
		if(listeTortuesVisibles.size() == 1) {
			Random rand = new Random();
			vitesse += rand.nextInt(5)-2;
			if(vitesse > Commun.VITESSE_MAXIMUM) vitesse = Commun.VITESSE_MAXIMUM;
			if(vitesse <= 0) vitesse = 1;
			direction += rand.nextInt(10)-5;
		}
		
		super.avancer(autresTortues);
		
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
		
		//Coordonnée du point haut droite
		int cX = (int) (this.getX() + Commun.LONGUEUR_VUE*Math.cos(Commun.RATIO_DEG_RAD*(this.getDirection()+Commun.ANGLE_VUE/2)));
		int cY = (int) (this.getY() + Commun.LONGUEUR_VUE*Math.sin(Commun.RATIO_DEG_RAD*(this.getDirection()+Commun.ANGLE_VUE/2)));
		Point c = new Point(cX, cY);
		
		champVision = new TriangleVision(a, b, c);
	}

	/************
	 * GETTER
	 ************/
	
	public TriangleVision getChampVision() { return champVision; }
	
	/************
	 * SETTER
	 ************/

	public void setChampVision(TriangleVision champVision) {
		this.champVision = champVision;
	}
}
