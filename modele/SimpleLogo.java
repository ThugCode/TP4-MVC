package modele;

import java.util.Observable;

/**
 * @author GERLAND - LETOURNEUR
 */
public class SimpleLogo extends Observable {

	private Tortue cTortue;
	private FeuilleDessinModele dessin;
	private boolean controle;
	private int cCouleur;
	
	public SimpleLogo() {
		this(true);
	}
	
	public SimpleLogo(boolean p_controle) {
		dessin = new FeuilleDessinModele();
		cTortue = new Tortue();
		controle = p_controle;
		cCouleur = 0;
	}

	public boolean isControle() {
		return controle;
	}

	public void setControle(boolean controle) {
		this.controle = controle;
	}

	public FeuilleDessinModele getDessin() {
		return dessin;
	}

	public void setDessin(FeuilleDessinModele dessin) {
		this.dessin = dessin;
	}

	public Tortue getCTortue() {
		return cTortue;
	}

	public void setCTortue(Tortue courante) {
		this.cTortue = courante;
	}

	public int getcCouleur() {
		return cCouleur;
	}

	public void setcCouleur(int cCouleur) {
		this.cCouleur = cCouleur;
	}
}
