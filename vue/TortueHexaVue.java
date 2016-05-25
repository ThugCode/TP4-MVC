package vue;

import java.awt.*;

import commun.Commun;
import modele.Segment;
import modele.Tortue;

/**
 * @author GERLAND - LETOURNEUR
 */
public class TortueHexaVue extends TortueVue
{	
	/**
	 * Constructeur
	 * @param p_tortue
	 */
	public TortueHexaVue(Tortue p_tortue) {
		super(p_tortue);
	}
	
	/**
	 * Dessiner la tortue et ses segments
	 * @param graph
	 */
	public void drawTurtle (Graphics graph) {
		
		super.drawTurtle(graph);
		
		// Dessine les segments
		for(Segment seg : tortue.getListSegments()) {
			seg.drawSegment(graph);
		}

		//Calcule les 3 coins du triangle a partir de
		// la position de la tortue p
		Point p = new Point(tortue.getX(),tortue.getY());
		Polygon arrow = new Polygon();

		//Calcule des deux bases
		//Angle de la droite
		double theta=Commun.ratioDegRad*(-tortue.getDir());
		//Demi angle au sommet du triangle
		double alpha=Math.atan( (float)Commun.rb / (float)Commun.rp );
		//Rayon de la fleche
		double r=Math.sqrt( Commun.rp*Commun.rp + Commun.rb*Commun.rb );
		//Sens de la fleche

		//Pointe
		Point p2=new Point((int) Math.round(p.x+r*Math.cos(theta)),
						 (int) Math.round(p.y-r*Math.sin(theta)));
		arrow.addPoint(p2.x,p2.y);
		arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta + alpha) ),
		  (int) Math.round( p2.y+r*Math.sin(theta + alpha) ));

		//Base2
		arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta - alpha) ),
		  (int) Math.round( p2.y+r*Math.sin(theta - alpha) ));

		arrow.addPoint(p2.x,p2.y);
		graph.setColor(tortue.decodeColor(tortue.getColor()));
		graph.fillPolygon(arrow);
    }
}
