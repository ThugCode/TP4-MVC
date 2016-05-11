package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JComboBox;

import modele.SimpleLogo;
import vue.SimpleLogoVue;

public class SimpleLogoControleur implements ActionListener, WindowListener {

	private SimpleLogo logo;
	private SimpleLogoVue logoVue;

	/**
	 * Constructeur
	 * @param p_logo
	 */
	public SimpleLogoControleur(SimpleLogo p_logo) {
		logo = p_logo;
	}

	/**
	 * ActionPerformed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String c = e.getActionCommand();

		// actions des boutons du haut
		if (c.equals("Avancer")) {
			try {
				int v = Integer.parseInt(this.logoVue.getInputValue());
				logo.getCourante().avancer(v);
			} catch (NumberFormatException ex){
				System.err.println("ce n'est pas un nombre : " + this.logoVue.getInputValue());
			}
			
		}
		else if (c.equals("Droite")) {
			try {
				int v = Integer.parseInt(this.logoVue.getInputValue());
				logo.getCourante().droite(v);
			} catch (NumberFormatException ex){
				System.err.println("ce n'est pas un nombre : " + this.logoVue.getInputValue());
			}
		}
		else if (c.equals("Gauche")) {
			try {
				int v = Integer.parseInt(this.logoVue.getInputValue());
				logo.getCourante().gauche(v);
			} catch (NumberFormatException ex){
				System.err.println("ce n'est pas un nombre : " + this.logoVue.getInputValue());
			}
		}
		else if (c.equals("Lever")) 
			logo.getCourante().leverCrayon();
		else if (c.equals("Baisser"))
			logo.getCourante().baisserCrayon();
		else if (c.equals("Proc1"))
			logo.getCourante().carre();
		else if (c.equals("Proc2"))
			logo.getCourante().poly(60,8);
		else if (c.equals("Proc3"))
			logo.getCourante().spiral(50,40,6);
		else if (c.equals("Effacer"))
			logoVue.effacer();
		else if (c.equals("Quitter"))
			System.exit(0);
		else if (c.equals("Couleur")) {
			JComboBox cb = (JComboBox)e.getSource();
			int n = cb.getSelectedIndex();
			logo.getCourante().setColor(n);
		}

		logo.getDessin().notifier();
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
	
	public SimpleLogoVue getLogoVue() {
		return logoVue;
	}

	public void setLogoVue(SimpleLogoVue logoVue) {
		this.logoVue = logoVue;
	}
	
}
