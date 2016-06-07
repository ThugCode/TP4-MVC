package src.modele;

import java.util.ArrayList;

/**
 * @author GERLAND - LETOURNEUR
 * 
 * Interface permettant de créer ses propres tortues autonomes
 * et de pouvoir les utiliser dans la feuille de dessin
 */
public interface TortueAutonome {
	
	public void reset();
	
	public void avancer(ArrayList<Tortue> autresTortues);
}
