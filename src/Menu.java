import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

//menü  megjelenítésére szolgáló JPanel
public class Menu extends JPanel
{
	public Menu() 
	{
		repaint();
	}
	
	@Override
    public void paint(Graphics g) {
        super.paint(g);
        
        
        URL loc = this.getClass().getResource("uj.jpg");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        
        g.drawImage(image, 5,5, this); 
    }
	
}
