package modele;

import java.util.ArrayList;
import java.util.Iterator;

public class Dessin {	
	private ArrayList<Tortue> tortues; // la liste des tortues enregistrees
	
	public Dessin() {
		tortues = new ArrayList<Tortue>();
	}

	public void addTortue(Tortue o) {
		tortues.add(o);
	}
	
	public void reset() {
		for (Iterator<Tortue> it = tortues.iterator();it.hasNext();) {
			Tortue t = it.next();
			t.reset();
		}
	}
}
