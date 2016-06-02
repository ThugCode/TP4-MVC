package test;

import org.junit.Before;

import modele.TortueIntelligente;

public class TestTortueIntelligente extends TestTortueAleatoire{

	TortueIntelligente tortue;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.tortue = new TortueIntelligente();
	}
}
