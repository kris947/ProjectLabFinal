import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

//men�  megjelen�t�s�re szolg�l� JPanel
public class Menu extends JPanel
{
	public Menu() 
	{
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
