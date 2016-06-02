package vue;

import java.awt.Color;
import java.awt.Graphics;

import commun.Commun;
import modele.Segment;
import modele.Tortue;
import modele.TortueAleatoire;

/**
 * @author GERLAND - LETOURNEUR
 */
public class TortueVue
{	
	protected Tortue tortue;
	private FormeVue forme;

	/**
	 * Constructeur
	 * @param p_tortue
	 */
	public TortueVue(Tortue p_tortue) {
		tortue = p_tortue;
		
		forme = new FormeHexaVue();
	}
	
	/**
	 * Dessiner la tortue et ses segments
	 * @param graph
	 */
	public void dessinerTortue (Graphics graph) {
		
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
		
		// Dessine les segments
		for(Segment seg : tortue.getListSegments()) {
			seg.drawSegment(graph);
		}
				
		forme.dessinerTortue(graph, this.getTortue());
		
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
	
	public Tortue getTortue() {
		return tortue;
	}
	
	public FormeVue getForme() {
		return forme;
	}

	public void setForme(FormeVue forme) {
		this.forme = forme;
	}
}
