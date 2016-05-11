package vue;


// package logo;

import java.awt.*;

import javax.swing.*;

import modele.Commun;
import modele.FeuilleDessin;
import modele.SimpleLogo;
import modele.Tortue;

import java.awt.event.*;

public class SimpleLogoVue extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private SimpleLogo logo;
	public JTextField inputValue;
	public JButton b20;
	public JButton b21;
	public JButton b22;

	public SimpleLogoVue(SimpleLogo p_logo) {
		super("un logo tout simple");
		
		logo = p_logo;
		
		logoInit();
	}
	
	public void logoInit() {
		getContentPane().setLayout(new BorderLayout(10,10));

		// Boutons
		JToolBar toolBar = new JToolBar();
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(toolBar);

		getContentPane().add(buttonPanel,"North");

		addButton(toolBar,"Effacer","Nouveau dessin","/icons/index.png");
		
		toolBar.add(Box.createRigidArea(Commun.HGAP));
		inputValue=new JTextField("45",5);
		toolBar.add(inputValue);
		addButton(toolBar, "Avancer", "Avancer 50", null);
		addButton(toolBar, "Droite", "Droite 45", null);
		addButton(toolBar, "Gauche", "Gauche 45", null);
		addButton(toolBar, "Lever", "Lever Crayon", null);
		addButton(toolBar, "Baisser", "Baisser Crayon", null);

		String[] colorStrings = {"noir", "bleu", "cyan","gris fonce","rouge",
								 "vert", "gris clair", "magenta", "orange",
								 "gris", "rose", "jaune"};

		// Create the combo box
		toolBar.add(Box.createRigidArea(Commun.HGAP));
		JLabel colorLabel = new JLabel("   Couleur: ");
		toolBar.add(colorLabel);
		JComboBox colorList = new JComboBox(colorStrings);
		toolBar.add(colorList);

		colorList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				int n = cb.getSelectedIndex();
				logo.getCourante().setColor(n);
			}
		});


		// Menus
		JMenuBar menubar=new JMenuBar();
		setJMenuBar(menubar);	// on installe le menu bar
		JMenu menuFile=new JMenu("File"); // on installe le premier menu
		menubar.add(menuFile);

		addMenuItem(menuFile, "Effacer", "Effacer", KeyEvent.VK_N);
		addMenuItem(menuFile, "Quitter", "Quitter", KeyEvent.VK_Q);

		JMenu menuCommandes=new JMenu("Commandes"); // on installe le premier menu
		menubar.add(menuCommandes);
		addMenuItem(menuCommandes, "Avancer", "Avancer", -1);
		addMenuItem(menuCommandes, "Droite", "Droite", -1);
		addMenuItem(menuCommandes, "Gauche", "Gauche", -1);
		addMenuItem(menuCommandes, "Lever Crayon", "Lever", -1);
		addMenuItem(menuCommandes, "Baisser Crayon", "Baisser", -1);

		JMenu menuHelp=new JMenu("Aide"); // on installe le premier menu
		menubar.add(menuHelp);
		addMenuItem(menuHelp, "Aide", "Help", -1);
		addMenuItem(menuHelp, "A propos", "About", -1);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// les boutons du bas
		JPanel p2 = new JPanel(new GridLayout());
		b20 = new JButton("Proc1");
		p2.add(b20);
		
		b21 = new JButton("Proc2");
		p2.add(b21);
		
		b22 = new JButton("Proc3");
		p2.add(b22);

		getContentPane().add(p2,"South");

		FeuilleDessinVue feuilleVue = new FeuilleDessinVue(logo.getDessin()); //500, 400);
		feuilleVue.setBackground(Color.white);
		feuilleVue.setSize(new Dimension(600,400));
		feuilleVue.setPreferredSize(new Dimension(600,400));
			
		getContentPane().add(feuilleVue,"Center");
		
		// Creation de la tortue
		TortueVue tortueVue = new TortueVue(logo.getCourante());
		logo.getCourante().setPosition(500/2, 400/2);
		logo.getDessin().addTortue(logo.getCourante());

		pack();
		setVisible(true);
	}

	public String getInputValue(){
		String s = inputValue.getText();
		return(s);
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

	// efface tout et reinitialise la feuille
	public void effacer() {
		logo.getDessin().reset();

		// Replace la tortue au centre
		Dimension size = new Dimension(600, 400);
		logo.getCourante().setPosition(size.width/2, size.height/2);
	}

	//utilitaires pour installer des boutons et des menus
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
		b.addActionListener(this);
	}

	public void addMenuItem(JMenu m, String label, String command, int key) {
		JMenuItem menuItem;
		menuItem = new JMenuItem(label);
		m.add(menuItem);

		menuItem.setActionCommand(command);
		menuItem.addActionListener(this);
		if (key > 0) {
			if (key != KeyEvent.VK_DELETE)
				menuItem.setAccelerator(KeyStroke.getKeyStroke(key, Event.CTRL_MASK, false));
			else
				menuItem.setAccelerator(KeyStroke.getKeyStroke(key, 0, false));
		}
	}
}
