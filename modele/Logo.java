package modele;

import java.util.Observable;

/**
 * @author GERLAND - LETOURNEUR
 */
public class Logo extends Observable {

	private Tortue cTortue;			//Tortue contrôlable
	private FeuilleDessin dessin;	//Feuille de dessin
	private boolean marche;			//Tortues aléatoires en marche ?
	private int cCouleur;			//Couleur courante
	
	/**
	 * Constructeur
	 */
	public Logo() {
		dessin = new FeuilleDessin();
		cTortue = new Tortue();
		marche = false;
		cCouleur = 0;
	}
	
	/**
	 * Lancer un thread qui, toutes les 100ms, fait bouger les tortues
	 */
	public void lancerLesTortues() {
		
		if(marche)
			return;
		
		marche = true;
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				while(marche) {
					dessin.faireAvancerTortuesAutonomes();
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
	
	public boolean isMarche() { return marche; }
	
	/************
	 * SETTER
	 ************/
	
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
