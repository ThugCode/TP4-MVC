package src.vue;

import javax.swing.JMenuBar;
import javax.swing.JToolBar;

import src.controleur.LogoControleur;
import src.modele.Logo;
import src.modele.TortueIntelligente;

/**
 * @author GERLAND - LETOURNEUR
 */
public class LogoAutonomeVue extends LogoVue {
	private static final long serialVersionUID = 1L;

	/**
	 * Controleur
	 * @param p_logo
	 * @param p_logoControleur
	 */
	public LogoAutonomeVue(Logo p_logo, LogoControleur p_logoControleur) {
		
		super(p_logo, p_logoControleur);
	}

	@Override
	public void logoInit() {
		
		super.logoInit();
		
		for(int i = 0; i<20; i++) {
			TortueIntelligente tortue = new TortueIntelligente();
			dessin.ajouterTortue(tortue);
		}
	}
	
	@Override
	public void boutonsGauche(JToolBar toolBar) {
		
		addButton(toolBar, "Lancer", "Lancer", null);
		addButton(toolBar, "Stopper", "Stopper", null);
		addButton(toolBar, "Ajouter", "Ajouter", null);
		addButton(toolBar, "Supprimer", "Supprimer", null);
	}

	@Override
	public void menuOption(JMenuBar menubar) {}
}
