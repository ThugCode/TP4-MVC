package modele;

import java.awt.Point;

public class Polygone {
	
	private Point a;
	private Point b;
	private Point c;
	private Point d;
	
	public Polygone(Point w, Point x, Point y, Point z) {
		this.a = w;
		this.b = x;
		this.c = y;
		this.d = z;
	}
	
	public boolean isIn(Point x, Point y) {
		return false;
	}
}
