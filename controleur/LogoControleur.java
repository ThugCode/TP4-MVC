package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JComboBox;

import commun.Commun;
import modele.Logo;
import vue.LogoVue;

/**
 * @author GERLAND - LETOURNEUR
 */
public abstract class LogoControleur implements ActionListener, WindowListener, ComponentListener {

	protected Logo logo;
	protected LogoVue logoVue;
	public LogoVue getLogoVue() { return logoVue; }
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

	/**
	 * ActionPerformed
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		String c = e.getActionCommand();

		if (c.equals("Effacer")) {
			logo.getDessin().reset();
		} 
		else if (c.equals("Couleur")) {
			logo.setcCouleur(((JComboBox<String>)e.getSource()).getSelectedIndex());
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

	/**
	 * ComponentListener
	 */
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
