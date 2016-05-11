package modele;

/**
 * 
 * @author GERLAND - LETOURNEUR
 *
 */
public class SimpleLogo {

	private FeuilleDessin dessin;
	private Tortue courante;

	public SimpleLogo() {
		dessin = new FeuilleDessin();
		courante = new Tortue();
	}

	public FeuilleDessin getDessin() {
		return dessin;
	}

	public void setDessin(FeuilleDessin dessin) {
		this.dessin = dessin;
	}

	public Tortue getCourante() {
		return courante;
	}

	public void setCourante(Tortue courante) {
		this.courante = courante;
	}
}
