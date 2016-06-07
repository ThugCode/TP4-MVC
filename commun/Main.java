package commun;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controleur.LogoAutonomeControleur;
import controleur.LogoControlableControleur;
import controleur.LogoControleur;
import modele.Logo;
import vue.FormeHexaVue;
import vue.FormeVue;
import vue.LogoAutonomeVue;
import vue.LogoControlableVue;
import vue.LogoVue;

/**
 * @author GERLAND - LETOURNEUR
 */
public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				String filePath = new File("").getAbsolutePath();
				filePath += "/ressources/tortue.png";
				
				String[] boutons = {"Tortue controlable", "Tortues intelligentes"};
			    int rang = JOptionPane.showOptionDialog(null, 
			      "Tortues intelligentes ou tortue controlable ?",
			      "Choix du type",
			      JOptionPane.YES_NO_OPTION,
			      JOptionPane.QUESTION_MESSAGE,
			      new ImageIcon(filePath),
			      boutons,
			      boutons[1]);
			    
			    if(rang == -1)
			    	System.exit(0);
			    
			    //Instanciation de l'application
				Logo logo = new Logo();
				LogoControleur logoControleur;
				LogoVue logoVue;
				if(rang == 1) {
					logoControleur = new LogoAutonomeControleur(logo);
					logoVue = new LogoAutonomeVue(logo, logoControleur);
				} else {
					logoControleur = new LogoControlableControleur(logo);
					logoVue = new LogoControlableVue(logo, (LogoControlableControleur) logoControleur);
				}
				logoControleur.setLogoVue(logoVue);
				logoVue.setVisible(true);
				
				//Changement de forme facilement
				FormeVue fcv = new FormeHexaVue();
				logoVue.getDessin().changerFormeTortues(fcv);
			}
		});
	}

}
