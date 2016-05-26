package commun;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controleur.SimpleLogoControleur;
import modele.SimpleLogo;
import vue.SimpleLogoVue;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				String[] boutons = {"Tortue controlable", "Tortues intelligentes"};
			    int rang = JOptionPane.showOptionDialog(null, 
			      "Tortues intelligentes ou tortue controlable ?",
			      "Choix du type",
			      JOptionPane.YES_NO_CANCEL_OPTION,
			      JOptionPane.QUESTION_MESSAGE,
			      null,
			      boutons,
			      boutons[1]);
			    
			    boolean controle = true;
			    if(rang == 1)
			    	controle = false;
			    
				SimpleLogo logo = new SimpleLogo(controle);
				SimpleLogoControleur logoControleur = new SimpleLogoControleur(logo);
				SimpleLogoVue logoVue = new SimpleLogoVue(logo, logoControleur);
				
				logoControleur.setLogoVue(logoVue);				
				
				logoVue.setVisible(true);
			}
		});
	}

}
