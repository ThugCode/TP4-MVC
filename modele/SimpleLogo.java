package modele;

import java.util.Observable;

import vue.FeuilleDessinVue;

/**
 * @author GERLAND - LETOURNEUR
 */
public class SimpleLogo extends Observable {

	private Tortue cTortue;
	private FeuilleDessinVue dessin;
	private boolean controle;
	
	public SimpleLogo() {
		this(true);
	}
	
	public SimpleLogo(boolean p_controle) {
		dessin = new FeuilleDessinVue();
		cTortue = new Tortue();
		controle = p_controle;
	}

	public boolean isControle() {
		return controle;
	}

	public void setControle(boolean controle) {
		this.controle = controle;
	}

	public FeuilleDessinVue getDessin() {
		return dessin;
	}

	public void setDessin(FeuilleDessinVue dessin) {
		this.dessin = dessin;
	}

	public Tortue getCTortue() {
		return cTortue;
	}

	public void setCTortue(Tortue courante) {
		this.cTortue = courante;
	}
}
