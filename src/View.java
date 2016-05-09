import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class View {
	Control control;
	private JFrame frame;
	public JPanel panel;	//Az ablakon megjelen�tett panel.
	private GamePanel gpanel;
	private Menu menu;
	
	public View(Control c)
	{		
		control = c;
		frame = new JFrame();
		gpanel = new GamePanel(this);
		
		frame.setSize(1006, 1035);
		frame.setTitle("Get_rekt");
		frame.setVisible(true);
		frame.setResizable(false);
	}
	

	public void Paint()
	{		
		panel.repaint();
	}
	
	
	//be�ll�tja az akt�v panelt
	public void setPanel(JPanel p)
	{
		panel = p;
		frame.add(panel);
	}
	
	
}
