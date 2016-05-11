package logoInit;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
				
				logoVue.addWindowListener(logoControleur);
				logoVue.setVisible(true);
			}
		});
	}

}
