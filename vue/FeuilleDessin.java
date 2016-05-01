package vue;

import java.awt.*;
import javax.swing.*;

import modele.Dessin;
import modele.Tortue;

import java.util.*;

/**
 * Titre :        Logo
 * Description :  Un exemple de programme graphique utilisant la celebre Tortue Logo
 * Copyright :    Copyright (c) 2000
 * Societe :      LIRMM
 * @author J. Ferber
 * @version 2.0
 */

public class FeuilleDessin extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	
	private Dessin dessin;
	
	public FeuilleDessin(Dessin p_dessin) {
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
			t.notifyObservers();
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}
