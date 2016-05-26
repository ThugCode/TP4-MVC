package modele;

import java.awt.Point;

public class Polygone {
	
	private Point a; //Centre de la tortue
	private Point b; //Haut gauche
	private Point c; //Haut centre
	private Point d; //Haut droit
	
	public Polygone(Point w, Point x, Point y, Point z) {
		this.a = w;
		this.b = x;
		this.c = y;
		this.d = z;
	}
	
	/**
	 * Vérifie si le point "test" est du même côté que le point "witness"
	 * en coupant en deux le plan avec la droite coupant les points P-S
	 * @param test
	 * @param P
	 * @param S
	 * @param temoin
	 * @return
	 */
	private boolean verifierDroite(Point test, Point P, Point S, Point temoin) {
		
		//Pente de la droite PS
		float pente = 0;
		if(S.x-P.x == 0)
			pente = ((float)S.y-(float)P.y) * Integer.MIN_VALUE;
		else 
			pente = ((float)S.y-(float)P.y) / ((float)S.x-(float)P.x);
		
		//Ordonnée à l'origine
		float ordonnee = -pente*(float)P.x + (float)P.y;
		
		//Calcul du y témoin et test sur la droite
		float yTemoinSurDroite = (float)temoin.x*pente + ordonnee;
		float yTestSurDroite = (float)test.x*pente + ordonnee;
		
		//Verification des points (quel côté de la droite)
		if( (yTemoinSurDroite < temoin.y && yTestSurDroite < test.y) 
		 || (yTemoinSurDroite > temoin.y && yTestSurDroite > test.y)) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Verifie si le point x est dans le polygone
	 * @param x
	 * @return
	 */
	public boolean estDansLePolygone(Point x) {
		
		return verifierDroite(x, this.a, this.b, this.c) 
			&& verifierDroite(x, this.b, this.c, this.d) 
			&& verifierDroite(x, this.c, this.d, this.a)
			&& verifierDroite(x, this.d, this.a, this.b);
	}

	/***************
	 * GETTERS
	 ***************/
	
	public Point getA() { return a; }

	public Point getB() { return b; }
	
	public Point getC() { return c; }

	public Point getD() { return d;	}
}
