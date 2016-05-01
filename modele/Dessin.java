package modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

/**
 * 
 * @author GERLAND - LETOURNEUR
 *
 */
public class Dessin extends Observable {
	
	// Liste des tortues enregistrees
	private ArrayList<Tortue> tortues;

	public Dessin() {
		tortues = new ArrayList<Tortue>();
	}

	public void addTortue(Tortue o) {
		tortues.add(o);
		
		this.setChanged();
		this.notifyObservers();
	}
	
	public void reset() {
		for (Iterator<Tortue> it = tortues.iterator();it.hasNext();) {
			Tortue t = it.next();
			t.reset();
		}
		
		this.setChanged();
		this.notifyObservers();
	}
	
	public ArrayList<Tortue> getTortues() {
		return tortues;
	}
}
