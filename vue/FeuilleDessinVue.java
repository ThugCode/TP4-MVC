package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import modele.Tortue;

public class FeuilleDessinVue extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<TortueVue> tortues;

	public FeuilleDessinVue() {
		tortues = new ArrayList<TortueVue>();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Color c = g.getColor();
		
		Dimension dim = getSize();
		g.setColor(Color.white);
		g.fillRect(0,0,dim.width, dim.height);
		g.setColor(c);

		showTurtles(g);
	}
	
	public void addTortue(Tortue o) {
		TortueVue tv = new TortueVue(o);
		tortues.add(tv);
		o.addObserver(this);
		
		this.repaint();
	}
	
	public void showTurtles(Graphics g) {
		for(TortueVue tv : tortues) {
			tv.drawTurtle(g);
		}
	}

	public void reset() {
		for (Iterator<TortueVue> it = tortues.iterator();it.hasNext();) {
			Tortue t = it.next().getTortue();
			t.reset();
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
	
	public ArrayList<TortueVue> getTortues() {
		return tortues;
	}
}
