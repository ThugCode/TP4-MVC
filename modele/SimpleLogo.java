package modele;

import java.util.Observable;

import vue.FeuilleDessinVue;

/**
 * @author GERLAND - LETOURNEUR
 */
public class SimpleLogo extends Observable {

	private Tortue cTortue;
	private FeuilleDessinVue dessin;
	
	public SimpleLogo() {
		dessin = new FeuilleDessinVue();
		cTortue = new Tortue();
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
