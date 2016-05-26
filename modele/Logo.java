package modele;

import java.util.Observable;

/**
 * @author GERLAND - LETOURNEUR
 */
public class Logo extends Observable {

	private Tortue cTortue;
	private FeuilleDessin dessin;
	private boolean controle;
	private boolean marche;
	private int cCouleur;
	
	public Logo() {
		this(true);
	}
	
	public Logo(boolean p_controle) {
		dessin = new FeuilleDessin();
		cTortue = new Tortue();
		controle = p_controle;
		setMarche(false);
		cCouleur = 0;
	}
	
	/**
	 * Lancer un thread qui toutes les 100ms fait bouger les tortues
	 */
	public void lancerLesTortues() {
		
		if(marche)
			return;
		
		marche = true;
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				while(marche) {
					dessin.faireAvancerTortuesIntelligentes();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t2.start();
	}

	/************
	 * GETTER
	 ************/

	public FeuilleDessin getDessin() { return dessin; }

	public Tortue getCTortue() { return cTortue; }

	public int getcCouleur() { return cCouleur; }

	public boolean isControle() { return controle; }
	
	public boolean isMarche() { return marche; }
	
	/************
	 * SETTER
	 ************/
	
	public void setControle(boolean controle) {
		this.controle = controle;
	}
	
	public void setDessin(FeuilleDessin dessin) {
		this.dessin = dessin;
	}
	
	public void setCTortue(Tortue courante) {
		this.cTortue = courante;
	}

	public void setcCouleur(int cCouleur) {
		this.cCouleur = cCouleur;
		this.dessin.changerCouleursTortues(cCouleur);
	}
	
	public void setMarche(boolean marche) {
		this.marche = marche;
	}
}
