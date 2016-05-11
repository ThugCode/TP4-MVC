package modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

/**
 * 
 * @author GERLAND - LETOURNEUR
 *
 */
public class FeuilleDessin extends Observable {
	
	// Liste des tortues enregistrees
	private ArrayList<Tortue> tortues;

	public FeuilleDessin() {
		tortues = new ArrayList<Tortue>();
	}

	public void addTortue(Tortue o) {
		tortues.add(o);
		
		notifier();
	}
	
	public void reset() {
		for (Iterator<Tortue> it = tortues.iterator();it.hasNext();) {
			Tortue t = it.next();
			t.reset();
		}
		
		notifier();
	}
	
	public ArrayList<Tortue> getTortues() {
		return tortues;
	}
	
	public void notifier() {
		setChanged();
		notifyObservers();
	}
}
