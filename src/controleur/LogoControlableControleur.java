package src.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import src.modele.Logo;
import src.vue.LogoControlableVue;

/**
 * @author GERLAND - LETOURNEUR
 */
public class LogoControlableControleur extends LogoControleur implements KeyListener {

	/**
	 * Constructeur
	 * @param p_logo
	 */
	public LogoControlableControleur(Logo p_logo) {
		super(p_logo);
	}
	
	/**
	 * Verifie le nombre inscrit dans le JTextField
	 * @return
	 */
	private int verifieNombre() {
		try {
			return Integer.parseInt(((LogoControlableVue)logoVue).getInputValue());
		} catch (NumberFormatException ex){
			System.err.println("ce n'est pas un nombre : " + ((LogoControlableVue)logoVue).getInputValue());
			return 0;
		}
	}

	/**
	 * ActionPerformed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		super.actionPerformed(e);
		
		String c = e.getActionCommand();

		if (c.equals("Avancer")) {
			logo.getCTortue().avancer(verifieNombre());
		}
		else if (c.equals("Droite")) {
			logo.getCTortue().droite(verifieNombre());
		}
		else if (c.equals("Gauche")) {
			logo.getCTortue().gauche(verifieNombre());
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
	}
	
	/**
	 * KeyListener
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		
		if((e.getKeyCode()==KeyEvent.VK_UP)) {
			logo.getCTortue().avancer(verifieNombre());
		} else if((e.getKeyCode()==KeyEvent.VK_LEFT)) {
			logo.getCTortue().gauche(verifieNombre());
		} else if((e.getKeyCode()==KeyEvent.VK_RIGHT)) {
			logo.getCTortue().droite(verifieNombre());
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
}
