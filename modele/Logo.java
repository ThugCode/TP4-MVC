package modele;

import javax.swing.SwingUtilities;

import vue.SimpleLogo;

/**
 * 
 * @author GERLAND - LETOURNEUR
 *
 */
public class Logo {

	private Dessin dessin;
	private Tortue courante;

	public Logo() {
		dessin = new Dessin();
		courante = new Tortue();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				Logo logo = new Logo();
				SimpleLogo fenetre = new SimpleLogo(logo);
				fenetre.setVisible(true);
			}
		});

	}

	public Dessin getDessin() {
		return dessin;
	}

	public void setDessin(Dessin dessin) {
		this.dessin = dessin;
	}

	public Tortue getCourante() {
		return courante;
	}

	public void setCourante(Tortue courante) {
		this.courante = courante;
	}
}
