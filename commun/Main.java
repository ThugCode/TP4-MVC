package commun;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controleur.LogoControleur;
import modele.Logo;
import vue.LogoVue;

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
			    
				Logo logo = new Logo(controle);
				LogoControleur logoControleur = new LogoControleur(logo);
				LogoVue logoVue = new LogoVue(logo, logoControleur);
				
				logoControleur.setLogoVue(logoVue);				
				
				logoVue.setVisible(true);
			}
		});
	}

}
