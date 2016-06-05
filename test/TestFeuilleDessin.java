package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modele.FeuilleDessin;
import modele.Tortue;
import modele.TortueAleatoire;

public class TestFeuilleDessin {
	
	FeuilleDessin dessin;
	Tortue tortue;

	@Before
	public void setUp() throws Exception {
		this.dessin = new FeuilleDessin();
		this.tortue = new Tortue();
		this.dessin.ajouterTortue(tortue);
	}

	@Test
	public void testChangerCouleurTortue() {
		this.dessin.changerCouleursTortues(1);
		
		assertEquals(1, tortue.getCouleur());
	}
	
	@Test
	public void testAvancerTortue() {
		this.tortue = new TortueAleatoire();
		this.dessin.retirerDerniereTortue();
		this.dessin.ajouterTortue(tortue);
		
		int ancienX = this.tortue.getX();
		int ancienY = this.tortue.getY();
		
		this.dessin.faireAvancerTortuesAleatoires();
		
		assertTrue(ancienX != this.tortue.getX());
		assertTrue(ancienY != this.tortue.getY());
	}

}
