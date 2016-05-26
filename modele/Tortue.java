package modele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;

import commun.Commun;

/**
 * @author GERLAND - LETOURNEUR
 */
public class Tortue extends Observable {

	protected int x, y;							//Coordonées
	protected int direction;					//Direction entre -360 et 360
	protected boolean crayon;					//Crayon baissé ou levé
	protected int couleur;
	protected int vitesse;
	protected ArrayList<Segment> listeSegments;

	/**
	 * Constructeur
	 */
	public Tortue() {
		couleur = 0;
		listeSegments = new ArrayList<Segment>();
		reset();
	}

	/**
	 * Réinitialiser la tortue
	 */
	public void reset() {
		x = Commun.LARGEUR_FEUILLE/2;
		y = Commun.HAUTEUR_FEUILLE/2;
		direction = -90;
		crayon = true;
		listeSegments.clear();
		
		notifier();
  	}
	
	/**
	 * Notifier la vue avec un Graphics g
	 * @param g
	 */
	public void notifier(Graphics g) {
		setChanged();
		notifyObservers(g);
	}
	
	/**
	 * Notifier la vue
	 */
	protected void notifier() {
		setChanged();
		notifyObservers();
	}

	/**
	 * Setter de la position
	 * @param newX
	 * @param newY
	 */
	public void setPosition(int newX, int newY) {
		x = newX;
		y = newY;
		
		notifier();
	}
	
	/**
	 * Associe une couleur de la classe Color à un integer
	 * @param c
	 * @return Color
	 */
	public Color decodeColor(int c) {
		switch(c) {
			case 0: return(Color.black);
			case 1: return(Color.blue);
			case 2: return(Color.cyan);
			case 3: return(Color.darkGray);
			case 4: return(Color.red);
			case 5: return(Color.green);
			case 6: return(Color.lightGray);
			case 7: return(Color.magenta);
			case 8: return(Color.orange);
			case 9: return(Color.gray);
			case 10: return(Color.pink);
			case 11: return(Color.yellow);
			default : return(Color.black);
		}
	}

	/**
	 * Avancer la tortue de la distance passée en paramêtre
	 * @param dist
	 */
	public void avancer(int dist) {
		
		//Coordonnées du point d'arrivé
		int newX = (int) Math.round(x+dist*Math.cos(Commun.RATIO_DEG_RAD*direction));
		int newY = (int) Math.round(y+dist*Math.sin(Commun.RATIO_DEG_RAD*direction));
		
		if (crayon) {
			Segment seg = new Segment();
			
			seg.getPtStart().x = x;
			seg.getPtStart().y = y;
			seg.getPtEnd().x = newX;
			seg.getPtEnd().y = newY;
			seg.setColor(decodeColor(couleur));
	
			listeSegments.add(seg);
		}

		x = newX;
		y = newY;
		
		notifier();
	}

	/**
	 * Tourner à droite la tortue
	 * @param ang
	 */
	public void droite(int ang) {
		direction = (direction + ang) % 360;
		notifier();
	}

	/**
	 * Tourner à gauche la tortue
	 * @param ang
	 */
	public void gauche(int ang) {
		direction = (direction - ang) % 360;
		notifier();
	}

	/**
	 * Baisser le crayon sur la feuille pour écrire
	 */
	public void baisserCrayon() {
		crayon = true;
		notifier();
	}

	/**
	 * Lever le crayon de la feuille pour ne plus écrire
	 */
	public void leverCrayon() {
		crayon = false;
		notifier();
	}

	/**
	 * Retourne l'entier modulo 12
	 * @param n
	 */
	public void couleur(int n) {
		couleur = n % 12;
		notifier();
	}

	/**
	 * Incrémente la couleur de 1
	 */
	public void couleurSuivante() {
	 	couleur(couleur+1);
	 	notifier();
	}
	
	/**
	 * Trace un carré
	 */
	public void carre() {
		for (int i=0;i<4;i++) {
			avancer(100);
			droite(90);
		}
	}

	/**
	 * Trace un polygone
	 * @param n
	 * @param a
	 */
	public void poly(int n, int a) {
		for (int j=0;j<a;j++) {
			avancer(n);
			droite(360/a);
		}
	}

	/**
	 * Trace une spiral en changeant de couleur
	 * pour chaque segment
	 * @param n
	 * @param k
	 * @param a
	 */
	public void spiral(int n, int k, int a) {
		int colorBefore = couleur;
		for (int i = 0; i < k; i++) {
			couleur(couleur+1);
			avancer(n);
			droite(360/a);
			n = n+1;
		}
		couleur = colorBefore;
	}
	
	/************
	 * GETTER
	 ************/
	
	public ArrayList<Segment> getListSegments() { return listeSegments; }

	public int getX() { return x; }
	
	public int getY() { return y; }
	
	public int getDirection() { return direction; }
	
	public int getCouleur() {return couleur;}
	
	public int getVitesse() { return vitesse; }
	
	/************
	 * SETTER
	 ************/
	
	public void setCouleur(int n) {
		couleur = n;
		notifier();
	}
	
	public void setDirection(int dir) {
		this.direction = dir;
	}
	
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
}
