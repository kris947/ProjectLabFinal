import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

//j�t�k p�lya megjelen�t�s�re szolg�l� JPanel
public class GamePanel extends JPanel
{
	View view;
	
	public GamePanel(View v) 
	{
		view = v;
	}

	//Az �sszes p�lya elem kirajzol�sa a Control.getDrawData f�ggv�nnyel
	@Override
    public void paint(Graphics g) 
	{
        super.paint(g);
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
			{
				Image[] images = view.control.getDrawData(i,j);
				g.drawImage(images[0], i*40, j*40, this); 
			}
		}
        
	}
	
	
}
