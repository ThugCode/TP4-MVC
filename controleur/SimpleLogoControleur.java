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
		
		logo = p_logo;
		logoVue = p_logoVue;
		
		logoVue.b20.addActionListener(this);
		logoVue.b21.addActionListener(this);
		logoVue.b22.addActionListener(this);
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
			proc1();
		else if (c.equals("Proc2"))
			proc2();
		else if (c.equals("Proc3"))
			proc3();
		else if (c.equals("Effacer"))
			logoVue.effacer();
		else if (c.equals("Quitter"))
			System.exit(0);

		logo.getDessin().notifier();
	}
	
  	/** les procedures Logo qui combine plusieurs commandes..*/
	public void proc1() {
		logo.getCourante().carre();
	}

	public void proc2() {
		logo.getCourante().poly(60,8);
	}

	public void proc3() {
		logo.getCourante().spiral(50,40,6);
	}

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
	
	
}
