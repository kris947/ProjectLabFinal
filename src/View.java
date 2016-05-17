import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class View{
	Control control;
	private JFrame frame;
	public JPanel panel;	//Az ablakon megjelenített panel.
	private GamePanel gpanel;
	private Menu menu;
	private JPanel credits;
	private JPanel rules;
	private JPanel Owin;
	private JPanel Jwin;
	JLabel picCredits;
	JLabel picRules;
	JLabel picWinO;
	JLabel picWinJ;
	
	//View konstrukor kap egy refernciát a controlra
	public View(Control c)
	{		
		control = c;
		frame = new JFrame();
		gpanel = new GamePanel(this);
		menu = new Menu(this);		
		
		panel = menu ;
		
		frame.setSize(1006, 1035);
		frame.setTitle("Get_rekt");	//frame név
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(c);
		frame.addMouseListener(c);
				
	}
	
	public GamePanel getGpanel(){return gpanel;}
	
	public JPanel getWOpanel()
	{
		Image myPicture3;  //win kép Oneill		
		myPicture3 = readImage("Owin.jpg");
		picWinO = new JLabel(new ImageIcon(myPicture3));
		Owin = new JPanel();
		Owin.setBounds(0, 0, 1000, 1000);
		Owin.add(picWinO);
		return Owin;	
	}
	
	public JPanel getWJpanel()
	{
		Image myPicture4;  //win kép Jaffa		
		myPicture4 = readImage("Jwin.jpg");
		picWinJ = new JLabel(new ImageIcon(myPicture4));
		Jwin = new JPanel();
		Jwin.setBounds(0, 0, 1000, 1000);
		Jwin.add(picWinJ);
		return Jwin;
	}
	
	public Menu getMpanel(){return menu;}
	
	public JPanel getCpanel()
	{
		Image myPicture;  //credits menü	
		myPicture = readImage("credits.jpg");
		picCredits = new JLabel(new ImageIcon(myPicture));	
		credits = new JPanel();
		credits.setBounds(0, 0, 1000, 1000);
		credits.add(picCredits);
		return credits;
	}
	
	public JPanel getRpanel()
	{	
		Image myPicture2;  //szabályok menü	
		myPicture2 = readImage("rules.jpg");
		picRules = new JLabel(new ImageIcon(myPicture2));
		rules = new JPanel();
		rules.setBounds(0, 0, 1000, 1000);
		rules.add(picRules);
		return rules;
	}
	
	//újra kirajzolja az aktív panelt
	public void Paint()
	{		
		panel.repaint();
	}
	
	
	//beállítja az aktív panelt
	public void setPanel(JPanel p)
	{
		panel.setVisible(false);
		panel = p;
		panel.setVisible(true);
		frame.add(panel);
	}
	
	public Image readImage(String name)
	{
		Image i;
		i = new ImageIcon(name).getImage();
		return i;
	}
	
}
