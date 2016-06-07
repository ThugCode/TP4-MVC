package src.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
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
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import src.commun.Commun;
import src.controleur.LogoControleur;
import src.modele.Logo;

/**
 * @author GERLAND - LETOURNEUR
 */
public abstract class LogoVue extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;
	
	protected Logo logo;
	protected LogoControleur controleur;
	protected FeuilleDessinVue dessin;

	/**
	 * Controleur
	 * @param p_logo
	 * @param p_logoControleur
	 */
	public LogoVue(Logo p_logo, LogoControleur p_logoControleur) {
		
		super("Un logo par GERLAND Loïc et LETOURNEUR Léo");
		
		controleur = p_logoControleur;
		this.addWindowListener(controleur);
		this.addComponentListener(controleur);
		
		logo = p_logo;
		dessin = new FeuilleDessinVue(logo.getDessin());
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
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		toolInit();
		
		menuInit();
		
		//FEUILLE
		dessin.setBackground(Color.red);
		dessin.setSize(new Dimension(Commun.LARGEUR_FEUILLE, Commun.HAUTEUR_FEUILLE));
		dessin.setPreferredSize(new Dimension(Commun.LARGEUR_FEUILLE, Commun.HAUTEUR_FEUILLE));
		getContentPane().add(dessin,"Center");
	}
	
	/**
	 * Initialisation de la toolbar
	 */
	public void toolInit() {
		
		JToolBar toolBar = new JToolBar();
		
		boutonsGauche(toolBar);
		
		addButton(toolBar,"Effacer","Nouveau dessin","/icons/index.png");
		
		// Create the combo box
		String[] colorStrings = {"noir", "bleu", "cyan","gris fonce","rouge", "vert", "gris clair",
									"magenta", "orange", "gris", "rose", "jaune"};
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
	}
	
	/**
	 * Ajouter des JButtons dans la JToolBar
	 * @param toolBar
	 */
	public abstract void boutonsGauche(JToolBar toolBar);
	
	/**
	 * Ajouter des JMenuItem dans le JMenu
	 * @param toolBar
	 */
	public abstract void menuOption(JMenuBar menubar);

	/**
	 * Initialisation du menu
	 */
	public void menuInit() {
		JMenuBar menubar = new JMenuBar();
		JMenu menuFile = new JMenu("Fichier");
		menubar.add(menuFile);
		addMenuItem(menuFile, "Effacer", "Effacer", KeyEvent.VK_N);
		addMenuItem(menuFile, "Quitter", "Quitter", KeyEvent.VK_Q);
		
		menuOption(menubar);
		
		JMenu menuHelp=new JMenu("Aide");
		menubar.add(menuHelp);
		addMenuItem(menuHelp, "Aide", "Help", -1);
		addMenuItem(menuHelp, "A propos", "About", -1);
		
		setJMenuBar(menubar);
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
	
	public LogoControleur getControleur() {
		return controleur;
	}

	public void setControleur(LogoControleur controleur) {
		this.controleur = controleur;
	}

	public FeuilleDessinVue getDessin() {
		return dessin;
	}

	public void setDessin(FeuilleDessinVue dessin) {
		this.dessin = dessin;
	}
}
