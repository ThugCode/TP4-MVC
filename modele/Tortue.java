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

	protected ArrayList<Segment> listSegments;
	protected int x, y;	
	protected int dir;	
	protected boolean crayon; 
	protected int coul;
	
	/**
	 * Constructeur
	 */
	public Tortue() { 
		listSegments = new ArrayList<Segment>();
		coul = 0;
		reset();
	}

	/**
	 * Réinitialiser la tortue
	 */
	public void reset() {
		x = 0;
		y = 0;
		dir = -90;
		crayon = true;
		listSegments.clear();
		
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
	public void notifier() {
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
		
		int newX = (int) Math.round(x+dist*Math.cos(Commun.ratioDegRad*dir));
		int newY = (int) Math.round(y+dist*Math.sin(Commun.ratioDegRad*dir));
		
		if (crayon) {
			Segment seg = new Segment();
			
			seg.getPtStart().x = x;
			seg.getPtStart().y = y;
			seg.getPtEnd().x = newX;
			seg.getPtEnd().y = newY;
			seg.setColor(decodeColor(coul));
	
			listSegments.add(seg);
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
		dir = (dir + ang) % 360;
		notifier();
	}

	/**
	 * Tourner à gauche la tortue
	 * @param ang
	 */
	public void gauche(int ang) {
		dir = (dir - ang) % 360;
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
		coul = n % 12;
		notifier();
	}

	/**
	 * Incrémente la couleur de 1
	 */
	public void couleurSuivante() {
	 	couleur(coul+1);
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
		for (int i = 0; i < k; i++) {
			couleur(coul+1);
			avancer(n);
			droite(360/a);
			n = n+1;
		}
	}
	
	/************
	 * GETTER
	 ************/
	
	public ArrayList<Segment> getListSegments() { return listSegments; }

	public int getX() { return x; }
	
	public int getY() { return y; }
	
	public int getDir() { return dir; }
	
	public int getColor() {return coul;}
	
	/************
	 * SETTER
	 ************/
	
	public void setColor(int n) {
		coul = n;
		notifier();
	}
}
