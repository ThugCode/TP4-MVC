package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.modele.TortueIntelligente;

public class TestTortueIntelligente extends TestTortueAleatoire{

	TortueIntelligente tortue;
	TortueIntelligente tortueDedans;
	TortueIntelligente tortueLoin;
	TortueIntelligente tortueDehors;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.tortue = new TortueIntelligente();
		this.tortue.setPosition(1, 1);
		this.tortue.setDirection(45);
		this.tortue.deployerLeChampsDeVision();
		
		this.tortueDedans = new TortueIntelligente();
		this.tortueDedans.setPosition(4, 5);
		this.tortueDedans.deployerLeChampsDeVision();
		
		this.tortueLoin = new TortueIntelligente();
		this.tortueLoin.setPosition(100, 100);
		this.tortueLoin.deployerLeChampsDeVision();
		
		this.tortueDehors = new TortueIntelligente();
		this.tortueDehors.setPosition(-2, -3);
		this.tortueDehors.deployerLeChampsDeVision();
	}
	
	@Test
	public void testDistanceDedans() {
		
		assertTrue((int)tortue.distanceAutreTortue(tortueDedans) == 5);
	}
	
	@Test
	public void testDedans() {
		
		assertTrue(this.tortue.estDansMonChampsDeVision(tortueDedans));
	}
	
	@Test
	public void testDistanceLoin() {
		assertTrue((int)tortue.distanceAutreTortue(tortueLoin) == 140);
	}
	
	@Test
	public void testLoin() {
		
		assertFalse(this.tortue.estDansMonChampsDeVision(tortueLoin));
	}
	
	@Test
	public void testDistanceDehors() {
		
		assertTrue((int)tortue.distanceAutreTortue(tortueDehors) == 5);
	}
	
	@Test
	public void testDehors() {
		
		assertFalse(this.tortue.estDansMonChampsDeVision(tortueDehors));
	}
}
