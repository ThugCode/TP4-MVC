package test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import modele.Polygone;

public class TestPolygone {
	
	Polygone polygone;
	Point pointDedans;
	Point pointDehors;
	
	@Before
	public void setUp() throws Exception {
		//Création d'un polygone en forme de losange
		this.polygone = new Polygone(new Point(5,5), new Point(3,3), new Point(5,9), new Point(7,7));
		this.pointDedans = new Point(5,5);
		this.pointDehors = new Point(0,0);
	}

	@Test
	public void testEstDansLePolygone() {
		assertTrue(polygone.estDansLePolygone(pointDedans));
	}
	
	@Test
	public void testEstEnDehorsDuPolygone() {
		assertFalse(polygone.estDansLePolygone(pointDehors));
	}

}
