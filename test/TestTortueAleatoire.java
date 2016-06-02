package test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import commun.Commun;
import modele.TortueAleatoire;

public class TestTortueAleatoire extends TestTortue {
	
	TortueAleatoire tortue;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.tortue = new TortueAleatoire();
	}

	@Test
	public void testCoordooneesValides() {
		tortue.avancerSeul();
		assertTrue(tortue.getX() > 0);
		assertTrue(tortue.getX() < Commun.LARGEUR_FEUILLE);
		assertTrue(tortue.getY() > 0);
		assertTrue(tortue.getY() < Commun.HAUTEUR_FEUILLE);
	}

}
