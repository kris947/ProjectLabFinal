import javax.swing.JFrame;
import javax.swing.JPanel;


public class View {
	Control control;
	private JFrame frame;
	JPanel panel;	//Az ablakon megjelen�tett panel.
	GamePanel gpanel;
	Menu menu;
	
	public View(Control c)
	{		
		control = c;
		frame = new JFrame();
		
		frame.setSize(1000, 1000);
		frame.setTitle("Get_rekt");
		frame.setVisible(true);
	}
	

	public void Paint()
	{		
		frame.repaint();
	}
	
	
	//be�ll�tja az akt�v panelt
	public void setPanel(JPanel p)
	{
		panel = p;
		frame.add(panel);
	}
	
	
}
