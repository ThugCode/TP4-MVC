package vue;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import commun.Commun;
import modele.Tortue;

/**
 * @author GERLAND - LETOURNEUR
 */
public class FormeHexaVue implements FormeVue
{
	@Override
	public void dessinerTortue(Graphics graph, Tortue tortue) {
		
		int nombreDeCotes = 8;
		float angle = 360/nombreDeCotes;
		
		int aX = (int) Math.round(tortue.getX()+Commun.TAILLE_POINTE*Math.cos(Commun.RATIO_DEG_RAD*tortue.getDirection()));
		int aY = (int) Math.round(tortue.getY()+Commun.TAILLE_POINTE*Math.sin(Commun.RATIO_DEG_RAD*tortue.getDirection()));
		Point a = new Point(aX, aY);
		Point b = null;
		
		Polygon hexa = new Polygon();
		hexa.addPoint(a.x, a.y);
		
		for(int i=1;i<=nombreDeCotes;i++) {
			int X = (int) (tortue.getX() + Commun.TAILLE_POINTE*Math.cos(Commun.RATIO_DEG_RAD*(tortue.getDirection()-angle*i)));
			int Y = (int) (tortue.getY() + Commun.TAILLE_POINTE*Math.sin(Commun.RATIO_DEG_RAD*(tortue.getDirection()-angle*i)));
			b = new Point(X, Y);
			hexa.addPoint(b.x, b.y);
		}

		graph.setColor(tortue.decodeColor(tortue.getCouleur()));
		
		graph.fillPolygon(hexa);
		
	}
}
