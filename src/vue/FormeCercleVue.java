package src.vue;

import java.awt.Graphics;
import java.awt.Point;

import src.modele.Tortue;

/**
 * @author GERLAND - LETOURNEUR
 */
public class FormeCercleVue implements FormeVue
{

	@Override
	public void dessinerTortue(Graphics graph, Tortue tortue) {
		
		Point p = new Point(tortue.getX(),tortue.getY());
		graph.setColor(tortue.decoderCouleur(tortue.getCouleur()));
		graph.fillOval(p.x-5,p.y-5, 10, 10);
	}
}
