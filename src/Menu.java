import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//menü  megjelenítésére szolgáló JPanel
public class Menu extends JPanel
{
	public int Menu1P;
	public int Menu2P;
	public int Menu3P;
	public int Menu4P;
	public View view;
	
	public Menu(View v) 
	{
		setLayout(null);
		setBounds(0, 0, 1000, 1000);
		view = v;
		repaint();
	}
	
	@Override
    public void paint(Graphics g) 
	{
        super.paint(g);
             

        ImageIcon ic = new ImageIcon("completemainmenu.jpg");
        Image image = ic.getImage();
        image.getScaledInstance(1000, 1000, Image.SCALE_AREA_AVERAGING);

       g.drawImage(image, 0, 0, this); 
    }
	
}
