package vue;

import java.awt.Color;
import java.awt.Graphics;

import commun.Commun;
import modele.Tortue;
import modele.TortueAleatoire;
import modele.TortueIntelligente;

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
		
		//Display arc angle vue
		if(tortue instanceof TortueAleatoire) {
			int arcDirection = 360 - tortue.getDirection() - Commun.ANGLE_VUE/2;
			int arcX = tortue.getX()-Commun.LONGUEUR_VUE/2;
			int arcY = tortue.getY()-Commun.LONGUEUR_VUE/2;
			graph.setColor(Color.yellow);
			graph.fillArc(arcX, arcY, Commun.LONGUEUR_VUE, Commun.LONGUEUR_VUE, arcDirection, Commun.ANGLE_VUE);
		}
		/*
		//Display point of the arc
		if(tortue instanceof TortueIntelligente && ((TortueIntelligente)tortue).getChampVision() != null) {
			graph.setColor(Color.green);
			graph.fillRect(((TortueIntelligente)tortue).getChampVision().getA().x, ((TortueIntelligente)tortue).getChampVision().getA().y, 5, 5);
			graph.fillRect(((TortueIntelligente)tortue).getChampVision().getB().x, ((TortueIntelligente)tortue).getChampVision().getB().y, 5, 5);
			graph.fillRect(((TortueIntelligente)tortue).getChampVision().getC().x, ((TortueIntelligente)tortue).getChampVision().getC().y, 5, 5);
			graph.fillRect(((TortueIntelligente)tortue).getChampVision().getD().x, ((TortueIntelligente)tortue).getChampVision().getD().y, 5, 5);
		}
		*/
	}
}
