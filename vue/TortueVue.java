package vue;

import java.awt.*;

import modele.Tortue;

/**
 * @author GERLAND - LETOURNEUR
 */
public abstract class TortueVue
{	
	protected Tortue tortue;

	public Tortue getTortue() {
		return tortue;
	}
	
	/**
	 * Constructeur
	 * @param p_tortue
	 */
	public TortueVue(Tortue p_tortue) {
		tortue = p_tortue;
	}
	
	/**
	 * Dessiner la tortue et ses segments
	 * @param graph
	 */
	public void drawTurtle (Graphics graph) {
		
		if (graph==null) {
			System.out.println("Impossible de trouver le Graphics pour dessiner la tortue");
			return;
		}
		
		int tr = 140;
		int directionArc = 360 - tortue.getDir() - 45;
		graph.setColor(Color.yellow);
		graph.fillArc(tortue.getX()-tr/2, tortue.getY()-tr/2, tr, tr, directionArc, 90);
	}
}
