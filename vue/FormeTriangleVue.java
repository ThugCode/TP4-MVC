package vue;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import commun.Commun;
import modele.Tortue;

/**
 * @author GERLAND - LETOURNEUR
 */
public class FormeTriangleVue implements FormeVue
{
	@Override
	public void dessinerTortue(Graphics graph, Tortue tortue) {
		//Calcule les 3 coins du triangle a partir de
		// la position de la tortue p
		Point p = new Point(tortue.getX(),tortue.getY());
		Polygon arrow = new Polygon();

		//Calcule des deux bases
		//Angle de la droite
		double theta=Commun.RATIO_DEG_RAD*(-tortue.getDirection());
		//Demi angle au sommet du triangle
		double alpha=Math.atan( (float)Commun.TAILLE_BASE / (float)Commun.TAILLE_POINTE );
		//Rayon de la fleche
		double r=Math.sqrt( Commun.TAILLE_POINTE*Commun.TAILLE_POINTE + Commun.TAILLE_BASE*Commun.TAILLE_BASE );
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
		graph.setColor(tortue.decoderCouleur(tortue.getCouleur()));
		graph.fillPolygon(arrow);
	}
}