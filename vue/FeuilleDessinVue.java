package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import modele.FeuilleDessin;
import modele.Tortue;

/**
 * Titre :        Logo
 * Description :  Un exemple de programme graphique utilisant la celebre Tortue Logo
 * Copyright :    Copyright (c) 2000
 * Societe :      LIRMM
 * @author J. Ferber
 * @version 2.0
 */

public class FeuilleDessinVue extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	
	private FeuilleDessin dessin;
	
	public FeuilleDessinVue(FeuilleDessin p_dessin) {
		dessin = p_dessin;
		dessin.addObserver(this);
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
	
	public void showTurtles(Graphics g) {
		for(Iterator<Tortue> it = dessin.getTortues().iterator();it.hasNext();) {
			Tortue t = (Tortue) it.next();
			t.notifier(g);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}
