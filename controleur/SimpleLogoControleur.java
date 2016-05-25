package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JComboBox;

import modele.SimpleLogo;
import modele.TortueRandom;
import vue.SimpleLogoVue;

/**
 * @author GERLAND - LETOURNEUR
 */
public class SimpleLogoControleur implements ActionListener, WindowListener, KeyListener {

	private SimpleLogo logo;
	private SimpleLogoVue logoVue;

	/**
	 * Constructeur
	 * @param p_logo
	 */
	public SimpleLogoControleur(SimpleLogo p_logo) {
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
			logoVue.effacer();
		} 
		else if (c.equals("Couleur")) {
			@SuppressWarnings("unchecked")
			JComboBox<String> cb = (JComboBox<String>)e.getSource();
			int n = cb.getSelectedIndex();
			logo.getDessin().changerCouleursTortues(n);
			logo.setcCouleur(n);
		}
		else if (c.equals("Ajouter")) {
			TortueRandom tortue = new TortueRandom();
			tortue.setColor(this.logo.getcCouleur());
			logo.getDessin().addTortue(tortue);
		} 
		else if (c.equals("Supprimer")) {
			if(logo.getDessin().getTortues().size() > 0)
				logo.getDessin().removeLastTortue();
		} 
		else if (c.equals("Aléatoires")) {
			
		}
		else if (c.equals("Contrôlable")) {
			
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
	
	public SimpleLogoVue getLogoVue() {
		return logoVue;
	}

	public void setLogoVue(SimpleLogoVue logoVue) {
		this.logoVue = logoVue;
		
		if(!logo.isControle())
			lancerLesTortues();
	}

	private void lancerLesTortues() {
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				while(true) {
					logo.getDessin().faireAvancerTortues();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t2.start();
		
	}
}
