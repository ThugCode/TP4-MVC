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
	 * Verify if a point "test" is in the same side of the point "witness"
	 * by cutting plan in two with segment first to second
	 * @param test
	 * @param first
	 * @param second
	 * @param witness
	 * @return
	 */
	private boolean verifySegment(Point test, Point first, Point second, Point witness) {
		
		//Slope between point first and second
		float slope = 0;
		if(second.x-first.x == 0)
			slope = ((float)second.y-(float)first.y) * Integer.MIN_VALUE;
		else 
			slope = ((float)second.y-(float)first.y) / ((float)second.x-(float)first.x);
		
		//Intercept
		float intercept = -slope*(float)first.x + (float)first.y;
		
		//Calculate y for witness and test points on segment
		float yWitnessInSegment = (float)witness.x*slope + intercept;
		float yTestInSegment = (float)test.x*slope + intercept;
		
		//Check if points are in the same side
		if( (yWitnessInSegment < witness.y && yTestInSegment < test.y) 
		 || (yWitnessInSegment > witness.y && yTestInSegment > test.y)) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Verify if the point x is in the polygone
	 * @param x
	 * @return
	 */
	public boolean isInPolygone(Point x) {
		
		//Check if the point is on the appropriate side of the segment
		return verifySegment(x, this.a, this.b, this.c) 
			&& verifySegment(x, this.b, this.c, this.d) 
			&& verifySegment(x, this.c, this.d, this.a)
			&& verifySegment(x, this.d, this.a, this.b);
	}

	/***************
	 * GETTERS
	 ***************/
	
	public Point getA() { return a; }

	public Point getB() { return b; }
	
	public Point getC() { return c; }

	public Point getD() { return d;	}
}
