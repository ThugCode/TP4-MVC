package test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import src.modele.TriangleVision;

public class TestTriangleVision {
	
	TriangleVision triangle;
	Point pointDedans;
	Point pointDehors;
	
	@Before
	public void setUp() throws Exception {
		//Création d'un polygone en forme de losange
		this.triangle = new TriangleVision(new Point(5,5), new Point(3,7), new Point(7,7));
		this.pointDedans = new Point(4,7);
		this.pointDehors = new Point(0,0);
	}

	@Test
	public void testVerifieDroiteABTrue() {
		assertTrue(triangle.verifierDroiteAB(this.pointDedans));
	}
	
	@Test
	public void testVerifieDroiteABFalse() {
		assertFalse(triangle.verifierDroiteAB(this.pointDehors));
	}
	
	@Test
	public void testVerifieDroiteADTrue() {
		assertTrue(triangle.verifierDroiteAD(this.pointDedans));
	}
	
	@Test
	public void testVerifieDroiteADFalse() {
		assertFalse(triangle.verifierDroiteAD(this.pointDehors));
	}

}
