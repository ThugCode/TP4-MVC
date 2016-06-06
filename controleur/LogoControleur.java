package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JComboBox;

import commun.Commun;
import modele.Logo;
import modele.TortueIntelligente;
import vue.LogoVue;

/**
 * @author GERLAND - LETOURNEUR
 */
public class LogoControleur implements ActionListener, WindowListener, KeyListener, ComponentListener {

	private Logo logo;
	private LogoVue logoVue;
	
	public LogoVue getLogoVue() {
		return logoVue;
	}

	public void setLogoVue(LogoVue logoVue) {
		this.logoVue = logoVue;
	}

	/**
	 * Constructeur
	 * @param p_logo
	 */
	public LogoControleur(Logo p_logo) {
		logo = p_logo;
	}
	
	private int verifieNombre() {
		try {
			return Integer.parseInt(this.logoVue.getInputValue());
		} catch (NumberFormatException ex){
			System.err.println("ce n'est pas un nombre : " + this.logoVue.getInputValue());
			return 0;
		}
	}
	
	private void avancer() {
		logo.getCTortue().avancer(verifieNombre());
	}
	
	private void gauche() {
		logo.getCTortue().gauche(verifieNombre());
	}
	
	private void droite() {
		logo.getCTortue().droite(verifieNombre());
	}

	/**
	 * ActionPerformed
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		String c = e.getActionCommand();

		if (c.equals("Avancer")) {
			this.avancer();
		}
		else if (c.equals("Droite")) {
			this.droite();
		}
		else if (c.equals("Gauche")) {
			this.gauche();
		}
		else if (c.equals("Lever")) {
			logo.getCTortue().leverCrayon();
		} 
		else if (c.equals("Baisser")) {
			logo.getCTortue().baisserCrayon();
		} 
		else if (c.equals("Proc1")) {
			logo.getCTortue().carre();
		} 
		else if (c.equals("Proc2")) {
			logo.getCTortue().poly(60,8);
		} 
		else if (c.equals("Proc3")) {
			logo.getCTortue().spiral(50,40,6);
		} 
		else if (c.equals("Effacer")) {
			logo.getDessin().reset();
		} 
		else if (c.equals("Couleur")) {
			logo.setcCouleur(((JComboBox<String>)e.getSource()).getSelectedIndex());
		}
		else if (c.equals("Lancer")) {
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
		else if (c.equals("Quitter")) {
			System.exit(0);
		}
	}

	/**
	 * WindowListener
	 */
	@Override
	public void windowClosing(WindowEvent arg0) {
        System.exit(0);
    }
	
	@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(!logo.isControle())
			return;
		
		if((e.getKeyCode()==KeyEvent.VK_ENTER)) {
			
		} else if((e.getKeyCode()==KeyEvent.VK_UP)) {
			this.avancer();
		} else if((e.getKeyCode()==KeyEvent.VK_LEFT)) {
			this.gauche();
		} else if((e.getKeyCode()==KeyEvent.VK_RIGHT)) {
			this.droite();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void componentResized(ComponentEvent e) {
		
		Commun.LARGEUR_FEUILLE = ((LogoVue) e.getSource()).getWidth();
		Commun.HAUTEUR_FEUILLE = ((LogoVue)e.getSource()).getHeight()-95;
	}

	@Override
	public void componentMoved(ComponentEvent e) {}

	@Override
	public void componentShown(ComponentEvent e) {}

	@Override
	public void componentHidden(ComponentEvent e) {}
}
