import javax.swing.JFrame;
import javax.swing.JPanel;


public class View {
	Control control;
	private JFrame frame;
	JPanel panel;	//Az ablakon megjelen�tett panel.
	GamePanel gpanel;
	Menu menu;
	
	public View(){
		frame = new JFrame();
		menu = new Menu();  
		frame.add(menu);	
		frame.setSize(800, 800);
		frame.setTitle("Get_rekt");
		frame.setVisible(true);
		
	}
	

	public void Paint()
	{
		
	}
	
	
	//Be lehet �ll�tani az aktu�lis megjelen�tett panelt.
	public void setPanel()
	{
		//TODO
	}
	
	
}
