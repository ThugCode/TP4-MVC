package controleur;

import java.awt.event.ActionEvent;

import modele.Logo;
import modele.TortueIntelligente;

/**
 * @author GERLAND - LETOURNEUR
 */
public class LogoAutonomeControleur extends LogoControleur {

	/**
	 * Constructeur
	 * @param p_logo
	 */
	public LogoAutonomeControleur(Logo p_logo) {
		super(p_logo);
	}
	
	/**
	 * ActionPerformed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		super.actionPerformed(e);
		
		String c = e.getActionCommand();

		if (c.equals("Lancer")) {
			logo.lancerLesTortues();
		}
		else if (c.equals("Stopper")) {
			logo.setMarche(false);
		}
		else if (c.equals("Ajouter")) {
			
			TortueIntelligente tortue = new TortueIntelligente();
			tortue.setCouleur(logo.getcCouleur());
			
			logoVue.getDessin().ajouterTortue(tortue);
		} 
		else if (c.equals("Supprimer")) {
			
			logoVue.getDessin().retirerDerniereTortue();
			logo.getDessin().retirerDerniereTortue();
		}
	}
}
