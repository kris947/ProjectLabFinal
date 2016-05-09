import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

//játék pálya megjelenítésére szolgáló JPanel
public class GamePanel extends JPanel
{
	private View view;
	
	public GamePanel(View v) 
	{
		view = v;
	}

	//Az összes pálya elem kirajzolása a Control.getDrawData függvénnyel
	@Override
    public void paint(Graphics g) 
	{
        super.paint(g);
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
			{
				Image[] images = view.control.getDrawData(i,j);
				g.drawImage(images[0], i*50, j*50, 50,50,this); 
				if(images.length == 2 )
				{
					g.drawImage(images[1], i*50, j*50,50,50,this);
				}
					
					
			}
		}
		CharGraphics OGrafInfo = view.control.ODraw();
		CharGraphics JGrafInfo = view.control.JDraw();
		CharGraphics RGrafInfo = view.control.RDraw();
		g.drawImage(OGrafInfo.getImage(), OGrafInfo.getloc().getX()*50,OGrafInfo.getloc().getY()*50, 50 , 50,this);
		g.drawImage(JGrafInfo.getImage(), JGrafInfo.getloc().getX()*50,JGrafInfo.getloc().getY()*50, 50 , 50,this);
		g.drawImage(RGrafInfo.getImage(), RGrafInfo.getloc().getX()*50,RGrafInfo.getloc().getY()*50, 50 , 50,this);
        
	}
	
	
}
