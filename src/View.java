import java.awt.Image;

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
	
	
	public View(Control c)
	{		
		control = c;
		frame = new JFrame();
		gpanel = new GamePanel(this);
		menu = new Menu(this);
		
		JLabel jlb2 = new JLabel("CREDITS");
		jlb2.setBounds(50, 50, 100, 100);
		credits = new JPanel();
		credits.setBounds(0, 0, 1000, 1000);
		credits.add(jlb2);
		
		rules = new JPanel();
		rules.setBounds(0, 0, 1000, 1000);
		JLabel jlb = new JLabel("RULES");
		jlb.setBounds(50, 50, 100, 100);
		rules.add(jlb);
		
		
		panel = menu ;
		
		frame.setSize(1006, 1035);
		frame.setTitle("Get_rekt");
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
