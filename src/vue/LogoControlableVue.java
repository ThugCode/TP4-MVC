package src.vue;

import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import src.commun.Commun;
import src.controleur.LogoControlableControleur;
import src.modele.Logo;

/**
 * @author GERLAND - LETOURNEUR
 */
public class LogoControlableVue extends LogoVue {
	private static final long serialVersionUID = 1L;
	
	private JTextField inputValue;

	/**
	 * Controleur
	 * @param p_logo
	 * @param p_logoControleur
	 */
	public LogoControlableVue(Logo p_logo, LogoControlableControleur p_logoControleur) {
		
		super(p_logo, p_logoControleur);
		
		this.addKeyListener(p_logoControleur);
	}

	@Override
	public void logoInit() {
		
		super.logoInit();
		
		procInit();
		
		dessin.ajouterTortue(logo.getCTortue());
	}

	/**
	 * Initialisation de la toolbar
	 */
	public void procInit() {
		
		JPanel p2 = new JPanel(new GridLayout());
		
		JButton b20 = new JButton("Proc1");
		b20.addActionListener(controleur);
		p2.add(b20);
		
		JButton b21 = new JButton("Proc2");
		b21.addActionListener(controleur);
		p2.add(b21);
		
		JButton b22 = new JButton("Proc3");
		b22.addActionListener(controleur);
		p2.add(b22);

		getContentPane().add(p2,"South");
	}
	
	@Override
	public void boutonsGauche(JToolBar toolBar) {
		
		inputValue = new JTextField("45",5);
		toolBar.add(inputValue);
		
		toolBar.add(Box.createRigidArea(Commun.HGAP));
		addButton(toolBar, "Avancer", "Avancer", null);
		addButton(toolBar, "Droite", "Droite", null);
		addButton(toolBar, "Gauche", "Gauche", null);
		addButton(toolBar, "Lever", "Lever Crayon", null);
		addButton(toolBar, "Baisser", "Baisser Crayon", null);
	}
	
	@Override
	public void menuOption(JMenuBar menubar) {
		
		JMenu menuCommandes = new JMenu("Commandes");
		menubar.add(menuCommandes);
		addMenuItem(menuCommandes, "Avancer", "Avancer", -1);
		addMenuItem(menuCommandes, "Droite", "Droite", -1);
		addMenuItem(menuCommandes, "Gauche", "Gauche", -1);
		addMenuItem(menuCommandes, "Lever Crayon", "Lever", -1);
		addMenuItem(menuCommandes, "Baisser Crayon", "Baisser", -1);
	}
	
	/**
	 * Getter sur la valeur du champs input
	 * @return String
	 */
	public String getInputValue(){
		String s = inputValue.getText();
		return(s);
	}
}