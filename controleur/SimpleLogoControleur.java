package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import modele.SimpleLogo;
import vue.SimpleLogoVue;

public class SimpleLogoControleur implements ActionListener, WindowListener {

	private SimpleLogo logo;
	private SimpleLogoVue logoVue;
	
	public SimpleLogoControleur(SimpleLogo p_logo, SimpleLogoVue p_logoVue) {
		
		this.logo = p_logo;
		this.logoVue = p_logoVue;
		
		this.logoVue.b20.addActionListener(this);
		this.logoVue.b21.addActionListener(this);
		this.logoVue.b22.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String c = e.getActionCommand();

		// actions des boutons du haut
		if (c.equals("Avancer")) {
			System.out.println("command avancer");
			try {
				int v = Integer.parseInt(this.logoVue.inputValue.getText());
				logo.getCourante().avancer(v);
			} catch (NumberFormatException ex){
				System.err.println("ce n'est pas un nombre : " + this.logoVue.inputValue.getText());
			}
			
		}
		else if (c.equals("Droite")) {
			try {
				int v = Integer.parseInt(this.logoVue.inputValue.getText());
				logo.getCourante().droite(v);
			} catch (NumberFormatException ex){
				System.err.println("ce n'est pas un nombre : " + this.logoVue.inputValue.getText());
			}
		}
		else if (c.equals("Gauche")) {
			try {
				int v = Integer.parseInt(this.logoVue.inputValue.getText());
				logo.getCourante().gauche(v);
			} catch (NumberFormatException ex){
				System.err.println("ce n'est pas un nombre : " + this.logoVue.inputValue.getText());
			}
		}
		else if (c.equals("Lever")) 
			logo.getCourante().leverCrayon();
		else if (c.equals("Baisser"))
			logo.getCourante().baisserCrayon();
		else if (c.equals("Proc1"))
			this.logoVue.proc1();
		else if (c.equals("Proc2"))
			this.logoVue.proc2();
		else if (c.equals("Proc3"))
			this.logoVue.proc3();
		else if (c.equals("Effacer"))
			this.logoVue.effacer();
		else if (c.equals("Quitter"))
			System.exit(0);

		logo.getDessin().notifyObservers();
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		this.windowClosing(arg0);
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
	
	
}
