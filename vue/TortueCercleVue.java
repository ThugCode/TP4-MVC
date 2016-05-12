package vue;

import java.awt.*;

import modele.Segment;
import modele.Tortue;

/**
 * @author GERLAND - LETOURNEUR
 */
public class TortueCercleVue extends TortueVue
{	
	/**
	 * Constructeur
	 * @param p_tortue
	 */
	public TortueCercleVue(Tortue p_tortue) {
		super(p_tortue);
	}
	
	/**
	 * Dessiner la tortue et ses segments
	 * @param graph
	 */
	public void drawTurtle (Graphics graph) {
		
		if (graph==null) {
			return;
		}
		
		// Dessine les segments
		for(Segment seg : tortue.getListSegments()) {
			seg.drawSegment(graph);
		}

		Point p = new Point(tortue.getX(),tortue.getY());
		graph.setColor(tortue.decodeColor(tortue.getColor()));
		graph.fillOval(p.x-5,p.y-5, 10, 10);
    }
}
