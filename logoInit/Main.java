package logoInit;

import javax.swing.SwingUtilities;

import controleur.SimpleLogoControleur;
import modele.SimpleLogo;
import vue.SimpleLogoVue;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				SimpleLogo logo = new SimpleLogo();
				SimpleLogoVue logoVue = new SimpleLogoVue(logo);
				SimpleLogoControleur logoControleur = new SimpleLogoControleur(logo, logoVue);
				
				logoVue.setControleur(logoControleur);				
				logoVue.addWindowListener(logoControleur);
				logoVue.setVisible(true);
			}
		});
	}

}
