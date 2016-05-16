import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	
	JLabel picCredits;
	JLabel picRules;
	
	//View konstrukor kap egy refernciát a controlra
	public View(Control c)
	{		
		control = c;
		frame = new JFrame();
		gpanel = new GamePanel(this);
		menu = new Menu(this);
		
		
		BufferedImage myPicture;  //credits menü
		try 
		{
			myPicture = ImageIO.read(new File("credits.jpg"));
			picCredits = new JLabel(new ImageIcon(myPicture));
		} 
		catch (IOException e) {}
		
		credits = new JPanel();
		credits.setBounds(0, 0, 1000, 1000);
		credits.add(picCredits);
	
		
		BufferedImage myPicture2;  //szabályok menü
		try 
		{
			myPicture2 = ImageIO.read(new File("rules.jpg"));
			picRules = new JLabel(new ImageIcon(myPicture2));
		} 
		catch (IOException e) {}
		
		rules = new JPanel();
		rules.setBounds(0, 0, 1000, 1000);
		rules.add(picRules);
		
		
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
	public Menu getMpanel(){return menu;}
	public JPanel getCpanel(){return credits;}
	public JPanel getRpanel(){return rules;}
	
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

	
	
}
