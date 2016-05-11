package commun;

import javax.swing.SwingUtilities;

import controleur.SimpleLogoControleur;
import modele.SimpleLogo;
import vue.SimpleLogoVue;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				SimpleLogo logo = new SimpleLogo();
				SimpleLogoControleur logoControleur = new SimpleLogoControleur(logo);
				SimpleLogoVue logoVue = new SimpleLogoVue(logo, logoControleur);
				
				logoControleur.setLogoVue(logoVue);				
				
				logoVue.setVisible(true);
			}
		});
	}

}
