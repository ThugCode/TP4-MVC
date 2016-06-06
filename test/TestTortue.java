package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modele.Tortue;

public class TestTortue {

	Tortue tortue;
	
	@Before
	public void setUp() throws Exception {
		tortue = new Tortue();
	}
	
	@Test
	public void testAvancerADroite() {
		tortue.setDirection(0);
		int ancienX = tortue.getX();
		int ancienY = tortue.getY();
		tortue.avancer(10);
		assertEquals(ancienX + 10, tortue.getX());
		assertEquals(ancienY, tortue.getY());
	}
	
	@Test
	public void testAvancerAGauche() {
		tortue.setDirection(180);
		int ancienX = tortue.getX();
		int ancienY = tortue.getY();
		tortue.avancer(10);
		assertEquals(ancienX - 10, tortue.getX());
		assertEquals(ancienY, tortue.getY());
	}
	
	@Test
	public void testAvancerEnHaut() {
		tortue.setDirection(90);
		int ancienX = tortue.getX();
		int ancienY = tortue.getY();
		tortue.avancer(10);
		assertEquals(ancienX, tortue.getX());
		assertEquals(ancienY + 10, tortue.getY());
	}
	
	@Test
	public void testAvancerEnBas() {
		tortue.setDirection(270);
		int ancienX = tortue.getX();
		int ancienY = tortue.getY();
		tortue.avancer(10);
		assertEquals(ancienX, tortue.getX());
		assertEquals(ancienY - 10, tortue.getY());
	}
}
