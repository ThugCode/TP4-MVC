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
	public abstract void drawTurtle (Graphics graph);
}
