package vue;

// package logo;

import java.awt.*;
import javax.swing.*;

import modele.Commun;
import modele.Segment;
import modele.Tortue;

import java.awt.event.*;
import java.util.*;
import java.io.*;


/*************************************************************************

	Un petit Logo minimal qui devra etre ameliore par la suite

	Source originale : J. Ferber - 1999-2001

			   Cours de DESS TNI - Montpellier II

	@version 2.0
	@date 25/09/2001

**************************************************************************/


public class TortueVue implements Observer
{	
	private Tortue tortue;
	
	public TortueVue(Tortue p_tortue) {
		tortue = p_tortue;
	}
	
	public void drawTurtle (Graphics graph) {
		if (graph==null)
			return;
		
		// Dessine les segments
		for(Iterator it = tortue.getListSegments().iterator();it.hasNext();) {
			Segment seg = (Segment) it.next();
			seg.drawSegment(graph);
		}

		//Calcule les 3 coins du triangle a partir de
		// la position de la tortue p
		Point p = new Point(tortue.getX(),tortue.getY());
		Polygon arrow = new Polygon();

		//Calcule des deux bases
		//Angle de la droite
		double theta=Commun.ratioDegRad*(-tortue.getDir());
		//Demi angle au sommet du triangle
		double alpha=Math.atan( (float)Commun.rb / (float)Commun.rp );
		//Rayon de la fleche
		double r=Math.sqrt( Commun.rp*Commun.rp + Commun.rb*Commun.rb );
		//Sens de la fleche

		//Pointe
		Point p2=new Point((int) Math.round(p.x+r*Math.cos(theta)),
						 (int) Math.round(p.y-r*Math.sin(theta)));
		arrow.addPoint(p2.x,p2.y);
		arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta + alpha) ),
		  (int) Math.round( p2.y+r*Math.sin(theta + alpha) ));

		//Base2
		arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta - alpha) ),
		  (int) Math.round( p2.y+r*Math.sin(theta - alpha) ));

		arrow.addPoint(p2.x,p2.y);
		graph.setColor(Color.green);
		graph.fillPolygon(arrow);
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
