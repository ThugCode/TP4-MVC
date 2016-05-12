package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import commun.Commun;
import controleur.SimpleLogoControleur;
import modele.SimpleLogo;

/**
 * @author GERLAND - LETOURNEUR
 */
public class SimpleLogoVue extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;
	
	private SimpleLogo logo;
	private SimpleLogoControleur controleur;
	private JTextField inputValue;

	/**
	 * Controleur
	 * @param p_logo
	 * @param p_logoControleur
	 */
	public SimpleLogoVue(SimpleLogo p_logo, SimpleLogoControleur p_logoControleur) {
		
		super("Un logo par GERLAND Loïc et LETOURNEUR Léo");
		
		controleur = p_logoControleur;
		this.addWindowListener(controleur);
		this.addKeyListener(controleur);
		
		logo = p_logo;
		logo.addObserver(this);
		
		logoInit();
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Constuction de la fenetre
	 */
	public void logoInit() {
		
		getContentPane().setLayout(new BorderLayout(10,10));

		//HAUT
		inputValue = new JTextField("45",5);
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		JToolBar toolBar = new JToolBar();
		toolBar.add(inputValue);
		toolBar.add(Box.createRigidArea(Commun.HGAP));
		
		// Boutons
		addButton(toolBar,"Effacer","Nouveau dessin","/icons/index.png");
		addButton(toolBar, "Avancer", "Avancer 50", null);
		addButton(toolBar, "Droite", "Droite 45", null);
		addButton(toolBar, "Gauche", "Gauche 45", null);
		addButton(toolBar, "Lever", "Lever Crayon", null);
		addButton(toolBar, "Baisser", "Baisser Crayon", null);
		
		// Create the combo box
		String[] colorStrings = {"noir", "bleu", "cyan","gris fonce","rouge",
				 "vert", "gris clair", "magenta", "orange",
				 "gris", "rose", "jaune"};
		toolBar.add(Box.createRigidArea(Commun.HGAP));
		JLabel colorLabel = new JLabel("   Couleur: ");
		toolBar.add(colorLabel);
		JComboBox<String> colorList = new JComboBox<String>(colorStrings);
		colorList.setActionCommand("Couleur");
		colorList.addActionListener(controleur);
		toolBar.add(colorList);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(toolBar);
		getContentPane().add(buttonPanel,"North");

		//MENU
		JMenuBar menubar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		menubar.add(menuFile);
		addMenuItem(menuFile, "Effacer", "Effacer", KeyEvent.VK_N);
		addMenuItem(menuFile, "Quitter", "Quitter", KeyEvent.VK_Q);
		
		JMenu menuCommandes = new JMenu("Commandes");
		menubar.add(menuCommandes);
		addMenuItem(menuCommandes, "Avancer", "Avancer", -1);
		addMenuItem(menuCommandes, "Droite", "Droite", -1);
		addMenuItem(menuCommandes, "Gauche", "Gauche", -1);
		addMenuItem(menuCommandes, "Lever Crayon", "Lever", -1);
		addMenuItem(menuCommandes, "Baisser Crayon", "Baisser", -1);
		
		JMenu menuHelp=new JMenu("Aide");
		menubar.add(menuHelp);
		addMenuItem(menuHelp, "Aide", "Help", -1);
		addMenuItem(menuHelp, "A propos", "About", -1);
		
		setJMenuBar(menubar);
		
		//BAS
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

		//FEUILLE
		logo.getDessin().setBackground(Color.red);
		logo.getDessin().setSize(new Dimension(Commun.LARGEURFEUILLE,Commun.HAUTEURFEUILLE));
		logo.getDessin().setPreferredSize(new Dimension(Commun.LARGEURFEUILLE,Commun.HAUTEURFEUILLE));
		getContentPane().add(logo.getDessin(),"Center");
		
		//TORTUE
		logo.getCTortue().setPosition(510/2, 400/2);
		logo.getDessin().addTortue(logo.getCTortue());
	}

	/**
	 * Getter sur la valeur du champs input
	 * @return String
	 */
	public String getInputValue(){
		String s = inputValue.getText();
		return(s);
	}
	
	/**
	 * Efface tout et reinitialise la feuille
	 */
	public void effacer() {
		logo.getDessin().reset();

		// Replace la tortue au centre
		Dimension size = new Dimension(Commun.LARGEURFEUILLE,Commun.HAUTEURFEUILLE);
		logo.getCTortue().setPosition(size.width/2, size.height/2);
	}
	
	/**
	 * Utilitaires pour installer des boutons
	 * @param p
	 * @param name
	 * @param tooltiptext
	 * @param imageName
	 */
	public void addButton(JComponent p, String name, String tooltiptext, String imageName) {
		JButton b;
		if ((imageName == null) || (imageName.equals(""))) {
			b = (JButton)p.add(new JButton(name));
		}
		else {
			java.net.URL u = this.getClass().getResource(imageName);
			if (u != null) {
				ImageIcon im = new ImageIcon (u);
				b = (JButton) p.add(new JButton(im));
			}
			else
				b = (JButton) p.add(new JButton(name));
			b.setActionCommand(name);
		}

		b.setToolTipText(tooltiptext);
		b.setBorder(BorderFactory.createRaisedBevelBorder());
		b.setMargin(new Insets(0,0,0,0));
		b.addActionListener(controleur);
	}

	/**
	 * Utilitaires pour installer des menus
	 * @param m
	 * @param label
	 * @param command
	 * @param key
	 */
	public void addMenuItem(JMenu m, String label, String command, int key) {
		JMenuItem menuItem;
		menuItem = new JMenuItem(label);
		m.add(menuItem);

		menuItem.setActionCommand(command);
		menuItem.addActionListener(controleur);
		if (key > 0) {
			if (key != KeyEvent.VK_DELETE)
				menuItem.setAccelerator(KeyStroke.getKeyStroke(key, Event.CTRL_MASK, false));
			else
				menuItem.setAccelerator(KeyStroke.getKeyStroke(key, 0, false));
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();		
	}
	
	public SimpleLogoControleur getControleur() {
		return controleur;
	}

	public void setControleur(SimpleLogoControleur controleur) {
		this.controleur = controleur;
	}
}
